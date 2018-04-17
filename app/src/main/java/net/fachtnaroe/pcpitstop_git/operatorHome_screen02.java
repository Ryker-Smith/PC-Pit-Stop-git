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
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;


public class operatorHome_screen02 extends Form implements HandlesEventDispatching
{
    private VerticalArrangement PCPS_mainContainer;
    private VerticalArrangement PCPS_leftSideSpacer;
    private VerticalArrangement PCPS_headerArrangement;
    private HorizontalArrangement PCPS_OperatorScreenBodyWithSpacer;
    private VerticalArrangement PCPS_OperatorScreenBody;
    private HorizontalArrangement PCPS_JobsControlButtonArea;
    private Button PCPS_JobsControl_Add;
    private Button PCPS_JobsControl_Edit;
    private HorizontalArrangement PCPS_CustomersControlButtonArea;
    private Button PCPS_CustomerControl_Add;
    private Button PCPS_CustomerControl_Edit;
    private Label PCPS_Title;
    private Label PCPS_JobsLabel;
    private Label PCPS_CustomersLabel;
    private VerticalScrollArrangement PCPS_Jobs;
    private VerticalScrollArrangement PCPS_Customers;
    //placeholders below---v
    private TextBox JobsOne;
    private TextBox JobsTwo;
    private TextBox JobsThree;
    private TextBox CustomersOne;
    private TextBox CustomersTwo;
    private TextBox CustomersThree;


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
        PCPS_Title.Text("Operator");
        PCPS_Title.FontSize(20);
        PCPS_Title.FontBold(true);
        PCPS_Title.TextColor(0xffffffff);
        PCPS_Title.Visible(true);

        PCPS_OperatorScreenBodyWithSpacer = new HorizontalArrangement(PCPS_mainContainer);
        PCPS_OperatorScreenBodyWithSpacer.Width((int)(getScreenWidth()));
        PCPS_OperatorScreenBodyWithSpacer.Height((int)(getScreenHeight()));

        //spacer that keeps everything 5% from the left
        PCPS_leftSideSpacer = new VerticalArrangement(PCPS_OperatorScreenBodyWithSpacer);
        PCPS_leftSideSpacer.WidthPercent(10);
        PCPS_leftSideSpacer.Height(getScreenHeight());

        PCPS_OperatorScreenBody = new VerticalArrangement(PCPS_OperatorScreenBodyWithSpacer);
        PCPS_OperatorScreenBody.Width((int)(getScreenWidth()));
        PCPS_OperatorScreenBody.Height((int)(getScreenHeight()));

        PCPS_JobsLabel = new Label(PCPS_OperatorScreenBody);
        PCPS_JobsLabel.FontSize(20);
        PCPS_JobsLabel.TextColor(0xff000000);
        PCPS_JobsLabel.Visible(true);
        PCPS_JobsLabel.Text("Jobs:");

        PCPS_Jobs = new VerticalScrollArrangement(PCPS_OperatorScreenBody);
        PCPS_Jobs.HeightPercent(25);
        PCPS_Jobs.WidthPercent(90);
        PCPS_Jobs.BackgroundColor(0xffffffff);

        JobsOne =new TextBox(PCPS_Jobs);
        JobsOne.HeightPercent(10);
        JobsOne.Text("This is detail one");
        JobsOne.Enabled(false);

        JobsTwo =new TextBox(PCPS_Jobs);
        JobsTwo.HeightPercent(10);
        JobsTwo.Text("This is detail two");
        JobsTwo.Enabled(false);

        JobsThree =new TextBox(PCPS_Jobs);
        JobsThree.HeightPercent(10);
        JobsThree.Text("This is detail three");
        JobsThree.Enabled(false);

        PCPS_JobsControlButtonArea = new HorizontalArrangement(PCPS_OperatorScreenBody);
        PCPS_JobsControlButtonArea.WidthPercent(90);
        PCPS_JobsControlButtonArea.BackgroundColor(0xff99bbff);
        PCPS_JobsControlButtonArea.HeightPercent(10);

        PCPS_JobsControl_Add = new Button(PCPS_JobsControlButtonArea);
        PCPS_JobsControl_Add.WidthPercent(50);
        PCPS_JobsControl_Add.Text("Add");
        PCPS_JobsControl_Add.BackgroundColor(0xff004a99);
        PCPS_JobsControl_Add.TextColor(0xffffffff);

        PCPS_JobsControl_Edit = new Button(PCPS_JobsControlButtonArea);
        PCPS_JobsControl_Edit.WidthPercent(50);
        PCPS_JobsControl_Edit.Text("Edit");
        PCPS_JobsControl_Edit.BackgroundColor(0xff004a99);
        PCPS_JobsControl_Edit.TextColor(0xffffffff);

        PCPS_CustomersLabel = new Label(PCPS_OperatorScreenBody);
        PCPS_CustomersLabel.FontSize(20);
        PCPS_CustomersLabel.TextColor(0xff000000);
        PCPS_CustomersLabel.Visible(true);
        PCPS_CustomersLabel.Text("Customers:");

        PCPS_Customers = new VerticalScrollArrangement(PCPS_OperatorScreenBody);
        PCPS_Customers.HeightPercent(25);
        PCPS_Customers.WidthPercent(90);
        PCPS_Customers.BackgroundColor(0xffffffff);

        CustomersOne =new TextBox(PCPS_Customers);
        CustomersOne.HeightPercent(10);
        CustomersOne.Text("This is detail one");
        CustomersOne.Enabled(false);

        CustomersTwo =new TextBox(PCPS_Customers);
        CustomersTwo.HeightPercent(10);
        CustomersTwo.Text("This is detail two");
        CustomersTwo.Enabled(false);

        CustomersThree =new TextBox(PCPS_Customers);
        CustomersThree.HeightPercent(10);
        CustomersThree.Text("This is detail three");
        CustomersThree.Enabled(false);

        PCPS_CustomersControlButtonArea = new HorizontalArrangement(PCPS_OperatorScreenBody);
        PCPS_CustomersControlButtonArea.WidthPercent(90);
        PCPS_CustomersControlButtonArea.BackgroundColor(0xff99bbff);
        PCPS_CustomersControlButtonArea.HeightPercent(10);

        PCPS_CustomerControl_Add = new Button(PCPS_CustomersControlButtonArea);
        PCPS_CustomerControl_Add.WidthPercent(50);
        PCPS_CustomerControl_Add.Text("Add");
        PCPS_CustomerControl_Add.BackgroundColor(0xff004a99);
        PCPS_CustomerControl_Add.TextColor(0xffffffff);

        PCPS_CustomerControl_Edit = new Button(PCPS_CustomersControlButtonArea);
        PCPS_CustomerControl_Edit.WidthPercent(50);
        PCPS_CustomerControl_Edit.Text("Edit");
        PCPS_CustomerControl_Edit.BackgroundColor(0xff004a99);
        PCPS_CustomerControl_Edit.TextColor(0xffffffff);

        EventDispatcher.registerEventForDelegation(this, "PCPS_JobsControl_Add", "Click");
        EventDispatcher.registerEventForDelegation(this, "PCPS_CustomerControl_Add", "Click");
    }

    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params)
    {
        //if login button clicked
        if (component.equals(PCPS_JobsControl_Add) && eventName.equals("Click"))
        {
            PCPS_AddJobButtonClicked();
            return true;
        }

        else if (component.equals(PCPS_JobsControl_Add) && eventName.equals("Click"))
        {
            PCPS_AddCustomerButtonClicked();
            return true;
        }

        else
        {
            return false;
        }
    }

    public void PCPS_AddJobButtonClicked()
    {
        Intent PCPS_AddJobIntent = new Intent(operatorHome_screen02.this, jobAddEdit_screen03.class);
        startActivity(PCPS_AddJobIntent);
        finish();
    }

    public void PCPS_AddCustomerButtonClicked()
    {
        Intent PCPS_AddJobIntent = new Intent(operatorHome_screen02.this, customerAddEdit_screen04.class);
        startActivity(PCPS_AddJobIntent);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(this, startingLogin_screen01.class));
        finish();
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