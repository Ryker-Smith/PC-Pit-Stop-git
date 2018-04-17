package net.fachtnaroe.pcpitstop_git;

import android.content.res.Resources;
import android.view.WindowManager;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.CheckBox;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;

import org.w3c.dom.Text;

public class actionAddEdit_screen06 extends Form implements HandlesEventDispatching
{
    private VerticalArrangement PCPS_mainContainer;
    private VerticalArrangement PCPS_leftSideSpacer;
    private VerticalArrangement PCPS_headerArrangement;
    private HorizontalArrangement PCPS_AddActionBodyWithSpacer;
    private VerticalArrangement PCPS_AddActionScreenBody;
    private Label PCPS_Title;
    private Label PCPS_CustomerNumLabel;
    private TextBox PCPS_CustomerNum;
    private Label PCPS_JobNumLabel;
    private Label PCPS_ActionDetailLabel;
    private HorizontalArrangement PCPS_CustomerNumArrangement;
    private HorizontalArrangement PCPS_JobNumArrangement;
    private CheckBox ActionDetailType;
    private VerticalScrollArrangement PCPS_ActionDescriptionContainer;
    private TextBox PCPS_ActionDescription;

    private HorizontalArrangement PCPS_ActionControlButtonArea;
    private Button PCPS_ActionControl_Save;

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
        PCPS_Title.Text("Technician");
        PCPS_Title.FontSize(20);
        PCPS_Title.FontBold(true);
        PCPS_Title.TextColor(0xffffffff);
        PCPS_Title.Visible(true);

        PCPS_AddActionBodyWithSpacer = new HorizontalArrangement(PCPS_mainContainer);
        PCPS_AddActionBodyWithSpacer.Width((int) (getScreenWidth()));
        PCPS_AddActionBodyWithSpacer.Height((int) (getScreenHeight()));

        //spacer that keeps everything 5% from the left
        PCPS_leftSideSpacer = new VerticalArrangement(PCPS_AddActionBodyWithSpacer);
        PCPS_leftSideSpacer.WidthPercent(10);
        PCPS_leftSideSpacer.Height(getScreenHeight());

        PCPS_AddActionScreenBody = new VerticalArrangement(PCPS_AddActionBodyWithSpacer);
        PCPS_AddActionScreenBody.Width((int) (getScreenWidth()));
        PCPS_AddActionScreenBody.Height((int) (getScreenHeight()));

        PCPS_CustomerNumArrangement = new HorizontalArrangement(PCPS_AddActionScreenBody);

        PCPS_CustomerNumLabel = new Label(PCPS_CustomerNumArrangement);
        PCPS_CustomerNumLabel.WidthPercent(30);
        PCPS_CustomerNumLabel.TextColor(0xff000000);
        PCPS_CustomerNumLabel.Visible(true);
        PCPS_CustomerNumLabel.Text("Customer #:");

        PCPS_ActionControl_Save = new Button(PCPS_ActionControlButtonArea);
        PCPS_ActionControl_Save.WidthPercent(50);
        PCPS_ActionControl_Save.Text("Save");
        PCPS_ActionControl_Save.BackgroundColor(0xff004a99);
        PCPS_ActionControl_Save.TextColor(0xffffffff);
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
