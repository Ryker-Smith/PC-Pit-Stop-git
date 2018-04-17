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
    private VerticalArrangement mainContainer;
    private VerticalArrangement leftSideSpacer;
    private VerticalArrangement headerArrangement;
    private HorizontalArrangement addCustomerScreenBodyWithSpacer;
    private VerticalArrangement addCustomerScreenBody;
    private HorizontalArrangement nameField;
    private VerticalArrangement nameArrangement;
    private HorizontalArrangement contactField;
    private VerticalArrangement contactArrangement;
    private HorizontalArrangement addressField;
    private VerticalArrangement addressArrangement;
    private VerticalArrangement locateArrangement;
    private HorizontalArrangement GPSField;
    private HorizontalArrangement notesField;
    private Label title;
    private Label nameLabel;
    private Label contactLabel;
    private Label addressLabel;
    private Label GPSLabel;
    private Label notesLabel;
    private TextBox firstName;
    private TextBox lastName;
    private TextBox phone;
    private TextBox email;
    private TextBox addressLineOne;
    private TextBox addressLineTwo;
    private TextBox addressLineThree;
    private Button autoLocateButton;
    private TextBox GPSLocation;
    private HorizontalArrangement addCustomerControlButtonArea;
    private Button customerControl_Save;


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
        title.Text("Add Customer");
        title.FontSize(20);
        title.FontBold(true);
        title.TextColor(0xffffffff);
        title.Visible(true);

        addCustomerScreenBodyWithSpacer = new HorizontalArrangement(mainContainer);
        addCustomerScreenBodyWithSpacer.Width((int)(getScreenWidth()));
        addCustomerScreenBodyWithSpacer.Height((int)(getScreenHeight()));

        //spacer that keeps everything 5% from the left
        leftSideSpacer = new VerticalArrangement(addCustomerScreenBodyWithSpacer);
        leftSideSpacer.WidthPercent(10);
        leftSideSpacer.Height(getScreenHeight());

        addCustomerScreenBody = new VerticalArrangement(addCustomerScreenBodyWithSpacer);
        addCustomerScreenBody.WidthPercent(90);
        addCustomerScreenBody.Height((int)(getScreenHeight()));

        nameField = new HorizontalArrangement(addCustomerScreenBody);
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

        lastName = new TextBox(nameArrangement);
        lastName.HeightPercent(10);
        lastName.WidthPercent(60);

        contactField = new HorizontalArrangement(addCustomerScreenBody);
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

        email = new TextBox(contactArrangement);
        email.HeightPercent(10);
        email.WidthPercent(60);

        addressField = new HorizontalArrangement(addCustomerScreenBody);
        addressField.WidthPercent(90);
        addressField.BackgroundColor(0xffe6f2ff);

        locateArrangement = new VerticalArrangement(addressField);
        locateArrangement.WidthPercent(30);

        addressLabel = new Label(locateArrangement);
        addressLabel.HeightPercent(10);
        addressLabel.WidthPercent(30);
        addressLabel.TextColor(0xff000000);
        addressLabel.Visible(true);
        addressLabel.Text("Address:");

        autoLocateButton = new Button(locateArrangement);
        autoLocateButton.HeightPercent(10);
        autoLocateButton.Text("Auto Locate");
        autoLocateButton.WidthPercent(25);
        autoLocateButton.FontSize(10);
        autoLocateButton.BackgroundColor(0xff004a99);
        autoLocateButton.TextColor(0xffffffff);

        addressArrangement = new VerticalArrangement(addressField);
        addressArrangement.WidthPercent(60);

        addressLineOne = new TextBox(addressArrangement);
        addressLineOne.HeightPercent(10);
        addressLineOne.WidthPercent(60);

        addressLineTwo = new TextBox(addressArrangement);
        addressLineTwo.HeightPercent(10);
        addressLineTwo.WidthPercent(60);

        addressLineThree = new TextBox(addressArrangement);
        addressLineThree.HeightPercent(10);
        addressLineThree.WidthPercent(60);

        GPSField = new HorizontalArrangement(addCustomerScreenBody);
        GPSField.WidthPercent(90);
        GPSField.BackgroundColor(0xffffffff);

        GPSLabel = new Label(GPSField);
        GPSLabel.HeightPercent(10);
        GPSLabel.WidthPercent(30);
        GPSLabel.TextColor(0xff000000);
        GPSLabel.Visible(true);
        GPSLabel.Text("GPS:");

        GPSLocation = new TextBox(GPSField);
        GPSLocation.HeightPercent(10);
        GPSLocation.WidthPercent(60);
        GPSLocation.BackgroundColor(0xffffffff);
        GPSLocation.Enabled(false);

        notesField = new HorizontalArrangement(addCustomerScreenBody);
        notesField.WidthPercent(90);
        notesField.BackgroundColor(0xffe6f2ff);

        notesLabel = new Label(notesField);
        notesLabel.HeightPercent(10);
        notesLabel.WidthPercent(30);
        notesLabel.TextColor(0xff000000);
        notesLabel.Visible(true);
        notesLabel.Text("Notes:");

        addCustomerControlButtonArea = new HorizontalArrangement(addCustomerScreenBody);
        addCustomerControlButtonArea.WidthPercent(90);
        addCustomerControlButtonArea.BackgroundColor(0xff99bbff);
        addCustomerControlButtonArea.HeightPercent(10);

        customerControl_Save = new Button(addCustomerControlButtonArea);
        customerControl_Save.WidthPercent(50);
        customerControl_Save.Text("Save");
        customerControl_Save.BackgroundColor(0xff004a99);
        customerControl_Save.TextColor(0xffffffff);
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
