package com.princeodzalasapp.fr.wmandroidui.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mikepenz.iconics.IconicsDrawable;
import com.princeodzalasapp.fr.wmandroidui.R;

import java.util.ArrayList;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Systeme.getDateYoutube;

public class MultipleAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {

    private Context mContext;

    public MultipleAdapter(Context context, ArrayList<MultipleItem> data) {
        super(data);
        addItemType(MultipleItem.LISTE_NORMAL, R.layout.card_liste );
        addItemType(MultipleItem.PUB_HAUT, R.layout.pub_natif_haut );
        addItemType(MultipleItem.PUB_BAS, R.layout.pub_natif_bas );
        addItemType(MultipleItem.PUB_MILIEU, R.layout.pub_natif );
        addItemType(MultipleItem.LIST_ESPACE, R.layout.espace );
        addItemType(MultipleItem.LIST_ACTUS, R.layout.card_actus );
        addItemType(MultipleItem.LIST_VIDEO, R.layout.card_video );
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.LISTE_NORMAL:
                TextView nom = helper.getView(R.id.list_titre);
                ImageView imageUrl = helper.getView(R.id.list_logo);
                nom.setText(item.getListe().getNom());
                Glide.with(mContext).load(item.getListe().getImageUrl()).into(imageUrl);
                break;
            case MultipleItem.PUB_HAUT:
                break;
            case MultipleItem.PUB_BAS:
                break;
            case MultipleItem.PUB_MILIEU:
                break;
            case MultipleItem.LIST_ESPACE:
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
        }
    }


}
