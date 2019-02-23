package com.princeodzalasapp.fr.wmandroidui.Adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.princeodzalasapp.fr.wmandroidui.models.MyListe;
import com.princeodzalasapp.fr.wmandroidui.models.MyListeIcon;

public class ValeurAdapter {

    public static MyListe mListe;
    public static MyListeIcon mListeIcon;
    public static String[] resultat;

    public static String[] getLigneValeur(MultipleAdapter DistrictAdapt){
        DistrictAdapt.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MultipleItem item = (MultipleItem) adapter.getData().get(position);
                if (item.getListeIcon() != null) {
                    resultat[0] = item.getListeIcon().getCode();
                    resultat[1] = item.getListeIcon().getNom();
                    resultat[2] = item.getListeIcon().getImageUrl();
                }
            }
        });
        return resultat;
    }

    public static MyListe getListe(MultipleAdapter DistrictAdapt){
        DistrictAdapt.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MultipleItem item = (MultipleItem) adapter.getData().get(position);
                if (item.getListe() != null) {
                    mListe = new MyListe(item.getListe().getNom(), item.getListe().getCode());
                }
            }
        });
        return mListe;
    }

    public static MyListeIcon getListeIcon(MultipleAdapter DistrictAdapt){
        DistrictAdapt.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MultipleItem item = (MultipleItem) adapter.getData().get(position);
                if (item.getListeIcon() != null) {
                    mListeIcon = new MyListeIcon(item.getListeIcon().getNom(),item.getListeIcon().getImageUrl(), item.getListeIcon().getCode());
                }
            }
        });
        return mListeIcon;
    }

}
