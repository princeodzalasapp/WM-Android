package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.content.Context;

public class Systeme {

    public static int DpToPx(int valeurDp, Context mContext){
        final float scale = mContext.getResources().getDisplayMetrics().density;
        final int dp = (int) ((valeurDp * scale) + 0.5f);
        return dp;
    }



}
