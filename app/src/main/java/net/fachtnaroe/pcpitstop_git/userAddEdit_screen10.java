package net.fachtnaroe.pcpitstop_git;

import android.content.res.Resources;
import android.text.LoginFilter;
import android.view.WindowManager;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.PasswordTextBox;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalArrangement;

/**
 * Created by Steveyc on 27/02/2018.
 */

public class userAddEdit_screen10 extends Form implements HandlesEventDispatching
{
    private VerticalArrangement PCPS_mainContainer;
    private VerticalArrangement PCPS_leftSideSpacer;
    private VerticalArrangement PCPS_headerArrangement;
    private HorizontalArrangement PCPS_AddUserScreenBodyWithSpacer;
    private VerticalArrangement PCPS_AddUserScreenBody;
    private HorizontalArrangement PCPS_NameField;
    private VerticalArrangement PCPS_NameArrangement;
    private HorizontalArrangement PCPS_ContactField;
    private VerticalArrangement PCPS_ContactArrangement;
    private HorizontalArrangement PCPS_LoginField;
    private VerticalArrangement PCPS_LoginArrangement;
    private HorizontalArrangement PCPS_RolesField;
    private VerticalArrangement PCPS_RolesArrangement;
    private Label PCPS_Title;
    private Label PCPS_NameLabel;
    private Label PCPS_ContactLabel;
    private Label PCPS_LoginLabel;
    private Label PCPS_RolesLabel;
    private TextBox PCPS_FirstName;
    private TextBox PCPS_LastName;
    private TextBox PCPS_Phone;
    private TextBox PCPS_Email;
    private TextBox PCPS_Username;
    private PasswordTextBox PCPS_Password;
    private HorizontalArrangement PCPS_AddCustomerControlButtonArea;
    private Button PCPS_CustomerControl_Save;


    protected void $define() {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        PCPS_mainContainer = new VerticalArrangement(this);
        PCPS_mainContainer.Width(getScreenWidth());
        PCPS_mainContainer.Height(getScreenHeight());
        PCPS_mainContainer.BackgroundColor(0xff99bbff);

        PCPS_headerArrangement = new VerticalArrangement(PCPS_mainContainer);
        PCPS_headerArrangement.Width((int) (getScreenWidth()));
        PCPS_headerArrangement.HeightPercent(10);
        PCPS_headerArrangement.AlignHorizontal(1);
        PCPS_headerArrangement.AlignVertical(1);

        PCPS_Title = new Label(PCPS_headerArrangement);
        PCPS_Title.Text("Add Customer");
        PCPS_Title.FontSize(20);
        PCPS_Title.FontBold(true);
        PCPS_Title.TextColor(0xffffffff);
        PCPS_Title.Visible(true);

        PCPS_AddUserScreenBodyWithSpacer = new HorizontalArrangement(PCPS_mainContainer);
        PCPS_AddUserScreenBodyWithSpacer.Width((int) (getScreenWidth()));
        PCPS_AddUserScreenBodyWithSpacer.Height((int) (getScreenHeight()));

        //spacer that keeps everything 5% from the left
        PCPS_leftSideSpacer = new VerticalArrangement(PCPS_AddUserScreenBodyWithSpacer);
        PCPS_leftSideSpacer.WidthPercent(10);
        PCPS_leftSideSpacer.Height(getScreenHeight());

        PCPS_AddUserScreenBody = new VerticalArrangement(PCPS_AddUserScreenBodyWithSpacer);
        PCPS_AddUserScreenBody.WidthPercent(90);
        PCPS_AddUserScreenBody.Height((int) (getScreenHeight()));

        PCPS_NameField = new HorizontalArrangement(PCPS_AddUserScreenBody);
        PCPS_NameField.WidthPercent(90);
        PCPS_NameField.BackgroundColor(0xffe6f2ff);

        PCPS_NameLabel = new Label(PCPS_NameField);
        PCPS_NameLabel.HeightPercent(10);
        PCPS_NameLabel.WidthPercent(30);
        PCPS_NameLabel.TextColor(0xff000000);
        PCPS_NameLabel.Visible(true);
        PCPS_NameLabel.Text("Name:");

        PCPS_NameArrangement = new VerticalArrangement(PCPS_NameField);
        PCPS_NameArrangement.WidthPercent(60);

        PCPS_FirstName = new TextBox(PCPS_NameArrangement);
        PCPS_FirstName.HeightPercent(10);
        PCPS_FirstName.WidthPercent(60);
        PCPS_FirstName.Hint("First Name");

        PCPS_LastName = new TextBox(PCPS_NameArrangement);
        PCPS_LastName.HeightPercent(10);
        PCPS_LastName.WidthPercent(60);
        PCPS_LastName.Hint("Family Name");

        PCPS_ContactField = new HorizontalArrangement(PCPS_AddUserScreenBody);
        PCPS_ContactField.WidthPercent(90);
        PCPS_ContactField.BackgroundColor(0xffffffff);

        PCPS_ContactLabel = new Label(PCPS_ContactField);
        PCPS_ContactLabel.HeightPercent(10);
        PCPS_ContactLabel.WidthPercent(30);
        PCPS_ContactLabel.TextColor(0xff000000);
        PCPS_ContactLabel.Visible(true);
        PCPS_ContactLabel.Text("Contact Details:");

        PCPS_ContactArrangement = new VerticalArrangement(PCPS_NameField);
        PCPS_ContactArrangement.WidthPercent(60);

        PCPS_Phone = new TextBox(PCPS_ContactArrangement);
        PCPS_Phone.HeightPercent(10);
        PCPS_Phone.WidthPercent(60);
        PCPS_Phone.Hint("Phone");

        PCPS_Email = new TextBox(PCPS_ContactArrangement);
        PCPS_Email.HeightPercent(10);
        PCPS_Email.WidthPercent(60);
        PCPS_Email.Hint("Email");

        PCPS_LoginField = new HorizontalArrangement(PCPS_AddUserScreenBody);
        PCPS_LoginField.WidthPercent(90);
        PCPS_LoginField.BackgroundColor(0xffe6f2ff);

        PCPS_LoginLabel = new Label(PCPS_LoginField);
        PCPS_LoginLabel.HeightPercent(10);
        PCPS_LoginLabel.WidthPercent(30);
        PCPS_LoginLabel.TextColor(0xff000000);
        PCPS_LoginLabel.Visible(true);
        PCPS_LoginLabel.Text("Login Details:");

        PCPS_LoginArrangement = new VerticalArrangement(PCPS_LoginField);
        PCPS_LoginArrangement.WidthPercent(60);

        PCPS_Username = new TextBox(PCPS_LoginArrangement);
        PCPS_Username.HeightPercent(10);
        PCPS_Username.WidthPercent(60);
        PCPS_Username.Hint("Username");

        PCPS_Password = new PasswordTextBox(PCPS_LoginArrangement);
        PCPS_Password.HeightPercent(10);
        PCPS_Password.WidthPercent(60);
        PCPS_Password.Hint("Password");

        PCPS_RolesField = new HorizontalArrangement(PCPS_AddUserScreenBody);
        PCPS_RolesField.WidthPercent(90);
        PCPS_RolesField.BackgroundColor(0xffffffff);

        PCPS_RolesLabel = new Label(PCPS_RolesField);
        PCPS_RolesLabel.HeightPercent(10);
        PCPS_RolesLabel.WidthPercent(30);
        PCPS_RolesLabel.TextColor(0xff000000);
        PCPS_RolesLabel.Visible(true);
        PCPS_RolesLabel.Text("Roles:");

        PCPS_RolesArrangement = new VerticalArrangement(PCPS_RolesField);

        PCPS_AddCustomerControlButtonArea = new HorizontalArrangement(PCPS_AddUserScreenBody);
        PCPS_AddCustomerControlButtonArea.WidthPercent(90);
        PCPS_AddCustomerControlButtonArea.BackgroundColor(0xff99bbff);
        PCPS_AddCustomerControlButtonArea.HeightPercent(10);

        PCPS_CustomerControl_Save = new Button(PCPS_AddCustomerControlButtonArea);
        PCPS_CustomerControl_Save.WidthPercent(50);
        PCPS_CustomerControl_Save.Text("Save");
        PCPS_CustomerControl_Save.BackgroundColor(0xff004a99);
        PCPS_CustomerControl_Save.TextColor(0xffffffff);
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
