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

public class screen06_actionAddEdit extends Form implements HandlesEventDispatching
{
    private VerticalArrangement mainContainer;
    private VerticalArrangement leftSideSpacer;
    private VerticalArrangement headerArrangement;
    private HorizontalArrangement addActionBodyWithSpacer;
    private VerticalArrangement addActionScreenBody;
    private Label title;
    private Label customerNumLabel;
    private TextBox customerNum;
    private Label jobNumLabel;
    private Label actionDetailLabel;
    private HorizontalArrangement customerNumArrangement;
    private HorizontalArrangement jobNumArrangement;
    private CheckBox actionDetailType;
    private VerticalScrollArrangement actionDescriptionContainer;
    private TextBox actionDescription;

    private HorizontalArrangement actionControlButtonArea;
    private Button actionControl_Save;

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
        title.Text("Technician");
        title.FontSize(20);
        title.FontBold(true);
        title.TextColor(0xffffffff);
        title.Visible(true);

        addActionBodyWithSpacer = new HorizontalArrangement(mainContainer);
        addActionBodyWithSpacer.Width((int) (getScreenWidth()));
        addActionBodyWithSpacer.Height((int) (getScreenHeight()));

        //spacer that keeps everything 5% from the left
        leftSideSpacer = new VerticalArrangement(addActionBodyWithSpacer);
        leftSideSpacer.WidthPercent(10);
        leftSideSpacer.Height(getScreenHeight());

        addActionScreenBody = new VerticalArrangement(addActionBodyWithSpacer);
        addActionScreenBody.Width((int) (getScreenWidth()));
        addActionScreenBody.Height((int) (getScreenHeight()));

        customerNumArrangement = new HorizontalArrangement(addActionScreenBody);

        customerNumLabel = new Label(customerNumArrangement);
        customerNumLabel.WidthPercent(30);
        customerNumLabel.TextColor(0xff000000);
        customerNumLabel.Visible(true);
        customerNumLabel.Text("Customer #:");

        actionControl_Save = new Button(actionControlButtonArea);
        actionControl_Save.WidthPercent(50);
        actionControl_Save.Text("Save");
        actionControl_Save.BackgroundColor(0xff004a99);
        actionControl_Save.TextColor(0xffffffff);
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
