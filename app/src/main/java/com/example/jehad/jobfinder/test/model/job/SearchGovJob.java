package com.example.jehad.jobfinder.test.model.job;

import java.util.List;

import javax.annotation.Generated;

import com.example.jehad.jobfinder.test.rest.ProviderStrategies;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class SearchGovJob extends BaseJob  {

    @SerializedName("end_date")
    private String endDate;

    @SerializedName("rate_interval_code")
    private String rateIntervalCode;

    @SerializedName("position_title")
    private String positionTitle;

    @SerializedName("maximum")
    private int maximum;

    @SerializedName("locations")
    private List<String> locations;

    @SerializedName("id")
    private String id;

    @SerializedName("organization_name")
    private String organizationName;

    @SerializedName("minimum")
    private int minimum;

    @SerializedName("url")
    private String url;

    @SerializedName("start_date")
    private String startDate;

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setRateIntervalCode(String rateIntervalCode) {
        this.rateIntervalCode = rateIntervalCode;
    }

    public String getRateIntervalCode() {
        return rateIntervalCode;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    @Override
    public ProviderStrategies.ProviderType getProviderType() {
        return ProviderStrategies.ProviderType.SEARCH_GOV;
    }
}