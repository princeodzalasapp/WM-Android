package com.princeodzalasapp.fr.wmandroidui.Button;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
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

    public static void Blanc(int nIdParent, Activity mActivity){

        EditText editText = new EditText(getAppContext(mActivity));
        LinearLayout.LayoutParams editTextParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        TextInputLayout textInputLayout = new TextInputLayout(getAppContext(mActivity));
        LinearLayout.LayoutParams textInputLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        textInputLayout.setLayoutParams(textInputLayoutParams);
        textInputLayout.addView(editText, editTextParams);
        textInputLayout.setHint("hint");

        //setContentView(textInputLayout);
    }

    public static View outlined(final int idParent, final int idButton, String mText, String mColorText, String mColor, boolean mEnable, final Activity mActivity){
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


}
