package com.princeodzalasapp.fr.wmandroidui.Button;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.princeodzalasapp.fr.wmandroidui.R;
import com.princeodzalasapp.fr.wmandroidui.Utiles.ErreurJava;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.DpToPx;
import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

public class CardView {

    public static void Blanc(int nIdParent, Activity mActivity){

        final float scale = getAppContext(mActivity).getResources().getDisplayMetrics().density;
        final int pxElevation = DpToPx(4,getAppContext(mActivity));
        final int pxRaduis = DpToPx(8,getAppContext(mActivity));
        final int pxMagins = DpToPx(5,getAppContext(mActivity));

        android.support.v7.widget.CardView mCardView = new android.support.v7.widget.CardView(getAppContext(mActivity));
        LinearLayout.LayoutParams clayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        clayoutParams.setMargins(pxMagins,pxMagins,pxMagins,pxMagins);
        mCardView.setLayoutParams(clayoutParams);
        mCardView.setCardBackgroundColor(Color.WHITE);
        mCardView.setMaxCardElevation(pxElevation);
        mCardView.setCardElevation(pxElevation);
        mCardView.setRadius(pxRaduis);

        ViewGroup parent = (ViewGroup) mActivity.findViewById(nIdParent);
        parent.setClipToPadding(false);
        parent.setClipChildren (false);

        if(parent != null)	{
            parent.addView(mCardView);
        }
    }

    public static void BlancXml(int idParent, Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            DesignCard mView = (DesignCard) inflater.inflate(R.layout.card1,null);
            ViewGroup parent = (ViewGroup)mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(mView);
            }
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
        }
    }

}
