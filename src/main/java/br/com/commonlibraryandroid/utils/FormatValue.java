package br.com.commonlibraryandroid.utils;

import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Dennys on 26/09/2017.
 */

public class FormatValue {

    public static String formatTime(String value) {

        if (!value.equals("null") && value != null && !value.isEmpty()) {
            try {
                Calendar cal = Calendar.getInstance(Locale.getDefault());
                long timestamp = Long.valueOf(value);
                cal.setTimeInMillis(timestamp);
                return DateFormat.format("yyyy-MM-dd hh:mm:ss", cal).toString();

            }catch (NumberFormatException e){

                return null;
            }

        } else {
            return null;
        }
    }

}
