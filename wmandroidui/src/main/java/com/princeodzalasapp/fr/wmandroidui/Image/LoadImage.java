package com.princeodzalasapp.fr.wmandroidui.Image;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class LoadImage {

    public static void setImageView(ImageView myImagetView, String nomUrl, Context mContext){
            myImagetView.setTag(10000);
            Glide.with(mContext).load(nomUrl).apply(new RequestOptions().centerCrop()).into(myImagetView);
    }

}
