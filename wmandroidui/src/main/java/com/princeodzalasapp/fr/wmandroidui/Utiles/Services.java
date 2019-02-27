package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class Services {

    public static int DpToPx(int valeurDp, Context mContext){
        final float scale = mContext.getResources().getDisplayMetrics().density;
        final int dp = (int) ((valeurDp * scale) + 0.5f);
        return dp;
    }

    public static Context getAppContext(Activity mActivity){
        return mActivity.getApplicationContext();
    }

    @SuppressLint("ResourceType")
    public static String getIdViewD(View view) {
        if (view.getId() == 0xffffffff) return "no-id";
        else return view.getResources().getResourceName(view.getId());
    }

    public static View getRootView(Activity mActivity) {
        final ViewGroup contentViewGroup = (ViewGroup) mActivity.findViewById(android.R.id.content);
        View rootView = null;
        if(contentViewGroup != null) rootView = contentViewGroup.getChildAt(0);
        if(rootView == null) rootView = mActivity.getWindow().getDecorView().getRootView();
        return rootView;
    }

}
