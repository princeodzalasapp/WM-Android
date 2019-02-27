package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.app.Activity;
import android.content.SharedPreferences;

import com.princeodzalasapp.fr.wmandroidui.R;

import static android.content.Context.MODE_PRIVATE;

public class Config {

    public static String KEY_PREFS = "prefs";
    public static String KEY_THEME = "KEY_THEME";
    public static String KEY_DEBUG_MODE = "debug_mode";
    public static final int LIGHT = R.style.MdAppTheme;
    public static final int DARK = R.style.MdTheme_Dark;
    public static final int CUSTOM = R.style.MdTheme_Custom;

    private static boolean debugMode = false;
    private static SharedPreferences prefs ;

    public static void initConfig(Activity mActivity){
        prefs = mActivity.getSharedPreferences(KEY_PREFS, MODE_PRIVATE);
        debugMode = prefs.getBoolean(KEY_DEBUG_MODE, false);
        mActivity.setTheme(LIGHT);
        prefs.edit().putString(KEY_THEME,"LIGHT").apply();
    }

    public static void changeTheme(Activity mActivity, int num){
        if ( num == 1 ){
            mActivity.setTheme(LIGHT);
            prefs.edit().putString(KEY_THEME,"LIGHT").apply();
        } else if ( num == 2 ){
            mActivity.setTheme(DARK);
            prefs.edit().putString(KEY_THEME,"DARK").apply();
        } else{
            mActivity.setTheme(CUSTOM);
            prefs.edit().putString(KEY_THEME,"CUSTOM").apply();
        }
    }



}
