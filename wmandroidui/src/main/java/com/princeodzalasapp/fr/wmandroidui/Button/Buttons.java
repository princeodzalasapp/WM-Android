package com.princeodzalasapp.fr.wmandroidui.Button;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.mikepenz.iconics.IconicsDrawable;
import com.princeodzalasapp.fr.wmandroidui.Adapter.ItemClickSupport;
import com.princeodzalasapp.fr.wmandroidui.R;
import com.princeodzalasapp.fr.wmandroidui.Utiles.ErreurJava;
import com.princeodzalasapp.fr.wmandroidui.Utiles.ToastColor;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

public class Buttons {

    public static View outlined_icon(final int idParent,final int idButton, String mText,String mColorText,String mIcon,String mColorIcon, String mColor,boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            DesignButton btn = (DesignButton) inflater.inflate(R.layout.button_outlined_icon,null);
            btn.setId(idButton);
            btn.setText(mText);
            btn.setTextColor(Color.parseColor(mColorText));
            btn.setBackgroundColor(Color.parseColor(mColor));
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            btn.setEnabled(mEnable);
            Drawable mImage =  new IconicsDrawable(getAppContext(mActivity), mIcon);
            btn.setIcon(mImage);
            //btn.setIconTint(ColorStateList.valueOf(Color.parseColor(mColorIcon)));
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(btn);
            }
            return btn;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static View icon(final int idParent,final int idButton, String mText,String mColorText,String mIcon,String mColorIcon, String mColor,boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            DesignButton btn = (DesignButton) inflater.inflate(R.layout.button_icon,null);
            btn.setId(idButton);
            btn.setText(mText);
            btn.setTextColor(Color.parseColor(mColorText));
            btn.setBackgroundColor(Color.parseColor(mColor));
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            btn.setEnabled(mEnable);
            Drawable mImage =  new IconicsDrawable(getAppContext(mActivity), mIcon);
            btn.setIcon(mImage);
            //btn.setIconTint(ColorStateList.valueOf(Color.parseColor(mColorIcon)));
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(btn);
            }
            return btn;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }
    public static View text_icon(final int idParent,final int idButton, String mText,String mColorText,String mIcon,String mColorIcon, String mColor,boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            DesignButton btn = (DesignButton) inflater.inflate(R.layout.button_text_icon,null);
            btn.setId(idButton);
            btn.setText(mText);
            btn.setTextColor(Color.parseColor(mColorText));
            btn.setBackgroundColor(Color.parseColor(mColor));
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            btn.setEnabled(mEnable);
            Drawable mImage =  new IconicsDrawable(getAppContext(mActivity), mIcon);
            btn.setIcon(mImage);
            //btn.setIconTint(ColorStateList.valueOf(Color.parseColor(mColorIcon)));
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(btn);
            }
            return btn;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static View text_dialog_icon(final int idParent,final int idButton, String mText,String mColorText,String mIcon,String mColorIcon, String mColor,boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            DesignButton btn = (DesignButton) inflater.inflate(R.layout.button_text_dialog_icon,null);
            btn.setId(idButton);
            btn.setText(mText);
            btn.setTextColor(Color.parseColor(mColorText));
            btn.setBackgroundColor(Color.parseColor(mColor));
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            btn.setEnabled(mEnable);
            Drawable mImage =  new IconicsDrawable(getAppContext(mActivity), mIcon);
            btn.setIcon(mImage);
            //btn.setIconTint(ColorStateList.valueOf(Color.parseColor(mColorIcon)));
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(btn);
            }
            return btn;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static View outlined(final int idParent,final int idButton, String mText,String mColorText, String mColor,boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            DesignButton btn = (DesignButton) inflater.inflate(R.layout.button_outlined,null);
            btn.setId(idButton);
            btn.setText(mText);
            btn.setTextColor(Color.parseColor(mColorText));
            btn.setBackgroundColor(Color.parseColor(mColor));
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            btn.setEnabled(mEnable);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(btn);
            }
            return btn;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static View unelevated(final int idParent,final int idButton, String mText,String mColorText, String mColor,boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            DesignButton btn = (DesignButton) inflater.inflate(R.layout.button_unelevated,null);
            btn.setId(idButton);
            btn.setText(mText);
            btn.setTextColor(Color.parseColor(mColorText));
            btn.setBackgroundColor(Color.parseColor(mColor));
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            btn.setEnabled(mEnable);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(btn);
            }
            return btn;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static View unelevated_icon(final int idParent,final int idButton, String mText,String mColorText,String mIcon,String mColorIcon, String mColor,boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            DesignButton btn = (DesignButton) inflater.inflate(R.layout.button_unelevated_icon,null);
            btn.setId(idButton);
            btn.setText(mText);
            btn.setTextColor(Color.parseColor(mColorText));
            btn.setBackgroundColor(Color.parseColor(mColor));
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            btn.setEnabled(mEnable);
            Drawable mImage =  new IconicsDrawable(getAppContext(mActivity), mIcon);
            btn.setIcon(mImage);
            //btn.setIconTint(ColorStateList.valueOf(Color.parseColor(mColorIcon)));
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(btn);
            }
            return btn;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static View text(final int idParent,final int idButton, String mText,String mColorText, String mColor,boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            DesignButton btn = (DesignButton) inflater.inflate(R.layout.button_text,null);
            btn.setId(idButton);
            btn.setText(mText);
            btn.setTextColor(Color.parseColor(mColorText));
            btn.setBackgroundColor(Color.parseColor(mColor));
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            btn.setEnabled(mEnable);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(btn);
            }
            return btn;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }
    public static View text_dialog(final int idParent,final int idButton, String mText,String mColorText, String mColor,boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            DesignButton btn = (DesignButton) inflater.inflate(R.layout.button_text_dialog,null);
            btn.setId(idButton);
            btn.setText(mText);
            btn.setTextColor(Color.parseColor(mColorText));
            btn.setBackgroundColor(Color.parseColor(mColor));
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            btn.setEnabled(mEnable);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(btn);
            }
            return btn;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static View normal(final int idParent,final int idButton, String mText,String mColorText, String mColor,boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            DesignButton btn = (DesignButton) inflater.inflate(R.layout.button,null);
            btn.setId(idButton);
            btn.setText(mText);
            btn.setTextColor(Color.parseColor(mColorText));
            btn.setBackgroundColor(Color.parseColor(mColor));
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            btn.setEnabled(mEnable);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(btn);
            }
            return btn;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static View facebook(final int idParent, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            LinearLayout mView = (LinearLayout) inflater.inflate(R.layout.button_facebook,null);
            LoginButton anonym = mView.findViewById(R.id.login_button_fb);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(mView);
            }
            return anonym;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static View google(final int idParent, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            LinearLayout mView = (LinearLayout) inflater.inflate(R.layout.button_google,null);
            LoginButton anonym = mView.findViewById(R.id.login_button_ggle);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(mView);
            }
            return anonym;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static View twitter(final int idParent, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            LinearLayout mView = (LinearLayout) inflater.inflate(R.layout.button_twitter,null);
            LoginButton anonym = mView.findViewById(R.id.login_button_twitter);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(mView);
            }
            return anonym;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static View github(final int idParent, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            LinearLayout mView = (LinearLayout) inflater.inflate(R.layout.button_github,null);
            LoginButton anonym = mView.findViewById(R.id.login_button_github);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(mView);
            }
            return anonym;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

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
            fb.setText(R.string.whatsapp);
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

    public static View anonyme(final int idParent, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            LinearLayout mView = (LinearLayout) inflater.inflate(R.layout.button_anonyme,null);
            LoginButton anonym = mView.findViewById(R.id.login_button_anonyme);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(mView);
            }
            return anonym;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }

    }

    public static View phone(final int idParent, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            LinearLayout mView = (LinearLayout) inflater.inflate(R.layout.button_phone,null);
            LoginButton anonym = mView.findViewById(R.id.login_button_phone);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(mView);
            }
            return anonym;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }

    }

    public static View email(final int idParent, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            LinearLayout mView = (LinearLayout) inflater.inflate(R.layout.button_email,null);
            LoginButton anonym = mView.findViewById(R.id.login_button_email);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(mView);
            }
            return anonym;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }

    }




}
