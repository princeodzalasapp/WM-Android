package com.princeodzalasapp.fr.wmandroidui;

import android.content.Context;
import android.widget.Toast;
import es.dmoral.toasty.Toasty;

public class ToastColor {

    public static void info(String message, Context mContext){
        Toasty.info(mContext, message, Toast.LENGTH_SHORT, true).show();
    }

    public static void erreur(String message, Context mContext){
        Toasty.error(mContext, message, Toast.LENGTH_SHORT, true).show();
    }

    public static void attention(String message, Context mContext){
        Toasty.warning(mContext, message, Toast.LENGTH_SHORT, true).show();
    }

    public static void succes(String message, Context mContext){
        Toasty.success(mContext, message, Toast.LENGTH_SHORT, true).show();
    }

    public static void normal(String message, Context mContext){
        Toasty.normal(mContext, message).show();
    }

}
