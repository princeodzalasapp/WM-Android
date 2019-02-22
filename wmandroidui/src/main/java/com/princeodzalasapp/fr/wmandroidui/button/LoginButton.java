package com.princeodzalasapp.fr.wmandroidui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.princeodzalasapp.fr.wmandroidui.R;

public class LoginButton extends AppCompatButton {

    public LoginButton(Context context) {
        super(context);
    }

    public LoginButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLoginButtonAttrs(attrs);
    }

    public LoginButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLoginButtonAttrs(attrs);
    }

    /**
     * Loads the compound drawables natively on L+ devices and using AppCompat pre-L.
     * <p>
     * <i>Note:</i> If we ever need a TextView with compound drawables, this same technique is
     * applicable.
     */
    private void initLoginButtonAttrs(AttributeSet attrs) {
        if (attrs == null) { return; }

        TypedArray attributeArray = getContext().obtainStyledAttributes(
                attrs,
                R.styleable.SupportVectorDrawablesButton);

        Drawable drawableStart = null;
        Drawable drawableEnd = null;
        Drawable drawableTop = null;
        Drawable drawableBottom = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            drawableStart = attributeArray.getDrawable(
                    R.styleable.SupportVectorDrawablesButton_drawableStartCompat);
            drawableEnd = attributeArray.getDrawable(
                    R.styleable.SupportVectorDrawablesButton_drawableEndCompat);
            drawableTop = attributeArray.getDrawable(
                    R.styleable.SupportVectorDrawablesButton_drawableTopCompat);
            drawableBottom = attributeArray.getDrawable(
                    R.styleable.SupportVectorDrawablesButton_drawableBottomCompat);
        } else {
            int drawableStartId = attributeArray.getResourceId(
                    R.styleable.SupportVectorDrawablesButton_drawableStartCompat, -1);
            int drawableEndId = attributeArray.getResourceId(
                    R.styleable.SupportVectorDrawablesButton_drawableEndCompat, -1);
            int drawableTopId = attributeArray.getResourceId(
                    R.styleable.SupportVectorDrawablesButton_drawableTopCompat, -1);
            int drawableBottomId = attributeArray.getResourceId(
                    R.styleable.SupportVectorDrawablesButton_drawableBottomCompat, -1);

            if (drawableStartId != -1) {
                drawableStart = AppCompatResources.getDrawable(getContext(), drawableStartId);
            }
            if (drawableEndId != -1) {
                drawableEnd = AppCompatResources.getDrawable(getContext(), drawableEndId);
            }
            if (drawableTopId != -1) {
                drawableTop = AppCompatResources.getDrawable(getContext(), drawableTopId);
            }
            if (drawableBottomId != -1) {
                drawableBottom = AppCompatResources.getDrawable(getContext(), drawableBottomId);
            }
        }

        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(
                this, drawableStart, drawableTop, drawableEnd, drawableBottom);

        attributeArray.recycle();
    }

}
