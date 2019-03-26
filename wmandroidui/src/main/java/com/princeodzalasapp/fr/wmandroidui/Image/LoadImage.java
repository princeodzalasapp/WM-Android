package com.princeodzalasapp.fr.wmandroidui.Image;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class LoadImage {

    public static void setImageView(ImageView img, String nomUrl, Context mContext){
        img.setTag(10000);
        Glide.with(mContext).load(nomUrl).apply(new RequestOptions().centerCrop()).into(img);
    }

    public static void displayImageOriginal(Context mContext, ImageView img, @DrawableRes int drawable) {
        try {
            Glide.with(mContext).load(drawable)
                    .transition(withCrossFade())
                    .apply(new RequestOptions()
                            .diskCacheStrategy(DiskCacheStrategy.NONE))
                    .into(img);
        } catch (Exception e) {
        }
    }

    public static void displayImageRound(final Context mContext, final ImageView img, @DrawableRes int drawable) {
        try {
            Glide.with(mContext).asBitmap().load(drawable)
                    .apply(new RequestOptions()
                            .centerCrop())
                    .into(new BitmapImageViewTarget(img) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                            circularBitmapDrawable.setCircular(true);
                            img.setImageDrawable(circularBitmapDrawable);
                        }
                    });
        } catch (Exception e) {
        }
    }

}
