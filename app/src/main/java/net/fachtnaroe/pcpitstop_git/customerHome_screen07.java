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
    private VerticalArrangement mainContainer;
    private VerticalArrangement leftSideSpacer;
    private VerticalArrangement headerArrangement;
    private HorizontalArrangement customerScreenBodyWithSpacer;
    private VerticalArrangement customerScreenBody;
    private Label title;
    private VerticalArrangement customerDetailsArrangement;
    private VerticalArrangement jobDetailsArrangement;
    private VerticalScrollArrangement actionsforSelectedJobArrangement;
    private Label customersLabel;
    private Label actionsLabel;
    private TextBox customerDetails;
    private ListPicker jobDetails;
    private TextBox actionsDetails;

    protected void $define()
    {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        mainContainer = new VerticalArrangement(this);
        mainContainer.Width(getScreenWidth());
        mainContainer.Height(getScreenHeight());
        mainContainer.BackgroundColor(0xff99bbff);

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

        jobDetailsArrangement = new VerticalArrangement(customerScreenBody);
        jobDetailsArrangement.BackgroundColor(0xffffffff);
        jobDetailsArrangement.HeightPercent(15);

        jobDetails = new ListPicker(jobDetailsArrangement);
        jobDetails.ElementsFromString("Job1, Job2, Job3");
        jobDetails.WidthPercent(90);
        jobDetails.Title("Jobs");

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
