package com.princeodzalasapp.fr.wmandroidui.Image;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.princeodzalasapp.fr.wmandroidui.R;
import jp.shts.android.storiesprogressview.StoriesProgressView;
import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

public class StoriesView {

    private static final int PROGRESS_COUNT = 6;

    public static StoriesProgressView storiesProgressView;
    public static ImageView image;

    public static int counter = 0;
    public static final int[] resources = new int[]{
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
    };

    public static final long[] durations = new long[]{
            500L, 1000L, 1500L, 4000L, 5000L, 1000,
    };

    static long pressTime = 0L;
    static long limit = 500L;

    public static  View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    pressTime = System.currentTimeMillis();
                    storiesProgressView.pause();
                    return false;
                case MotionEvent.ACTION_UP:
                    long now = System.currentTimeMillis();
                    storiesProgressView.resume();
                    return limit < now - pressTime;
            }
            return false;
        }
    };

    public static void send(int idParent, final String[] resourcess, Activity mActivity){
//        Intent a = new Intent(getAppContext(mActivity), StatusStoriesActivity.class);
//        a.putExtra(StatusStoriesActivity.STATUS_DURATION_KEY, 3000L);
//        a.putExtra(StatusStoriesActivity.IS_IMMERSIVE_KEY, true);
//        a.putExtra(StatusStoriesActivity.IS_CACHING_ENABLED_KEY, true);
//        a.putExtra(StatusStoriesActivity.IS_TEXT_PROGRESS_ENABLED_KEY, true);
//        if ( test == true ){
//            a.putExtra(StatusStoriesActivity.STATUS_RESOURCES_KEY, test_resources);
//        }else{
//            a.putExtra(StatusStoriesActivity.STATUS_RESOURCES_KEY, resources);
//        }
//        mActivity.startActivity(a);
        mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        LinearLayout fen = (LinearLayout) inflater.inflate(R.layout.expanding_activity,null);

        storiesProgressView = (StoriesProgressView) fen.findViewById(R.id.stories);
        storiesProgressView.setStoriesCount(PROGRESS_COUNT);
        storiesProgressView.setStoryDuration(3000L);
        // or
        // storiesProgressView.setStoriesCountWithDurations(durations);
        StoriesProgressView.StoriesListener mcliko = new StoriesProgressView.StoriesListener(){

            @Override
            public void onNext() {
                image.setImageResource(resources[++counter]);
            }

            @Override
            public void onPrev() {
                if ((counter - 1) < 0) return;
                image.setImageResource(resources[--counter]);
            }

            @Override
            public void onComplete() {

            }
        };
        storiesProgressView.setStoriesListener(mcliko);
//        storiesProgressView.startStories();
        counter = 2;
        storiesProgressView.startStories(counter);

        image = (ImageView) fen.findViewById(R.id.image);
        image.setImageResource(resources[counter]);

        // bind reverse view
        View reverse = fen.findViewById(R.id.reverse);
        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storiesProgressView.reverse();
            }
        });
        reverse.setOnTouchListener(onTouchListener);

        // bind skip view
        View skip = fen.findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storiesProgressView.skip();
            }
        });
        skip.setOnTouchListener(onTouchListener);

            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(fen);
            }

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

    public static void fermeStorie(){
        storiesProgressView.destroy();
    }

}
