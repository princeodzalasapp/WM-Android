package com.princeodzalasapp.fr.wmandroidui.Snackbar;

import android.app.Activity;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getRootView;

public class Snackbars {

    public static android.support.design.widget.Snackbar snackbar;

    public static void Long(String nMessage, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) Snackbar.make(rootView, nMessage, Snackbar.LENGTH_LONG).show();
    }
    public static void Short(String nMessage, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) Snackbar.make(rootView, nMessage, Snackbar.LENGTH_SHORT).show();
    }
    public static void LongCustomise(String nMessage, String sColorFond, String sColorText, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) {
            Snackbar snackbar = Snackbar.make(rootView, nMessage, Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.parseColor(sColorFond));
            TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.parseColor(sColorText));
            snackbar.show();
        }
    }
    public static void ShortCustomise(String nMessage, String sColorFond, String sColorText, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) {
            Snackbar snackbar = Snackbar.make(rootView, nMessage, Snackbar.LENGTH_SHORT);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.parseColor(sColorFond));
            TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.parseColor(sColorText));
            snackbar.show();
        }
    }
    public static void SecCustomise(String nMessage, String sColorFond, String sColorText, int mTemps, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) {
            Snackbar snackbar = Snackbar.make(rootView, nMessage, mTemps*1000);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.parseColor(sColorFond));
            TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
            Button snackViewButton = snackBarView.findViewById(android.support.design.R.id.snackbar_action);
            textView.setTextColor(Color.parseColor(sColorText));
            snackbar.show();
        }
    }
    public static void Sec(String nMessage, int mTemps,Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) Snackbar.make(rootView, nMessage, mTemps*1000 ).show();
    }
    public static Snackbar SecAction(String nMessage,int mTemps, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        return Snackbar.make(rootView, nMessage,  mTemps*1000 );
    }
    public static void Indefini(String nMessage,String mAction, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        Snackbar.make(rootView, nMessage, Snackbar.LENGTH_INDEFINITE).setAction(mAction, new View.OnClickListener() {
            @Override
            public void onClick(View view) {}
        }).show();
    }

    public static Snackbar IndefiniAction(String nMessage, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        return  Snackbar.make(rootView, nMessage, Snackbar.LENGTH_INDEFINITE);
    }

    public static void IndefiniCustomise(String nMessage, String sColorFond, String sColorText, String mAction,String sColorActionText,String sColorAction, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) {
            Snackbar snackbar = Snackbar.make(rootView, nMessage, Snackbar.LENGTH_INDEFINITE);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.parseColor(sColorFond));
            TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.parseColor(sColorText));
            Button snackViewButton = snackBarView.findViewById(android.support.design.R.id.snackbar_action);
            snackViewButton.setBackgroundColor(Color.parseColor(sColorAction));
            snackbar.setAction(mAction, new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            snackbar.setActionTextColor(Color.parseColor(sColorActionText));
            snackbar.show();
        }
    }
    public static Snackbar SecActionCustomise(String nMessage, String sColorFond, String sColorText, String sColorActionText,String sColorAction, int mTemps, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        Snackbar snackbar = Snackbar.make(rootView, nMessage, mTemps*1000);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(Color.parseColor(sColorFond));
        TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.parseColor(sColorText));
        Button snackViewButton = (Button) snackBarView.findViewById(android.support.design.R.id.snackbar_action);
        snackViewButton.setBackgroundColor(Color.parseColor(sColorAction));
        snackbar.setActionTextColor(Color.parseColor(sColorActionText));
        return snackbar;
    }
    public static Snackbar IndefiniActionCustomise(String nMessage, String sColorFond, String sColorText,String sColorActionText,String sColorAction, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        Snackbar snackbar = Snackbar.make(rootView, nMessage, Snackbar.LENGTH_INDEFINITE);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(Color.parseColor(sColorFond));
        TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.parseColor(sColorText));
        Button snackViewButton = (Button) snackBarView.findViewById(android.support.design.R.id.snackbar_action);
        snackViewButton.setBackgroundColor(Color.parseColor(sColorAction));
        snackbar.setActionTextColor(Color.parseColor(sColorActionText));
        return snackbar;
    }

    //  Short Snackbar No Action
    public static void infoShort(String nMessage, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) Snack.info(rootView, nMessage, Snack.LENGTH_SHORT).show();
    }
    public static void warningShort(String nMessage, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) Snack.warning(rootView, nMessage, Snack.LENGTH_SHORT).show();
    }
    public static void errorShort(String nMessage, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) Snack.error(rootView, nMessage, Snack.LENGTH_SHORT).show();
    }
    public static void normalShort(String nMessage, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) Snack.normal(rootView, nMessage, Snack.LENGTH_SHORT).show();
    }
    public static void SuccessShort(String nMessage, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) Snack.success(rootView, nMessage, Snack.LENGTH_SHORT).show();
    }

    //  Long Snackbar No Action
    public static void infoLong(String nMessage, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) Snack.info(rootView, nMessage, Snack.LENGTH_LONG).show();
    }
    public static void warningLong(String nMessage, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) Snack.warning(rootView, nMessage, Snack.LENGTH_LONG).show();
    }
    public static void errorLong(String nMessage, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) Snack.error(rootView, nMessage, Snack.LENGTH_LONG).show();
    }
    public static void normalLong(String nMessage, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) Snack.normal(rootView, nMessage, Snack.LENGTH_LONG).show();
    }
    public static void SuccessLong(String nMessage, Activity mActivity) {
        final View rootView = getRootView(mActivity);
        if(rootView != null) Snack.success(rootView, nMessage, Snack.LENGTH_LONG).show();
    }

    public static void test() {
        String[]  donnes = "".split("|");
        for(int i=0 ; i< donnes.length; i++ ){
            String nId = donnes[0];
            String nTitre = donnes[1];
        }
    }




}
