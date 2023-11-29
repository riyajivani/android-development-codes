package com.example.loginlogoutexternalfile;

import android.os.Environment;

public class Methods {

    public static boolean isExternalStorageAvailable()
    {
        String extStorageState = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(extStorageState))
        {
            return true;
        }
        return false;
    }

    public static boolean isExternalStorageReadOnly()
    {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }
}
