package com.princeodzalasapp.fr.wmandroidui.Adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

public class ValeurAdapter {

    public static String[] resultat;

    public static String[] getLigneValeur(MultipleAdapter DistrictAdapt){
        DistrictAdapt.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
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

}
