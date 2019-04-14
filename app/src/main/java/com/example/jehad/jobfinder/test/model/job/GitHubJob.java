package com.example.jehad.jobfinder.test.model.job;

import javax.annotation.Generated;

import com.example.jehad.jobfinder.test.rest.ProviderStrategies;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class GitHubJob extends BaseJob {

    @SerializedName("company_logo")
    private String companyLogo;

    @SerializedName("how_to_apply")
    private String howToApply;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("description")
    private String description;

    @SerializedName("company")
    private String company;

    @SerializedName("company_url")
    private String companyUrl;

    @SerializedName("location")
    private String location;

    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private String type;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setHowToApply(String howToApply) {
        this.howToApply = howToApply;
    }

    public String getHowToApply() {
        return howToApply;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }


    @Override
    public ProviderStrategies.ProviderType getProviderType() {
        return ProviderStrategies.ProviderType.GITHUB;
    }
}