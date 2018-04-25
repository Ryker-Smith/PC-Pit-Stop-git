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


public class screen05_technicianHome extends Form implements HandlesEventDispatching
{
    private VerticalArrangement mainContainer;
    private VerticalArrangement leftSideSpacer;
    private VerticalArrangement headerArrangement;
    private HorizontalArrangement techScreenBodyWithSpacer;
    private VerticalArrangement techScreenBody;
    private Label title;
    private Label jobsLabel;
    private Label jobsDescriptionLabel;
    private ListPicker jobs;
    private VerticalScrollArrangement jobDescription;
    private HorizontalArrangement jobsControlButtonArea;
    private Button jobsControlAdd;
    private Button jobsControlEdit;
    private Web webHost;
    private JSONArray jobList;
    private Notifier myNotify;
    private String sessionID;

    //placeholders below---v
    private TextBox detailsOne;
    private TextBox detailsTwo;
    private TextBox detailsThree;

    protected void $define()
    {

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        Bundle b = getIntent().getExtras();
        if (b != null) {
            sessionID = b.getString("sessionID");
        }
        mainContainer = new VerticalArrangement(this);
        mainContainer.Width(getScreenWidth());
        mainContainer.Height(getScreenHeight());
        mainContainer.BackgroundColor(0xff99bbff);

        headerArrangement = new VerticalArrangement(mainContainer);
        headerArrangement.Width((getScreenWidth()));
        headerArrangement.HeightPercent(10);
        headerArrangement.AlignHorizontal(1);
        headerArrangement.AlignVertical(1);

        title = new Label(headerArrangement);
        title.Text("Technician");
        title.FontSize(20);
        title.FontBold(true);
        title.TextColor(0xffffffff);
        title.Visible(true);

        techScreenBodyWithSpacer = new HorizontalArrangement(mainContainer);
        techScreenBodyWithSpacer.Width((getScreenWidth()));
        techScreenBodyWithSpacer.Height((getScreenHeight()));

        //spacer that keeps everything 5% from the left
        leftSideSpacer = new VerticalArrangement(techScreenBodyWithSpacer);
        leftSideSpacer.WidthPercent(10);
        leftSideSpacer.Height(getScreenHeight());

        techScreenBody = new VerticalArrangement(techScreenBodyWithSpacer);
        techScreenBody.Width((getScreenWidth()));
        techScreenBody.Height((getScreenHeight()));

        jobsLabel = new Label(techScreenBody);
        jobsLabel.FontSize(20);
        jobsLabel.TextColor(0xff000000);
        jobsLabel.Visible(true);
        jobsLabel.Text("jobs:");

        jobs = new ListPicker(techScreenBody);
        jobs.HeightPercent(25);
        jobs.WidthPercent(90);
        jobs.BackgroundColor(0xffffffff);

        jobsDescriptionLabel = new Label(techScreenBody);
        jobsDescriptionLabel.FontSize(20);
        jobsDescriptionLabel.TextColor(0xff000000);
        jobsDescriptionLabel.Visible(true);
        jobsDescriptionLabel.Text("Details:");

        jobDescription = new VerticalScrollArrangement(techScreenBody);
        jobDescription.HeightPercent(40);
        jobDescription.WidthPercent(90);
        jobDescription.BackgroundColor(0xffffffff);

        detailsOne =new TextBox(jobDescription);
        detailsOne.HeightPercent(20);
        detailsOne.Text("This is detail one");
        detailsOne.Enabled(false);

        detailsTwo =new TextBox(jobDescription);
        detailsTwo.HeightPercent(20);
        detailsTwo.Text("This is detail two");
        detailsTwo.Enabled(false);

        detailsThree =new TextBox(jobDescription);
        detailsThree.HeightPercent(20);
        detailsThree.Text("This is detail three");
        detailsThree.Enabled(false);

        jobsControlButtonArea = new HorizontalArrangement(techScreenBody);
        jobsControlButtonArea.WidthPercent(90);
        jobsControlButtonArea.BackgroundColor(0xff99bbff);
        jobsControlButtonArea.HeightPercent(10);

        jobsControlAdd = new Button(jobsControlButtonArea);
        jobsControlAdd.WidthPercent(50);
        jobsControlAdd.Text("Add Action");
        jobsControlAdd.BackgroundColor(0xff004a99);
        jobsControlAdd.TextColor(0xffffffff);

        jobsControlEdit = new Button(jobsControlButtonArea);
        jobsControlEdit.WidthPercent(50);
        jobsControlEdit.Text("Edit");
        jobsControlEdit.BackgroundColor(0xff004a99);
        jobsControlEdit.TextColor(0xffffffff);

        EventDispatcher.registerEventForDelegation(this, "jobsControlAdd", "Click");
        EventDispatcher.registerEventForDelegation(this, "webHost", "gotText" );
        webHost = new Web(mainContainer);
        webHost.Url(targetURL + "&" +
                code_commonBits.RequestCombine(new String[]{
                        code_commonBits.RequestValue("sessionID", sessionID),
                        code_commonBits.RequestValue("entity", "job")
                }));
        webHost.Get();

    }
    //list of jobs, from backend. Details populated into relevant fields. Page has ability to add an action to a job, Or edit existing details.

    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params)
    {
        //if login button clicked
        if (component.equals(jobsControlAdd) && eventName.equals("Click"))
        {
            jobsControl_AddClicked();
            return true;
        }
        else if (component.equals(webHost) && eventName.equals("GotText")) {
            String result = (String) params[3];
            gotJobs(result);
            return true;
        }
        else
        {
            return false;
        }
    }

    public void jobsControl_AddClicked()
    {
        Intent CustomerListIntent = new Intent(screen05_technicianHome.this, screen06_actionAddEdit.class);
        startActivity(CustomerListIntent);
        finish();
    }
    public void gotJobs(String result){
        try {
            JSONObject myJSONparser = new JSONObject(result);
            jobList = myJSONparser.getJSONArray("job");
            ArrayList<String> temp_NotYlist = new ArrayList<>(toJobList(jobList));
            YailList temp_Ylist = YailList.makeList(temp_NotYlist);
            jobs.Elements();
        }
        catch (JSONException e) {
            myNotify.ShowMessageDialog("Error getting job list", "Error", "Grand");
        }
    }
    public ArrayList<String> toJobList (JSONArray data) {
        ArrayList<String> jobs = new ArrayList<>();
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