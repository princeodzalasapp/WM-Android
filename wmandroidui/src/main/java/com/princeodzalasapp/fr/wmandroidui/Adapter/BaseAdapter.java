package com.princeodzalasapp.fr.wmandroidui.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

public abstract class BaseAdapter extends BaseQuickAdapter {


    public BaseAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    public BaseAdapter(@Nullable List data) {
        super(data);
    }

    public BaseAdapter(int layoutResId) {
        super(layoutResId);
    }
}
