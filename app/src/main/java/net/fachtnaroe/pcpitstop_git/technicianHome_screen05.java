package net.fachtnaroe.pcpitstop_git;

import android.content.Intent;
import android.content.res.Resources;
import android.view.WindowManager;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.ListPicker;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;


public class technicianHome_screen05 extends Form implements HandlesEventDispatching
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
    //placeholders below---v
    private TextBox detailsOne;
    private TextBox detailsTwo;
    private TextBox detailsThree;

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
        title.Text("Technician");
        title.FontSize(20);
        title.FontBold(true);
        title.TextColor(0xffffffff);
        title.Visible(true);

        techScreenBodyWithSpacer = new HorizontalArrangement(mainContainer);
        techScreenBodyWithSpacer.Width((int)(getScreenWidth()));
        techScreenBodyWithSpacer.Height((int)(getScreenHeight()));

        //spacer that keeps everything 5% from the left
        leftSideSpacer = new VerticalArrangement(techScreenBodyWithSpacer);
        leftSideSpacer.WidthPercent(10);
        leftSideSpacer.Height(getScreenHeight());

        techScreenBody = new VerticalArrangement(techScreenBodyWithSpacer);
        techScreenBody.Width((int)(getScreenWidth()));
        techScreenBody.Height((int)(getScreenHeight()));

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
    }

    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params)
    {
        //if login button clicked
        if (component.equals(jobsControlAdd) && eventName.equals("Click"))
        {
            jobsControl_AddClicked();
            return true;
        }
        else
        {
            return false;
        }
    }

    public void jobsControl_AddClicked()
    {
        Intent CustomerListIntent = new Intent(technicianHome_screen05.this, actionAddEdit_screen06.class);
        startActivity(CustomerListIntent);
        finish();
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