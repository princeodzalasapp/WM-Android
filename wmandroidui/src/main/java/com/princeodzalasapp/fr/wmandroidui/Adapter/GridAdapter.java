package com.princeodzalasapp.fr.wmandroidui.Adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.princeodzalasapp.fr.wmandroidui.R;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends BaseAdapter {
        private List<Item> mItems = new ArrayList<Item>();
        private LayoutInflater mInflater;
        private Context mContext;

    public GridAdapter(ArrayList<Item> mData, Context context) {
            mInflater = LayoutInflater.from(context);
            this.mContext = context;
            this.mItems = mData;
            //mItems.add(new Item("Red",R.drawable.red));
        }

        @Override
        public int getCount() {
            return mItems.size();
        }

        @Override
        public Item getItem(int i) {
            return mItems.get(i);
        }

        @Override
        public long getItemId(int i) {
            return mItems.get(i).drawableId;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            android.view.View v = view;
            ImageView picture;
            TextView name;
            if (v == null) {
                v = mInflater.inflate(R.layout.grid_image3_item, viewGroup, false);
                v.setTag(R.id.picture, v.findViewById(R.id.picture));
                v.setTag(R.id.text, v.findViewById(R.id.text));
            }
            picture = (ImageView) v.getTag(R.id.picture);
            name = (TextView) v.getTag(R.id.text);
            Item item = getItem(i);
            picture.setImageResource(item.drawableId);
            name.setText(item.name);
            return v;
        }

        private static class Item {
            public final String name;
            public final int drawableId;

            Item(String name, int drawableId) {
                this.name = name;
                this.drawableId = drawableId;
            }
        }
}
