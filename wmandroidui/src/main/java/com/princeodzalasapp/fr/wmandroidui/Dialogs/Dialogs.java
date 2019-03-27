package com.princeodzalasapp.fr.wmandroidui.Dialogs;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.afollestad.materialdialogs.simplelist.MaterialSimpleListAdapter;
import com.afollestad.materialdialogs.simplelist.MaterialSimpleListItem;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.view.View;

import java.util.ArrayList;

public class Dialogs {

    public static String reponse = "";
    public static ArrayList<String> Listereponse = new ArrayList<String>();

    public static void Text(String mText, Activity mActivity){
        new MaterialDialog.Builder(mActivity)
                .content(mText).show();
    }
    public static void TextTitre(String mTitre, String mText, Activity mActivity){
        MaterialDialog.SingleButtonCallback singleButtonCallback ;
        new MaterialDialog.Builder(mActivity)
                .title(mTitre).content(mText).show();
    }
    public static void TextTitreUn(String mTitre, String mText, String mAction,Activity mActivity){
        new MaterialDialog.Builder(mActivity)
                .title(mTitre).content(mText).positiveText(mAction).show();
    }
    public static void TextTitreUnIcon(String mTitre, String mText, String mAction, Drawable mIcon, Activity mActivity){
        new MaterialDialog.Builder(mActivity)
                .title(mTitre).content(mText).positiveText(mAction).icon(mIcon).show();
    }
    public static void TextTitreDeux(String mTitre, String mText, String mAction1, String mAction2, Activity mActivity){
        new MaterialDialog.Builder(mActivity)
                .title(mTitre).content(mText).negativeText(mAction1).positiveText(mAction2).show();
    }
    public static void TextTitreDeuxIcon(String mTitre, String mText, String mAction1, String mAction2, Drawable mIcon, Activity mActivity){
        new MaterialDialog.Builder(mActivity)
                .title(mTitre).content(mText).negativeText(mAction1).positiveText(mAction2).icon(mIcon).show();
    }
    public static void ListeTitre(String mTitre, ArrayList<String> mText, Activity mActivity){
        new MaterialDialog.Builder(mActivity)
                .title(mTitre).items(mText).itemsCallback(new MaterialDialog.ListCallback() {
            @Override
            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                reponse = which+"|"+text;
            }
        }).show();
    }
    public static void ListeTitreUnChoix(String mTitre, ArrayList<String> mText, String mAction, Activity mActivity){
        new MaterialDialog.Builder(mActivity)
                .title(mTitre).items(mText).itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
            @Override
            public boolean  onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                reponse = which+"|"+text;
                return true;
            }
        }).positiveText(mAction).show();
    }
    public static void ListeTitreMultiChoix(String mTitre, ArrayList<String> mText, String mAction, Activity mActivity){
        new MaterialDialog.Builder(mActivity)
                .title(mTitre).items(mText).itemsCallbackMultiChoice(null, new MaterialDialog.ListCallbackMultiChoice() {
            @Override
            public boolean  onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                for ( int i = 0; i < which.length; i++){
                    Listereponse.add(which[i]+"|"+text[i]);
                }
                return true;
            }
        }).positiveText(mAction).show();
    }
    public static void ListeTitreId(String mTitre, ArrayList<String> mText,int[] mId, Activity mActivity){
        new MaterialDialog.Builder(mActivity)
                .title(mTitre).items(mText).itemsIds(mId).itemsCallback(new MaterialDialog.ListCallback() {
            @Override
            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                reponse = which+"|"+text+"|"+view.getId();
            }
        }).show();
    }
    public static void TitreInput(String mTitre, String mText,String mText1, String mText2, Activity mActivity){
        new MaterialDialog.Builder(mActivity)
                .title(mTitre).content(mText)
                .inputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)
                .input(mText1, mText2, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        reponse = ""+input;
                    }
                }).show();
    }
    public static void ListeProfil(String mTitre, String[] mText,Drawable[] mIcon, Activity mActivity){
        final MaterialSimpleListAdapter adapter = new MaterialSimpleListAdapter(new MaterialSimpleListAdapter.Callback() {
            @Override
            public void onMaterialListItemSelected(MaterialDialog dialog, int index, MaterialSimpleListItem item) {
                reponse = ""+index;
            }
        });
        for ( int i = 0; i < mText.length; i++){
            adapter.add(new MaterialSimpleListItem.Builder(mActivity)
                    .content(mText[i])
                    .icon(mIcon[i])
                    .backgroundColor(Color.WHITE)
                    .build());
        }
        new MaterialDialog.Builder(mActivity)
                .title(mTitre)
                .adapter(adapter, null)
                .show();
    }

    public void ChangeThemeLight( Activity mActivity){
        new MaterialDialog.Builder(mActivity)
                .title("Thème")
                .content("Light activé !")
                .theme(Theme.LIGHT)
                .show();
    }
    public void ChangeThemeDark( Activity mActivity){
        new MaterialDialog.Builder(mActivity)
                .title("Thème")
                .content("Dark activé !")
                .theme(Theme.DARK)
                .show();
    }

}
