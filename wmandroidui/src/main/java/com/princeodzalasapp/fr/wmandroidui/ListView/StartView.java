package com.princeodzalasapp.fr.wmandroidui.ListView;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.princeodzalasapp.fr.wmandroidui.R;
import com.princeodzalasapp.fr.wmandroidui.Utiles.ErreurJava;
import com.ramotion.paperonboarding.PaperOnboardingEngine;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnChangeListener;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

import static com.princeodzalasapp.fr.wmandroidui.Image.Images.getIdImageRessource;
import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

public class StartView {


    public static ViewGroup OnboardingActivity(int idParent, String[] mTitre, String[] mDesc, String[] mIcon1, String[] mIcon2, String[] mColor, Activity mActivity){

        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            RelativeLayout fen = (RelativeLayout) inflater.inflate(R.layout.onboarding_main_layout,null);

            ArrayList<PaperOnboardingPage> elements = new ArrayList<PaperOnboardingPage>();
            for (int i = 0 ; i < mTitre.length ; i++){
                elements.add(new PaperOnboardingPage(mTitre[i], mDesc[i], Color.parseColor(mColor[i]), getIdImageRessource(mActivity,mIcon1[i]), getIdImageRessource(mActivity,mIcon2[i])));
            }
            PaperOnboardingEngine engine = new PaperOnboardingEngine(fen.findViewById(R.id.onboardingRootView), elements, getAppContext(mActivity));
            engine.setOnChangeListener(new PaperOnboardingOnChangeListener() {
                @Override
                public void onPageChanged(int oldElementIndex, int newElementIndex) {

                }
            });
            engine.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
                @Override
                public void onRightOut() {

                }
            });
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(fen);
            }
            return parent;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }

    }


}
