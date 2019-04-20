package com.princeodzalasapp.fr.wmandroidui.Button;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;

import com.princeodzalasapp.fr.wmandroidui.R;
import com.princeodzalasapp.fr.wmandroidui.Utiles.ErreurJava;

public class EditTexts {

    public static EditText edit_normal(final int idParent, final int idEdit, String mText, String mColorText, String mColor,String mColor1, boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            final TextInputLayout textInputLayout = (TextInputLayout) inflater.inflate(R.layout.edit_text_normal,null);
            final  EditText mEdittext = textInputLayout.findViewById(R.id.edit_text);

            if(mColorText != "" )
                textInputLayout.setDefaultHintTextColor(ColorStateList.valueOf(Color.parseColor(mColorText)));

            if(mColor != "" )
                textInputLayout.setBackgroundColor(Color.parseColor(mColor));
            textInputLayout.setHint(mText);

            if(mColor1 != "" )
                mEdittext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            mEdittext.setId(idEdit);
            mEdittext.setEnabled(mEnable);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(textInputLayout);
            }
            return mEdittext;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static EditText edit_pwd(final int idParent, final int idEdit, String mText, String mColorText, String mColor,String mColor1, boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            final TextInputLayout textInputLayout = (TextInputLayout) inflater.inflate(R.layout.edit_text_normal,null);
            final  EditText mEdittext = textInputLayout.findViewById(R.id.edit_text);

            if(mColorText != "" )
                textInputLayout.setDefaultHintTextColor(ColorStateList.valueOf(Color.parseColor(mColorText)));

            if(mColor != "" )
                textInputLayout.setBackgroundColor(Color.parseColor(mColor));
            textInputLayout.setHint(mText);

            if(mColor1 != "" )
                mEdittext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            mEdittext.setId(idEdit);
            mEdittext.setEnabled(mEnable);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(textInputLayout);
            }
            return mEdittext;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static EditText filledBox(final int idParent, final int idEdit, String mText, String mColorText, String mColor,String mColor1, boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            final TextInputLayout textInputLayout = (TextInputLayout) inflater.inflate(R.layout.edit_text_fillebox,null);
            final  EditText mEdittext = textInputLayout.findViewById(R.id.edit_text);

            if(mColorText != "" )
                textInputLayout.setDefaultHintTextColor(ColorStateList.valueOf(Color.parseColor(mColorText)));

            if(mColor != "" )
                textInputLayout.setBackgroundColor(Color.parseColor(mColor));
            textInputLayout.setHint(mText);

            if(mColor1 != "" )
                mEdittext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            mEdittext.setId(idEdit);
            mEdittext.setEnabled(mEnable);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(textInputLayout);
            }
            return mEdittext;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static EditText filledBoxdense(final int idParent, final int idEdit, String mText, String mColorText, String mColor, String mColor1, boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            final TextInputLayout textInputLayout = (TextInputLayout) inflater.inflate(R.layout.edit_text_fillebox_dense,null);
            final  EditText mEdittext = textInputLayout.findViewById(R.id.edit_text);

            if(mColorText != "" )
                textInputLayout.setDefaultHintTextColor(ColorStateList.valueOf(Color.parseColor(mColorText)));

            if(mColor != "" )
                textInputLayout.setBackgroundColor(Color.parseColor(mColor));
            textInputLayout.setHint(mText);

            if(mColor1 != "" )
                mEdittext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            mEdittext.setId(idEdit);
            mEdittext.setEnabled(mEnable);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(textInputLayout);
            }
            return mEdittext;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static EditText outlinedbox(final int idParent, final int idEdit, String mText, String mColorText, String mColor, String mColor1, boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            final TextInputLayout textInputLayout = (TextInputLayout) inflater.inflate(R.layout.edit_text_outlinedbox,null);
            final  EditText mEdittext = textInputLayout.findViewById(R.id.edit_text);

            if(mColorText != "" )
                textInputLayout.setDefaultHintTextColor(ColorStateList.valueOf(Color.parseColor(mColorText)));

            if(mColor != "" )
                textInputLayout.setBackgroundColor(Color.parseColor(mColor));
            textInputLayout.setHint(mText);

            if(mColor1 != "" )
                mEdittext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            mEdittext.setId(idEdit);
            mEdittext.setEnabled(mEnable);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(textInputLayout);
            }
            return mEdittext;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static EditText outlinedbox_dense(final int idParent, final int idEdit, String mText, String mColorText, String mColor, String mColor1, boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            final TextInputLayout textInputLayout = (TextInputLayout) inflater.inflate(R.layout.edit_text_outlinedbox_dense,null);
            final  EditText mEdittext = textInputLayout.findViewById(R.id.edit_text);

            if(mColorText != "" )
                textInputLayout.setDefaultHintTextColor(ColorStateList.valueOf(Color.parseColor(mColorText)));

            if(mColor != "" )
                textInputLayout.setBackgroundColor(Color.parseColor(mColor));
            textInputLayout.setHint(mText);

            if(mColor1 != "" )
                mEdittext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            mEdittext.setId(idEdit);
            mEdittext.setEnabled(mEnable);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(textInputLayout);
            }
            return mEdittext;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static EditText outlinedbox_pwd(final int idParent, final int idEdit, String mText, String mColorText, String mColor, String mColor1, boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            final TextInputLayout textInputLayout = (TextInputLayout) inflater.inflate(R.layout.edit_text_outlinedbox_password,null);
            final  EditText mEdittext = textInputLayout.findViewById(R.id.edit_text);

            if(mColorText != "" )
                textInputLayout.setDefaultHintTextColor(ColorStateList.valueOf(Color.parseColor(mColorText)));

            if(mColor != "" )
                textInputLayout.setBackgroundColor(Color.parseColor(mColor));
            textInputLayout.setHint(mText);

            if(mColor1 != "" )
                mEdittext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            mEdittext.setId(idEdit);
            mEdittext.setEnabled(mEnable);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(textInputLayout);
            }
            return mEdittext;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

}
