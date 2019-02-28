package com.princeodzalasapp.fr.wmandroidui.Image;

import android.app.Activity;
import android.content.Intent;

import com.rahuljanagouda.statusstories.StatusStoriesActivity;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

public class StoriesView {

    public static void send(final String[] resources, Activity mActivity, boolean test){
        Intent a = new Intent(getAppContext(mActivity), StatusStoriesActivity.class);
        a.putExtra(StatusStoriesActivity.STATUS_DURATION_KEY, 3000L);
        a.putExtra(StatusStoriesActivity.IS_IMMERSIVE_KEY, true);
        a.putExtra(StatusStoriesActivity.IS_CACHING_ENABLED_KEY, true);
        a.putExtra(StatusStoriesActivity.IS_TEXT_PROGRESS_ENABLED_KEY, true);
        if ( test == true ){
            a.putExtra(StatusStoriesActivity.STATUS_RESOURCES_KEY, test_resources);
        }else{
            a.putExtra(StatusStoriesActivity.STATUS_RESOURCES_KEY, resources);
        }
        mActivity.startActivity(a);
    }

    private static final String[] test_resources = new String[]{
            "https://firebasestorage.googleapis.com/v0/b/firebase-satya.appspot.com/o/images%2Fi00001.jpg?alt=media&token=460667e4-e084-4dc5-b873-eefa028cec32",
            "https://firebasestorage.googleapis.com/v0/b/firebase-satya.appspot.com/o/images%2Fi00002.jpg?alt=media&token=e8e86192-eb5d-4e99-b1a8-f00debcdc016",
            "https://firebasestorage.googleapis.com/v0/b/firebase-satya.appspot.com/o/images%2Fi00004.jpg?alt=media&token=af71cbf5-4be3-4f8a-8a2b-2994bce38377",
            "https://firebasestorage.googleapis.com/v0/b/firebase-satya.appspot.com/o/images%2Fi00005.jpg?alt=media&token=7d179938-c419-44f4-b965-1993858d6e71",
            "https://firebasestorage.googleapis.com/v0/b/firebase-satya.appspot.com/o/images%2Fi00006.jpg?alt=media&token=cdd14cf5-6ed0-4fb7-95f5-74618528a48b",
            "https://firebasestorage.googleapis.com/v0/b/firebase-satya.appspot.com/o/images%2Fi00007.jpg?alt=media&token=98524820-6d7c-4fb4-89b1-65301e1d6053",
            "https://firebasestorage.googleapis.com/v0/b/firebase-satya.appspot.com/o/images%2Fi00008.jpg?alt=media&token=7ef9ed49-3221-4d49-8fb4-2c79e5dab333",
            "https://firebasestorage.googleapis.com/v0/b/firebase-satya.appspot.com/o/images%2Fi00009.jpg?alt=media&token=00d56a11-7a92-4998-a05a-e1dd77b02fe4",
            "https://firebasestorage.googleapis.com/v0/b/firebase-satya.appspot.com/o/images%2Fi00010.jpg?alt=media&token=24f8f091-acb9-432a-ae0f-7e6227d18803",
    };


}
