package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.app.Activity;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import com.princeodzalasapp.fr.wmandroidui.BottomSheet.BottomSheetListView;
import com.princeodzalasapp.fr.wmandroidui.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErreurJava {

    public static void set(Activity mActivity, String mMessage){
        final BottomSheetDialog dialog = new BottomSheetDialog(mActivity);
        dialog.setContentView(R.layout.bottom_sheet_list_view);
        BottomSheetListView listView = dialog.findViewById(R.id.BottomSheet_listView);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("titre", "WM Design Erreur JAVA !");
        map.put("desc", mMessage);
        list.add(map);
        SimpleAdapter adapter = new SimpleAdapter(mActivity,list, R.layout.bottom_sheet_dialog_info,
                new String[]{"titre", "desc"},
                new int[]{R.id.info_title, R.id.info_desc});
        if (listView != null) {
            listView.setAdapter(adapter);
            dialog.show();
        }
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View container, int position, long id) {
                LinearLayout linearLayoutParent = (LinearLayout) container;
                Button btn = linearLayoutParent.findViewById(R.id.button_fermer);
                btn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        dialog.cancel();
                    }
                });
            }
        };
        listView.setOnItemClickListener(itemClickListener);
    }


    //@BindView(R.id.logo)ImageView imgLogo;
    //@BindViews({R.id.lbl_name, R.id.lbl_email, R.id.lbl_address})List<TextView> lblArray;
    //@BindDrawable(R.mipmap.ic_launcher)Drawable drawableLogo;
    //@BindString(R.string.app_name)String appName;
    //@BindColor(R.color.colorPrimaryDark)int colorTitle;
    //@BindDimen(R.id.padding_hori)float paddingHorizontal;
    //@BindAnim(R.anim.move_up)Animation animMoveUp;
    //@BindBitmap(R.mipmap.ic_launcher)Bitmap logo;
    //@BindViews({R.id.lbl_name, R.id.lbl_email, R.id.lbl_address})List<TextView> lblArray;
    //@BindFloat(R.dimen.radius)float radius;
    //@BindInt(R.integer.distance)int distance;



}
