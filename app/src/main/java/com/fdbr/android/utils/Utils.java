package com.fdbr.android.utils;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.fdbr.android.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LTE on 8/15/2016.
 */
public class Utils {

    public static void d(final String tag,final String desc)
    {
        Log.d(tag, desc);
    }


    public static void showToast(Activity a, String message) {
        Toast.makeText(a, message, Toast.LENGTH_SHORT).show();
        // ----
    }

    public static String getStringResource(Activity a, int id){
        return a.getResources().getString(id);
    }

    public static boolean validasiInput(int type, String input){
        boolean isValid = false;
        Pattern pattern;
        Matcher matcher;
        switch (type){
            case Constant.TYPE_USERNAME:
                if(input.length()>=6){
                    pattern = Pattern.compile(Constant.USERNAME_PATTERN);
                    matcher = pattern.matcher(input);
                    isValid = matcher.matches();
                }
                break;
            case Constant.TYPE_PASSWORD:
                if(input.length()>=6){
                    isValid = true;
                }
                break;
            case Constant.TYPE_EMAIL:
                if(input.length()>=6){
                    pattern = Pattern.compile(Constant.EMAIL_PATTERN);
                    matcher = pattern.matcher(input);
                    isValid = matcher.matches();
                }
                break;
        }

        return isValid;
    }

    public static boolean isAndroid5() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }
}
