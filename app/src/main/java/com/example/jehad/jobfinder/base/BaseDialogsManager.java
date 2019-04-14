package com.example.jehad.jobfinder.base;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.example.jehad.jobfinder.util.DeviceUtils;

import butterknife.ButterKnife;

/***
 * The super class of all dialogs concepts (Custom View or Default).
 */
public abstract class BaseDialogsManager {

    protected Context mContext;
    protected View mView;
    protected LayoutInflater inflater;
    protected AlertDialog.Builder mBuilder;
    protected AlertDialog dialog;

    protected boolean isShowKeyboard = false;

    protected BaseDialogsManager initDialog(@LayoutRes int viewId, boolean isCancelable) {
        if (viewId != 0) {
            mView = inflater.inflate(viewId, null);
            mBuilder.setCustomTitle(mView);
        }
        dialog = mBuilder.create();
        dialog.setCancelable(isCancelable);
        return this;
    }

    protected BaseDialogsManager buildDefaultDialog() {
        DeviceUtils.hideKeyboard((Activity) mContext);
        mBuilder.show();
        handleEnablingShowingKeyboard();

        return this;
    }

    protected BaseDialogsManager buildCustomDialog() {
        DeviceUtils.hideKeyboard((Activity) mContext);
        dialog.show();
        handleEnablingShowingKeyboard();

        return this;
    }

    /**
     * dismiss the dialog
     * @return
     */
    public BaseDialogsManager dismiss() {
        DeviceUtils.hideKeyboard((Activity) mContext);
        dialog.dismiss();
        return this;
    }

    public AlertDialog getDialog() {
        return dialog;
    }

    public View getCustomView() {
        return mView;
    }

    private void handleEnablingShowingKeyboard() {
        if (isShowKeyboard) {
            dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        }
    }

    public void showAutoKeyboard(boolean isEnable) {
        if (isEnable) {
            dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE
                    | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        }
    }

}
