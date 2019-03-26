package com.princeodzalasapp.fr.wmandroidui.Snackbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.princeodzalasapp.fr.wmandroidui.R;

public class Snack{

    public static final int TYPE_SUCCESS = 0x00;
    public static final int TYPE_INFO = 0x01;
    public static final int TYPE_WARNING = 0x02;
    public static final int TYPE_ERROR = 0x03;
    public static final int TYPE_NORMAL = 0x04;


    public static final int LENGTH_SHORT = Snackbar.LENGTH_SHORT;
    public static final int LENGTH_LONG = Snackbar.LENGTH_LONG;
    public static final int LENGTH_INDEFINITE = Snackbar.LENGTH_INDEFINITE;

    // Prevent direct instantiation
    private Snack() {}

    public static Snackbar make(@NonNull View view, @NonNull CharSequence text, int type, int duration) {
        switch (type) {
            case TYPE_ERROR:
                return error(view, text, duration);
            case TYPE_WARNING:
                return info(view, text, duration);
            case TYPE_INFO:
                return info(view, text, duration);
            case TYPE_SUCCESS:
                return success(view, text, duration);
            case TYPE_NORMAL:
                // Default type is TYPE_NORMAL.
            default:
                return Snackbar.make(view, text, duration);
        }
    }


    public static Snackbar success(@NonNull View view, @NonNull CharSequence text, int duration) {
        Context context = view.getContext();
        return make(view,
                text,
                // DO NOT use the resource id directly.
                // It should be a resolved drawable or color.
                ContextCompat.getDrawable(context, R.drawable.ic_check_white_24dp),
                // getResources().getColor() is deprecated.
                ContextCompat.getColor(context, R.color.color_success),
                ContextCompat.getColor(context, android.R.color.white),
                duration);
    }

    public static Snackbar error(@NonNull View view, @NonNull CharSequence text, int duration) {
        Context context = view.getContext();
        return make(view,
                text,
                // DO NOT use the resource id directly.
                // It should be a resolved drawable or color.
                ContextCompat.getDrawable(context, R.drawable.ic_clear_white_24dp),
                // getResources().getColor() is deprecated.
                ContextCompat.getColor(context, R.color.color_error),
                ContextCompat.getColor(context, android.R.color.white),
                duration);
    }

    public static Snackbar info(@NonNull View view, @NonNull CharSequence text, int duration) {
        Context context = view.getContext();
        return make(view,
                text,
                // DO NOT use the resource id directly.
                // It should be a resolved drawable or color.
                ContextCompat.getDrawable(context, R.drawable.ic_info_outline_white_24dp),
                // getResources().getColor() is deprecated.
                ContextCompat.getColor(context, R.color.color_info),
                ContextCompat.getColor(context, android.R.color.white),
                duration);
    }

    public static Snackbar warning(@NonNull View view, @NonNull CharSequence text, int duration) {
        Context context = view.getContext();
        return make(view,
                text,
                // DO NOT use the resource id directly.
                // It should be a resolved drawable or color.
                ContextCompat.getDrawable(context, R.drawable.ic_error_outline_white_24dp),
                // getResources().getColor() is deprecated.
                ContextCompat.getColor(context, R.color.color_warning),
                ContextCompat.getColor(context, android.R.color.white),
                duration);
    }

    public static Snackbar normal(@NonNull View view, @NonNull CharSequence text, int duration) {
        return Snackbar.make(view, text, duration);
    }


    public static Snackbar make(@NonNull View view, @NonNull CharSequence text, Drawable textIcon,
                                @ColorInt int backgroundColor, @ColorInt int textColor, int duration) {
        // Get a usual Snackbar
        Snackbar snackbar = Snackbar.make(view, text, duration);

        // Get the view of it.
        View mView = snackbar.getView();
        // Change the background color.
        mView.setBackgroundColor(backgroundColor);

        // Get the TextView of message.
        TextView textView = (TextView) mView.findViewById(android.support.design.R.id.snackbar_text);
        // Set the left icon of message.
        textView.setCompoundDrawablesWithIntrinsicBounds(textIcon, null, null, null);
        // Set the padding between message and icon.
        textView.setCompoundDrawablePadding(16);
        // To make icon and message aligned.
        textView.setGravity(Gravity.CENTER);
        // Change color of message text.
        textView.setTextColor(textColor);

        return snackbar;
    }

    public static Snackbar make(@NonNull View view, @NonNull CharSequence text, Drawable textIcon,
                                @ColorInt int backgroundColor, @ColorInt int textColor,
                                int duration, Drawable actionIcon, @ColorInt int actionTextColor) {
        // Call the {@link Snack#make(View, CharSequence, Drawable, int, int, int)}
        // and get the Snackbar whose message text is customized.
        Snackbar snackbar = make(view, text, textIcon, backgroundColor, textColor, duration);

        // Get the button of action.
        Button actionButton = (Button) snackbar.getView().findViewById(android.support.design.R.id.snackbar_action);
        // Same to TextView of message, set the left icon of action.
        actionButton.setCompoundDrawablesWithIntrinsicBounds(actionIcon, null, null, null);
        // Set the padding between action text and icon.
        actionButton.setCompoundDrawablePadding(16);
        // To make icon and action text aligned.
        actionButton.setGravity(Gravity.CENTER);
        // Change color of action text.
        actionButton.setTextColor(actionTextColor);

        return snackbar;
    }

    public static Snackbar make(@NonNull View view, @StringRes int textRes, @DrawableRes int textIconRes,
                                @ColorRes int backgroundColorRes, @ColorRes int textColorRes, int duration) {
        Context context = view.getContext();
        return make(view,
                context.getString(textRes),
                // DO NOT use the resource id directly.
                // It should be a resolved drawable or color.
                ContextCompat.getDrawable(context, textIconRes),
                // getResources().getColor() is deprecated.
                ContextCompat.getColor(context, backgroundColorRes),
                ContextCompat.getColor(context, textColorRes),
                duration);
    }

    public static Snackbar make(@NonNull View view, @StringRes int textRes, @DrawableRes int textIconRes,
                                @ColorRes int backgroundColorRes, @ColorRes int textColorRes,
                                int duration, @DrawableRes int actionIconRes, @ColorRes int actionTextColorRes) {
        Context context = view.getContext();
        return make(view,
                context.getString(textRes),
                // DO NOT use the resource id directly.
                // It should be a resolved drawable or color.
                ContextCompat.getDrawable(context, textIconRes),
                // getResources().getColor() is deprecated.
                ContextCompat.getColor(context, backgroundColorRes),
                ContextCompat.getColor(context, textColorRes),
                duration,
                ContextCompat.getDrawable(context, actionIconRes),
                ContextCompat.getColor(context, actionTextColorRes));
    }

    /**
     * Make a customized {@link Snackbar} to display a message without any action.
     * Method {@link Snack#make(View, CharSequence, Drawable, int, int, int)}.
     *
     * @param view The view to find a parent from.
     * @param text The message to display. Formatted text is supported.
     * @param textIconRes The left icon of the message. Drawable resource id required.
     * @param backgroundColorRes The background color of the Snackbar. Color resource id required.
     * @param textColorRes The color of action message text. Color resource id required.
     * @param duration How long to show the message.
     *                 Either {@link Snack#LENGTH_SHORT} or {@link Snack#LENGTH_LONG}.
     *
     * @return The customized Snackbar that will be displayed.
     */
    public static Snackbar make(@NonNull View view, @NonNull CharSequence text, @DrawableRes int textIconRes,
                                @ColorRes int backgroundColorRes, @ColorRes int textColorRes, int duration) {
        Context context = view.getContext();
        return make(view,
                text,
                // DO NOT use the resource id directly.
                // It should be a resolved drawable or color.
                ContextCompat.getDrawable(context, textIconRes),
                // getResources().getColor() is deprecated.
                ContextCompat.getColor(context, backgroundColorRes),
                ContextCompat.getColor(context, textColorRes),
                duration);
    }

    /**
     * Make a customized {@link Snackbar} to display a message without any action.
     * Method {@link Snack#make(View, CharSequence, Drawable, int, int, int, Drawable, int) }
     *
     * @param view The view to find a parent from.
     * @param text The message to display. Formatted text is supported.
     * @param textIconRes The left icon of the message. Drawable resource id required.
     * @param backgroundColorRes The background color of the Snackbar. Color resource id required.
     * @param textColorRes The color of action message text. Color resource id required.
     * @param duration How long to show the message.
     *                 Either {@link Snack#LENGTH_SHORT} or {@link Snack#LENGTH_LONG}.
     * @param actionIconRes The left icon of action message text. Drawable resource id required.
     * @param actionTextColorRes The color of action message text. Color resource id required.
     *
     * @return The customized Snackbar that will be displayed.
     */
    public static Snackbar make(@NonNull View view, @NonNull CharSequence text, @DrawableRes int textIconRes,
                                @ColorRes int backgroundColorRes, @ColorRes int textColorRes,
                                int duration, @DrawableRes int actionIconRes, @ColorRes int actionTextColorRes) {
        Context context = view.getContext();
        return make(view,
                text,
                // DO NOT use the resource id directly.
                // It should be a resolved drawable or color.
                ContextCompat.getDrawable(context, textIconRes),
                // getResources().getColor() is deprecated.
                ContextCompat.getColor(context, backgroundColorRes),
                ContextCompat.getColor(context, textColorRes),
                duration,
                ContextCompat.getDrawable(context, actionIconRes),
                ContextCompat.getColor(context, actionTextColorRes));
    }

}
