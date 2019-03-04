package com.princeodzalasapp.fr.wmandroidui.Animations;

import android.app.Activity;
import android.transition.Fade;
import android.transition.Slide;

public class Animations {

    public static void slideWindowExit(Activity mActivity){
        Slide slide = new Slide();
        slide.setDuration(1000);
        mActivity.getWindow().setExitTransition(slide);
    }

    public static void fadeWindowEnter(Activity mActivity){
        Fade fade = new Fade();
        fade.setDuration(1000);
        mActivity.getWindow().setEnterTransition(fade);
    }


}
