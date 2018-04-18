package net.fachtnaroe.pcpitstop_git;

import android.content.res.Resources;
import android.view.WindowManager;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.Spinner;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalArrangement;

public class screen03_jobAddEdit extends Form implements HandlesEventDispatching
{
    private VerticalArrangement mainContainer;
    private VerticalArrangement leftSideSpacer;
    private VerticalArrangement headerArrangement;
    private HorizontalArrangement addJobScreenBodyWithSpacer;
    private VerticalArrangement addJobScreenBody;
    private HorizontalArrangement customerNumField;
    private HorizontalArrangement locationField;
    private HorizontalArrangement homeAddressField;
    private HorizontalArrangement GPSField;
    private HorizontalArrangement descriptionField;
    private HorizontalArrangement imageField;
    private Label title;
    private Label customerLabel;
    private Spinner customerNum;
    private Label locationLabel;
    private TextBox location;
    private Button useGPSButton;
    private TextBox GPSLocation;
    private Label descriptionLabel;
    private TextBox description;
    private Label imagesLabel;
    private HorizontalArrangement addJobControlButtonArea;
    private Button addJobControlSave;
    private Button homeAddressButton;
    private TextBox homeAddressTextBox;
    private Button addImageButton;


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
        title.Text("Add Job");
        title.FontSize(20);
        title.FontBold(true);
        title.TextColor(0xffffffff);
        title.Visible(true);

        addJobScreenBodyWithSpacer = new HorizontalArrangement(mainContainer);
        addJobScreenBodyWithSpacer.Width((int)(getScreenWidth()));
        addJobScreenBodyWithSpacer.Height((int)(getScreenHeight()));

        //spacer that keeps everything 5% from the left
        leftSideSpacer = new VerticalArrangement(addJobScreenBodyWithSpacer);
        leftSideSpacer.WidthPercent(10);
        leftSideSpacer.Height(getScreenHeight());

        addJobScreenBody = new VerticalArrangement(addJobScreenBodyWithSpacer);
        addJobScreenBody.WidthPercent(90);
        addJobScreenBody.Height((int)(getScreenHeight()));

        customerNumField = new HorizontalArrangement(addJobScreenBody);
        customerNumField.WidthPercent(90);
        customerNumField.BackgroundColor(0xffe6f2ff);

        locationField = new HorizontalArrangement(addJobScreenBody);
        locationField.WidthPercent(90);
        locationField.BackgroundColor(0xffffffff);

        homeAddressField = new HorizontalArrangement(addJobScreenBody);
        homeAddressField.WidthPercent(90);
        homeAddressField.BackgroundColor(0xffe6f2ff);

        GPSField = new HorizontalArrangement(addJobScreenBody);
        GPSField.WidthPercent(90);
        GPSField.BackgroundColor(0xffffffff);

        descriptionField = new HorizontalArrangement(addJobScreenBody);
        descriptionField.WidthPercent(90);
        descriptionField.BackgroundColor(0xffe6f2ff);

        imageField = new HorizontalArrangement(addJobScreenBody);
        imageField.WidthPercent(90);
        imageField.BackgroundColor(0xffffffff);

        //Customer Field
        customerLabel = new Label(customerNumField);
        customerLabel.HeightPercent(10);
        customerLabel.WidthPercent(30);
        customerLabel.TextColor(0xff000000);
        customerLabel.Visible(true);
        customerLabel.Text("Customer#:");

        customerNum = new Spinner(customerNumField);
        customerNum.HeightPercent(10);
        customerNum.WidthPercent(60);
        customerNum.Prompt("Select...");

        //location field
        locationLabel = new Label(locationField);
        locationLabel.HeightPercent(10);
        locationLabel.TextColor(0xff000000);
        locationLabel.Visible(true);
        locationLabel.Text("location:");
        locationLabel.WidthPercent(24);

        location = new TextBox(locationField);
        location.WidthPercent(60);
        location.BackgroundColor(0xffffffff);

        //Home Address
        homeAddressButton = new Button(homeAddressField);
        homeAddressButton.WidthPercent(25);
        homeAddressButton.Text("Use Home Address");
        homeAddressButton.HeightPercent(10);
        homeAddressButton.FontSize(10);
        homeAddressButton.BackgroundColor(0xff004a99);
        homeAddressButton.TextColor(0xffffffff);

        homeAddressTextBox = new TextBox(homeAddressField);
        homeAddressTextBox.HeightPercent(10);
        homeAddressTextBox.WidthPercent(60);
        homeAddressTextBox.BackgroundColor(0xffe6f2ff);

        //GPS
        useGPSButton = new Button(GPSField);
        useGPSButton.HeightPercent(10);
        useGPSButton.Text("Use GPS");
        useGPSButton.WidthPercent(25);
        useGPSButton.FontSize(10);
        useGPSButton.BackgroundColor(0xff004a99);
        useGPSButton.TextColor(0xffffffff);

        GPSLocation = new TextBox(GPSField);
        GPSLocation.HeightPercent(10);
        GPSLocation.WidthPercent(60);
        GPSLocation.BackgroundColor(0xffffffff);

        //description
        descriptionLabel = new Label(descriptionField);
        descriptionLabel.HeightPercent(10);
        descriptionLabel.WidthPercent(24);
        descriptionLabel.TextColor(0xff000000);
        descriptionLabel.Visible(true);
        descriptionLabel.Text("description:");

        description = new TextBox(descriptionField);
        description.HeightPercent(25);
        description.WidthPercent(60);
        description.BackgroundColor(0xffe6f2ff);

        //Images
        imagesLabel = new Label(imageField);
        imagesLabel.HeightPercent(10);
        imagesLabel.Text("Images:");

        addJobControlButtonArea = new HorizontalArrangement(addJobScreenBody);
        addJobControlButtonArea.WidthPercent(90);
        addJobControlButtonArea.BackgroundColor(0xff99bbff);
        addJobControlButtonArea.HeightPercent(10);

        addImageButton = new Button(addJobControlButtonArea);
        addImageButton.WidthPercent(25);
        addImageButton.Text("Add Images");
        addImageButton.BackgroundColor(0xff004a99);
        addImageButton.TextColor(0xffffffff);
        addImageButton.FontSize(10);
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