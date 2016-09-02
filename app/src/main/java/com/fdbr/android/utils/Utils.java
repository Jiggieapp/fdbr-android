package com.fdbr.android.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
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

    private static int screenWidth = 0;
    public static int getScreenWidth(Context c) {
        if (screenWidth == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenWidth = size.x;
        }

        return screenWidth;
    }

    public static boolean contains(String[] array, String value, boolean ignoreCase) {
        return indexOf(array, value, ignoreCase) >= 0;
    }

    public static int indexOf(String[] array, String value, boolean ignoreCase) {
        final int length = array == null ? 0 : array.length;

        for (int i = 0; i < length; i++) {
            if (isEquals(array[i], value, ignoreCase))
                return i;
        }

        return -1;
    }

    public static boolean isEquals(String str1, String str2, boolean ignoreCase) {
        if (str1 == null)
            return str2 == null;
        else if (str2 == null)
            return false;
        else if (ignoreCase)
            return str1.equalsIgnoreCase(str2);
        else
            return str1.equals(str2);
    }
}
