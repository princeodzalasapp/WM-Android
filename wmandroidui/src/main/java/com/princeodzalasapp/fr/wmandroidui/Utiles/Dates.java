package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Dates {

    public static final int MAX_PROGRESS = 10000;


    public static String getDateCourt(Long dateTime) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat newFormat = new SimpleDateFormat("dd'/'MM'/'yyyy");
        return newFormat.format(new Date(dateTime));
    }

    public static String getDateLong(Long dateTime) {
        // exemple: mardi, 27 juin 2006
        @SuppressLint("SimpleDateFormat") SimpleDateFormat newFormat = new SimpleDateFormat("EEEE, d MMM yyyy");
        return newFormat.format(new Date(dateTime));
    }

    public static String getDateHeureCourt(Long dateTime) {
        // exemple: le 27/06/2006 à 09:37:10
        @SuppressLint("SimpleDateFormat") SimpleDateFormat newFormat = new SimpleDateFormat("'le' dd/MM/yyyy 'à' hh:mm:ss");
        return newFormat.format(new Date(dateTime));
    }

    public static String getDateHeureLong(Long dateTime) {
        // exemple: le 27 juin 2006 à 09:37:10
        @SuppressLint("SimpleDateFormat") SimpleDateFormat newFormat = new SimpleDateFormat("'le' dd MMMM yyyy 'à' hh:mm:ss");
        return newFormat.format(new Date(dateTime));
    }

    public static String getFormattedTimeEvent(Long time) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat newFormat = new SimpleDateFormat("h:mm a");
        return newFormat.format(new Date(time));
    }

    public static String getDateYoutube(String date) {
        final String ISO_8601_24H_FULL_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
        @SuppressLint("SimpleDateFormat") DateFormat df = new SimpleDateFormat(ISO_8601_24H_FULL_FORMAT);
        String dateString;
        try {
            java.util.Date d = df.parse(date);
            dateString = DateFormat.getDateInstance().format(d);
        } catch (ParseException e) {
            e.printStackTrace();
            dateString = "";
        }
        return dateString;
    }

    public static String getDurationString(int seconds) {
        Date date = new Date(seconds * 1000);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat(seconds >= 3600 ? "HH:mm:ss" : "mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        return formatter.format(date);
    }

    public static String getCurrentTimestamp() {
        Long tsLong = System.currentTimeMillis()/1000;
        return tsLong.toString();
    }

    /**
     * Function to convert milliseconds time to
     * Timer Format
     * Hours:Minutes:Seconds
     */
    public String milliSecondsToTimer(long milliseconds) {
        String finalTimerString = "";
        String secondsString = "";

        // Convert total duration into time
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
        // Add hours if there
        if (hours > 0) {
            finalTimerString = hours + ":";
        }

        // Prepending 0 to seconds if it is one digit
        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }


    public int getProgressSeekBar(long currentDuration, long totalDuration) {
        Double progress = (double) 0;
        // calculating percentage
        progress = (((double) currentDuration) / totalDuration) * MAX_PROGRESS;

        // return percentage
        return progress.intValue();
    }

    public int progressToTimer(int progress, int totalDuration) {
        int currentDuration = 0;
        totalDuration = (int) (totalDuration / 1000);
        currentDuration = (int) ((((double) progress) / MAX_PROGRESS) * totalDuration);

        // return current duration in milliseconds
        return currentDuration * 1000;
    }
}
