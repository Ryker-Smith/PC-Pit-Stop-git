package net.fachtnaroe.pcpitstop_git;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.ListPicker;
import com.google.appinventor.components.runtime.ListView;
import com.google.appinventor.components.runtime.Notifier;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;
import com.google.appinventor.components.runtime.Web;
import com.google.appinventor.components.runtime.util.YailList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static net.fachtnaroe.pcpitstop_git.code_commonBits.targetURL;

public class screen07_customerHome extends Form implements HandlesEventDispatching
{
    private VerticalArrangement mainContaine;
    private VerticalArrangement leftSideSpacer;
    private VerticalArrangement headerArrangement;
    private HorizontalArrangement customerScreenBodyWithSpacer;
    private VerticalArrangement customerScreenBody;
    private Label title;
    private VerticalArrangement customerDetailsArrangement;
    private VerticalArrangement jobDetailsArrangement;
    private VerticalScrollArrangement actionsforSelectedJobArrangement;
    private VerticalScrollArrangement jobs;
    private Label customersLabel;
    private Label actionsLabel;
    private TextBox customerDetails;
    private ListPicker jobDetails;
    private ListView jobList;
    private TextBox actionsDetails;
    private Notifier myNotify;
    private JSONArray jobData;
    private Web jobList_webComponent;
    private String sessionID;
    private Label jobsLabel;
    private HorizontalArrangement jobsControlButtonArea;
    private Button jobsControlReport;
    private HorizontalArrangement customerDetailsControlButtonArea;
    private Button customerDetailsControlReport;
    private HorizontalArrangement actionsDetailsControlButtonArea;
    private Button actionsDetailsControlReport;
    private VerticalScrollArrangement mainContainer;

    protected void $define()
    {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        Bundle b = getIntent().getExtras();
        if (b != null) {
            sessionID = b.getString("sessionID");
        }

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        mainContainer = new VerticalScrollArrangement(this);
        mainContainer.Width(getScreenWidth());
        mainContainer.Height(getScreenHeight());
        mainContainer.BackgroundColor(0xff99bbff);
        myNotify = new Notifier(mainContainer);

        headerArrangement = new VerticalArrangement(mainContainer);
        headerArrangement.Width((int)(getScreenWidth()));
        headerArrangement.HeightPercent(10);
        headerArrangement.AlignHorizontal(1);
        headerArrangement.AlignVertical(1);

        title = new Label(headerArrangement);
        title.Text("Customer");
        title.FontSize(20);
        title.FontBold(true);
        title.TextColor(0xffffffff);
        title.Visible(true);

        customerScreenBodyWithSpacer = new HorizontalArrangement(mainContainer);
        customerScreenBodyWithSpacer.Width((int)(getScreenWidth()));
        customerScreenBodyWithSpacer.Height((int)(getScreenHeight()));

        //spacer that keeps everything 5% from the left
        leftSideSpacer = new VerticalArrangement(customerScreenBodyWithSpacer);
        leftSideSpacer.WidthPercent(10);
        leftSideSpacer.Height(getScreenHeight());

        customerScreenBody = new VerticalArrangement(customerScreenBodyWithSpacer);
        customerScreenBody.Width((int)(getScreenWidth()));
        customerScreenBody.Height((int)(getScreenHeight()));

        customerDetailsArrangement = new VerticalArrangement(customerScreenBody);
        customerDetailsArrangement.BackgroundColor(0xffe6f2ff);
        customerDetailsArrangement.HeightPercent(20);

            customersLabel = new Label(customerDetailsArrangement);
            customersLabel.FontSize(20);
            customersLabel.TextColor(0xff000000);
            customersLabel.Visible(true);
            customersLabel.Text("My Details:");

            customerDetails = new TextBox(customerDetailsArrangement);
            customerDetails.Enabled(false);
            customerDetails.Text("Customer Details go here");
            customerDetails.WidthPercent(90);
            customerDetails.HeightPercent(35);

            customerDetailsControlButtonArea = new HorizontalArrangement(customerScreenBody);
            customerDetailsControlButtonArea.WidthPercent(90);
            customerDetailsControlButtonArea.BackgroundColor(0xff99bbff);
            customerDetailsControlButtonArea.HeightPercent(10);

            customerDetailsControlReport = new Button(customerDetailsControlButtonArea);
            customerDetailsControlReport.WidthPercent(30);
    //        customerDetailsControlReport.HeightPercent(100);
            customerDetailsControlReport.Text("Report");
            customerDetailsControlReport.BackgroundColor(0xff004a99);
            customerDetailsControlReport.TextColor(0xffffffff);

        jobsLabel = new Label(customerScreenBody);
        jobsLabel.FontSize(20);
        jobsLabel.TextColor(0xff000000);
        jobsLabel.Visible(true);
        jobsLabel.Text("Jobs:");

        jobs = new VerticalScrollArrangement(customerScreenBody);
        jobs.HeightPercent(20);
        jobs.WidthPercent(90);
        jobs.BackgroundColor(0xffffffff);
        jobList = new ListView(jobs);
        jobList.Width(LENGTH_FILL_PARENT);
        jobList.HeightPercent(20);
        jobList.SelectionColor(COLOR_LTGRAY);
        jobList.ShowFilterBar(true);
        jobList.TextSize(40);
        jobList.TextColor(0xff004a99);
        jobList.BackgroundColor(COLOR_WHITE);

        jobsControlButtonArea = new HorizontalArrangement(customerScreenBody);
        jobsControlButtonArea.WidthPercent(90);
        jobsControlButtonArea.BackgroundColor(0xff99bbff);
        jobsControlButtonArea.HeightPercent(10);

        jobsControlReport = new Button(jobsControlButtonArea);
        jobsControlReport.WidthPercent(30);
        jobsControlReport.Text("Report");
        jobsControlReport.BackgroundColor(0xff004a99);
        jobsControlReport.TextColor(0xffffffff);

        actionsforSelectedJobArrangement = new VerticalScrollArrangement(customerScreenBody);
        actionsforSelectedJobArrangement.BackgroundColor(0xffe6f2ff);
        actionsforSelectedJobArrangement.HeightPercent(30);

        actionsLabel = new Label(actionsforSelectedJobArrangement);
        actionsLabel.FontSize(20);
        actionsLabel.TextColor(0xff000000);
        actionsLabel.Visible(true);
        actionsLabel.Text("Actions taken:");

        actionsDetails = new TextBox(actionsforSelectedJobArrangement);
        actionsDetails.Enabled(false);
        actionsDetails.Text("Job Action Details go here");
        actionsDetails.WidthPercent(90);
        actionsDetails.HeightPercent(25);

        actionsDetailsControlButtonArea = new HorizontalArrangement(actionsforSelectedJobArrangement);
        actionsDetailsControlButtonArea.WidthPercent(90);
        actionsDetailsControlButtonArea.BackgroundColor(0xff99bbff);
        actionsDetailsControlButtonArea.HeightPercent(10);

        actionsDetailsControlReport = new Button(actionsDetailsControlButtonArea);
        actionsDetailsControlReport.WidthPercent(50);
        actionsDetailsControlReport.Text("Report");
        actionsDetailsControlReport.BackgroundColor(0xff004a99);
        actionsDetailsControlReport.TextColor(0xffffffff);

        EventDispatcher.registerEventForDelegation(this, "jobsList_webComponent", "GotText");

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
//        //if login button clicked
//        if (component.equals(jobsControlAdd) && eventName.equals("Click"))  {
//            addJobButtonClicked();
//            return true;
//        }
        if (component.equals(jobList_webComponent) && eventName.equals("GotText")) {
            String result = (String) params[3];
            gotJobs(result);
            return true;
        }
        else  {
            return false;
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
            for (int n = 0; n <= data.length() - 1; n++) {
                String line = "[pID " + data.getJSONObject(n).getString("pID")
                        + "] " + data.getJSONObject(n).getString("Details")
                        + " of " + data.getJSONObject(n).getString("Location");
                jobs.add(line);
                Log.i("PCPITSTOP ", line); // remove when production ready
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
        finish();
        startActivity(new Intent(this, screen01_startingLogin.class));
    }

    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
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
