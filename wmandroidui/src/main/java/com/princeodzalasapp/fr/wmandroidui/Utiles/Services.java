package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.princeodzalasapp.fr.wmandroidui.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

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

}
