package com.princeodzalasapp.fr.wmandroidui.Picker;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import com.princeodzalasapp.fr.wmandroidui.Utiles.ErreurJava;

import java.util.Calendar;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

public class Picker {

    public static TimePicker Time(final int idParent, Activity mActivity){
        TimePicker mtime = new TimePicker(getAppContext(mActivity));
        try {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, Gravity.CENTER);
            mtime.setLayoutParams(lp);
            ViewGroup parent = (ViewGroup)mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(mtime);
            }
            return mtime;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return mtime;
        }
    }

    public static DatePicker Date(final int idParent, Activity mActivity){
        DatePicker mDate = new DatePicker(getAppContext(mActivity));
        try {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, Gravity.CENTER);
            mDate.setLayoutParams(lp);
            int headerId = getAppContext(mActivity).getResources().getIdentifier("day_picker_selector_layout", "id", "android");
            final View header = mDate.findViewById(headerId);
            if (header != null) header.setBackgroundColor(Color.parseColor("#35be45"));
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(mDate);
            }
            return mDate;

        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return mDate;
        }
    }


}
