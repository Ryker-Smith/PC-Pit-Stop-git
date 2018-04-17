package net.fachtnaroe.pcpitstop_git;

import android.content.Intent;
import android.content.res.Resources;
import android.view.WindowManager;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.Spinner;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalArrangement;

public class jobAddEdit_screen03 extends Form implements HandlesEventDispatching
{
    private VerticalArrangement PCPS_mainContainer;
    private VerticalArrangement PCPS_leftSideSpacer;
    private VerticalArrangement PCPS_headerArrangement;
    private HorizontalArrangement PCPS_AddJobScreenBodyWithSpacer;
    private VerticalArrangement PCPS_AddJobScreenBody;
    private HorizontalArrangement PCPS_CustomerNumField;
    private HorizontalArrangement PCPS_LocationField;
    private HorizontalArrangement PCPS_HomeAddressField;
    private HorizontalArrangement PCPS_GPSField;
    private HorizontalArrangement PCPS_DescriptionField;
    private HorizontalArrangement PCPS_ImageField;
    private Label PCPS_Title;
    private Label PCPS_CustomerLabel;
    private Spinner PCPS_CustomerNum;
    private Label PCPS_LocationLabel;
    private TextBox PCPS_Location;
    private Button PCPS_UseGPSButton;
    private TextBox PCPS_GPSLocation;
    private Label PCPS_DescriptionLabel;
    private TextBox PCPS_Description;
    private Label PCPS_ImagesLabel;
    private HorizontalArrangement PCPS_AddJobControlButtonArea;
    private Button PCPS_AddJobControl_Save;
    private Button PCPS_HomeAddressButton;
    private TextBox PCPS_HomeAddressTextBox;
    private Button PCPS_AddImageButton;


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
        PCPS_Title.Text("Add Job");
        PCPS_Title.FontSize(20);
        PCPS_Title.FontBold(true);
        PCPS_Title.TextColor(0xffffffff);
        PCPS_Title.Visible(true);

        PCPS_AddJobScreenBodyWithSpacer = new HorizontalArrangement(PCPS_mainContainer);
        PCPS_AddJobScreenBodyWithSpacer.Width((int)(getScreenWidth()));
        PCPS_AddJobScreenBodyWithSpacer.Height((int)(getScreenHeight()));

        //spacer that keeps everything 5% from the left
        PCPS_leftSideSpacer = new VerticalArrangement(PCPS_AddJobScreenBodyWithSpacer);
        PCPS_leftSideSpacer.WidthPercent(10);
        PCPS_leftSideSpacer.Height(getScreenHeight());

        PCPS_AddJobScreenBody = new VerticalArrangement(PCPS_AddJobScreenBodyWithSpacer);
        PCPS_AddJobScreenBody.WidthPercent(90);
        PCPS_AddJobScreenBody.Height((int)(getScreenHeight()));

        PCPS_CustomerNumField = new HorizontalArrangement(PCPS_AddJobScreenBody);
        PCPS_CustomerNumField.WidthPercent(90);
        PCPS_CustomerNumField.BackgroundColor(0xffe6f2ff);

        PCPS_LocationField = new HorizontalArrangement(PCPS_AddJobScreenBody);
        PCPS_LocationField.WidthPercent(90);
        PCPS_LocationField.BackgroundColor(0xffffffff);

        PCPS_HomeAddressField = new HorizontalArrangement(PCPS_AddJobScreenBody);
        PCPS_HomeAddressField.WidthPercent(90);
        PCPS_HomeAddressField.BackgroundColor(0xffe6f2ff);

        PCPS_GPSField = new HorizontalArrangement(PCPS_AddJobScreenBody);
        PCPS_GPSField.WidthPercent(90);
        PCPS_GPSField.BackgroundColor(0xffffffff);

        PCPS_DescriptionField = new HorizontalArrangement(PCPS_AddJobScreenBody);
        PCPS_DescriptionField.WidthPercent(90);
        PCPS_DescriptionField.BackgroundColor(0xffe6f2ff);

        PCPS_ImageField = new HorizontalArrangement(PCPS_AddJobScreenBody);
        PCPS_ImageField.WidthPercent(90);
        PCPS_ImageField.BackgroundColor(0xffffffff);

        //Customer Field
        PCPS_CustomerLabel = new Label(PCPS_CustomerNumField);
        PCPS_CustomerLabel.HeightPercent(10);
        PCPS_CustomerLabel.WidthPercent(30);
        PCPS_CustomerLabel.TextColor(0xff000000);
        PCPS_CustomerLabel.Visible(true);
        PCPS_CustomerLabel.Text("Customer#:");

        PCPS_CustomerNum = new Spinner(PCPS_CustomerNumField);
        PCPS_CustomerNum.HeightPercent(10);
        PCPS_CustomerNum.WidthPercent(60);
        PCPS_CustomerNum.Prompt("Select...");

        //Location field
        PCPS_LocationLabel = new Label(PCPS_LocationField);
        PCPS_LocationLabel.HeightPercent(10);
        PCPS_LocationLabel.TextColor(0xff000000);
        PCPS_LocationLabel.Visible(true);
        PCPS_LocationLabel.Text("Location:");
        PCPS_LocationLabel.WidthPercent(24);

        PCPS_Location = new TextBox(PCPS_LocationField);
        PCPS_Location.WidthPercent(60);
        PCPS_Location.BackgroundColor(0xffffffff);

        //Home Address
        PCPS_HomeAddressButton = new Button(PCPS_HomeAddressField);
        PCPS_HomeAddressButton.WidthPercent(25);
        PCPS_HomeAddressButton.Text("Use Home Address");
        PCPS_HomeAddressButton.HeightPercent(10);
        PCPS_HomeAddressButton.FontSize(10);
        PCPS_HomeAddressButton.BackgroundColor(0xff004a99);
        PCPS_HomeAddressButton.TextColor(0xffffffff);

        PCPS_HomeAddressTextBox = new TextBox(PCPS_HomeAddressField);
        PCPS_HomeAddressTextBox.HeightPercent(10);
        PCPS_HomeAddressTextBox.WidthPercent(60);
        PCPS_HomeAddressTextBox.BackgroundColor(0xffe6f2ff);

        //GPS
        PCPS_UseGPSButton = new Button(PCPS_GPSField);
        PCPS_UseGPSButton.HeightPercent(10);
        PCPS_UseGPSButton.Text("Use GPS");
        PCPS_UseGPSButton.WidthPercent(25);
        PCPS_UseGPSButton.FontSize(10);
        PCPS_UseGPSButton.BackgroundColor(0xff004a99);
        PCPS_UseGPSButton.TextColor(0xffffffff);

        PCPS_GPSLocation = new TextBox(PCPS_GPSField);
        PCPS_GPSLocation.HeightPercent(10);
        PCPS_GPSLocation.WidthPercent(60);
        PCPS_GPSLocation.BackgroundColor(0xffffffff);

        //Description
        PCPS_DescriptionLabel = new Label(PCPS_DescriptionField);
        PCPS_DescriptionLabel.HeightPercent(10);
        PCPS_DescriptionLabel.WidthPercent(24);
        PCPS_DescriptionLabel.TextColor(0xff000000);
        PCPS_DescriptionLabel.Visible(true);
        PCPS_DescriptionLabel.Text("Description:");

        PCPS_Description = new TextBox(PCPS_DescriptionField);
        PCPS_Description.HeightPercent(25);
        PCPS_Description.WidthPercent(60);
        PCPS_Description.BackgroundColor(0xffe6f2ff);

        //Images
        PCPS_ImagesLabel = new Label(PCPS_ImageField);
        PCPS_ImagesLabel.HeightPercent(10);
        PCPS_ImagesLabel.Text("Images:");

        PCPS_AddJobControlButtonArea = new HorizontalArrangement(PCPS_AddJobScreenBody);
        PCPS_AddJobControlButtonArea.WidthPercent(90);
        PCPS_AddJobControlButtonArea.BackgroundColor(0xff99bbff);
        PCPS_AddJobControlButtonArea.HeightPercent(10);

        PCPS_AddImageButton = new Button(PCPS_AddJobControlButtonArea);
        PCPS_AddImageButton.WidthPercent(25);
        PCPS_AddImageButton.Text("Add Images");
        PCPS_AddImageButton.BackgroundColor(0xff004a99);
        PCPS_AddImageButton.TextColor(0xffffffff);
        PCPS_AddImageButton.FontSize(10);
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