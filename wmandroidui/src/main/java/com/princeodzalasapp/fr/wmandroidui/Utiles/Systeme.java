package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.content.Context;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Systeme {

    public static int DpToPx(int valeurDp, Context mContext){
        final float scale = mContext.getResources().getDisplayMetrics().density;
        final int dp = (int) ((valeurDp * scale) + 0.5f);
        return dp;
    }

    public static String getDateYoutube(String date) {

        final String ISO_8601_24H_FULL_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
        DateFormat df = new SimpleDateFormat(ISO_8601_24H_FULL_FORMAT);
        String dateString;
        try {
            Date d = df.parse(date);
            dateString = DateFormat.getDateInstance().format(d);
        } catch (ParseException e) {
            e.printStackTrace();
            dateString = "";
        }
        return dateString;
    }


}
