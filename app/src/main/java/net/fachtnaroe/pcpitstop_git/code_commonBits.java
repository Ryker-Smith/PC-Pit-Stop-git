package net.fachtnaroe.pcpitstop_git;

import android.content.res.Resources;

public class code_commonBits {

    public static String targetURL = "https://fachtnaroe.net/pcpitstop-2018?";

    public static String RequestValue (String s1, String s2) {
        // Purpose: To combine two strings into a name=value pair
        // Expects: Two strings
        // Returns: One string of the form s1=s2
        return s1 + '=' + s2;
    }

    public static String RequestCombine (String[] Pairs) {
        // Purpose: To combine multiple strings (of the form name=value) into a web data string
        // Expects: Series of strings
        // Returns: One string of the form string&string&string
        int i=Pairs.length;
        int count = (int) i/2;
        String result = new String();
        for (int loop=0; loop<i; loop+=1){
            result += Pairs[loop];
            if (loop < (i-1)) {
                result += "&";
            }
        }
        return result;
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
