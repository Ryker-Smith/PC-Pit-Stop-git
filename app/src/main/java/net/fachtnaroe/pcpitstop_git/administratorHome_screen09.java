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


public class administratorHome_screen09 extends Form implements HandlesEventDispatching
{
    private VerticalArrangement PCPS_mainContainer;
    private VerticalArrangement PCPS_leftSideSpacer;
    private VerticalArrangement PCPS_headerArrangement;
    private HorizontalArrangement PCPS_AdminScreenBodyWithSpacer;
    private VerticalArrangement PCPS_AdminScreenBody;
    private Label PCPS_Title;
    private VerticalArrangement PCPS_CustomerListArrangement;
    private VerticalArrangement PCPS_JobListArrangement;
    private VerticalArrangement PCPS_ActionsListArrangement;
    private VerticalArrangement PCPS_TechniciansListArrangement;
    private VerticalArrangement PCPS_UserListArrangement;
    private Button PCPS_CustomerList;
    private Button PCPS_JobList;
    private Button PCPS_ActionsList;
    private Button PCPS_TechniciansList;
    private Button PCPS_UserList;



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
        PCPS_Title.Text("Admin");
        PCPS_Title.FontSize(20);
        PCPS_Title.FontBold(true);
        PCPS_Title.TextColor(0xffffffff);
        PCPS_Title.Visible(true);

        PCPS_AdminScreenBodyWithSpacer = new HorizontalArrangement(PCPS_mainContainer);
        PCPS_AdminScreenBodyWithSpacer.Width((int)(getScreenWidth()));
        PCPS_AdminScreenBodyWithSpacer.Height((int)(getScreenHeight()));

        //spacer that keeps everything 5% from the left
        PCPS_leftSideSpacer = new VerticalArrangement(PCPS_AdminScreenBodyWithSpacer);
        PCPS_leftSideSpacer.WidthPercent(10);
        PCPS_leftSideSpacer.Height(getScreenHeight());

        PCPS_AdminScreenBody = new VerticalArrangement(PCPS_AdminScreenBodyWithSpacer);
        PCPS_AdminScreenBody.Width((int)(getScreenWidth()));
        PCPS_AdminScreenBody.Height((int)(getScreenHeight()));

        PCPS_CustomerListArrangement = new VerticalArrangement(PCPS_AdminScreenBody);
        PCPS_CustomerListArrangement.BackgroundColor(0xff99bbff);
        PCPS_CustomerListArrangement.HeightPercent(20);

        PCPS_JobListArrangement = new VerticalArrangement(PCPS_AdminScreenBody);
        PCPS_JobListArrangement.BackgroundColor(0xff99bbff);
        PCPS_JobListArrangement.HeightPercent(20);

        PCPS_ActionsListArrangement = new VerticalArrangement(PCPS_AdminScreenBody);
        PCPS_ActionsListArrangement.BackgroundColor(0xff99bbff);
        PCPS_ActionsListArrangement.HeightPercent(20);

        PCPS_TechniciansListArrangement = new VerticalArrangement(PCPS_AdminScreenBody);
        PCPS_TechniciansListArrangement.BackgroundColor(0xff99bbff);
        PCPS_TechniciansListArrangement.HeightPercent(20);

        PCPS_UserListArrangement = new VerticalArrangement(PCPS_AdminScreenBody);
        PCPS_UserListArrangement.BackgroundColor(0xff99bbff);
        PCPS_UserListArrangement.HeightPercent(20);

        PCPS_CustomerList = new Button(PCPS_CustomerListArrangement);
        PCPS_CustomerList.HeightPercent(15);
        PCPS_CustomerList.WidthPercent(90);
        PCPS_CustomerList.Text("Customer List");
        PCPS_CustomerList.BackgroundColor(0xff004a99);
        PCPS_CustomerList.TextColor(0xffffffff);
        PCPS_CustomerList.FontSize(14);

        PCPS_JobList = new Button(PCPS_JobListArrangement);
        PCPS_JobList.HeightPercent(15);
        PCPS_JobList.WidthPercent(90);
        PCPS_JobList.Text("Job List");
        PCPS_JobList.BackgroundColor(0xff004a99);
        PCPS_JobList.TextColor(0xffffffff);
        PCPS_JobList.FontSize(14);

        PCPS_ActionsList = new Button(PCPS_ActionsListArrangement);
        PCPS_ActionsList.HeightPercent(15);
        PCPS_ActionsList.WidthPercent(90);
        PCPS_ActionsList.Text("Actions List");
        PCPS_ActionsList.BackgroundColor(0xff004a99);
        PCPS_ActionsList.TextColor(0xffffffff);
        PCPS_ActionsList.FontSize(14);

        PCPS_TechniciansList = new Button(PCPS_TechniciansListArrangement);
        PCPS_TechniciansList.HeightPercent(15);
        PCPS_TechniciansList.WidthPercent(90);
        PCPS_TechniciansList.Text("Technicians List");
        PCPS_TechniciansList.BackgroundColor(0xff004a99);
        PCPS_TechniciansList.TextColor(0xffffffff);
        PCPS_TechniciansList.FontSize(14);

        PCPS_UserList = new Button(PCPS_UserListArrangement);
        PCPS_UserList.HeightPercent(15);
        PCPS_UserList.WidthPercent(90);
        PCPS_UserList.Text("User List");
        PCPS_UserList.BackgroundColor(0xff004a99);
        PCPS_UserList.TextColor(0xffffffff);
        PCPS_UserList.FontSize(14);

        EventDispatcher.registerEventForDelegation(this, "PCPS_CustomerList", "Click");
        EventDispatcher.registerEventForDelegation(this, "PCPS_UserList", "Click");
        EventDispatcher.registerEventForDelegation(this, "PCPS_TechniciansList", "Click");
    }

    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params)
    {
        //if login button clicked
        if (component.equals(PCPS_CustomerList) && eventName.equals("Click"))
        {
            PCPS_CustomerListClicked();
            return true;
        }

        else if (component.equals(PCPS_UserList) && eventName.equals("Click"))
        {
            PCPS_UserListClicked();
            return true;
        }

        else if (component.equals(PCPS_TechniciansList) && eventName.equals("Click"))
        {
            PCPS_UserListClicked();
            return true;
        }

        else
        {
            return false;
        }
    }

    public void PCPS_CustomerListClicked()
    {
        Intent PCPS_CustomerListIntent = new Intent(administratorHome_screen09.this, customerAddEdit_screen04.class);
        startActivity(PCPS_CustomerListIntent);
        finish();
    }

    public void PCPS_UserListClicked()
    {
        Intent PCPS_UserListIntent = new Intent(administratorHome_screen09.this, userAddEdit_screen10.class);
        startActivity(PCPS_UserListIntent);
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