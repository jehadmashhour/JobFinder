package com.example.jehad.jobfinder.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jehad.jobfinder.R;
import com.example.jehad.jobfinder.config.GlideApp;

/**
 * * Utils for handling the toast message with custom properties .
 */
public class ToastUtils {

    /**
     * Did it here with a controlling of the gravity of the toast text view , because rear devices
     * not show the long toast in the center of its view
     *
     * @param context  The current context
     * @param message  The toast message
     * @param duration The duration toast , control the time of showing -> values : {0 , 1}
     */
    public static void showToast(Context context, String message, int duration) {

        Toast toast = Toast.makeText(context, message, duration);
        TextView v = toast.getView().findViewById(android.R.id.message);
        if (v != null) {
            v.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen._15sdp));
            v.setGravity(Gravity.CENTER);
        }
        toast.show();
    }


}
