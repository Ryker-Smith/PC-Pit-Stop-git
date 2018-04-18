package net.fachtnaroe.pcpitstop_git;

import android.content.res.Resources;
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

public class screen10_userAddEdit extends Form implements HandlesEventDispatching
{
    private VerticalArrangement mainContainer;
    private VerticalArrangement leftSideSpacer;
    private VerticalArrangement headerArrangement;
    private HorizontalArrangement addUserScreenBodyWithSpacer;
    private VerticalArrangement addUserScreenBody;
    private HorizontalArrangement nameField;
    private VerticalArrangement nameArrangement;
    private HorizontalArrangement contactField;
    private VerticalArrangement contactArrangement;
    private HorizontalArrangement loginField;
    private VerticalArrangement loginArrangement;
    private HorizontalArrangement rolesField;
    private VerticalArrangement rolesArrangement;
    private Label title;
    private Label nameLabel;
    private Label contactLabel;
    private Label loginLabel;
    private Label rolesLabel;
    private TextBox firstName;
    private TextBox lastName;
    private TextBox phone;
    private TextBox email;
    private TextBox username;
    private PasswordTextBox password;
    private HorizontalArrangement addCustomerControlButtonArea;
    private Button customerControlSave;


    protected void $define() {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        mainContainer = new VerticalArrangement(this);
        mainContainer.Width(getScreenWidth());
        mainContainer.Height(getScreenHeight());
        mainContainer.BackgroundColor(0xff99bbff);

        headerArrangement = new VerticalArrangement(mainContainer);
        headerArrangement.Width((int) (getScreenWidth()));
        headerArrangement.HeightPercent(10);
        headerArrangement.AlignHorizontal(1);
        headerArrangement.AlignVertical(1);

        title = new Label(headerArrangement);
        title.Text("Add Customer");
        title.FontSize(20);
        title.FontBold(true);
        title.TextColor(0xffffffff);
        title.Visible(true);

        addUserScreenBodyWithSpacer = new HorizontalArrangement(mainContainer);
        addUserScreenBodyWithSpacer.Width((int) (getScreenWidth()));
        addUserScreenBodyWithSpacer.Height((int) (getScreenHeight()));

        //spacer that keeps everything 5% from the left
        leftSideSpacer = new VerticalArrangement(addUserScreenBodyWithSpacer);
        leftSideSpacer.WidthPercent(10);
        leftSideSpacer.Height(getScreenHeight());

        addUserScreenBody = new VerticalArrangement(addUserScreenBodyWithSpacer);
        addUserScreenBody.WidthPercent(90);
        addUserScreenBody.Height((int) (getScreenHeight()));

        nameField = new HorizontalArrangement(addUserScreenBody);
        nameField.WidthPercent(90);
        nameField.BackgroundColor(0xffe6f2ff);

        nameLabel = new Label(nameField);
        nameLabel.HeightPercent(10);
        nameLabel.WidthPercent(30);
        nameLabel.TextColor(0xff000000);
        nameLabel.Visible(true);
        nameLabel.Text("Name:");

        nameArrangement = new VerticalArrangement(nameField);
        nameArrangement.WidthPercent(60);

        firstName = new TextBox(nameArrangement);
        firstName.HeightPercent(10);
        firstName.WidthPercent(60);
        firstName.Hint("First Name");

        lastName = new TextBox(nameArrangement);
        lastName.HeightPercent(10);
        lastName.WidthPercent(60);
        lastName.Hint("Family Name");

        contactField = new HorizontalArrangement(addUserScreenBody);
        contactField.WidthPercent(90);
        contactField.BackgroundColor(0xffffffff);

        contactLabel = new Label(contactField);
        contactLabel.HeightPercent(10);
        contactLabel.WidthPercent(30);
        contactLabel.TextColor(0xff000000);
        contactLabel.Visible(true);
        contactLabel.Text("Contact Details:");

        contactArrangement = new VerticalArrangement(nameField);
        contactArrangement.WidthPercent(60);

        phone = new TextBox(contactArrangement);
        phone.HeightPercent(10);
        phone.WidthPercent(60);
        phone.Hint("phone");

        email = new TextBox(contactArrangement);
        email.HeightPercent(10);
        email.WidthPercent(60);
        email.Hint("email");

        loginField = new HorizontalArrangement(addUserScreenBody);
        loginField.WidthPercent(90);
        loginField.BackgroundColor(0xffe6f2ff);

        loginLabel = new Label(loginField);
        loginLabel.HeightPercent(10);
        loginLabel.WidthPercent(30);
        loginLabel.TextColor(0xff000000);
        loginLabel.Visible(true);
        loginLabel.Text("Login Details:");

        loginArrangement = new VerticalArrangement(loginField);
        loginArrangement.WidthPercent(60);

        username = new TextBox(loginArrangement);
        username.HeightPercent(10);
        username.WidthPercent(60);
        username.Hint("username");

        password = new PasswordTextBox(loginArrangement);
        password.HeightPercent(10);
        password.WidthPercent(60);
        password.Hint("password");

        rolesField = new HorizontalArrangement(addUserScreenBody);
        rolesField.WidthPercent(90);
        rolesField.BackgroundColor(0xffffffff);

        rolesLabel = new Label(rolesField);
        rolesLabel.HeightPercent(10);
        rolesLabel.WidthPercent(30);
        rolesLabel.TextColor(0xff000000);
        rolesLabel.Visible(true);
        rolesLabel.Text("Roles:");

        rolesArrangement = new VerticalArrangement(rolesField);

        addCustomerControlButtonArea = new HorizontalArrangement(addUserScreenBody);
        addCustomerControlButtonArea.WidthPercent(90);
        addCustomerControlButtonArea.BackgroundColor(0xff99bbff);
        addCustomerControlButtonArea.HeightPercent(10);

        customerControlSave = new Button(addCustomerControlButtonArea);
        customerControlSave.WidthPercent(50);
        customerControlSave.Text("Save");
        customerControlSave.BackgroundColor(0xff004a99);
        customerControlSave.TextColor(0xffffffff);
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
