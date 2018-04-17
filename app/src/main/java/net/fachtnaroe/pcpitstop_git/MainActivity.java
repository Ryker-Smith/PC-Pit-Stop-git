package net.fachtnaroe.pcpitstop_git;

import android.content.Intent;
import android.content.res.Resources;

import android.os.CountDownTimer;

import com.google.appinventor.components.runtime.Canvas;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.ImageSprite;
import com.google.appinventor.components.runtime.VerticalArrangement;

public class MainActivity extends Form implements HandlesEventDispatching
{
    private VerticalArrangement loadingBackground;
    private Canvas loadingCanvas;
    private ImageSprite loadingLogo;

    protected void $define()
    {
        loadingBackground = new VerticalArrangement(this);
        loadingBackground.Width(Component.LENGTH_FILL_PARENT);
        loadingBackground.Height(Component.LENGTH_FILL_PARENT);
        loadingBackground.BackgroundColor(0xff99bbff);

        loadingCanvas = new Canvas(loadingBackground);
        loadingCanvas.Width(Component.LENGTH_FILL_PARENT);
        loadingCanvas.Height(Component.LENGTH_FILL_PARENT);
        loadingCanvas.BackgroundImage("loadingscreen.png");

        PCPS_ThreeSecondTimer();
    }

    public void PCPS_ThreeSecondTimer()
    {
        new CountDownTimer(3000, 1000)
        {
            public void onTick(long millisUntilFinished)
            {

            }

            public void onFinish()
            {
                PCPS_nextScreen();
            }

        }.start();
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

    public void PCPS_nextScreen()
    {
            Intent LoginScreenIntent = new Intent(MainActivity.this, startingLogin_screen01.class);
            startActivity(LoginScreenIntent);
            finish();
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
