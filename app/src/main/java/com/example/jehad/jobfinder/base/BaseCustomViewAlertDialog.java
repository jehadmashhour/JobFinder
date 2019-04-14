package com.example.jehad.jobfinder.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;

/**
 * The super class of any custom view alert dialog u want to show ,
 * So extend from it , it handles the initialization logic for the {@link AlertDialog}.
 */
public abstract class BaseCustomViewAlertDialog extends BaseDialogsManager {


    public BaseCustomViewAlertDialog(Context mContext, @LayoutRes int viewId, boolean isShowKeyboard, boolean isCancelable) {
        this.mContext = mContext;
        this.isShowKeyboard = isShowKeyboard;
        this.mBuilder = new AlertDialog.Builder(this.mContext);
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        super.initDialog(viewId, isCancelable);
        ButterKnife.bind(this, mView);
    }

    public BaseCustomViewAlertDialog(Context mContext, @LayoutRes int viewId, @StyleRes int themeResId, boolean isShowKeyboard, boolean isCancelable) {
        this.mContext = mContext;
        this.isShowKeyboard = isShowKeyboard;
        this.mBuilder = new AlertDialog.Builder(this.mContext, themeResId);
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        super.initDialog(viewId, isCancelable);
        ButterKnife.bind(this, mView);
    }

    /**
     * Show the dialog
     * @return
     */
    public BaseCustomViewAlertDialog show() {
        buildCustomDialog();
        return this;
    }

    /**
     * dismiss the dialog
     * @return
     */
    @Override
    public BaseDialogsManager dismiss() {
        return super.dismiss();
    }

    @Override
    public AlertDialog getDialog() {
        return super.getDialog();
    }

    /**
     * @return the custom view of the dialog
     */
    @Override
    public View getCustomView() {
        return super.getCustomView();
    }


    public BaseCustomViewAlertDialog isShowAutoKeyboard(boolean isEnable) {
        showAutoKeyboard(isEnable);
        return this;
    }

    public boolean isDialogShowing() {
        return dialog.isShowing();
    }

    protected abstract void initializer();

}
