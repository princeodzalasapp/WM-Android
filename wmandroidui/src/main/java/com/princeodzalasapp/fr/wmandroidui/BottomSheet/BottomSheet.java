package com.princeodzalasapp.fr.wmandroidui.BottomSheet;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import com.princeodzalasapp.fr.wmandroidui.R;
import com.princeodzalasapp.fr.wmandroidui.Utiles.ErreurJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

public class BottomSheet {

    private static boolean reponse = false;

    public static void info(String mTitre, String mMessage, final String mBouton, Activity mActivity){
        final BottomSheetDialog dialog = new BottomSheetDialog(mActivity);
        dialog.setContentView(R.layout.bottom_sheet_list_view);
        BottomSheetListView listView = dialog.findViewById(R.id.BottomSheet_listView);
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("titre", mTitre);
        map.put("desc", mMessage);
        map.put("btn", mBouton);
        list.add(map);
        SimpleAdapter adapter = new SimpleAdapter(mActivity,list, R.layout.bottom_sheet_dialog_info,
                new String[]{"titre", "desc","btn"},
                new int[]{R.id.info_title, R.id.info_desc, R.id.button_fermer}){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View v = super.getView(position, convertView, parent);
                Button b=v.findViewById(R.id.button_fermer);
                b.setText(mBouton);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        dialog.dismiss();
                    }
                });
                return v;
            }
        };
        if (listView != null) {
            listView.setAdapter(adapter);
            dialog.show();
        }
    }

    public static boolean reponse(String mTitre, String mMessage, final String mBouton1,final String mBouton2, Activity mActivity){
        final BottomSheetDialog dialog = new BottomSheetDialog(mActivity);
        dialog.setContentView(R.layout.bottom_sheet_list_view);
        BottomSheetListView listView = dialog.findViewById(R.id.BottomSheet_listView);
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("titre", mTitre);
        map.put("desc", mMessage);
        map.put("btn1", mBouton1);
        map.put("btn2", mBouton2);
        list.add(map);
        SimpleAdapter adapter = new SimpleAdapter(mActivity,list, R.layout.bottom_sheet_dialog_reponse,
                new String[]{"titre", "desc","btn1","btn2"},
                new int[]{R.id.info_title, R.id.info_desc, R.id.button_close, R.id.button_ok}){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View v = super.getView(position, convertView, parent);
                Button b1 = v.findViewById(R.id.button_close);
                Button b2 = v.findViewById(R.id.button_ok);
                b1.setText(mBouton1);
                b2.setText(mBouton2);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        dialog.dismiss();
                        reponse = false;
                    }
                });
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        dialog.dismiss();
                        reponse = true;
                    }
                });
                return v;
            }
        };
        if (listView != null) {
            listView.setAdapter(adapter);
            dialog.show();
        }
        return reponse;
    }

    public static BottomSheetListView list(final View myView, final List<Map<String, Object>> list, Activity mActivity){
        try {
            final BottomSheetDialog dialog = new BottomSheetDialog(mActivity);
            dialog.setContentView(R.layout.bottom_sheet_list_view);

            BottomSheetListView listView = dialog.findViewById(R.id.BottomSheet_listView);
            SimpleAdapter adapter = new SimpleAdapter(mActivity,list, R.layout.bottom_sheet_text_icon,
                    new String[]{"titre", "logo"},
                    new int[]{R.id.list_titre, R.id.list_logo});
            if (listView != null) {
                listView.setAdapter(adapter);
            }
            myView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.show();
                }
            });
            return listView;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static BottomSheetListView icon(final View myView, final List<Map<String, Object>> list, Activity mActivity){
        try {
            final BottomSheetDialog dialog = new BottomSheetDialog(mActivity);
            dialog.setContentView(R.layout.bottom_sheet_list_view);
            BottomSheetListView listView = dialog.findViewById(R.id.BottomSheet_listView);
            SimpleAdapter adapter = new SimpleAdapter(mActivity, list, R.layout.bottom_sheet_icon,
                    new String[]{"texte1", "logo1", "texte2", "logo2", "texte3", "logo3"},
                    new int[]{R.id.list_titre1, R.id.list_logo1, R.id.list_titre2, R.id.list_logo2, R.id.list_titre3, R.id.list_logo3}){
                @Override
                public View getView(int position, View convertView, ViewGroup parent){
                    View v = super.getView(position, convertView, parent);
                    ImageView i1 = v.findViewById(R.id.list_logo1);
                    ImageView i2 = v.findViewById(R.id.list_logo2);
                    ImageView i3 = v.findViewById(R.id.list_logo3);
                    i1.setClickable(true);
                    i2.setClickable(true);
                    i3.setClickable(true);
                    i1.setFocusable(true);
                    i2.setFocusable(true);
                    i3.setFocusable(true);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        i1.setForeground(new ColorDrawable(R.attr.selectableItemBackground));
                        i2.setForeground(new ColorDrawable(R.attr.selectableItemBackground));
                        i3.setForeground(new ColorDrawable(R.attr.selectableItemBackground));
                    }
                    return v;
                }
            };
            if (listView != null) {
                listView.setAdapter(adapter);
                listView.setClickable(false);
                listView.setFocusable(false);
            }
            myView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.show();
                }
            });
            return listView;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }


}
