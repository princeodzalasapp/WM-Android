package com.princeodzalasapp.fr.wmandroidui.Image;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;
import com.princeodzalasapp.fr.wmandroidui.R;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

public class ExpandingView {

    public static ExpandingList mExpandingList;
    public static Activity mAct;

    public static void testAct(int idParent, Activity mAt){
        mAct = mAt;
        LayoutInflater inflater = mAt.getLayoutInflater();
        RelativeLayout fen = (RelativeLayout) inflater.inflate(R.layout.expanding_activity,null);
        mExpandingList = fen.findViewById(R.id.expanding_list_main);
        testItems();
        ViewGroup parent = mAt.findViewById(idParent);
        if(parent != null){
            parent.addView(fen);
        }
    }

    public static void testItems() {
        addItem("John", new String[]{"House", "Boat", "Candy", "Collection", "Sport", "Ball", "Head"}, R.color.couleur_rose400, R.drawable.ic_menu_24dp);
        addItem("Mary", new String[]{"Dog", "Horse", "Boat"}, R.color.blue, R.drawable.ic_add_attachment);
        addItem("Ana", new String[]{"Cat"}, R.color.colorAccent, R.drawable.fui_ic_anonymous_white_24dp);
        addItem("Peter", new String[]{"Parrot", "Elephant", "Coffee"}, R.color.couleur_ambre900, R.drawable.fui_ic_twitter_bird_white_24dp);
        addItem("Joseph", new String[]{}, R.color.couleur_orange500, R.drawable.fui_ic_facebook_white_22dp);
        addItem("Paul", new String[]{"Golf", "Football"}, R.color.couleur_vert500, R.drawable.fui_ic_googleg_color_24dp);
        addItem("Larry", new String[]{"Ferrari", "Mazda", "Honda", "Toyota", "Fiat"}, R.color.blue, R.drawable.fui_ic_github_white_24dp);
        addItem("Moe", new String[]{"Beans", "Rice", "Meat"}, R.color.couleur_jaune500, R.drawable.fui_ic_mail_white_24dp);
        addItem("Bart", new String[]{"Hamburger", "Ice cream", "Candy"}, R.color.couleur_violet500, R.drawable.fui_ic_phone_white_24dp);
    }

    public static void addItem(String title, String[] subItems, int colorRes, int iconRes) {
        final ExpandingItem item = mExpandingList.createNewItem(R.layout.expanding_layout);
        if (item != null) {
            item.setIndicatorColorRes(colorRes);
            item.setIndicatorIconRes(iconRes);
            ((TextView) item.findViewById(R.id.title)).setText(title);
            item.createSubItems(subItems.length);
            for (int i = 0; i < item.getSubItemsCount(); i++) {
                final View view = item.getSubItemView(i);
                configureSubItem(item, view, subItems[i]);
            }
            item.findViewById(R.id.add_more_sub_items).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showInsertDialog(new OnItemCreated() {
                        @Override
                        public void itemCreated(String title) {
                            View newSubItem = item.createSubItem();
                            configureSubItem(item, newSubItem, title);
                        }
                    });
                }
            });

            item.findViewById(R.id.remove_item).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mExpandingList.removeItem(item);
                }
            });
        }
    }

    public static void configureSubItem(final ExpandingItem item, final View view, String subTitle) {
        ((TextView) view.findViewById(R.id.sub_title)).setText(subTitle);
        view.findViewById(R.id.remove_sub_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.removeSubItem(view);
            }
        });
    }

    public static void showInsertDialog(final OnItemCreated positive) {
        final EditText text = new EditText(getAppContext(mAct));
        AlertDialog.Builder builder = new AlertDialog.Builder(getAppContext(mAct));
        builder.setView(text);
        builder.setTitle("WM Design");
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                positive.itemCreated(text.getText().toString());
            }
        });
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.show();
    }

    interface OnItemCreated {
        void itemCreated(String title);
    }

}
