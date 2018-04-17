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
    private VerticalArrangement PCPS_mainContainer;
    private VerticalArrangement PCPS_leftSideSpacer;
    private VerticalArrangement PCPS_headerArrangement;
    private HorizontalArrangement PCPS_TechScreenBodyWithSpacer;
    private VerticalArrangement PCPS_TechScreenBody;
    private Label PCPS_Title;
    private Label PCPS_JobsLabel;
    private Label PCPS_JobsDescriptionLabel;
    private ListPicker PCPS_Jobs;
    private VerticalScrollArrangement PCPS_JobDescription;
    private HorizontalArrangement PCPS_JobsControlButtonArea;
    private Button PCPS_JobsControl_Add;
    private Button PCPS_JobsControl_Edit;
    //placeholders below---v
    private TextBox DetailsOne;
    private TextBox DetailsTwo;
    private TextBox DetailsThree;

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
        PCPS_Title.Text("Technician");
        PCPS_Title.FontSize(20);
        PCPS_Title.FontBold(true);
        PCPS_Title.TextColor(0xffffffff);
        PCPS_Title.Visible(true);

        PCPS_TechScreenBodyWithSpacer = new HorizontalArrangement(PCPS_mainContainer);
        PCPS_TechScreenBodyWithSpacer.Width((int)(getScreenWidth()));
        PCPS_TechScreenBodyWithSpacer.Height((int)(getScreenHeight()));

        //spacer that keeps everything 5% from the left
        PCPS_leftSideSpacer = new VerticalArrangement(PCPS_TechScreenBodyWithSpacer);
        PCPS_leftSideSpacer.WidthPercent(10);
        PCPS_leftSideSpacer.Height(getScreenHeight());

        PCPS_TechScreenBody = new VerticalArrangement(PCPS_TechScreenBodyWithSpacer);
        PCPS_TechScreenBody.Width((int)(getScreenWidth()));
        PCPS_TechScreenBody.Height((int)(getScreenHeight()));

        PCPS_JobsLabel = new Label(PCPS_TechScreenBody);
        PCPS_JobsLabel.FontSize(20);
        PCPS_JobsLabel.TextColor(0xff000000);
        PCPS_JobsLabel.Visible(true);
        PCPS_JobsLabel.Text("Jobs:");

        PCPS_Jobs = new ListPicker(PCPS_TechScreenBody);
        PCPS_Jobs.HeightPercent(25);
        PCPS_Jobs.WidthPercent(90);
        PCPS_Jobs.BackgroundColor(0xffffffff);

        PCPS_JobsDescriptionLabel = new Label(PCPS_TechScreenBody);
        PCPS_JobsDescriptionLabel.FontSize(20);
        PCPS_JobsDescriptionLabel.TextColor(0xff000000);
        PCPS_JobsDescriptionLabel.Visible(true);
        PCPS_JobsDescriptionLabel.Text("Details:");

        PCPS_JobDescription = new VerticalScrollArrangement(PCPS_TechScreenBody);
        PCPS_JobDescription.HeightPercent(40);
        PCPS_JobDescription.WidthPercent(90);
        PCPS_JobDescription.BackgroundColor(0xffffffff);

        DetailsOne=new TextBox(PCPS_JobDescription);
        DetailsOne.HeightPercent(20);
        DetailsOne.Text("This is detail one");
        DetailsOne.Enabled(false);

        DetailsTwo=new TextBox(PCPS_JobDescription);
        DetailsTwo.HeightPercent(20);
        DetailsTwo.Text("This is detail two");
        DetailsTwo.Enabled(false);

        DetailsThree=new TextBox(PCPS_JobDescription);
        DetailsThree.HeightPercent(20);
        DetailsThree.Text("This is detail three");
        DetailsThree.Enabled(false);

        PCPS_JobsControlButtonArea = new HorizontalArrangement(PCPS_TechScreenBody);
        PCPS_JobsControlButtonArea.WidthPercent(90);
        PCPS_JobsControlButtonArea.BackgroundColor(0xff99bbff);
        PCPS_JobsControlButtonArea.HeightPercent(10);

        PCPS_JobsControl_Add = new Button(PCPS_JobsControlButtonArea);
        PCPS_JobsControl_Add.WidthPercent(50);
        PCPS_JobsControl_Add.Text("Add Action");
        PCPS_JobsControl_Add.BackgroundColor(0xff004a99);
        PCPS_JobsControl_Add.TextColor(0xffffffff);

        PCPS_JobsControl_Edit = new Button(PCPS_JobsControlButtonArea);
        PCPS_JobsControl_Edit.WidthPercent(50);
        PCPS_JobsControl_Edit.Text("Edit");
        PCPS_JobsControl_Edit.BackgroundColor(0xff004a99);
        PCPS_JobsControl_Edit.TextColor(0xffffffff);

        EventDispatcher.registerEventForDelegation(this, "PCPS_JobsControl_Add", "Click");
    }

    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params)
    {
        //if login button clicked
        if (component.equals(PCPS_JobsControl_Add) && eventName.equals("Click"))
        {
            PCPS_JobsControl_AddClicked();
            return true;
        }
        else
        {
            return false;
        }
    }

    public void PCPS_JobsControl_AddClicked()
    {
        Intent PCPS_CustomerListIntent = new Intent(technicianHome_screen05.this, actionAddEdit_screen06.class);
        startActivity(PCPS_CustomerListIntent);
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