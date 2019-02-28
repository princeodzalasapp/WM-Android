package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.princeodzalasapp.fr.wmandroidui.R;
import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

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
    public static String getIdView(View view) {
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

    public static void setPoliceProductSansBold(TextView myTextView, Activity mActivity){
        Typeface typeface = ResourcesCompat.getFont(getAppContext(mActivity), R.font.product_sans_bold);
        myTextView.setTypeface(typeface);
    }
    public static void setPoliceProductSansRegular(TextView myTextView, Activity mActivity){
        Typeface typeface = ResourcesCompat.getFont(getAppContext(mActivity), R.font.product_sans_regular);
        myTextView.setTypeface(typeface);
    }

}
