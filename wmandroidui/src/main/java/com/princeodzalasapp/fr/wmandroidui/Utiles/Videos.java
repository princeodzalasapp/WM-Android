package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.ui.PlayerUIController;
import com.pierfrancescosoffritti.androidyoutubeplayer.ui.menu.MenuItem;
import com.princeodzalasapp.fr.wmandroidui.R;

import org.videolan.libvlc.IVLCVout;
import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.Media;
import org.videolan.libvlc.MediaPlayer;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

public class Videos {

    private static String mFilePath = "rtmp://rrbalancer.broadcast.tneg.de:1935/pw/ruk/ruk";
    private static SurfaceView mSurface;
    private static SurfaceHolder holder;
    private static LibVLC libvlc;
    private static MediaPlayer mMediaPlayer = null;
    private static int mVideoWidth;
    private static int mVideoHeight;
    private static Activity mAct;
    private static IVLCVout.Callback mCallback;
    private static MediaPlayer.EventListener mPlayerListener;
    private static YouTubePlayerView youTubePlayerView;

    public static void youtube(int idParent, final String mUrl, Activity mActivity){
        try {
            youTubePlayerView = new YouTubePlayerView(mActivity);
            youTubePlayerView.initialize(youTubePlayer -> {
                youTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady() {
                        youTubePlayer.loadVideo(mUrl, 0);
                    }
                });
            }, true);

            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(youTubePlayerView);
            }
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
        }
    }

    public static void stream(int idParent, String mUrl, Activity mActivity){
        mAct = mActivity;
        try {
            LayoutInflater inflater = mAct.getLayoutInflater();
            FrameLayout fond = (FrameLayout) inflater.inflate(R.layout.video_main,null);

            if ( mUrl != "" ) mFilePath = mUrl;
            mSurface = (SurfaceView) fond.findViewById(R.id.surface);
            holder = mSurface.getHolder();

            mCallback = new IVLCVout.Callback(){
                @Override
                public void onSurfacesCreated(IVLCVout vlcVout) {

                }

                @Override
                public void onSurfacesDestroyed(IVLCVout vlcVout) {

                }
            };

            mPlayerListener = new MyPlayerListener();
            createPlayer(mFilePath);

            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(fond);
            }
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
        }

    }

    public static class MyPlayerListener implements MediaPlayer.EventListener {
        public MyPlayerListener() {}
        @Override
        public void onEvent(MediaPlayer.Event event) {
            switch (event.type) {
                case MediaPlayer.Event.EndReached:
                    releasePlayer();
                    break;
                case MediaPlayer.Event.Playing:
                case MediaPlayer.Event.Paused:
                case MediaPlayer.Event.Stopped:
                default:
                    break;
            }
        }
    }

    public static void releasePlayer() {
        if (libvlc == null)
            return;
        mMediaPlayer.stop();
        final IVLCVout vout = mMediaPlayer.getVLCVout();
        vout.removeCallback(mCallback);
        vout.detachViews();
        holder = null;
        libvlc.release();
        libvlc = null;
        mVideoWidth = 0;
        mVideoHeight = 0;
    }

    public static void createPlayer(String media) {
        releasePlayer();
        try {
            if (media.length() > 0) {
                Toast toast = Toast.makeText(mAct, media, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0,
                        0);
                toast.show();
            }

            // Create LibVLC
            // TODO: make this more robust, and sync with audio demo
            ArrayList<String> options = new ArrayList<String>();
            //options.add("--subsdec-encoding <encoding>");
            options.add("--aout=opensles");
            options.add("--audio-time-stretch"); // time stretching
            options.add("-vvv"); // verbosity
            libvlc = new LibVLC(getAppContext(mAct), options);
            holder.setKeepScreenOn(true);

            // Creating media player
            mMediaPlayer = new MediaPlayer(libvlc);
            mMediaPlayer.setEventListener(mPlayerListener);

            // Seting up video output
            final IVLCVout vout = mMediaPlayer.getVLCVout();
            vout.setVideoView(mSurface);
            //vout.setSubtitlesView(mSurfaceSubtitles);
            vout.addCallback(mCallback);
            vout.attachViews();

            Media m = new Media(libvlc, Uri.parse(media));
            mMediaPlayer.setMedia(m);
            mMediaPlayer.play();
        } catch (Exception e) {
            ToastColor.erreur("Error in creating player!",getAppContext(mAct));
        }
    }



}
