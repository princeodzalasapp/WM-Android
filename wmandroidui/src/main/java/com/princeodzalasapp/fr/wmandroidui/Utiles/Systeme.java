package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.mikepenz.iconics.IconicsDrawable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Systeme {

    public static void test1(ImageView nlogo, String nImage, Activity mActivity){
        Drawable mImage =  new IconicsDrawable(getAppContext(mActivity), nImage);
        nlogo.setImageDrawable(mImage);
    }

    public static void test2(Context mContext){
        try{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                View statusbar = getActiviteEnCours(mContext).getWindow().getDecorView();
                int flags = statusbar.getSystemUiVisibility();
                flags = flags ^ View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                statusbar.setSystemUiVisibility(flags);
            }
        } catch ( Exception e ) {
            ToastColor.erreur(e.getMessage(), mContext);
        }
    }

    public static int DpToPx(int valeurDp, Context mContext){
        final float scale = mContext.getResources().getDisplayMetrics().density;
        final int dp = (int) ((valeurDp * scale) + 0.5f);
        return dp;
    }

    public static void ActionBarOmbreElevation(int elevation, Context mContext, Activity mActivity){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View actionbar;
            // Récupération de l'action bar
            Window window = mActivity.getWindow();
            View v = window.getDecorView();
            int resId = mContext.getResources().getIdentifier("action_bar_container", "id", "android");
            actionbar = v.findViewById(resId);
            // Changement de l'élévation pour supprimer l'ombre
            if (actionbar != null){
                actionbar.setElevation(DpToPx(elevation, mContext));
            }
        }
    }

    public static String getDateYoutube(String date) {
        final String ISO_8601_24H_FULL_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
        @SuppressLint("SimpleDateFormat") DateFormat df = new SimpleDateFormat(ISO_8601_24H_FULL_FORMAT);
        String dateString;
        try {
            Date d = df.parse(date);
            dateString = DateFormat.getDateInstance().format(d);
        } catch (ParseException e) {
            e.printStackTrace();
            dateString = "";
        }
        return dateString;
    }

    public static void sys_statusBar_iconClaire(Activity mActivity){
        try{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                View statusbar = mActivity.getWindow().getDecorView();
                int flags = statusbar.getSystemUiVisibility();
                flags = flags ^ View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                statusbar.setSystemUiVisibility(flags);
            }
        } catch ( Exception e ) {
            //appelProcedureWL("ErreurCode", e.getMessage());
        }

    }

    public static Activity getActiviteEnCours(Context context){
        if (context == null){
            return null;
        } else if (context instanceof ContextWrapper){
            if (context instanceof Activity){
                return (Activity) context;
            } else{
                return getActiviteEnCours(((ContextWrapper) context).getBaseContext());
            }
        }
        return null;
    }

    public static Context getAppContext(Activity mActivity){
        return mActivity.getApplicationContext();
    }

}
