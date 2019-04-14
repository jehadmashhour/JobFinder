package com.example.jehad.jobfinder.ui.main.dialogs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jehad.jobfinder.R;
import com.example.jehad.jobfinder.constants.RequestCodes;
import com.example.jehad.jobfinder.base.BaseCustomViewAlertDialog;
import com.example.jehad.jobfinder.test.model.filter.QueryFilter;
import com.example.jehad.jobfinder.test.model.provider.BaseProvider;
import com.example.jehad.jobfinder.test.rest.ProviderStrategies;
import com.example.jehad.jobfinder.callback.OnFilterListener;
import com.example.jehad.jobfinder.util.DataTypeUtils;
import com.example.jehad.jobfinder.util.ToastUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import java.util.List;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * The responsible class on the filtration logic inside the filter dialog
 */
public class FilterBaseCustomViewAlertDialog extends BaseCustomViewAlertDialog {

    @BindView(R.id.sp_provider)
    Spinner providerSpinner;
    @BindView(R.id.et_provider)
    EditText providerEditText;
    @BindView(R.id.cb_provider)
    CheckBox providerCheckBox;
    @BindView(R.id.et_position)
    EditText positionEditText;
    @BindView(R.id.cb_position)
    CheckBox positionCheckBox;
    @BindView(R.id.et_location)
    EditText locationEditText;
    @BindView(R.id.cb_location)
    CheckBox locationCheckBox;

    private OnFilterListener onFilterListener;
    private QueryFilter queryFilter = new QueryFilter();
    private Place place;

    public FilterBaseCustomViewAlertDialog(Context mContext, int viewId, int themeResId, boolean isShowKeyboard, boolean isCancelable, OnFilterListener onFilterListener) {
        super(mContext, viewId, themeResId, isShowKeyboard, isCancelable);
        this.onFilterListener = onFilterListener;
        initializer();
    }

    private FilterBaseCustomViewAlertDialog(Context mContext, int viewId, boolean isShowKeyboard, boolean isCancelable, OnFilterListener onFilterListener) {
        super(mContext, viewId, isShowKeyboard, isCancelable);
        this.onFilterListener = onFilterListener;
        initializer();
    }

    public static FilterBaseCustomViewAlertDialog getInstance(@NonNull Context mContext, boolean showKeyboard, boolean isCancelable, OnFilterListener onFilterListener) {
        return new FilterBaseCustomViewAlertDialog(mContext, R.layout.dialog_filter, showKeyboard, isCancelable, onFilterListener);
    }

    public static FilterBaseCustomViewAlertDialog getInstance(@NonNull Context mContext, @StyleRes int themeResId, boolean showKeyboard, boolean isCancelable, OnFilterListener onFilterListener) {
        return new FilterBaseCustomViewAlertDialog(mContext, R.layout.dialog_filter, themeResId, showKeyboard, isCancelable, onFilterListener);
    }

    @Override
    protected void initializer() {
        setupSpinner();
    }

    private void setupSpinner() {

        List<BaseProvider> baseProviderList = ProviderStrategies.getProviderList();
        ArrayAdapter<BaseProvider> dataAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_item, baseProviderList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        providerSpinner.setAdapter(dataAdapter);
        providerSpinner.setEnabled(false);
    }

    @Override
    public FilterBaseCustomViewAlertDialog show() {
        super.show();
        return this;

    }

    public void setPlace(Place place) {
        this.place = place;
        locationEditText.setText(this.place.getAddress());
    }

    @OnClick(R.id.tv_done)
    public void onDoneClicked() {
        if (isFieldsValid()) {
            queryFilter.setBaseProvider(providerCheckBox.isChecked() ? (BaseProvider) providerSpinner.getSelectedItem() : null);
            queryFilter.setPosition(positionCheckBox.isChecked() ? positionEditText.getText().toString() : null);
            queryFilter.setLatLng(locationCheckBox.isChecked() ? place.getLatLng() : null);
            onFilterListener.onDone(queryFilter);
            dismiss();
        }
    }

    public boolean isFieldsValid() {
        if (!isProviderCheckBoxChecked() && !isPositionCheckBoxChecked() && !isLocationCheckBoxChecked()) {
            ToastUtils.showToast(mContext, mContext.getString(R.string.please_fill_fields), Toast.LENGTH_SHORT);
            return false;
        }

        if (isPositionCheckBoxChecked() && DataTypeUtils.isNullOrEmpty(getPositionEditText())) {
            ToastUtils.showToast(mContext, mContext.getString(R.string.please_fill_position_field), Toast.LENGTH_SHORT);
            return false;
        } else if (isLocationCheckBoxChecked() && DataTypeUtils.isNullOrEmpty(getLocationEditText())) {
            ToastUtils.showToast(mContext, mContext.getString(R.string.please_fill_location_field), Toast.LENGTH_SHORT);
            return false;
        }
        return true;
    }

    /**
     * Made it public for Purposes of the Unit testing
     *
     * @return
     */
    public boolean isProviderCheckBoxChecked() {
        return providerCheckBox.isChecked();
    }

    /**
     * Made it public for Purposes of the Unit testing
     *
     * @return
     */
    public boolean isPositionCheckBoxChecked() {
        return positionCheckBox.isChecked();
    }

    /**
     * Made it public for Purposes of the Unit testing
     *
     * @return
     */
    public boolean isLocationCheckBoxChecked() {
        return locationCheckBox.isChecked();
    }

    /**
     * Made it public for Purposes of the Unit testing
     *
     * @return
     */
    public String getPositionEditText() {
        return positionEditText.getText().toString();
    }

    /**
     * Made it public for Purposes of the Unit testing
     *
     * @return
     */
    public String getLocationEditText() {
        return locationEditText.getText().toString();
    }

    @OnClick(R.id.tv_cancel)
    public void onCancelClicked() {
        dismiss();
    }

    @OnClick(R.id.et_location)
    public void onLocationEditTextClicked() {
        showGoogleAutoCompletePickerMap();
    }


    @OnCheckedChanged(R.id.cb_provider)
    public void onProviderCheckBoxChanged(CompoundButton button, boolean checked) {
        providerSpinner.setEnabled(checked);
        if (!checked) {
            providerEditText.setText("");
            queryFilter.setBaseProvider(null);
        }
    }

    @OnCheckedChanged(R.id.cb_position)
    public void onPositionCheckBoxChanged(CompoundButton button, boolean checked) {
        positionEditText.setEnabled(checked);
        if (!checked) {
            positionEditText.setText("");
            queryFilter.setPosition(null);
        }
    }

    @OnCheckedChanged(R.id.cb_location)
    public void onLocationCheckBoxChanged(CompoundButton button, boolean checked) {
        locationEditText.setEnabled(checked);
        if (!checked) {
            locationEditText.setText("");
            queryFilter.setLatLng(null);
        }
    }

    /**
     * Show the autocomplete search locations  of google APis
     */
    private void showGoogleAutoCompletePickerMap() {
        PlaceAutocomplete.IntentBuilder intentBuilder = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN);

        Intent intent = null;
        try {
            intent = intentBuilder.build((Activity) mContext);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
        // Start the Intent by requesting a result, identified by a request code.
        ((Activity) mContext).startActivityForResult(intent, RequestCodes.AUTO_COMPLETE_REQUEST_CODE);
    }
}
