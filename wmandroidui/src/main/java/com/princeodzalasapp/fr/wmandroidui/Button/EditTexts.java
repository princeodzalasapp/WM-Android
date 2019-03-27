package com.princeodzalasapp.fr.wmandroidui.Button;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.princeodzalasapp.fr.wmandroidui.R;
import com.princeodzalasapp.fr.wmandroidui.Utiles.ErreurJava;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.DpToPx;
import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

public class EditTexts {

    public static View normal(final int idParent, final int idEdit, String mText, String mColorText, Activity mActivity){

        try {
        EditText editText = new EditText(getAppContext(mActivity));
        editText.setId(idEdit);
        LinearLayout.LayoutParams editTextParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        TextInputLayout textInputLayout = new TextInputLayout(getAppContext(mActivity));
        LinearLayout.LayoutParams textInputLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        textInputLayout.setLayoutParams(textInputLayoutParams);
        textInputLayout.addView(editText, editTextParams);
        textInputLayout.setHint(mText);
        textInputLayout.setDefaultHintTextColor(ColorStateList.valueOf(Color.parseColor(mColorText)));
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(textInputLayout);
            }
            return textInputLayout;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static View filledBox(final int idParent, final int idEdit, String mText, String mColorText, String mColor, boolean mEnable, final Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            TextInputLayout textInputLayout = (TextInputLayout) inflater.inflate(R.layout.edit_text_fillebox,null);
            textInputLayout.setDefaultHintTextColor(ColorStateList.valueOf(Color.parseColor(mColorText)));
            TextInputEditText mEdittext = textInputLayout.findViewById(R.id.edit_text);
            mEdittext.setId(idEdit);
            mEdittext.setHint(mText);
            mEdittext.setBackgroundColor(Color.parseColor(mColor));
            mEdittext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mColor)));
            mEdittext.setEnabled(mEnable);
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(textInputLayout);
            }
            return textInputLayout;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }


}
