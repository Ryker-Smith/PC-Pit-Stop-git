package net.fachtnaroe.pcpitstop_git;

import android.content.Intent;
import android.content.res.Resources;
import android.view.WindowManager;

import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.ListPicker;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;


public class customerHome_screen07 extends Form implements HandlesEventDispatching
{
    private VerticalArrangement PCPS_mainContainer;
    private VerticalArrangement PCPS_leftSideSpacer;
    private VerticalArrangement PCPS_headerArrangement;
    private HorizontalArrangement PCPS_CustomerScreenBodyWithSpacer;
    private VerticalArrangement PCPS_CustomerScreenBody;
    private Label PCPS_Title;
    private VerticalArrangement PCPS_CustomerDetailsArrangement;
    private VerticalArrangement PCPS_JobDetailsArrangement;
    private VerticalScrollArrangement PCPS_ActionsforSelectedJobArrangement;
    private Label PCPS_CustomersLabel;
    private Label PCPS_ActionsLabel;
    private TextBox PCPS_CustomerDetails;
    private ListPicker PCPS_JobDetails;
    private TextBox PCPS_ActionsDetails;



    protected void $define()
    {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        PCPS_mainContainer = new VerticalArrangement(this);
        PCPS_mainContainer.Width(getScreenWidth());
        PCPS_mainContainer.Height(getScreenHeight());
        PCPS_mainContainer.BackgroundColor(0xff99bbff);

        PCPS_headerArrangement = new VerticalArrangement(PCPS_mainContainer);
        PCPS_headerArrangement.Width((int)(getScreenWidth()));
        PCPS_headerArrangement.HeightPercent(10);
        PCPS_headerArrangement.AlignHorizontal(1);
        PCPS_headerArrangement.AlignVertical(1);

        PCPS_Title = new Label(PCPS_headerArrangement);
        PCPS_Title.Text("Customer");
        PCPS_Title.FontSize(20);
        PCPS_Title.FontBold(true);
        PCPS_Title.TextColor(0xffffffff);
        PCPS_Title.Visible(true);

        PCPS_CustomerScreenBodyWithSpacer = new HorizontalArrangement(PCPS_mainContainer);
        PCPS_CustomerScreenBodyWithSpacer.Width((int)(getScreenWidth()));
        PCPS_CustomerScreenBodyWithSpacer.Height((int)(getScreenHeight()));

        //spacer that keeps everything 5% from the left
        PCPS_leftSideSpacer = new VerticalArrangement(PCPS_CustomerScreenBodyWithSpacer);
        PCPS_leftSideSpacer.WidthPercent(10);
        PCPS_leftSideSpacer.Height(getScreenHeight());

        PCPS_CustomerScreenBody = new VerticalArrangement(PCPS_CustomerScreenBodyWithSpacer);
        PCPS_CustomerScreenBody.Width((int)(getScreenWidth()));
        PCPS_CustomerScreenBody.Height((int)(getScreenHeight()));

        PCPS_CustomerDetailsArrangement = new VerticalArrangement(PCPS_CustomerScreenBody);
        PCPS_CustomerDetailsArrangement.BackgroundColor(0xffe6f2ff);
        PCPS_CustomerDetailsArrangement.HeightPercent(20);

        PCPS_CustomersLabel = new Label(PCPS_CustomerDetailsArrangement);
        PCPS_CustomersLabel.FontSize(20);
        PCPS_CustomersLabel.TextColor(0xff000000);
        PCPS_CustomersLabel.Visible(true);
        PCPS_CustomersLabel.Text("My Details:");

        PCPS_CustomerDetails = new TextBox(PCPS_CustomerDetailsArrangement);
        PCPS_CustomerDetails.Enabled(false);
        PCPS_CustomerDetails.Text("Customer Details go here");
        PCPS_CustomerDetails.WidthPercent(90);
        PCPS_CustomerDetails.HeightPercent(35);

        PCPS_JobDetailsArrangement = new VerticalArrangement(PCPS_CustomerScreenBody);
        PCPS_JobDetailsArrangement.BackgroundColor(0xffffffff);
        PCPS_JobDetailsArrangement.HeightPercent(15);

        PCPS_JobDetails = new ListPicker(PCPS_JobDetailsArrangement);
        PCPS_JobDetails.ElementsFromString("Job1, Job2, Job3");
        PCPS_JobDetails.WidthPercent(90);
        PCPS_JobDetails.Title("Jobs");

        PCPS_ActionsforSelectedJobArrangement = new VerticalScrollArrangement(PCPS_CustomerScreenBody);
        PCPS_ActionsforSelectedJobArrangement.BackgroundColor(0xffe6f2ff);
        PCPS_ActionsforSelectedJobArrangement.HeightPercent(30);

        PCPS_ActionsLabel = new Label(PCPS_ActionsforSelectedJobArrangement);
        PCPS_ActionsLabel.FontSize(20);
        PCPS_ActionsLabel.TextColor(0xff000000);
        PCPS_ActionsLabel.Visible(true);
        PCPS_ActionsLabel.Text("Actions taken:");

        PCPS_ActionsDetails = new TextBox(PCPS_ActionsforSelectedJobArrangement);
        PCPS_ActionsDetails.Enabled(false);
        PCPS_ActionsDetails.Text("Job Action Details go here");
        PCPS_ActionsDetails.WidthPercent(90);
        PCPS_ActionsDetails.HeightPercent(25);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        finish();
        startActivity(new Intent(this, startingLogin_screen01.class));
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
