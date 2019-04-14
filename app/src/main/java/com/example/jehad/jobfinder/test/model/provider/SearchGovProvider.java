package com.example.jehad.jobfinder.test.model.provider;

import android.content.Context;
import android.widget.ProgressBar;

import com.example.jehad.jobfinder.base.BaseRecyclerViewAdapter;
import com.example.jehad.jobfinder.base.BaseViewHolder;
import com.example.jehad.jobfinder.test.model.filter.QueryFilter;
import com.example.jehad.jobfinder.test.rest.ApiClient;
import com.example.jehad.jobfinder.test.rest.ApiProviderInterface;
import com.example.jehad.jobfinder.test.rest.ProviderApiRepository;
import com.example.jehad.jobfinder.ui.main.viewholder.SearchGovViewHolder;

public class SearchGovProvider extends BaseProvider {
    private Class<? extends SearchGovViewHolder> searchViewHolderClass;
    private Class<? extends ApiProviderInterface.SearchGov> searchGovInterface;
    private ApiProviderInterface.SearchGov api;

    public SearchGovProvider(String name, Class<? extends SearchGovViewHolder> searchViewHolderClass
            , Class<? extends ApiProviderInterface.SearchGov> searchGovInterface) {
        super(name);
        this.searchViewHolderClass = searchViewHolderClass;
        this.searchGovInterface = searchGovInterface;
        this.api = ApiClient.getClient().create(searchGovInterface);
    }

    public Class<? extends SearchGovViewHolder> getSearchViewHolderClass() {
        return searchViewHolderClass;
    }

    public Class<? extends ApiProviderInterface.SearchGov> getSearchGovInterface() {
        return searchGovInterface;
    }

    public ApiProviderInterface.SearchGov getApi() {
        return api;
    }

    @Override
    public void showList(final Context context, final BaseRecyclerViewAdapter baseRecyclerViewAdapter, ProgressBar progressBar, QueryFilter queryFilter) {
        ProviderApiRepository.getSearchGovJobList(context, baseRecyclerViewAdapter,progressBar, queryFilter, getApi());
    }

    @Override
    public Class<? extends BaseViewHolder> getBaseViewHolder() {
        return searchViewHolderClass;
    }
}
