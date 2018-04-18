package net.fachtnaroe.pcpitstop_git;

import android.content.Intent;
import android.content.res.Resources;

import android.os.Bundle;
import android.view.WindowManager;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.Notifier;
import com.google.appinventor.components.runtime.PasswordTextBox;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.Web;

import org.json.JSONException;
import org.json.JSONObject;

import static net.fachtnaroe.pcpitstop_git.code_commonBits.targetURL;

public class screen01_startingLogin extends Form implements HandlesEventDispatching
{
    //all objects/variables named with shortcut of PC_PitStop -> PCPS
    private TextBox username; //username field for login
    private PasswordTextBox password; //password field
    private Button loginButton;
    private VerticalArrangement mainContainer;
    private VerticalArrangement leftSideSpacerUpper;
    private VerticalArrangement leftSideSpacerLower;
    private HorizontalArrangement loginBody;
    private HorizontalArrangement loginBodyLower;
    private VerticalArrangement loginArrangement;
    private VerticalArrangement textFieldsArrangement;
    private HorizontalArrangement headerArrangement;
    private VerticalArrangement rolesArrangement;
    private HorizontalArrangement rolesTopRow;
    private HorizontalArrangement rolesBottomRow;
    private Button customerButton;
    private Button operatorButton;
    private Button techButton;
    private Button adminButton;
    private com.google.appinventor.components.runtime.Canvas logoCanvas;
    private com.google.appinventor.components.runtime.Canvas logoSpacer;
    private Label Title;
    private Label usernameLabel;
    private Label passwordLabel;
    private Web customer_webComponent, operator_webComponent, technician_webComponent, administrator_webComponent;
    private TextBox debugBox;
    private String sessionID;
    private Notifier myNotify;
    private String role;
//    private String sessionIDWeb = "&sessionID=a1b2c3d4";
    private Label loginTypeLineOne;
    private Label loginTypeLineTwo;

    protected void $define()
    {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //MainContainer. Contains main arrangement of objects plus "spacer" arrangement
        mainContainer = new VerticalArrangement(this);
        mainContainer.Width(code_commonBits.getScreenWidth());
        mainContainer.Height(code_commonBits.getScreenHeight());
        mainContainer.BackgroundColor(0xff99bbff);

        //Header with app title
        headerArrangement = new HorizontalArrangement(mainContainer);
        headerArrangement.Width((code_commonBits.getScreenWidth()));
        headerArrangement.HeightPercent(25);
        headerArrangement.AlignHorizontal(1);
        headerArrangement.AlignVertical(1);

        logoSpacer = new com.google.appinventor.components.runtime.Canvas(headerArrangement);
        logoSpacer.WidthPercent(37);
        logoSpacer.Height(Component.LENGTH_FILL_PARENT);
        logoSpacer.BackgroundColor(0xff99bbff);

        logoCanvas = new com.google.appinventor.components.runtime.Canvas(headerArrangement);
        logoCanvas.WidthPercent(35);
        logoCanvas.Height(Component.LENGTH_FILL_PARENT);
        logoCanvas.BackgroundImage("Logo.png");

        loginBody = new HorizontalArrangement(mainContainer);
        loginBody.Width(code_commonBits.getScreenWidth());
        loginBody.HeightPercent(30);

        //spacer that keeps everything 5% from the left
        leftSideSpacerUpper = new VerticalArrangement(loginBody);
        leftSideSpacerUpper.WidthPercent(25);
        leftSideSpacerUpper.Height(code_commonBits.getScreenHeight());

        //Main Arrangement of objects
        loginArrangement = new VerticalArrangement(loginBody);
        loginArrangement.Width(code_commonBits.getScreenWidth());
        loginArrangement.Height(code_commonBits.getScreenHeight());

        //Arrangement for Text fields (Username, Password)
        textFieldsArrangement = new VerticalArrangement(loginArrangement);
        textFieldsArrangement.Width((code_commonBits.getScreenWidth()));
        textFieldsArrangement.HeightPercent(30);

        usernameLabel = new Label(textFieldsArrangement);
        usernameLabel.Text("Username:");

        //username field
        username = new TextBox(textFieldsArrangement);
        username.WidthPercent(60);
        username.FontSize(14);
        username.Text("stevey.cullen");
        username.BackgroundColor(0xffffffff);

        passwordLabel = new Label(textFieldsArrangement);
        passwordLabel.Text("Password:");

        //password field
        password = new PasswordTextBox(textFieldsArrangement);
        password.WidthPercent(60);
        password.FontSize(14);
        password.Text("tcfetcfe");
        password.BackgroundColor(0xffffffff);

        loginTypeLineOne = new Label(textFieldsArrangement);
        loginTypeLineOne.Text("Please Select Login Type:");
        loginTypeLineOne.FontSize(16);
        loginTypeLineOne.FontBold(true);

        loginBodyLower = new HorizontalArrangement(mainContainer);
        loginBodyLower.Height(code_commonBits.getScreenHeight());
        loginBodyLower.Width(code_commonBits.getScreenWidth());

        leftSideSpacerLower = new VerticalArrangement(loginBodyLower);
        leftSideSpacerLower.Height(code_commonBits.getScreenHeight());
        leftSideSpacerLower.WidthPercent(10);

        rolesArrangement = new VerticalArrangement(loginBodyLower);

        rolesTopRow = new HorizontalArrangement(rolesArrangement);

        customerButton = new Button(rolesTopRow);
        customerButton.WidthPercent(45);
        customerButton.HeightPercent(25);
        customerButton.Image("CustomerButtonImage.png");

        adminButton = new Button(rolesTopRow);
        adminButton.WidthPercent(45);
        adminButton.HeightPercent(25);
        adminButton.Image("AdminButtonImage.png");
        adminButton.FontSize(14);

        rolesBottomRow = new HorizontalArrangement(rolesArrangement);

        techButton = new Button(rolesBottomRow);
        techButton.WidthPercent(45);
        techButton.HeightPercent(25);
        techButton.Image("TechnicianButtonImage.png");

        operatorButton = new Button(rolesBottomRow);
        operatorButton.WidthPercent(45);
        operatorButton.HeightPercent(25);
        operatorButton.Image("OperatorButtonImage.png");

        //initialise web component for login
        customer_webComponent = new Web(loginArrangement);
        operator_webComponent = new Web(loginArrangement);
        technician_webComponent = new Web(loginArrangement);
        administrator_webComponent = new Web(loginArrangement);

        //box to display reault of web also to show that session ID is successfully stored
        debugBox = new TextBox(loginArrangement);
        debugBox.WidthPercent(100);
        debugBox.Visible(false);

        //delegating events that are expected to happen
        EventDispatcher.registerEventForDelegation(this, "customerButton", "Click");
        EventDispatcher.registerEventForDelegation(this, "adminButton", "Click");
        EventDispatcher.registerEventForDelegation(this, "techButton", "Click");
        EventDispatcher.registerEventForDelegation(this, "operatorButton", "Click");
//        EventDispatcher.registerEventForDelegation(this, "loginWeb", "GotText");

        EventDispatcher.registerEventForDelegation(this, "customer_webComponent", "GotText");
        EventDispatcher.registerEventForDelegation(this, "operator_webComponent", "GotText");
        EventDispatcher.registerEventForDelegation(this, "technician_webComponent", "GotText");
        EventDispatcher.registerEventForDelegation(this, "administrator_webComponent", "GotText");

    }

    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params)
    {
        //if login button clicked
        if (component.equals(customerButton) && eventName.equals("Click"))
        {
            customerButtonClicked();
            return true;
        }

        else if (component.equals(adminButton) && eventName.equals("Click"))
        {
            administratorButtonClicked();
            return true;
        }

        else if (component.equals(techButton) && eventName.equals("Click"))
        {
            technicianButtonClicked();
            return true;
        }

        else if (component.equals(operatorButton) && eventName.equals("Click"))
        {
            operatorButtonClicked();
            return true;
        }

        //if web has got a result
//        else if (component.equals(loginWeb) && eventName.equals("GotText"))
//        {
//            String result = (String) params[3];
//            youveGotText(result);
//            return true;
//        }
        else if (component.equals(customer_webComponent) && eventName.equals("GotText")) {
            String result = (String) params[3];
            customerGotText(result);
            return true;
        }
        else if (component.equals(operator_webComponent) && eventName.equals("GotText")) {
            String result = (String) params[3];
            operatorGotText(result);
            return true;
        }
        else if (component.equals(administrator_webComponent) && eventName.equals("GotText")) {
            String result = (String) params[3];
            administratorGotText(result);
            return true;
        }
        else if (component.equals(technician_webComponent) && eventName.equals("GotText")) {
            String result = (String) params[3];
            technicianGotText(result);
            return true;
        }

        else
        {
            return false;
        }
    }

    //method called when button is clicked
    public void customerButtonClicked()
    {

        customer_webComponent.Url(targetURL + "cmd=login&user=" + username.Text() + "&pass=" + password.Text());
        customer_webComponent.Get();
        role = "Customer";
    }

    public void administratorButtonClicked()
    {
        administrator_webComponent.Url(targetURL +"cmd=login&user=" + username.Text() + "&pass=" + password.Text());
        administrator_webComponent.Get();
        role = "Admin";
    }

    public void technicianButtonClicked()
    {
        technician_webComponent.Url(targetURL + "cmd=login&user=" + username.Text() + "&pass=" + password.Text());
        technician_webComponent.Get();
        role = "Tech";
    }

    public void operatorButtonClicked()
    {
        operator_webComponent.Url(targetURL + "cmd=login&user=" + username.Text() + "&pass=" + password.Text());
        operator_webComponent.Get();
        role = "Office";
    }

    //method called when web returns a result
    public void youveGotText(String result)
    {
        try
        {
            JSONObject parser= new JSONObject(result);
            debugBox.Text(parser.getString("Status") + " (" + parser.getString("sessionID") + ")");
            String myResult=debugBox.Text();

            if(myResult.charAt(0)=='O')
            {
                sessionID = parser.getString("sessionID");
                password.BackgroundColor(0xffffffff);
                username.BackgroundColor(0xffffffff);
                nextScreen();
            }
            else
            {
                username.BackgroundColor(0xffff6666);
                password.BackgroundColor(0xffff6666);
            }
        }

        catch(JSONException e)
        {
            // if an exception occurs, code for it in here
        }
    }

    public void customerGotText(String result) {
        startActivity(new Intent(screen01_startingLogin.this, screen07_customerHome.class));
        try {
            JSONObject parser = new JSONObject(result);
            if (parser.getString("result").equals("OK"))
            {}
        } catch (JSONException e) {
            // if an exception occurs, code for it in here
        }
    }

    public void operatorGotText(String result) {
        try {
            JSONObject parser = new JSONObject(result);
            debugBox.Text(
                    parser.getString("Status") + " (" +
                            parser.getString("sessionID") + ")"
            );
            if (parser.getString("Status").equals("OK")) {
                sessionID= parser.getString("sessionID");
//                localDB.StoreValue("sessionID", sessionID);
//                localDB.StoreValue((String) "sessionID", (Object) sessionID);
                Intent intent = new Intent(this, screen02_operatorHome.class);
                Bundle b = new Bundle();
                b.putString("sessionID", sessionID); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
//                finish();
//                startActivity(new Intent(startingLogin_screen01.this, operatorHome_screen02.class));
//                startingLogin_screen01.switchForm("customerAddEdit_screen04");
            }
        } catch (JSONException e) {
            // if an exception occurs, code for it in here
            myNotify.ShowMessageDialog("Error logging in", "Error", "OK");
        }
    }

    public void technicianGotText(String result) {
        startActivity(new Intent(screen01_startingLogin.this, screen02_operatorHome.class));
        try {
            JSONObject parser = new JSONObject(result);
//            outputBox.Text(
//                    parser.getString("result") + " (" +
//                           parser.getString("sessionID") + ")"
//            );

            if (parser.getString("result").equals("OK")) {}
        } catch (JSONException e) {
            // if an exception occurs, code for it in here
        }
    }

    public void administratorGotText(String result) {
        startActivity(new Intent(screen01_startingLogin.this, screen02_operatorHome.class));
        try {
            JSONObject parser = new JSONObject(result);
//            outputBox.Text(
//                    parser.getString("result") + " (" +
//                           parser.getString("sessionID") + ")"
//            );

            if (parser.getString("Status").equals("OK")) {}
        } catch (JSONException e) {
            // if an exception occurs, code for it in here
        }
    }


    public void nextScreen()
    {
        if(role == "Customer")
        {
            Intent customerIntent = new Intent(screen01_startingLogin.this, screen07_customerHome.class);
            finish();
            startActivity(customerIntent);
        }

        else if(role == "Tech")
        {
            Intent techIntent = new Intent(screen01_startingLogin.this, screen05_technicianHome.class);
            finish();
            startActivity(techIntent);
        }

        else if (role == "Office")
        {
            Intent officeIntent = new Intent(screen01_startingLogin.this, screen02_operatorHome.class);
            finish();
            startActivity(officeIntent);
        }

        else if (role == "Admin")
        {
            Intent adminIntent = new Intent(screen01_startingLogin.this, screen09_administratorHome.class);
            finish();
            startActivity(adminIntent);
        }
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}
