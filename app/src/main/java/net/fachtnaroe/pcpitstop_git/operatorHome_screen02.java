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
    private TextBox jobsOne;
    private TextBox jobsTwo;
    private TextBox jobsThree;
    private TextBox customersOne;
    private TextBox customersTwo;
    private TextBox customersThree;


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
        title.Text("Operator");
        title.FontSize(20);
        title.FontBold(true);
        title.TextColor(0xffffffff);
        title.Visible(true);

        operatorScreenBodyWithSpacer = new HorizontalArrangement(mainContainer);
        operatorScreenBodyWithSpacer.Width((int)(getScreenWidth()));
        operatorScreenBodyWithSpacer.Height((int)(getScreenHeight()));

        //spacer that keeps everything 5% from the left
        leftSideSpacer = new VerticalArrangement(operatorScreenBodyWithSpacer);
        leftSideSpacer.WidthPercent(10);
        leftSideSpacer.Height(getScreenHeight());

        operatorScreenBody = new VerticalArrangement(operatorScreenBodyWithSpacer);
        operatorScreenBody.Width((int)(getScreenWidth()));
        operatorScreenBody.Height((int)(getScreenHeight()));

        jobsLabel = new Label(operatorScreenBody);
        jobsLabel.FontSize(20);
        jobsLabel.TextColor(0xff000000);
        jobsLabel.Visible(true);
        jobsLabel.Text("jobs:");

        jobs = new VerticalScrollArrangement(operatorScreenBody);
        jobs.HeightPercent(25);
        jobs.WidthPercent(90);
        jobs.BackgroundColor(0xffffffff);

        jobsOne =new TextBox(jobs);
        jobsOne.HeightPercent(10);
        jobsOne.Text("This is detail one");
        jobsOne.Enabled(false);

        jobsTwo =new TextBox(jobs);
        jobsTwo.HeightPercent(10);
        jobsTwo.Text("This is detail two");
        jobsTwo.Enabled(false);

        jobsThree =new TextBox(jobs);
        jobsThree.HeightPercent(10);
        jobsThree.Text("This is detail three");
        jobsThree.Enabled(false);

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

        customersLabel = new Label(operatorScreenBody);
        customersLabel.FontSize(20);
        customersLabel.TextColor(0xff000000);
        customersLabel.Visible(true);
        customersLabel.Text("customers:");

        customers = new VerticalScrollArrangement(operatorScreenBody);
        customers.HeightPercent(25);
        customers.WidthPercent(90);
        customers.BackgroundColor(0xffffffff);

        customersOne =new TextBox(customers);
        customersOne.HeightPercent(10);
        customersOne.Text("This is detail one");
        customersOne.Enabled(false);

        customersTwo =new TextBox(customers);
        customersTwo.HeightPercent(10);
        customersTwo.Text("This is detail two");
        customersTwo.Enabled(false);

        customersThree =new TextBox(customers);
        customersThree.HeightPercent(10);
        customersThree.Text("This is detail three");
        customersThree.Enabled(false);

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

        EventDispatcher.registerEventForDelegation(this, "jobsControlAdd", "Click");
        EventDispatcher.registerEventForDelegation(this, "customerControlAdd", "Click");
    }

    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params)
    {
        //if login button clicked
        if (component.equals(jobsControlAdd) && eventName.equals("Click"))
        {
            addJobButtonClicked();
            return true;
        }

        else if (component.equals(jobsControlAdd) && eventName.equals("Click"))
        {
            addCustomerButtonClicked();
            return true;
        }

        else
        {
            return false;
        }
    }

    public void addJobButtonClicked()
    {
        Intent AddJobIntent = new Intent(operatorHome_screen02.this, jobAddEdit_screen03.class);
        startActivity(AddJobIntent);
        finish();
    }

    public void addCustomerButtonClicked()
    {
        Intent AddJobIntent = new Intent(operatorHome_screen02.this, customerAddEdit_screen04.class);
        startActivity(AddJobIntent);
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