package net.fachtnaroe.pcpitstop_git;


import android.graphics.Color;

public class settings_screen08
{
    private int backgroundColour = 0xff4080bf;
    private int inputBoxColour = 0xffffffff;
    private int errorInputBoxColour = 0xffff4d4d;
    private int buttonColour = 0xffb3daff;

    public settings_screen08()
    {

    }

    public void setBackgroundColour(int BackG)
    {
        backgroundColour = BackG;
    }

    public int getBackgroundColour()
    {
        return backgroundColour;
    }

    public void setInputBoxColour(int InBoxC)
    {
        inputBoxColour = InBoxC;
    }

    public int getInputBoxColour()
    {
        return inputBoxColour;
    }

    public void setErrorInputBoxColour(int ErrBox)
    {
        errorInputBoxColour = ErrBox;
    }

    public int getErrorInputBoxColour() {
        return errorInputBoxColour;
    }

    public void setButtonColour(int ButtCol)
    {
        buttonColour = ButtCol;
    }

    public int getButtonColour()
    {
        return buttonColour;
    }
}
