package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Switch;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.DpToPx;
import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;


public class Systeme {

    public static void sys_statusBarClaire(Activity mActivity){
        try{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                View statusbar = mActivity.getWindow().getDecorView();
                int flags = statusbar.getSystemUiVisibility();
                flags = flags ^ View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                statusbar.setSystemUiVisibility(flags);
            }
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
        }
    }

    public static void sys_statusBarSombre(Activity mActivity){
        try{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                View statusbar = mActivity.getWindow().getDecorView();
                statusbar.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
        }
    }

    public static void sys_activeGPS(Activity mActivity){
        try{
            mActivity.startActivityForResult(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS), 1);
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
        }
    }

    public static boolean sys_enModeEconomie(Activity mActivity){
        PowerManager powerManager = (PowerManager) mActivity.getSystemService(Context.POWER_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && powerManager.isPowerSaveMode()) {
            return true;
        }
        return false;
    }

    public static void sys_actionBarOmbreElevation(int elevation, Activity mActivity){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View actionbar;
            Window window = mActivity.getWindow();
            View v = window.getDecorView();
            int resId = getAppContext(mActivity).getResources().getIdentifier("action_bar_container", "id", "android");
            actionbar = v.findViewById(resId);
            if (actionbar != null){
                actionbar.setElevation(DpToPx(elevation, getAppContext(mActivity)));
            }
        }
    }


    public static boolean sys_couleurInterrupteur(ViewGroup viewGroup,String sCouleur, Activity mActivity){

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return false;
        }
        try{
            if (viewGroup == null){
                return false;
            }
            Switch monswitch;
            int[][] states;
            int[] colorsThumb;
            int[] colorsTrack;
            ColorStateList myListThumb;
            ColorStateList myListTrack;
            states = new int[][] { new int[] { android.R.attr.state_checked }, new int[] { -android.R.attr.state_checked  } };
            colorsThumb = new int[] { Color.parseColor(sCouleur), Color.parseColor("#E8E8E8") };
            colorsTrack = new int[] { Color.parseColor(sCouleur), Color.parseColor("#000000") };
            myListThumb = new ColorStateList(states, colorsThumb);
            myListTrack = new ColorStateList(states, colorsTrack);

            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                try{
                    monswitch = (Switch) child;
                    monswitch.setThumbTintList(myListThumb);
                    monswitch.setTrackTintList(myListTrack);
                }
                catch(Exception e) {
                    ErreurJava.set(mActivity, e.getMessage());
                    return false;
                }
            }
            return true;
        }
        catch(Exception e) {
            ErreurJava.set(mActivity, e.getMessage());
            return false;
        }
    }
}
