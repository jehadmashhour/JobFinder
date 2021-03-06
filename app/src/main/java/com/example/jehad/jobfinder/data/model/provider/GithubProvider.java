package com.example.jehad.jobfinder.data.model.provider;

import android.content.Context;

import com.example.jehad.jobfinder.base.BaseViewHolder;
import com.example.jehad.jobfinder.data.model.filter.QueryFilter;
import com.example.jehad.jobfinder.data.rest.api.ApiClient;
import com.example.jehad.jobfinder.data.rest.api.ApiProviderInterface;
import com.example.jehad.jobfinder.data.rest.api.ProviderApiRepository;
import com.example.jehad.jobfinder.data.rest.base.ProviderStrategies;
import com.example.jehad.jobfinder.ui.main.viewholder.GitHubViewHolder;


public class GithubProvider extends BaseProvider {
    private Class<? extends GitHubViewHolder> githubViewHolderClass;
    private Class<? extends ApiProviderInterface.Github> githubInterface;
    private ApiProviderInterface.Github api;

    public GithubProvider(String name, ProviderStrategies.ProviderType providerType, Class<? extends GitHubViewHolder> githubViewHolderClass, Class<? extends ApiProviderInterface.Github> githubInterface) {
        super(name, providerType);
        this.githubViewHolderClass = githubViewHolderClass;
        this.githubInterface = githubInterface;
        this.api = ApiClient.getClient().create(githubInterface);
    }

    public Class<? extends GitHubViewHolder> getGithubViewHolderClass() {
        return githubViewHolderClass;
    }


    public Class<? extends ApiProviderInterface.Github> getGithubInterface() {
        return githubInterface;
    }

    public ApiProviderInterface.Github getApi() {
        return api;
    }

    @Override
    public void showList(final Context context, QueryFilter queryFilter) {
        ProviderApiRepository.getGitHubJobList(context, queryFilter, getApi());
    }

    @Override
    public Class<? extends BaseViewHolder> getBaseViewHolder() {
        return githubViewHolderClass;
    }
}
