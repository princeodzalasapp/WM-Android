package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.mikepenz.iconics.IconicsDrawable;

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
        Toasty.normal(mContext, message, Toast.LENGTH_SHORT).show();
    }

    public static void normalIcon(String message, String nImage, Context mContext){
        Drawable mImage =  new IconicsDrawable(mContext, nImage);
        mImage.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
        Toasty.normal(mContext, message, Toast.LENGTH_SHORT, mImage,true).show();
    }

    public static void customiseIcon(String message, String nImage,String ColorMsg, String ColorFond, Context mContext){
        Drawable mImage =  new IconicsDrawable(mContext, nImage);
        mImage.setColorFilter(Color.parseColor(ColorMsg), PorterDuff.Mode.SRC_IN);
        Toasty.custom(mContext, message, mImage,Color.parseColor(ColorFond), Color.parseColor(ColorMsg), Toasty.LENGTH_SHORT, true, true).show();
    }

}
