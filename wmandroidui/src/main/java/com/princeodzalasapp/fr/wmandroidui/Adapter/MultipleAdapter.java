package com.princeodzalasapp.fr.wmandroidui.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mikepenz.iconics.IconicsDrawable;
import com.princeodzalasapp.fr.wmandroidui.R;
import com.princeodzalasapp.fr.wmandroidui.Utiles.Images;

import java.util.ArrayList;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Systeme.getDateYoutube;

public class MultipleAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {

    private Context mContext;

    public MultipleAdapter(Context context, ArrayList<MultipleItem> data) {
        super(data);
        addItemType(MultipleItem.LISTE_NORMAL, R.layout.card_liste );
        addItemType(MultipleItem.LISTE_NORMAL_ICON, R.layout.card_liste_icon );
        addItemType(MultipleItem.LISTE_NORMAL_IMAGE, R.layout.card_liste_url );
        addItemType(MultipleItem.LIST_ACTUS, R.layout.card_actus );
        addItemType(MultipleItem.LIST_VIDEO, R.layout.card_video );
        addItemType(MultipleItem.PUB_HAUT, R.layout.pub_natif_haut );
        addItemType(MultipleItem.PUB_BAS, R.layout.pub_natif_bas );
        addItemType(MultipleItem.PUB_MILIEU, R.layout.pub_natif );
        addItemType(MultipleItem.LIST_ESPACE, R.layout.espace );
        addItemType(MultipleItem.TEXT_NORMAL, R.layout.text_item );
        addItemType(MultipleItem.TEXT_NORMAL_BLANC, R.layout.text_item_blanc );
        addItemType(MultipleItem.TEXT_IMAGE, R.layout.text_image );
        addItemType(MultipleItem.TEXT_IMAGE_BLANC, R.layout.text_image_blanc );
        addItemType(MultipleItem.TEXT_ICON, R.layout.text_icon );
        addItemType(MultipleItem.TEXT_ICON_BLANC, R.layout.text_icon_blanc );
        addItemType(MultipleItem.CARD_RECYCLER, R.layout.card_recycler );
        addItemType(MultipleItem.CARD_IMAGE, R.layout.card_image );
        addItemType(MultipleItem.CARD_IMAGE_TITRE, R.layout.card_image_titre );
        addItemType(MultipleItem.LIGNE_100, R.layout.ligne100 );
        addItemType(MultipleItem.LIGNE_85, R.layout.ligne85 );
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.LISTE_NORMAL:
                TextView nom = helper.getView(R.id.list_titre);
                nom.setText(item.getListe().getNom());
                if (item.getListe().getColor() != null ) nom.setTextColor(Color.parseColor(item.getListe().getColor()));
                break;
            case MultipleItem.LISTE_NORMAL_ICON:
                TextView nom1 = helper.getView(R.id.list_titre);
                ImageView imageUrl1 = helper.getView(R.id.list_logo);
                nom1.setText(item.getListeIcon().getNom());
                Images.setIcon(imageUrl1,item.getListeIcon().getImageUrl(), mContext);
                if (item.getListeIcon().getColor() != null ) nom1.setTextColor(Color.parseColor(item.getListeIcon().getColor()));
                if (item.getListeIcon().getColorIcon() != null ) Images.setIconeColor(imageUrl1, item.getListeIcon().getColorIcon());
                break;
            case MultipleItem.LISTE_NORMAL_IMAGE:
                TextView nom2 = helper.getView(R.id.list_titre);
                ImageView imageUrl2 = helper.getView(R.id.list_logo);
                nom2.setText(item.getListeUrl().getNom());
                Glide.with(mContext).load(item.getListeUrl().getImageUrl()).into(imageUrl2);
                if (item.getListeUrl().getColor() != null ) nom2.setTextColor(Color.parseColor(item.getListeUrl().getColor()));
                break;
            case MultipleItem.LIST_ACTUS:
                TextView tnom = helper.getView(R.id.nom);
                TextView tequipe = helper.getView(R.id.ville);
                TextView tdescrip = helper.getView(R.id.description);
                TextView tjaime = helper.getView(R.id.like);
                TextView tcomment = helper.getView(R.id.cmt);
                TextView tdateheure = helper.getView(R.id.date);

                ImageView iprofil = helper.getView(R.id.profilphoto);
                ImageView iimageUrl = helper.getView(R.id.image);
                ImageView iimageLike = helper.getView(R.id.image_like);
                ImageView iimageCmt = helper.getView(R.id.image_cmt);

                Drawable mImage1 =  new IconicsDrawable(mContext,"faw_heart");
                iimageLike.setImageDrawable(mImage1);
                Drawable mImage2 =  new IconicsDrawable(mContext,"faw_comment");
                iimageCmt.setImageDrawable(mImage2);

                LinearLayout jaim = helper.getView(R.id.jaime);
                LinearLayout cmt = helper.getView(R.id.comment);
                CardView fond = helper.getView(R.id.card_actus);

                tnom.setText(item.getActus().getNom());
                tequipe.setText(item.getActus().getClub());
                tdescrip.setText(item.getActus().getDesciption());
                tdateheure.setText(item.getActus().getDate());
                String like = String.valueOf(item.getActus().getLike()) +" J'aime";
                String cmte = String.valueOf(item.getActus().getComment()) +" Commenter";

                tjaime.setText(like);
                tcomment.setText(cmte);

                if ( item.getActus().getMoilike() == 1 ) {
                    Drawable mImag =  new IconicsDrawable(mContext,"faw_heart1");
                    iimageLike.setImageDrawable(mImag);
                }

                Glide.with(mContext).load(item.getActus().getPhotoUrl()).apply(new RequestOptions().centerCrop()).into(iprofil);
                Glide.with(mContext).load(item.getActus().getImageUrl()).apply(new RequestOptions().centerCrop()).into(iimageUrl);
                break;
            case MultipleItem.LIST_VIDEO:
                TextView nnom = helper.getView(R.id.video_titre);
                ImageView nimageUrl = helper.getView(R.id.video_image);
                TextView data = helper.getView(R.id.video_date);
                nnom.setText(item.getVideo().getNom());
                data.setText(getDateYoutube(item.getVideo().getDate()));
                Glide.with(mContext).load(item.getVideo().getImageUrl()).apply(new RequestOptions().fitCenter()).into(nimageUrl);
                break;
            case MultipleItem.TEXT_NORMAL:
                TextView snom = helper.getView(R.id.list_titre);
                snom.setText(item.getListe().getNom());
                if (item.getListe().getColor() != null ) snom.setTextColor(Color.parseColor(item.getListe().getColor()));
                break;
            case MultipleItem.TEXT_NORMAL_BLANC:
                TextView snom1 = helper.getView(R.id.list_titre);
                snom1.setText(item.getListe().getNom());
                if (item.getListe().getColor() != null ) snom1.setTextColor(Color.parseColor(item.getListe().getColor()));
                break;
            case MultipleItem.TEXT_IMAGE:
                TextView snom2 = helper.getView(R.id.list_titre);
                ImageView simageUrl2 = helper.getView(R.id.list_logo);
                snom2.setText(item.getListeUrl().getNom());
                Glide.with(mContext).load(item.getListeUrl().getImageUrl()).into(simageUrl2);
                if (item.getListeUrl().getColor() != null ) snom2.setTextColor(Color.parseColor(item.getListeUrl().getColor()));
                break;
            case MultipleItem.TEXT_IMAGE_BLANC:
                TextView snom3 = helper.getView(R.id.list_titre);
                ImageView simageUrl3 = helper.getView(R.id.list_logo);
                snom3.setText(item.getListeUrl().getNom());
                Glide.with(mContext).load(item.getListeUrl().getImageUrl()).into(simageUrl3);
                if (item.getListeUrl().getColor() != null ) snom3.setTextColor(Color.parseColor(item.getListeUrl().getColor()));
                break;
            case MultipleItem.CARD_IMAGE:
                ImageView simage = helper.getView(R.id.video_image);
                Glide.with(mContext).load(item.getListe().getNom()).apply(new RequestOptions().fitCenter()).into(simage);
                break;
            case MultipleItem.CARD_IMAGE_TITRE:
                TextView snom4 = helper.getView(R.id.list_titre);
                ImageView simageUrl4 = helper.getView(R.id.list_logo);
                snom4.setText(item.getListeUrl().getNom());
                Glide.with(mContext).load(item.getListeUrl().getImageUrl()).into(simageUrl4);
                if (item.getListeUrl().getColor() != null ) snom4.setTextColor(Color.parseColor(item.getListeUrl().getColor()));
                break;
            case MultipleItem.TEXT_ICON:
                TextView snom5 = helper.getView(R.id.list_titre);
                ImageView simageUrl5 = helper.getView(R.id.list_logo);
                snom5.setText(item.getListeUrl().getNom());
                Glide.with(mContext).load(item.getListeUrl().getImageUrl()).into(simageUrl5);
                if (item.getListeUrl().getColor() != null ) snom5.setTextColor(Color.parseColor(item.getListeUrl().getColor()));
                break;
            case MultipleItem.TEXT_ICON_BLANC:
                TextView snom6 = helper.getView(R.id.list_titre);
                ImageView simageUrl6 = helper.getView(R.id.list_logo);
                snom6.setText(item.getListeUrl().getNom());
                Glide.with(mContext).load(item.getListeUrl().getImageUrl()).into(simageUrl6);
                if (item.getListeUrl().getColor() != null ) snom6.setTextColor(Color.parseColor(item.getListeUrl().getColor()));
                break;
            case MultipleItem.PUB_HAUT:
                break;
            case MultipleItem.PUB_BAS:
                break;
            case MultipleItem.PUB_MILIEU:
                break;
            case MultipleItem.LIST_ESPACE:
                break;
            case MultipleItem.LIGNE_100:
                break;
            case MultipleItem.LIGNE_85:
                break;
        }
    }


}
