package com.princeodzalasapp.fr.wmandroidui.Pub;

import android.content.Context;
import android.os.Handler;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

import com.google.android.gms.ads.*;
import com.google.android.gms.ads.reward.*;

public class Interstitial {

    public static InterstitialAd interstitialAd;
    public static com.google.android.gms.ads.InterstitialAd interstitial;

    public static void Facebook(String PubId,final int delaySec, Context mContext){
        interstitialAd = new InterstitialAd(mContext, PubId);
        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {}
            @Override
            public void onInterstitialDismissed(Ad ad) {}
            @Override
            public void onError(Ad ad, AdError adError) {}
            @Override
            public void onAdLoaded(Ad ad) {
                showAdWithDelay(delaySec);
            }
            @Override
            public void onAdClicked(Ad ad) {}
            @Override
            public void onLoggingImpression(Ad ad) {}
        });
        interstitialAd.loadAd();
    }

    public static void showAdWithDelay(final int delaySec) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if(interstitialAd == null || !interstitialAd.isAdLoaded()) {
                    return;
                }
                if(interstitialAd.isAdInvalidated()) {
                    return;
                }
                interstitialAd.show();
            }
        }, 1000 * delaySec ); // Show the ad after delaySec Secondes
    }


    public static void AdMob(String PubId, Context mContext){
        com.google.android.gms.ads.AdRequest adRequest;

        // Création de la pub
        interstitial = new com.google.android.gms.ads.InterstitialAd(mContext);
        interstitial.setAdUnitId(PubId);

        // Listener pour afficher la pub une fois qu'elle sera chargée
        interstitial.setAdListener(new com.google.android.gms.ads.AdListener() {
            @Override
            public void onAdLoaded() {
                interstitial.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
            }
        });

        // Demande d'affichage de la pub
        adRequest = new com.google.android.gms.ads.AdRequest.Builder().build();

        // Affichage de la pub
        interstitial.loadAd(adRequest);
    }

}
