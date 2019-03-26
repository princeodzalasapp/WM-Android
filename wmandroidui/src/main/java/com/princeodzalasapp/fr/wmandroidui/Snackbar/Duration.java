package com.princeodzalasapp.fr.wmandroidui.Snackbar;

import android.support.design.widget.Snackbar;

public enum Duration {
    SHORT, LONG, CUSTOM, INFINITE;

    public static int getDuration(Duration duration){
        switch (duration){
            case SHORT:
                return Snackbar.LENGTH_SHORT;
            case LONG:
                return Snackbar.LENGTH_LONG;
            case INFINITE:
                return Snackbar.LENGTH_INDEFINITE;
        }

        return Snackbar.LENGTH_SHORT;
    }
}
