package com.princeodzalasapp.fr.wmandroidui.TabLayout;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.princeodzalasapp.fr.wmandroidui.R;
import com.princeodzalasapp.fr.wmandroidui.Utiles.ErreurJava;

import static com.princeodzalasapp.fr.wmandroidui.Image.Images.setIconeColor;
import static com.princeodzalasapp.fr.wmandroidui.Image.Images.setIconeImageColor;
import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

public class TabLayout {

    public static ViewGroup iconD(int idParent,final String[] mIcons, final String[] mColor, Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            CardView fen = (CardView) inflater.inflate(R.layout.tab_layout_icon2,null);
            CardView mCardView1 = fen.findViewById(R.id.card1);
            CardView mCardView2 = fen.findViewById(R.id.card2);
            final ImageView TabMenu_logo1 = fen.findViewById(R.id.Logo1);
            final ImageView TabMenu_logo2 = fen.findViewById(R.id.Logo2);
            setIconeImageColor(TabMenu_logo1, mIcons[0], mColor[1], getAppContext(mActivity));
            setIconeImageColor(TabMenu_logo2, mIcons[1], mColor[0], getAppContext(mActivity));
            mCardView1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo2,mColor[0]);
                    setIconeColor(TabMenu_logo1,mColor[1]);
                }
            });
            mCardView2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo1, mColor[0]);
                    setIconeColor(TabMenu_logo2, mColor[1]);
                }
            });
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(fen);
            }
            return parent;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static void TabScrollD(ViewGroup fen, int onglet, final String[] mColor){
        final ImageView TabMenu_logo1 = fen.findViewById(R.id.Logo1);
        final ImageView TabMenu_logo2 = fen.findViewById(R.id.Logo2);
        switch(onglet){
            case 1 :
                setIconeColor(TabMenu_logo2,mColor[0]);
                setIconeColor(TabMenu_logo1,mColor[1]);
                break;
            case 2 :
                setIconeColor(TabMenu_logo1, mColor[0]);
                setIconeColor(TabMenu_logo2, mColor[1]);
                break;
            default : break;
        }
    }

    public static ViewGroup iconT(int idParent,final String[] mIcons, final String[] mColor, Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            CardView fen = (CardView) inflater.inflate(R.layout.tab_layout_icon3,null);
            CardView mCardView1 = fen.findViewById(R.id.card1);
            CardView mCardView2 = fen.findViewById(R.id.card2);
            CardView mCardView3 = fen.findViewById(R.id.card3);
            final ImageView TabMenu_logo1 = fen.findViewById(R.id.Logo1);
            final ImageView TabMenu_logo2 = fen.findViewById(R.id.Logo2);
            final ImageView TabMenu_logo3 = fen.findViewById(R.id.Logo3);
            setIconeImageColor(TabMenu_logo1, mIcons[0], mColor[1], getAppContext(mActivity));
            setIconeImageColor(TabMenu_logo2, mIcons[1], mColor[0], getAppContext(mActivity));
            setIconeImageColor(TabMenu_logo3, mIcons[2], mColor[0], getAppContext(mActivity));
            mCardView1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo2,mColor[0]);
                    setIconeColor(TabMenu_logo3,mColor[0]);
                    setIconeColor(TabMenu_logo1,mColor[1]);
                }
            });
            mCardView2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo1, mColor[0]);
                    setIconeColor(TabMenu_logo3, mColor[0]);
                    setIconeColor(TabMenu_logo2, mColor[1]);
                }
            });
            mCardView3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo1, mColor[0]);
                    setIconeColor(TabMenu_logo2, mColor[0]);
                    setIconeColor(TabMenu_logo3, mColor[1]);
                }
            });
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(fen);
            }
            return parent;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static void TabScrollT(ViewGroup fen, int onglet, final String[] mColor){
        final ImageView TabMenu_logo1 = fen.findViewById(R.id.Logo1);
        final ImageView TabMenu_logo2 = fen.findViewById(R.id.Logo2);
        final ImageView TabMenu_logo3 = fen.findViewById(R.id.Logo3);
        switch(onglet){
            case 1 :
                setIconeColor(TabMenu_logo2,mColor[0]);
                setIconeColor(TabMenu_logo3,mColor[0]);
                setIconeColor(TabMenu_logo1,mColor[1]);
                break;
            case 2 :
                setIconeColor(TabMenu_logo1, mColor[0]);
                setIconeColor(TabMenu_logo3, mColor[0]);
                setIconeColor(TabMenu_logo2, mColor[1]);
                break;
            case 3 :
                setIconeColor(TabMenu_logo1, mColor[0]);
                setIconeColor(TabMenu_logo2, mColor[0]);
                setIconeColor(TabMenu_logo3, mColor[1]);
                break;
            default : break;
        }
    }

    public static ViewGroup iconQ(int idParent,final String[] mIcons, final String[] mColor, Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            CardView fen = (CardView) inflater.inflate(R.layout.tab_layout_icon4,null);
            CardView mCardView1 = fen.findViewById(R.id.card1);
            CardView mCardView2 = fen.findViewById(R.id.card2);
            CardView mCardView3 = fen.findViewById(R.id.card3);
            CardView mCardView4 = fen.findViewById(R.id.card4);
            final ImageView TabMenu_logo1 = fen.findViewById(R.id.Logo1);
            final ImageView TabMenu_logo2 = fen.findViewById(R.id.Logo2);
            final ImageView TabMenu_logo3 = fen.findViewById(R.id.Logo3);
            final ImageView TabMenu_logo4 = fen.findViewById(R.id.Logo4);
            setIconeImageColor(TabMenu_logo1, mIcons[0], mColor[1], getAppContext(mActivity));
            setIconeImageColor(TabMenu_logo2, mIcons[1], mColor[0], getAppContext(mActivity));
            setIconeImageColor(TabMenu_logo3, mIcons[2], mColor[0], getAppContext(mActivity));
            setIconeImageColor(TabMenu_logo4, mIcons[3], mColor[0], getAppContext(mActivity));
            mCardView1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo2,mColor[0]);
                    setIconeColor(TabMenu_logo3,mColor[0]);
                    setIconeColor(TabMenu_logo4,mColor[0]);
                    setIconeColor(TabMenu_logo1,mColor[1]);
                }
            });
            mCardView2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo1, mColor[0]);
                    setIconeColor(TabMenu_logo3, mColor[0]);
                    setIconeColor(TabMenu_logo4, mColor[0]);
                    setIconeColor(TabMenu_logo2, mColor[1]);
                }
            });
            mCardView3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo1, mColor[0]);
                    setIconeColor(TabMenu_logo2, mColor[0]);
                    setIconeColor(TabMenu_logo4, mColor[0]);
                    setIconeColor(TabMenu_logo3, mColor[1]);
                }
            });
            mCardView4.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo1, mColor[0]);
                    setIconeColor(TabMenu_logo3, mColor[0]);
                    setIconeColor(TabMenu_logo2, mColor[0]);
                    setIconeColor(TabMenu_logo4, mColor[1]);
                }
            });
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(fen);
            }
            return parent;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static void TabScrollQ(ViewGroup fen, int onglet, final String[] mColor){
        final ImageView TabMenu_logo1 = fen.findViewById(R.id.Logo1);
        final ImageView TabMenu_logo2 = fen.findViewById(R.id.Logo2);
        final ImageView TabMenu_logo3 = fen.findViewById(R.id.Logo3);
        final ImageView TabMenu_logo4 = fen.findViewById(R.id.Logo4);
        switch(onglet){
            case 1 :
                setIconeColor(TabMenu_logo2,mColor[0]);
                setIconeColor(TabMenu_logo3,mColor[0]);
                setIconeColor(TabMenu_logo4,mColor[0]);
                setIconeColor(TabMenu_logo1,mColor[1]);
                break;
            case 2 :
                setIconeColor(TabMenu_logo1, mColor[0]);
                setIconeColor(TabMenu_logo3, mColor[0]);
                setIconeColor(TabMenu_logo4, mColor[0]);
                setIconeColor(TabMenu_logo2, mColor[1]);
                break;
            case 3 :
                setIconeColor(TabMenu_logo1, mColor[0]);
                setIconeColor(TabMenu_logo2, mColor[0]);
                setIconeColor(TabMenu_logo4, mColor[0]);
                setIconeColor(TabMenu_logo3, mColor[1]);
                break;
            case 4 :
                setIconeColor(TabMenu_logo1,  mColor[0]);
                setIconeColor(TabMenu_logo3,  mColor[0]);
                setIconeColor(TabMenu_logo2,  mColor[0]);
                setIconeColor(TabMenu_logo4, mColor[1]);
                break;
            default : break;
        }
    }

    public static ViewGroup iconC(int idParent,final String[] mIcons, final String[] mColor, Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            CardView fen = (CardView) inflater.inflate(R.layout.tab_layout_icon5,null);
            CardView mCardView1 = fen.findViewById(R.id.card1);
            CardView mCardView2 = fen.findViewById(R.id.card2);
            CardView mCardView3 = fen.findViewById(R.id.card3);
            CardView mCardView4 = fen.findViewById(R.id.card4);
            CardView mCardView5 = fen.findViewById(R.id.card5);
            final ImageView TabMenu_logo1 = fen.findViewById(R.id.Logo1);
            final ImageView TabMenu_logo2 = fen.findViewById(R.id.Logo2);
            final ImageView TabMenu_logo3 = fen.findViewById(R.id.Logo3);
            final ImageView TabMenu_logo4 = fen.findViewById(R.id.Logo4);
            final ImageView TabMenu_logo5 = fen.findViewById(R.id.Logo5);
            setIconeImageColor(TabMenu_logo1, mIcons[0], mColor[1], getAppContext(mActivity));
            setIconeImageColor(TabMenu_logo2, mIcons[1], mColor[0], getAppContext(mActivity));
            setIconeImageColor(TabMenu_logo3, mIcons[2], mColor[0], getAppContext(mActivity));
            setIconeImageColor(TabMenu_logo4, mIcons[3], mColor[0], getAppContext(mActivity));
            setIconeImageColor(TabMenu_logo5, mIcons[4], mColor[0], getAppContext(mActivity));
            mCardView1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo2,mColor[0]);
                    setIconeColor(TabMenu_logo3,mColor[0]);
                    setIconeColor(TabMenu_logo4,mColor[0]);
                    setIconeColor(TabMenu_logo5,mColor[0]);
                    setIconeColor(TabMenu_logo1,mColor[1]);
                }
            });
            mCardView2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo1, mColor[0]);
                    setIconeColor(TabMenu_logo3, mColor[0]);
                    setIconeColor(TabMenu_logo4, mColor[0]);
                    setIconeColor(TabMenu_logo5, mColor[0]);
                    setIconeColor(TabMenu_logo2, mColor[1]);
                }
            });
            mCardView3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo1, mColor[0]);
                    setIconeColor(TabMenu_logo2, mColor[0]);
                    setIconeColor(TabMenu_logo4, mColor[0]);
                    setIconeColor(TabMenu_logo5, mColor[0]);
                    setIconeColor(TabMenu_logo3, mColor[1]);
                }
            });
            mCardView4.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo1, mColor[0]);
                    setIconeColor(TabMenu_logo3, mColor[0]);
                    setIconeColor(TabMenu_logo2, mColor[0]);
                    setIconeColor(TabMenu_logo5, mColor[0]);
                    setIconeColor(TabMenu_logo4, mColor[1]);
                }
            });
            mCardView5.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo1, mColor[0]);
                    setIconeColor(TabMenu_logo3, mColor[0]);
                    setIconeColor(TabMenu_logo4, mColor[0]);
                    setIconeColor(TabMenu_logo2, mColor[0]);
                    setIconeColor(TabMenu_logo5, mColor[1]);
                }
            });
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(fen);
            }
            return parent;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static void TabScrollC(ViewGroup fen, int onglet, final String[] mColor){
        final ImageView TabMenu_logo1 = fen.findViewById(R.id.Logo1);
        final ImageView TabMenu_logo2 = fen.findViewById(R.id.Logo2);
        final ImageView TabMenu_logo3 = fen.findViewById(R.id.Logo3);
        final ImageView TabMenu_logo4 = fen.findViewById(R.id.Logo4);
        final ImageView TabMenu_logo5 = fen.findViewById(R.id.Logo5);
        switch(onglet){
            case 1 :
                setIconeColor(TabMenu_logo2,mColor[0]);
                setIconeColor(TabMenu_logo3,mColor[0]);
                setIconeColor(TabMenu_logo4,mColor[0]);
                setIconeColor(TabMenu_logo5,mColor[0]);
                setIconeColor(TabMenu_logo1,mColor[1]);
                break;
            case 2 :
                setIconeColor(TabMenu_logo1, mColor[0]);
                setIconeColor(TabMenu_logo3, mColor[0]);
                setIconeColor(TabMenu_logo4, mColor[0]);
                setIconeColor(TabMenu_logo5, mColor[0]);
                setIconeColor(TabMenu_logo2, mColor[1]);
                break;
            case 3 :
                setIconeColor(TabMenu_logo1, mColor[0]);
                setIconeColor(TabMenu_logo2, mColor[0]);
                setIconeColor(TabMenu_logo4, mColor[0]);
                setIconeColor(TabMenu_logo5, mColor[0]);
                setIconeColor(TabMenu_logo3, mColor[1]);
                break;
            case 4 :
                setIconeColor(TabMenu_logo1,  mColor[0]);
                setIconeColor(TabMenu_logo3,  mColor[0]);
                setIconeColor(TabMenu_logo2,  mColor[0]);
                setIconeColor(TabMenu_logo5,  mColor[0]);
                setIconeColor(TabMenu_logo4, mColor[1]);
                break;
            case 5 :
                setIconeColor(TabMenu_logo1, mColor[0]);
                setIconeColor(TabMenu_logo3, mColor[0]);
                setIconeColor(TabMenu_logo4, mColor[0]);
                setIconeColor(TabMenu_logo2, mColor[0]);
                setIconeColor(TabMenu_logo5, mColor[1]);
                break;
            default : break;
        }
    }

    public static ViewGroup iconS(int idParent,final String[] mIcons, final String[] mColor, Activity mActivity){
        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            CardView fen = (CardView) inflater.inflate(R.layout.tab_layout_icon6,null);
            CardView mCardView1 = fen.findViewById(R.id.card1);
            CardView mCardView2 = fen.findViewById(R.id.card2);
            CardView mCardView3 = fen.findViewById(R.id.card3);
            CardView mCardView4 = fen.findViewById(R.id.card4);
            CardView mCardView5 = fen.findViewById(R.id.card5);
            CardView mCardView6 = fen.findViewById(R.id.card6);
            final ImageView TabMenu_logo1 = fen.findViewById(R.id.Logo1);
            final ImageView TabMenu_logo2 = fen.findViewById(R.id.Logo2);
            final ImageView TabMenu_logo3 = fen.findViewById(R.id.Logo3);
            final ImageView TabMenu_logo4 = fen.findViewById(R.id.Logo4);
            final ImageView TabMenu_logo5 = fen.findViewById(R.id.Logo5);
            final ImageView TabMenu_logo6 = fen.findViewById(R.id.Logo6);
            setIconeImageColor(TabMenu_logo1, mIcons[0], mColor[1], getAppContext(mActivity));
            setIconeImageColor(TabMenu_logo2, mIcons[1], mColor[0], getAppContext(mActivity));
            setIconeImageColor(TabMenu_logo3, mIcons[2], mColor[0], getAppContext(mActivity));
            setIconeImageColor(TabMenu_logo4, mIcons[3], mColor[0], getAppContext(mActivity));
            setIconeImageColor(TabMenu_logo5, mIcons[4], mColor[0], getAppContext(mActivity));
            setIconeImageColor(TabMenu_logo6, mIcons[5], mColor[0], getAppContext(mActivity));
            mCardView1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo2,mColor[0]);
                    setIconeColor(TabMenu_logo3,mColor[0]);
                    setIconeColor(TabMenu_logo4,mColor[0]);
                    setIconeColor(TabMenu_logo5,mColor[0]);
                    setIconeColor(TabMenu_logo6,mColor[0]);
                    setIconeColor(TabMenu_logo1,mColor[1]);
                }
            });
            mCardView2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo1, mColor[0]);
                    setIconeColor(TabMenu_logo3, mColor[0]);
                    setIconeColor(TabMenu_logo4, mColor[0]);
                    setIconeColor(TabMenu_logo5, mColor[0]);
                    setIconeColor(TabMenu_logo6, mColor[0]);
                    setIconeColor(TabMenu_logo2, mColor[1]);
                }
            });
            mCardView3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo1, mColor[0]);
                    setIconeColor(TabMenu_logo2, mColor[0]);
                    setIconeColor(TabMenu_logo4, mColor[0]);
                    setIconeColor(TabMenu_logo5, mColor[0]);
                    setIconeColor(TabMenu_logo6, mColor[0]);
                    setIconeColor(TabMenu_logo3, mColor[1]);
                }
            });
            mCardView4.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo1, mColor[0]);
                    setIconeColor(TabMenu_logo3, mColor[0]);
                    setIconeColor(TabMenu_logo2, mColor[0]);
                    setIconeColor(TabMenu_logo5, mColor[0]);
                    setIconeColor(TabMenu_logo6, mColor[0]);
                    setIconeColor(TabMenu_logo4, mColor[1]);
                }
            });
            mCardView5.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo1, mColor[0]);
                    setIconeColor(TabMenu_logo3, mColor[0]);
                    setIconeColor(TabMenu_logo4, mColor[0]);
                    setIconeColor(TabMenu_logo2, mColor[0]);
                    setIconeColor(TabMenu_logo6, mColor[0]);
                    setIconeColor(TabMenu_logo5, mColor[1]);
                }
            });
            mCardView6.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setIconeColor(TabMenu_logo1, mColor[0]);
                    setIconeColor(TabMenu_logo3, mColor[0]);
                    setIconeColor(TabMenu_logo4, mColor[0]);
                    setIconeColor(TabMenu_logo5, mColor[0]);
                    setIconeColor(TabMenu_logo2, mColor[0]);
                    setIconeColor(TabMenu_logo6, mColor[1]);
                }
            });
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(fen);
            }
            return parent;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static void TabScrollS(ViewGroup fen, int onglet, final String[] mColor){
        final ImageView TabMenu_logo1 = fen.findViewById(R.id.Logo1);
        final ImageView TabMenu_logo2 = fen.findViewById(R.id.Logo2);
        final ImageView TabMenu_logo3 = fen.findViewById(R.id.Logo3);
        final ImageView TabMenu_logo4 = fen.findViewById(R.id.Logo4);
        final ImageView TabMenu_logo5 = fen.findViewById(R.id.Logo5);
        final ImageView TabMenu_logo6 = fen.findViewById(R.id.Logo6);
        switch(onglet){
            case 1 :
                setIconeColor(TabMenu_logo2,mColor[0]);
                setIconeColor(TabMenu_logo3,mColor[0]);
                setIconeColor(TabMenu_logo4,mColor[0]);
                setIconeColor(TabMenu_logo5,mColor[0]);
                setIconeColor(TabMenu_logo6,mColor[0]);
                setIconeColor(TabMenu_logo1,mColor[1]);
                break;
            case 2 :
                setIconeColor(TabMenu_logo1, mColor[0]);
                setIconeColor(TabMenu_logo3, mColor[0]);
                setIconeColor(TabMenu_logo4, mColor[0]);
                setIconeColor(TabMenu_logo5, mColor[0]);
                setIconeColor(TabMenu_logo6, mColor[0]);
                setIconeColor(TabMenu_logo2, mColor[1]);
                break;
            case 3 :
                setIconeColor(TabMenu_logo1, mColor[0]);
                setIconeColor(TabMenu_logo2, mColor[0]);
                setIconeColor(TabMenu_logo4, mColor[0]);
                setIconeColor(TabMenu_logo5, mColor[0]);
                setIconeColor(TabMenu_logo6, mColor[0]);
                setIconeColor(TabMenu_logo3, mColor[1]);
                break;
            case 4 :
                setIconeColor(TabMenu_logo1,  mColor[0]);
                setIconeColor(TabMenu_logo3,  mColor[0]);
                setIconeColor(TabMenu_logo2,  mColor[0]);
                setIconeColor(TabMenu_logo5,  mColor[0]);
                setIconeColor(TabMenu_logo6,  mColor[0]);
                setIconeColor(TabMenu_logo4, mColor[1]);
                break;
            case 5 :
                setIconeColor(TabMenu_logo1, mColor[0]);
                setIconeColor(TabMenu_logo3, mColor[0]);
                setIconeColor(TabMenu_logo4, mColor[0]);
                setIconeColor(TabMenu_logo2, mColor[0]);
                setIconeColor(TabMenu_logo6, mColor[0]);
                setIconeColor(TabMenu_logo5, mColor[1]);
                break;
            case 6 :
                setIconeColor(TabMenu_logo1, mColor[0]);
                setIconeColor(TabMenu_logo3, mColor[0]);
                setIconeColor(TabMenu_logo4, mColor[0]);
                setIconeColor(TabMenu_logo5, mColor[0]);
                setIconeColor(TabMenu_logo2, mColor[0]);
                setIconeColor(TabMenu_logo6, mColor[1]);
                break;
            default : break;
        }
    }


}
