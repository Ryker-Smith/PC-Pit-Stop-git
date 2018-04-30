package net.fachtnaroe.pcpitstop_git;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.WindowManager;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;
import com.google.appinventor.components.runtime.Web;

import org.json.JSONException;
import org.json.JSONObject;


public class screen04_customerAddEdit extends Form implements HandlesEventDispatching
{
    private Button connectionButton, postButton, putButton, deleteButton, getButton;
    private Label firstLabel, familyLabel, emailLabel, phoneLabel, responseLabel, ppsLabel, urlLabel, debugSideLabel;
    private Web webComponent_POST, webComponent_PUT, webComponent_GET, webComponent_DELETE;
    private VerticalScrollArrangement mainContainer;
    private HorizontalArrangement topLine, nextLine, ppsLine;
    public static TextBox firstName, lastName, email, phone, urlBox, outputBox, ppsBox, debugLabel, sessionIDBox;
    private Label address1Label, address2Label, address3Label, sessionIDLabel;
    public static TextBox addressLineOne, addressLineTwo, addressLineThree;
    private String remoteHost = "https://fachtnaroe.net";
    //    private Image myLogo;
    private String targetURL = new String();


    protected void $define() {

//      GUI setup

        mainContainer = new VerticalScrollArrangement(this);
        mainContainer.WidthPercent(100);
        mainContainer.HeightPercent(100);
        mainContainer.BackgroundColor(0xff99bbff);

        topLine = new HorizontalArrangement(mainContainer);
        topLine.WidthPercent(100);
        Label titleLabel = new Label(topLine);
        titleLabel.Text("Add / Edit Customer");
        titleLabel.FontSize(20);
        titleLabel.FontTypeface(Component.TYPEFACE_SERIF);
        titleLabel.WidthPercent(100);
        titleLabel.FontBold(true);
        titleLabel.TextAlignment(Component.ALIGNMENT_CENTER);

        HorizontalArrangement urlHorz = new HorizontalArrangement(mainContainer);
        urlLabel = new Label(urlHorz);
        urlLabel.Text("Backend:");
        urlBox = new TextBox(urlHorz);
        urlBox.WidthPercent(100);
        urlBox.Text(remoteHost + "/pcpitstop-2018");

        HorizontalArrangement firstHoriz = new HorizontalArrangement(mainContainer);
        firstHoriz.WidthPercent(100);
        firstLabel = new Label(firstHoriz);
        firstLabel.Text("First: ");
        firstLabel.WidthPercent(20);
        firstName = new TextBox(firstHoriz);
        firstName.WidthPercent(100);
        firstName.Text("");

        HorizontalArrangement familyHoriz = new HorizontalArrangement(mainContainer);
        familyHoriz.WidthPercent(100);
        familyLabel = new Label(familyHoriz);
        familyLabel.Text("Family: ");
        familyLabel.WidthPercent(20);
        lastName = new TextBox(familyHoriz);
        lastName.WidthPercent(100);
        lastName.Text("");

        HorizontalArrangement emailHoriz = new HorizontalArrangement(mainContainer);
        emailHoriz.WidthPercent(100);
        emailLabel = new Label(emailHoriz);
        emailLabel.Text("email: ");
        emailLabel.WidthPercent(20);
        email = new TextBox(emailHoriz);
        email.WidthPercent(100);
        email.Text("");

        HorizontalArrangement phoneHoriz = new HorizontalArrangement(mainContainer);
        phoneHoriz.WidthPercent(100);
        phoneLabel = new Label(phoneHoriz);
        phoneLabel.Text("Phone: ");
        phoneLabel.WidthPercent(20);
        phone = new TextBox(phoneHoriz);
        phone.WidthPercent(100);
        phone.Text("");

        HorizontalArrangement address1Horiz = new HorizontalArrangement(mainContainer);
        address1Horiz.WidthPercent(100);
        address1Label = new Label(address1Horiz);
        address1Label.Text("Address1: ");
        address1Label.WidthPercent(20);
        addressLineOne = new TextBox(address1Horiz);
        addressLineOne.WidthPercent(100);
        addressLineOne.Text("");

        HorizontalArrangement address2Horiz = new HorizontalArrangement(mainContainer);
        address2Horiz.WidthPercent(100);
        address2Label = new Label(address2Horiz);
        address2Label.Text("Address2: ");
        address2Label.WidthPercent(20);
        addressLineTwo = new TextBox(address2Horiz);
        addressLineTwo.WidthPercent(100);
        addressLineTwo.Text("");

        HorizontalArrangement address3Horiz = new HorizontalArrangement(mainContainer);
        address3Horiz.WidthPercent(100);
        address3Label = new Label(address3Horiz);
        address3Label.Text("Address3: ");
        address3Label.WidthPercent(20);
        addressLineThree = new TextBox(address3Horiz);
        addressLineThree.WidthPercent(100);
        addressLineThree.Text("");

        HorizontalArrangement ppsHoriz = new HorizontalArrangement(mainContainer);
        ppsHoriz.WidthPercent(100);
        ppsLabel = new Label(ppsHoriz);
        ppsLabel.Text("PPS: ");
        ppsLabel.WidthPercent(20);
        ppsBox = new TextBox(ppsHoriz);
        ppsBox.WidthPercent(100);
        ppsBox.Text("");

        HorizontalArrangement sessionIDHoriz = new HorizontalArrangement(mainContainer);
        sessionIDHoriz.WidthPercent(100);
        sessionIDLabel = new Label(sessionIDHoriz);
        sessionIDLabel.Text("sessionID");
        sessionIDLabel.WidthPercent(20);
        sessionIDBox = new TextBox(sessionIDHoriz);
        sessionIDBox.WidthPercent(100);
        sessionIDBox.Text("");

        HorizontalArrangement debugHoriz = new HorizontalArrangement(mainContainer);
        debugSideLabel = new Label(debugHoriz);
        debugSideLabel.WidthPercent(20);
        debugSideLabel.Text("Debug: ");
        debugLabel = new TextBox(debugHoriz);
        debugLabel.WidthPercent(100);
        debugLabel.Text("");

        HorizontalArrangement uploadHoriz = new HorizontalArrangement(mainContainer);
        uploadHoriz.WidthPercent(100);
        postButton = new Button(uploadHoriz);
        postButton.Text("POST");
        postButton.WidthPercent(50);

        putButton = new Button(uploadHoriz);
        putButton.Text("PUT");
        putButton.WidthPercent(50);
        putButton.Enabled(false);

        HorizontalArrangement getHoriz = new HorizontalArrangement(mainContainer);
        getHoriz.WidthPercent(100);
        deleteButton = new Button(getHoriz);
        deleteButton.Text("DELETE");
        deleteButton.WidthPercent(50);
        deleteButton.Enabled(false);

        getButton = new Button(getHoriz);
        getButton.Text("GET");
        getButton.WidthPercent(50);
        getButton.Enabled(false);

//        connectionButton = new Button(screenContainer);
//        connectionButton.Text("Connect");
//
//        connectionButton.BackgroundColor(COLOR_LTGRAY);
//        connectionButton.WidthPercent(50);
//        connectionButton.TextAlignment(Component.ALIGNMENT_CENTER);

        webComponent_POST = new Web(mainContainer);
        webComponent_PUT = new Web(mainContainer);
        webComponent_GET = new Web(mainContainer);
        webComponent_DELETE = new Web(mainContainer);

//      Making events for buttons

//        EventDispatcher.registerEventForDelegation(this, "connectButton", "Click");
        EventDispatcher.registerEventForDelegation(this, "postButton", "Click");
//        EventDispatcher.registerEventForDelegation(this, "putButton", "Click");
//        EventDispatcher.registerEventForDelegation(this, "deleteButton", "Click");
//        EventDispatcher.registerEventForDelegation(this, "getButton", "Click");
        EventDispatcher.registerEventForDelegation(this, "webComponent_POST", "GotText");
    }

    String RequestValue (String s1, String s2) {
        // Purpose: To combine two strings into a name=value pair
        // Expects: Two strings
        // Returns: One string of the form s1=s2
        return s1 + '=' + s2;
    }

    String RequestCombine (String[] Pairs) {
        // Purpose: To combine multiple strings (of the form name=value) into a web data string
        // Expects: Series of strings
        // Returns: One string of the form string&string&string
        int i=Pairs.length;
        int count = (int) i/2;
        String result = new String();
        for (int loop=0; loop<i; loop+=1){
            result += Pairs[loop];
            if (loop < (i-1)) {
                result += "&";
            }
        }
        return result;
    }

    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params) {
        if (component.equals(connectionButton) && eventName.equals("Click")) {
            return true;
        }
        else if (component.equals(webComponent_POST) && eventName.equals("GotText")) {
            String result = (String) params[3];
            youveGotText(result);
            return true;
        }
//        Arranges all info into a URL to send as a request to the backend
        else if (component.equals(postButton) && eventName.equals("Click")) {
            data_PPSN PPSNValidate = new data_PPSN();
            if (PPSNValidate.Valid(ppsBox.Text())){
                targetURL = urlBox.Text();
                debugLabel.Text(targetURL);
                postButton.Text("sending");
                webComponent_POST.Url(targetURL);
                String textToPost =
                       RequestCombine(new String[]{
                                RequestValue("sessionID",sessionIDBox.Text()),
                                RequestValue("entity","person"),
                                RequestValue("First",firstName.Text()),
                                RequestValue("Family",lastName.Text()),
                                RequestValue("Email", email.Text()),
                                RequestValue("Phone", phone.Text()),
                                RequestValue("Address1", addressLineOne.Text()),
                                RequestValue("Address2", addressLineTwo.Text()),
                                RequestValue("Address3", addressLineThree.Text()),
                                RequestValue("PPS", ppsBox.Text()),
                        });
                webComponent_POST.PostText(textToPost);
                debugLabel.Text(textToPost);
                return true;
            }
        }
        else if (component.equals(putButton) && eventName.equals("Click")) {
            return true;
        }
        else if (component.equals(deleteButton) && eventName.equals("Click")) {
            return true;
        }
        else if (component.equals(getButton) && eventName.equals("Click")) {
            getButtonClick();
            return true;
        }
        else {
        }

        // here is where you'd check for other events of your app...
        return false;
    }

    public void getButtonClick() {

//        targetURL = urlBox.Text();
//        webComponent_POST.Url(targetURL);
//        webComponent_POST.Get();
    }
    //      Get the result of the request
    public void youveGotText(String result) {
        postButton.Text("Got data");
        debugLabel.Text(result);
        try {
            JSONObject parser = new JSONObject(result);
            debugLabel.Text(result);
//                    parser.getString("result") + " (" +
//                            parser.getString("sessionID") + ")"
//            );

        } catch (JSONException e) {
            // if an exception occurs, code for it in here
        }
    }

public static int getScreenWidth()
        {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
        }

//get height of screen
public static int getScreenHeight()
        {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
}

}
