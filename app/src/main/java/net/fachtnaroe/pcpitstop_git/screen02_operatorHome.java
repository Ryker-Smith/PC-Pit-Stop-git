package net.fachtnaroe.pcpitstop_git;

import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.WindowManager;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.ListView;
import com.google.appinventor.components.runtime.Notifier;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;
import com.google.appinventor.components.runtime.Web;
import com.google.appinventor.components.runtime.util.YailList;

import android.os.Bundle;

import org.json.*;

import java.util.ArrayList;

import static net.fachtnaroe.pcpitstop_git.code_commonBits.targetURL;

public class screen02_operatorHome extends Form implements HandlesEventDispatching
{
    private VerticalArrangement mainContainer;
    private VerticalArrangement leftSideSpacer;
    private VerticalArrangement headerArrangement;
    private HorizontalArrangement operatorScreenBodyWithSpacer;
    private VerticalArrangement operatorScreenBody;
    private HorizontalArrangement jobsControlButtonArea;
    private Button jobsControlAdd;
    private Button jobsControlEdit;
    private HorizontalArrangement customersControlButtonArea;
    private Button customerControlAdd;
    private Button customerControlEdit;
    private Label title;
    private Label jobsLabel;
    private Label customersLabel;
    private VerticalScrollArrangement jobs;
    private VerticalScrollArrangement customers;
    //placeholders below---v
    private Notifier myNotify;
    private String sessionID;
    private Web customerList_webComponent, jobList_webComponent;
    private ListView customerList, jobList;
    private JSONArray customerData, jobData;


    protected void $define()
    {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        Bundle b = getIntent().getExtras();
        if (b != null) {
            sessionID = b.getString("sessionID");
        }
        mainContainer = new VerticalArrangement(this);
        mainContainer.Width(code_commonBits.getScreenWidth());
        mainContainer.Height(code_commonBits.getScreenHeight());
        mainContainer.BackgroundColor(0xff99bbff);
        myNotify = new Notifier(mainContainer);

        headerArrangement = new VerticalArrangement(mainContainer);
        headerArrangement.Width((int)(code_commonBits.getScreenWidth()));
        headerArrangement.HeightPercent(10);
        headerArrangement.AlignHorizontal(1);
        headerArrangement.AlignVertical(1);

        title = new Label(headerArrangement);
        title.Text("Operator");
        title.FontSize(20);
        title.FontBold(true);
        title.TextColor(0xffffffff);
        title.Visible(true);

        operatorScreenBodyWithSpacer = new HorizontalArrangement(mainContainer);
        operatorScreenBodyWithSpacer.Width((int)(code_commonBits.getScreenWidth()));
        operatorScreenBodyWithSpacer.Height((int)(code_commonBits.getScreenHeight()));

        //spacer that keeps everything 5% from the left
        leftSideSpacer = new VerticalArrangement(operatorScreenBodyWithSpacer);
        leftSideSpacer.WidthPercent(5);
        leftSideSpacer.Height(code_commonBits.getScreenHeight());

        operatorScreenBody = new VerticalArrangement(operatorScreenBodyWithSpacer);
        operatorScreenBody.Width((int)(code_commonBits.getScreenWidth()));
        operatorScreenBody.Height((int)(code_commonBits.getScreenHeight()));

        customersLabel = new Label(operatorScreenBody);
        customersLabel.FontSize(20);
        customersLabel.TextColor(0xff000000);
        customersLabel.Visible(true);
        customersLabel.Text("customers:");

        customers = new VerticalScrollArrangement(operatorScreenBody);
        customers.HeightPercent(25);
        customers.WidthPercent(90);
        customers.BackgroundColor(0xffffffff);
        customerList = new ListView(customers);
        customerList.Width(LENGTH_FILL_PARENT);
        customerList.HeightPercent(40);
        customerList.SelectionColor(COLOR_LTGRAY);
        customerList.ShowFilterBar(true);
        customerList.TextSize(40);
        customerList.TextColor(0xff004a99);
        customerList.BackgroundColor(COLOR_WHITE);

        customersControlButtonArea = new HorizontalArrangement(operatorScreenBody);
        customersControlButtonArea.WidthPercent(90);
        customersControlButtonArea.BackgroundColor(0xff99bbff);
        customersControlButtonArea.HeightPercent(10);

        customerControlAdd = new Button(customersControlButtonArea);
        customerControlAdd.WidthPercent(50);
        customerControlAdd.Text("Add");
        customerControlAdd.BackgroundColor(0xff004a99);
        customerControlAdd.TextColor(0xffffffff);

        customerControlEdit = new Button(customersControlButtonArea);
        customerControlEdit.WidthPercent(50);
        customerControlEdit.Text("Edit");
        customerControlEdit.BackgroundColor(0xff004a99);
        customerControlEdit.TextColor(0xffffffff);

        jobsLabel = new Label(operatorScreenBody);
        jobsLabel.FontSize(20);
        jobsLabel.TextColor(0xff000000);
        jobsLabel.Visible(true);
        jobsLabel.Text("jobs:");

        jobs = new VerticalScrollArrangement(operatorScreenBody);
        jobs.HeightPercent(25);
        jobs.WidthPercent(90);
        jobs.BackgroundColor(0xffffffff);
        jobList = new ListView(jobs);
        jobList.Width(LENGTH_FILL_PARENT);
        jobList.HeightPercent(40);
        jobList.SelectionColor(COLOR_LTGRAY);
        jobList.ShowFilterBar(true);
        jobList.TextSize(40);
        jobList.TextColor(0xff004a99);
        jobList.BackgroundColor(COLOR_WHITE);

        jobsControlButtonArea = new HorizontalArrangement(operatorScreenBody);
        jobsControlButtonArea.WidthPercent(90);
        jobsControlButtonArea.BackgroundColor(0xff99bbff);
        jobsControlButtonArea.HeightPercent(10);

        jobsControlAdd = new Button(jobsControlButtonArea);
        jobsControlAdd.WidthPercent(50);
        jobsControlAdd.Text("Add");
        jobsControlAdd.BackgroundColor(0xff004a99);
        jobsControlAdd.TextColor(0xffffffff);

        jobsControlEdit = new Button(jobsControlButtonArea);
        jobsControlEdit.WidthPercent(50);
        jobsControlEdit.Text("Edit");
        jobsControlEdit.BackgroundColor(0xff004a99);
        jobsControlEdit.TextColor(0xffffffff);

        EventDispatcher.registerEventForDelegation(this, "jobsControlAdd", "Click");
        EventDispatcher.registerEventForDelegation(this, "customerControlAdd", "Click");
        EventDispatcher.registerEventForDelegation(this, "customerList_webComponent", "GotText");
        EventDispatcher.registerEventForDelegation(this, "jobsList_webComponent", "GotText");

        customerList_webComponent = new Web(mainContainer);
        customerList_webComponent.Url(targetURL + "&" +
                code_commonBits.RequestCombine(new String[]{
                                code_commonBits.RequestValue("sessionID", sessionID),
                                code_commonBits.RequestValue("entity", "person")
                }));
        customerList_webComponent.Get();
        jobList_webComponent = new Web(mainContainer);
        jobList_webComponent.Url(targetURL + "&" +
                code_commonBits.RequestCombine(new String[]{
                        code_commonBits.RequestValue("sessionID", sessionID),
                        code_commonBits.RequestValue("entity", "job")
                }));
        jobList_webComponent.Get();
    }

    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params)
    {
        //if login button clicked
        if (component.equals(jobsControlAdd) && eventName.equals("Click"))  {
            addJobButtonClicked();
            return true;
        }
        else if (component.equals(customerControlAdd) && eventName.equals("Click")) {
            addCustomerButtonClicked();
            return true;
        }
        else if (component.equals(jobList_webComponent) && eventName.equals("GotText")) {
            String result = (String) params[3];
            gotJobs(result);
            return true;
        }
        else if (component.equals(customerList_webComponent) && eventName.equals("GotText")) {
            String result = (String) params[3];
            gotCustomers(result);
            return true;
        }
        else  {
            return false;
        }
    }

    public void addJobButtonClicked()
    {
        Intent AddJobIntent = new Intent(screen02_operatorHome.this, screen03_jobAddEdit.class);
        startActivity(AddJobIntent);
        finish();
    }

    public void addCustomerButtonClicked()
    {
        Intent intent = new Intent(this, screen04_customerAddEdit.class);
        Bundle b = new Bundle();
        b.putString("sessionID", sessionID); //Your id
        intent.putExtras(b); //Put your id to your next Intent
        startActivity(intent);
        finish();
//        Intent AddJobIntent = new Intent(screen02_operatorHome.this, screen04_customerAddEdit.class);
//        startActivity(AddJobIntent);
//        finish();
    }

    void gotCustomers(String result) {
        data_person myPerson = new data_person();
        try {
            JSONObject myJSONparser = new JSONObject(result);
            customerData = myJSONparser.getJSONArray("person");
            ArrayList<String> temp_NotYlist = new ArrayList<String>(myPerson.toList(customerData));
            YailList temp_Ylist = YailList.makeList(temp_NotYlist);
            customerList.Elements(temp_Ylist);
        } catch (JSONException e) {
            myNotify.ShowMessageDialog("Error getting customer list", "Error", "Grand");
        }
    }

    void gotJobs(String result) {
        try {
            JSONObject myJSONparser = new JSONObject(result);
            jobData = myJSONparser.getJSONArray("job");
            ArrayList<String> temp_NotYlist = new ArrayList<String>(toJobList(jobData));
            YailList temp_Ylist = YailList.makeList(temp_NotYlist);
            jobList.Elements(temp_Ylist);
        } catch (JSONException e) {
            myNotify.ShowMessageDialog("Error getting job list", "Error", "Grand");
        }
    }

    public ArrayList<String> toJobList (JSONArray data) {
        ArrayList<String> jobs = new ArrayList<String>();
        try {
            for (int n=0; n<=data.length()-1;n++) {
                String line = "[pID " + data.getJSONObject(n).getString("pID")
                        + "] " + data.getJSONObject(n).getString("Details")
                        + " of " + data.getJSONObject(n).getString("Location");
                jobs.add(line);
                Log.i("PCPITSTOP ",line); // remove when production ready
            }
            return jobs;

        } catch (JSONException e) {
            // if an exception occurs, code for it in here
        }
        return null;
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(this, screen01_startingLogin.class));
        finish();
    }

    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }


}