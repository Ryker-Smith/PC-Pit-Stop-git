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
import com.google.appinventor.components.runtime.VerticalArrangement;


public class screen09_administratorHome extends Form implements HandlesEventDispatching
{
    private VerticalArrangement mainContainer;
    private VerticalArrangement leftSideSpacer;
    private VerticalArrangement headerArrangement;
    private HorizontalArrangement adminScreenBodyWithSpacer;
    private VerticalArrangement adminScreenBody;
    private Label title;
    private VerticalArrangement customerListArrangement;
    private VerticalArrangement jobListArrangement;
    private VerticalArrangement actionsListArrangement;
    private VerticalArrangement techniciansListArrangement;
    private VerticalArrangement userListArrangement;
    private Button customerList;
    private Button jobList;
    private Button actionsList;
    private Button techniciansList;
    private Button userList;



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
        title.Text("Admin");
        title.FontSize(20);
        title.FontBold(true);
        title.TextColor(0xffffffff);
        title.Visible(true);

        adminScreenBodyWithSpacer = new HorizontalArrangement(mainContainer);
        adminScreenBodyWithSpacer.Width((int)(getScreenWidth()));
        adminScreenBodyWithSpacer.Height((int)(getScreenHeight()));

        //spacer that keeps everything 5% from the left
        leftSideSpacer = new VerticalArrangement(adminScreenBodyWithSpacer);
        leftSideSpacer.WidthPercent(10);
        leftSideSpacer.Height(getScreenHeight());

        adminScreenBody = new VerticalArrangement(adminScreenBodyWithSpacer);
        adminScreenBody.Width((int)(getScreenWidth()));
        adminScreenBody.Height((int)(getScreenHeight()));

        customerListArrangement = new VerticalArrangement(adminScreenBody);
        customerListArrangement.BackgroundColor(0xff99bbff);
        customerListArrangement.HeightPercent(20);

        jobListArrangement = new VerticalArrangement(adminScreenBody);
        jobListArrangement.BackgroundColor(0xff99bbff);
        jobListArrangement.HeightPercent(20);

        actionsListArrangement = new VerticalArrangement(adminScreenBody);
        actionsListArrangement.BackgroundColor(0xff99bbff);
        actionsListArrangement.HeightPercent(20);

        techniciansListArrangement = new VerticalArrangement(adminScreenBody);
        techniciansListArrangement.BackgroundColor(0xff99bbff);
        techniciansListArrangement.HeightPercent(20);

        userListArrangement = new VerticalArrangement(adminScreenBody);
        userListArrangement.BackgroundColor(0xff99bbff);
        userListArrangement.HeightPercent(20);

        customerList = new Button(customerListArrangement);
        customerList.HeightPercent(15);
        customerList.WidthPercent(90);
        customerList.Text("Customer List");
        customerList.BackgroundColor(0xff004a99);
        customerList.TextColor(0xffffffff);
        customerList.FontSize(14);

        jobList = new Button(jobListArrangement);
        jobList.HeightPercent(15);
        jobList.WidthPercent(90);
        jobList.Text("Job List");
        jobList.BackgroundColor(0xff004a99);
        jobList.TextColor(0xffffffff);
        jobList.FontSize(14);

        actionsList = new Button(actionsListArrangement);
        actionsList.HeightPercent(15);
        actionsList.WidthPercent(90);
        actionsList.Text("Actions List");
        actionsList.BackgroundColor(0xff004a99);
        actionsList.TextColor(0xffffffff);
        actionsList.FontSize(14);

        techniciansList = new Button(techniciansListArrangement);
        techniciansList.HeightPercent(15);
        techniciansList.WidthPercent(90);
        techniciansList.Text("Technicians List");
        techniciansList.BackgroundColor(0xff004a99);
        techniciansList.TextColor(0xffffffff);
        techniciansList.FontSize(14);

        userList = new Button(userListArrangement);
        userList.HeightPercent(15);
        userList.WidthPercent(90);
        userList.Text("User List");
        userList.BackgroundColor(0xff004a99);
        userList.TextColor(0xffffffff);
        userList.FontSize(14);

        EventDispatcher.registerEventForDelegation(this, "customerList", "Click");
        EventDispatcher.registerEventForDelegation(this, "userList", "Click");
        EventDispatcher.registerEventForDelegation(this, "techniciansList", "Click");
    }

    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params)
    {
        //if login button clicked
        if (component.equals(customerList) && eventName.equals("Click"))
        {
            CustomerListClicked();
            return true;
        }

        else if (component.equals(userList) && eventName.equals("Click"))
        {
            UserListClicked();
            return true;
        }

        else if (component.equals(techniciansList) && eventName.equals("Click"))
        {
            UserListClicked();
            return true;
        }

        else
        {
            return false;
        }
    }

    public void CustomerListClicked()
    {
        Intent CustomerListIntent = new Intent(screen09_administratorHome.this, screen04_customerAddEdit.class);
        startActivity(CustomerListIntent);
        finish();
    }

    public void UserListClicked()
    {
        Intent UserListIntent = new Intent(screen09_administratorHome.this, screen10_userAddEdit.class);
        startActivity(UserListIntent);
        finish();
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