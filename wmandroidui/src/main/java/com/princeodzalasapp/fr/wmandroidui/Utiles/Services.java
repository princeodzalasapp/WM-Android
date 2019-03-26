package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.princeodzalasapp.fr.wmandroidui.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

import android.content.res.TypedArray;
import android.graphics.Color;

import java.util.Random;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

public class Services {

    public static int DpToPx(int valeurDp, Context mContext){
        final float scale = mContext.getResources().getDisplayMetrics().density;
        final int dp = (int) ((valeurDp * scale) + 0.5f);
        return dp;
    }

    public static Context getAppContext(Activity mActivity){
        return mActivity.getApplicationContext();
    }

    @SuppressLint("ResourceType")
    public static String getIdView(View view) {
        if (view.getId() == 0xffffffff) return "no-id";
        else return view.getResources().getResourceName(view.getId());
    }

    public static View getRootView(Activity mActivity) {
        final ViewGroup contentViewGroup = (ViewGroup) mActivity.findViewById(android.R.id.content);
        View rootView = null;
        if(contentViewGroup != null) rootView = contentViewGroup.getChildAt(0);
        if(rootView == null) rootView = mActivity.getWindow().getDecorView().getRootView();
        return rootView;
    }

    public static void setPoliceProductSansBold(TextView myTextView, Activity mActivity){
        Typeface typeface = ResourcesCompat.getFont(getAppContext(mActivity), R.font.product_sans_bold);
        myTextView.setTypeface(typeface);
    }
    public static void setPoliceProductSansRegular(TextView myTextView, Activity mActivity){
        Typeface typeface = ResourcesCompat.getFont(getAppContext(mActivity), R.font.product_sans_regular);
        myTextView.setTypeface(typeface);
    }


    public static int dpToPx(Context c, int dp) {
        Resources r = c.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static JSONObject mapToJson(Map<?, ?> data){
        JSONObject object = new JSONObject();
        for (Map.Entry<?, ?> entry : data.entrySet()){
            String key = (String) entry.getKey();
            if (key == null){
                throw new NullPointerException("key == null");
            }try{
                object.put(key, wrap(entry.getValue()));
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return object;
    }

    private static Random r = new Random();

    public static int randInt(int max) {
        return r.nextInt(max);
    }

    public static int getColor(Context ctx) {
        int returnColor = Color.WHITE;
        int arrayId = ctx.getResources().getIdentifier("mdcolor_random", "array", ctx.getPackageName());

        if (arrayId != 0) {
            TypedArray colors = ctx.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.GRAY);
            colors.recycle();
        }
        return returnColor;
    }

    public static int getColor(Context ctx, String str, int index) {
        int returnColor = Color.WHITE;
        int arrayId = ctx.getResources().getIdentifier("mdcolor_random", "array", ctx.getPackageName());

        if (arrayId != 0) {
            TypedArray colors = ctx.getResources().obtainTypedArray(arrayId);
            int idx = index;
            while (idx >= colors.length()) {
                idx = idx - 5;
            }
            while (idx < 0) {
                idx = idx + 2;
            }
            returnColor = colors.getColor(idx, Color.GRAY);
            colors.recycle();
        }
        return returnColor;
    }

    public static JSONArray collectionToJson(Collection data){
        JSONArray jsonArray = new JSONArray();
        if (data != null){
            for (Object aData : data){
                jsonArray.put(wrap(aData));
            }
        }
        return jsonArray;
    }

    public static JSONArray arrayToJson(Object data) throws JSONException{
        if (!data.getClass().isArray()){
            throw new JSONException("Not a primitive data: " + data.getClass());
        }
        final int length = Array.getLength(data);
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < length; ++i){
            jsonArray.put(wrap(Array.get(data, i)));
        }
        return jsonArray;
    }

    private static Object wrap(Object o){
        if (o == null){
            return null;
        }if (o instanceof JSONArray || o instanceof JSONObject){
            return o;
        }try{
            if (o instanceof Collection){
                return collectionToJson((Collection) o);
            }else if (o.getClass().isArray()){
                return arrayToJson(o);
            }if (o instanceof Map){
                return mapToJson((Map) o);
            }if (o instanceof Boolean ||
                    o instanceof Byte ||
                    o instanceof Character ||
                    o instanceof Double ||
                    o instanceof Float ||
                    o instanceof Integer ||
                    o instanceof Long ||
                    o instanceof Short ||
                    o instanceof String)
            {
                return o;
            }
            if (o.getClass().getPackage().getName().startsWith("java.")){
                return o.toString();
            }
        }
        catch (Exception ignored){}
        return null;
    }

    /**
     * Handling the keyboard on device
     *
     * @param activity
     */
    private static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        if (activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(
                    activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * Handling the listener to dismiss the keyboard on device
     *
     * @param context <br>
     * @param view    is parent view <br>
     */
    @SuppressLint("ClickableViewAccessibility")
    public static void setupDismissKeyboardListener(Context context, View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener((v, event) -> {
                hideSoftKeyboard((Activity) context);
                return false;
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupDismissKeyboardListener(context, innerView);
            }
        }
    }

}
