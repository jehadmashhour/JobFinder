package com.example.jehad.jobfinder.test.model.filter;

import com.example.jehad.jobfinder.test.model.provider.BaseProvider;
import com.example.jehad.jobfinder.util.DataTypeUtils;
import com.google.android.gms.maps.model.LatLng;

/**
 * The responsible model on combination the filter values
 */
public class QueryFilter {
    private BaseProvider baseProvider;
    private String position;
    private LatLng latLng;

    public BaseProvider getBaseProvider() {
        return baseProvider;
    }

    public void setBaseProvider(BaseProvider baseProvider) {
        this.baseProvider = baseProvider;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getLatLngSum() {
        if (DataTypeUtils.isNull(getLatLng())) {
            return null;
        }
        return getLatLng().latitude + "," + getLatLng().longitude;
    }
}
