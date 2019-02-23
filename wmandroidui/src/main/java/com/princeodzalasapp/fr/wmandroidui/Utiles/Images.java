package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mikepenz.iconics.IconicsDrawable;

public class Images {

    public static void setIconeImageColor(ImageView nlogo, String nImage, String nColor, Context mContext){
        Drawable mImage =  new IconicsDrawable(mContext, nImage);
        nlogo.setImageDrawable(mImage);
        nlogo.setColorFilter(Color.parseColor(nColor), PorterDuff.Mode.SRC_IN);
    }

    public static void setIconeColor(ImageView nlogo, String nColor){
        nlogo.setColorFilter(Color.parseColor(nColor), PorterDuff.Mode.SRC_IN);
    }

    public static void setIconeImage(ImageView nlogo, String nImage, Context mContext){
        Drawable mImage =  new IconicsDrawable(mContext, nImage);
        nlogo.setImageDrawable(mImage);
    }

    public static void setIcon(ImageView nlogo, String nImage, Context mContext){
        Drawable mImage =  new IconicsDrawable(mContext, nImage);
        nlogo.setImageDrawable(mImage);
    }

    public static void setImageUrl(ImageView myImagetView, String nomUrl, Context mContext){
        myImagetView.setTag(10000);
        Glide.with(mContext).load(nomUrl).apply(new RequestOptions().centerCrop()).into(myImagetView);

    }

    public static Drawable getIconicsDrawable(String nomImage, Context mContext){
        Drawable mImage =  new IconicsDrawable(mContext, nomImage);
        return  mImage;
    }

}
