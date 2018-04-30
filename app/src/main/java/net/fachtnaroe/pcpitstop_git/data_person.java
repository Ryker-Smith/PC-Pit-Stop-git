package net.fachtnaroe.pcpitstop_git;

import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.Web;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static net.fachtnaroe.pcpitstop_git.screen04_customerAddEdit.addressLineOne;
import static net.fachtnaroe.pcpitstop_git.screen04_customerAddEdit.addressLineTwo;
import static net.fachtnaroe.pcpitstop_git.screen04_customerAddEdit.addressLineThree;
import static net.fachtnaroe.pcpitstop_git.screen04_customerAddEdit.email;
import static net.fachtnaroe.pcpitstop_git.screen04_customerAddEdit.lastName;
import static net.fachtnaroe.pcpitstop_git.screen04_customerAddEdit.firstName;
import static net.fachtnaroe.pcpitstop_git.screen04_customerAddEdit.phone;
import static net.fachtnaroe.pcpitstop_git.screen04_customerAddEdit.ppsBox;

/**
 * Created by fachtna on 09/03/18.
 */

public class data_person extends Form implements HandlesEventDispatching{
    public int pID;
    public String First;
    public String Family;
    public String Email;
    public String Phone;
    public String Address1;
    public String Address2;
    public String Address3;
    public data_PPSN pps;
    public boolean SavedOK;

    protected void $define() {
    }

    public data_person(){
        // constructor
        pps  = new data_PPSN();
        pID=-1; // if subsequently found to be different, use PUT not POST
    }

    boolean Set (String[] details) {
        // SET means copy from screen to background record
        First = details[0];
        Family = details[1];
        Email = details[2];
        Phone = details[3];
        Address1 = details[4];
        Address2 = details[5];
        Address3 = details[6];
        // not forcing a valid PPS at this point
        boolean result=pps.Set (details[7]);
        return true;
    }

    public boolean Save(Web webComponent){
        String request = webComponent.Url() + "&" + MakeRequestString();
        if (pID == -1) { // -1 means no active pID, should POST; else PUT
            webComponent.PostText(request);
        }
        else {
            webComponent.PutText(request);
        }
        return true;
    }

    void Get (JSONObject dataRcvd) {
        // GET means for us, interpret the JSON data received then copy from background record into screen
//        String[] details = new String[] {};
        try {
//            JSONObject parser = new JSONObject(dataRcvd);
            pID= Integer.valueOf(dataRcvd.getString("pID"));
            First= dataRcvd.getString("First");
            Family= dataRcvd.getString("Family");
            Email= dataRcvd.getString("Email");
            Phone= dataRcvd.getString("Phone");
            Address1= dataRcvd.getString("Address1");
            Address2= dataRcvd.getString("Address2");
            Address3= dataRcvd.getString("Address3");
//            pps.Set(dataRcvd.getString("pps"));

            firstName.Text(First);
            lastName.Text(Family);
            email.Text(Email);
            phone.Text(Phone);
            addressLineOne.Text(Address1);
            addressLineTwo.Text(Address2);
            addressLineThree.Text(Address3);
            ppsBox.Text(pps.Number);

        } catch (JSONException e) {
            // if an exception occurs, code for it in here


        }

    }

    public data_person Load (Web webComponent, Integer pID) {
        String textToPost =
                code_commonBits.RequestCombine(new String[]{
                        code_commonBits.RequestValue("sessionID","a1b2c3d4"),
                        code_commonBits.RequestValue("iam","fachtna"),
                        code_commonBits.RequestValue("entity","data_person")
                });
        if ((pID != null) && (pID != -1)) {
            textToPost += "&" + code_commonBits.RequestValue("pID",Integer.toString(pID));
        }
        webComponent.Url( code_commonBits.targetURL +  textToPost );
        webComponent.Get();
        return null;
    }

    public ArrayList<String> toList (JSONArray data) {
        ArrayList<String> people = new ArrayList<String>();
            try {
                for (int n=0; n<=data.length()-1;n++) {
                    pID = Integer.valueOf(data.getJSONObject(n).getString("pID"));
                    String line = "[pID " + data.getJSONObject(n).getString("pID")
                            + "] " + data.getJSONObject(n).getString("Family")
                            + ", " + data.getJSONObject(n).getString("First")
                            + " of " + data.getJSONObject(n).getString("Address1")
                            + " " + data.getJSONObject(n).getString("Address2")
                            + " " + data.getJSONObject(n).getString("Address3");
                    people.add(line);
                }
                return people;

            } catch (JSONException e) {
                // if an exception occurs, code for it in here
            }
            return null;
        }


    public String MakeRequestString (){
        // Purpose: build a URL string for use with Web compnent
        // Expects: Nothing. Hard coded for this object
        // Returns: String suitable for passing to AppInventor Web component.
        String textToPost =
                code_commonBits.RequestCombine(new String[]{
                        code_commonBits.RequestValue("sessionID","a1b2c3d4"),
                        code_commonBits.RequestValue("myProcess","fachtna"),
                        code_commonBits.RequestValue("entity","data_person"),
                        code_commonBits.RequestValue("First",this.First),
                        code_commonBits.RequestValue("Family",this.Family),
                        code_commonBits.RequestValue("Email", this.Email),
                        code_commonBits.RequestValue("Phone", this.Phone),
                        code_commonBits.RequestValue("Address1", this.Address1),
                        code_commonBits.RequestValue("Address2", this.Address2),
                        code_commonBits.RequestValue("Address3", this.Address3),
                        code_commonBits.RequestValue("PPS", this.pps.Number),
                });
        return textToPost;
    }

    public String AddressOf () {
        String result= this.Address1;
        if (this.Address2 != null) {
            result += "," + Address2;
        }
        if (this.Address3 != null) {
            result += "," + Address3;
        }
        return result;
    }

    public boolean HasContactDetails () {
        if ((this.Phone != null) && (this.Email != null)) {
            return true;
        }
        else {
            return false;
        }
    }

    public String ContactDetails () {
        String result = new String();
        if (this.Phone != null) {
            result= "Phone: (" + this.Phone + ")";
        }
        if (this.Email != null) {
            result += "Email: (" + this.Email + ")";
        }
        return result;
    }

}
