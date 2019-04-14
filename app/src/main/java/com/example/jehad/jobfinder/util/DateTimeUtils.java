package com.example.jehad.jobfinder.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utils for date time , embedded the {@link SimpleDateFormat} for converting to a target format
 */
public class DateTimeUtils {
    public static final String dd_MMMM_yyyy = "dd/MM/yyyy";
    public static final String yyyy_MM_dd = "yyyy-MM-dd";//2018-10-31
    public static final String EEE_MMM_d_HH_mm_ss_UTC_yyyy = "EEE MMM d HH:mm:ss Z yyyy";//Fri Apr 12 15:06:06 UTC 2019


    public static String fromStringToString(String value, String currentFrame, String targetFormat) {
        return formatDateToString(formatStringToDate(value, currentFrame), targetFormat);
    }

    public static String formatDateToString(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static Date formatStringToDate(String value, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = dateFormat.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
