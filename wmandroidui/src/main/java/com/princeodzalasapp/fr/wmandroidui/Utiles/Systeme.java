package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;

import com.princeodzalasapp.fr.wmandroidui.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.pcsoft.wdjava.api.WDAPIDialogue;
import fr.pcsoft.wdjava.core.types.*;
import fr.pcsoft.wdjava.core.*;
import fr.pcsoft.wdjava.core.application.*;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Windev.getActiviteEnCours;

public class Systeme extends WDCollProc {

    public static void test(){


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

    public static void sys_statusBar_iconClaire(String mProcedure){

        try{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                View statusbar = getActiviteEnCours().getWindow().getDecorView();
                int flags = statusbar.getSystemUiVisibility();
                flags = flags ^ View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                statusbar.setSystemUiVisibility(flags);
            }
        } catch ( Exception e ) {
            appelProcedureWL( "JavaErreur", e.getMessage());
        }

    }

    static public void fWD_javaErreur(WDObjet vWD_sMessage ){
        initExecProcGlobale("JavaErreur");
        try{
            vWD_sMessage = WDParametre.traiterParametre(vWD_sMessage, 1, false, 16);
            // info(sMessage)
            WDAPIDialogue.info(vWD_sMessage.getString());
        } finally{
            finExecProcGlobale();
        }
    }

}
