package com.princeodzalasapp.fr.wmandroidui.Image;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mikepenz.iconics.IconicsDrawable;
import com.princeodzalasapp.fr.wmandroidui.Utiles.ErreurJava;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

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

    public static int getIdImageRessource(Activity mActivity, String mImageRessource){
        try{
            return getAppContext(mActivity).getResources().getIdentifier(mImageRessource, "drawable",getAppContext(mActivity).getPackageName() );
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return 0;
        }

    }

}
