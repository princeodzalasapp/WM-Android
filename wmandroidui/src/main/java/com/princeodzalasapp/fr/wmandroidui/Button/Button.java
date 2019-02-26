package com.princeodzalasapp.fr.wmandroidui.Button;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.princeodzalasapp.fr.wmandroidui.R;
import com.princeodzalasapp.fr.wmandroidui.Utiles.ErreurJava;
import com.princeodzalasapp.fr.wmandroidui.Utiles.ToastColor;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

public class Button {

    public static void fb_partageText(final int idParent, final String mText, final Activity mActivity){

        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            LinearLayout mView = (LinearLayout) inflater.inflate(R.layout.button_facebook,null);
            LoginButton fb = (LoginButton) mView.findViewById(R.id.login_button_fb);
            fb.setText(R.string.fb_partage);
            fb.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent PartagerIntent = new Intent(Intent.ACTION_SEND);
                    PartagerIntent.setType("text/plain");
                    PartagerIntent.putExtra(Intent.EXTRA_TEXT, mText);
                    PartagerIntent.setPackage("com.facebook.katana");
                    try {
                        mActivity.startActivity(PartagerIntent);
                    } catch (android.content.ActivityNotFoundException ex) {
                        ToastColor.erreur("Facebook n'est pas installée !",getAppContext(mActivity));
                    }
                }
            });
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(mView);
            }
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
        }
    }


    public static void wa_partageText(final int idParent, final String mText, final Activity mActivity){

        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            LinearLayout mView = (LinearLayout) inflater.inflate(R.layout.button_facebook,null);
            LoginButton fb = mView.findViewById(R.id.login_button_fb);
            fb.setText(R.string.fb_partage);
            fb.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent PartagerIntent = new Intent(Intent.ACTION_SEND);
                    PartagerIntent.setType("text/plain");
                    PartagerIntent.putExtra(Intent.EXTRA_TEXT, mText);
                    PartagerIntent.setPackage("com.whatsapp");
                    try {
                        mActivity.startActivity(PartagerIntent);
                    } catch (android.content.ActivityNotFoundException ex) {
                        ToastColor.erreur("Whatsapp n'est pas installée !",getAppContext(mActivity));
                    }
                }
            });
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(mView);
            }
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
        }
    }
}
