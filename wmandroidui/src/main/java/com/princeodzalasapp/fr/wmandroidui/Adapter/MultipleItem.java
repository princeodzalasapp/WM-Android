package com.princeodzalasapp.fr.wmandroidui.Adapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.princeodzalasapp.fr.wmandroidui.models.MyActus;
import com.princeodzalasapp.fr.wmandroidui.models.MyListe;
import com.princeodzalasapp.fr.wmandroidui.models.MyVideo;

public class MultipleItem implements MultiItemEntity {

    public static final int LISTE_NORMAL = 1;
    public static final int PUB_HAUT = 2;
    public static final int PUB_BAS = 3;
    public static final int PUB_MILIEU = 4;
    public static final int LIST_ESPACE = 5;
    public static final int LIST_ACTUS = 6;
    public static final int LIST_VIDEO = 7;
    private MyActus mActus;
    private MyVideo mVideo;
    private MyListe mListe;
    private int itemType;

    public MultipleItem(int itemType, MyActus mActus) {
        this.mActus = mActus;
        this.itemType = itemType;
    }
    public MultipleItem(int itemType, MyVideo mVideo) {
        this.mVideo = mVideo;
        this.itemType = itemType;
    }
    public MultipleItem(int itemType, MyListe mListe) {
        this.mListe = mListe;
        this.itemType = itemType;
    }
    public MultipleItem(int itemType) {
        this.itemType = itemType;
    }

    public MyActus getActus() {
        return mActus;
    }
    public MyVideo getVideo() {
        return mVideo;
    }
    public MyListe getListe() {
        return mListe;
    }
    @Override
    public int getItemType() {
        return itemType;
    }

}
