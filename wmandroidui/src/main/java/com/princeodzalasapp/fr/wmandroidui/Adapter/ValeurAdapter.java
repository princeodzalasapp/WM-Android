package com.princeodzalasapp.fr.wmandroidui.Adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

public class ValeurAdapter {

    public static String[] resultat;

    public static String[] getLigneValeur(MultipleAdapter DistrictAdapt){
        DistrictAdapt.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MultipleItem item = (MultipleItem) adapter.getData().get(position);
                if (item.getListe() != null) {
                    resultat[0] = item.getListe().getCode();
                    resultat[1] = item.getListe().getNom();
                    resultat[2] = item.getListe().getImageUrl();
                }
            }
        });
        return resultat;
    }

}
