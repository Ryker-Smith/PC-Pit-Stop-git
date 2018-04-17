package net.fachtnaroe.pcpitstop_git;

import android.content.res.Resources;
import android.view.WindowManager;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalArrangement;

public class customerAddEdit_screen04 extends Form implements HandlesEventDispatching
{
    private VerticalArrangement PCPS_mainContainer;
    private VerticalArrangement PCPS_leftSideSpacer;
    private VerticalArrangement PCPS_headerArrangement;
    private HorizontalArrangement PCPS_AddCustomerScreenBodyWithSpacer;
    private VerticalArrangement PCPS_AddCustomerScreenBody;
    private HorizontalArrangement PCPS_NameField;
    private VerticalArrangement PCPS_NameArrangement;
    private HorizontalArrangement PCPS_ContactField;
    private VerticalArrangement PCPS_ContactArrangement;
    private HorizontalArrangement PCPS_AddressField;
    private VerticalArrangement PCPS_AddressArrangement;
    private VerticalArrangement PCPS_LocateArrangement;
    private HorizontalArrangement PCPS_GPSField;
    private HorizontalArrangement PCPS_NotesField;
    private Label PCPS_Title;
    private Label PCPS_NameLabel;
    private Label PCPS_ContactLabel;
    private Label PCPS_AddressLabel;
    private Label PCPS_GPSLabel;
    private Label PCPS_NotesLabel;
    private TextBox PCPS_FirstName;
    private TextBox PCPS_LastName;
    private TextBox PCPS_Phone;
    private TextBox PCPS_Email;
    private TextBox PCPS_AddressLineOne;
    private TextBox PCPS_AddressLineTwo;
    private TextBox PCPS_AddressLineThree;
    private Button PCPS_AutoLocateButton;
    private TextBox PCPS_GPSLocation;
    private HorizontalArrangement PCPS_AddCustomerControlButtonArea;
    private Button PCPS_CustomerControl_Save;


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
        PCPS_Title.Text("Add Customer");
        PCPS_Title.FontSize(20);
        PCPS_Title.FontBold(true);
        PCPS_Title.TextColor(0xffffffff);
        PCPS_Title.Visible(true);

        PCPS_AddCustomerScreenBodyWithSpacer = new HorizontalArrangement(PCPS_mainContainer);
        PCPS_AddCustomerScreenBodyWithSpacer.Width((int)(getScreenWidth()));
        PCPS_AddCustomerScreenBodyWithSpacer.Height((int)(getScreenHeight()));

        //spacer that keeps everything 5% from the left
        PCPS_leftSideSpacer = new VerticalArrangement(PCPS_AddCustomerScreenBodyWithSpacer);
        PCPS_leftSideSpacer.WidthPercent(10);
        PCPS_leftSideSpacer.Height(getScreenHeight());

        PCPS_AddCustomerScreenBody = new VerticalArrangement(PCPS_AddCustomerScreenBodyWithSpacer);
        PCPS_AddCustomerScreenBody.WidthPercent(90);
        PCPS_AddCustomerScreenBody.Height((int)(getScreenHeight()));

        PCPS_NameField = new HorizontalArrangement(PCPS_AddCustomerScreenBody);
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

        PCPS_LastName = new TextBox(PCPS_NameArrangement);
        PCPS_LastName.HeightPercent(10);
        PCPS_LastName.WidthPercent(60);

        PCPS_ContactField = new HorizontalArrangement(PCPS_AddCustomerScreenBody);
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

        PCPS_Email = new TextBox(PCPS_ContactArrangement);
        PCPS_Email.HeightPercent(10);
        PCPS_Email.WidthPercent(60);

        PCPS_AddressField = new HorizontalArrangement(PCPS_AddCustomerScreenBody);
        PCPS_AddressField.WidthPercent(90);
        PCPS_AddressField.BackgroundColor(0xffe6f2ff);

        PCPS_LocateArrangement = new VerticalArrangement(PCPS_AddressField);
        PCPS_LocateArrangement.WidthPercent(30);

        PCPS_AddressLabel = new Label(PCPS_LocateArrangement);
        PCPS_AddressLabel.HeightPercent(10);
        PCPS_AddressLabel.WidthPercent(30);
        PCPS_AddressLabel.TextColor(0xff000000);
        PCPS_AddressLabel.Visible(true);
        PCPS_AddressLabel.Text("Address:");

        PCPS_AutoLocateButton = new Button(PCPS_LocateArrangement);
        PCPS_AutoLocateButton.HeightPercent(10);
        PCPS_AutoLocateButton.Text("Auto Locate");
        PCPS_AutoLocateButton.WidthPercent(25);
        PCPS_AutoLocateButton.FontSize(10);
        PCPS_AutoLocateButton.BackgroundColor(0xff004a99);
        PCPS_AutoLocateButton.TextColor(0xffffffff);

        PCPS_AddressArrangement = new VerticalArrangement(PCPS_AddressField);
        PCPS_AddressArrangement.WidthPercent(60);

        PCPS_AddressLineOne = new TextBox(PCPS_AddressArrangement);
        PCPS_AddressLineOne.HeightPercent(10);
        PCPS_AddressLineOne.WidthPercent(60);

        PCPS_AddressLineTwo = new TextBox(PCPS_AddressArrangement);
        PCPS_AddressLineTwo.HeightPercent(10);
        PCPS_AddressLineTwo.WidthPercent(60);

        PCPS_AddressLineThree = new TextBox(PCPS_AddressArrangement);
        PCPS_AddressLineThree.HeightPercent(10);
        PCPS_AddressLineThree.WidthPercent(60);

        PCPS_GPSField = new HorizontalArrangement(PCPS_AddCustomerScreenBody);
        PCPS_GPSField.WidthPercent(90);
        PCPS_GPSField.BackgroundColor(0xffffffff);

        PCPS_GPSLabel = new Label(PCPS_GPSField);
        PCPS_GPSLabel.HeightPercent(10);
        PCPS_GPSLabel.WidthPercent(30);
        PCPS_GPSLabel.TextColor(0xff000000);
        PCPS_GPSLabel.Visible(true);
        PCPS_GPSLabel.Text("GPS:");

        PCPS_GPSLocation = new TextBox(PCPS_GPSField);
        PCPS_GPSLocation.HeightPercent(10);
        PCPS_GPSLocation.WidthPercent(60);
        PCPS_GPSLocation.BackgroundColor(0xffffffff);
        PCPS_GPSLocation.Enabled(false);

        PCPS_NotesField = new HorizontalArrangement(PCPS_AddCustomerScreenBody);
        PCPS_NotesField.WidthPercent(90);
        PCPS_NotesField.BackgroundColor(0xffe6f2ff);

        PCPS_NotesLabel = new Label(PCPS_NotesField);
        PCPS_NotesLabel.HeightPercent(10);
        PCPS_NotesLabel.WidthPercent(30);
        PCPS_NotesLabel.TextColor(0xff000000);
        PCPS_NotesLabel.Visible(true);
        PCPS_NotesLabel.Text("Notes:");

        PCPS_AddCustomerControlButtonArea = new HorizontalArrangement(PCPS_AddCustomerScreenBody);
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
