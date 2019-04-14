package com.example.jehad.jobfinder.data.rest;

import android.content.Context;
import android.widget.ProgressBar;

import com.example.jehad.jobfinder.base.BaseRecyclerViewAdapter;
import com.example.jehad.jobfinder.constants.ProviderNames;
import com.example.jehad.jobfinder.data.model.filter.QueryFilter;
import com.example.jehad.jobfinder.data.model.provider.BaseProvider;
import com.example.jehad.jobfinder.data.model.provider.GithubProvider;
import com.example.jehad.jobfinder.data.model.provider.SearchGovProvider;
import com.example.jehad.jobfinder.ui.main.viewholder.GitHubViewHolder;
import com.example.jehad.jobfinder.ui.main.viewholder.SearchGovViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ProviderStrategies {

    /**
     * @return Get The full Providers list , a new provider should be added here .
     */
    public static List<BaseProvider> getProviderList() {
        return new ArrayList<BaseProvider>() {{
            add(new GithubProvider(ProviderNames.GITHUB, ProviderType.GITHUB, GitHubViewHolder.class, ApiProviderInterface.Github.class));
            add(new SearchGovProvider(ProviderNames.SEARCH_GOV, ProviderType.SEARCH_GOV, SearchGovViewHolder.class, ApiProviderInterface.SearchGov.class));
        }};
    }

    /**
     * The full provider types, a new provider type should be added here .
     */
    public enum ProviderType {
        GITHUB,
        SEARCH_GOV
    }

    /**
     * @param providerType the current selected {@link ProviderType}
     * @return The {@link BaseProvider} of the specifc {@link ProviderType}
     */
    public static BaseProvider getProvider(ProviderType providerType) {
        return getProviderList().get(providerType.ordinal());
    }

    /**
     * show one Job list
     *
     * @param context                 The current activity context
     * @param baseRecyclerViewAdapter The current {@link BaseRecyclerViewAdapter}
     * @param progressBar             The current {@link ProgressBar}
     * @param queryFilter             The current {@link QueryFilter}
     */
    public static void showOneJobsList(final Context context, final BaseRecyclerViewAdapter baseRecyclerViewAdapter, ProgressBar progressBar, QueryFilter queryFilter) {
        queryFilter.getBaseProvider().showList(context, baseRecyclerViewAdapter, progressBar, queryFilter);
    }

    /**
     * show one Job list
     *
     * @param providerType            The current selected {@link ProviderType}
     * @param context                 The current activity context
     * @param baseRecyclerViewAdapter The current {@link BaseRecyclerViewAdapter}
     * @param progressBar             The current {@link ProgressBar}
     * @param queryFilter             The current {@link QueryFilter}
     */
    public static void showOneJobsList(ProviderType providerType, final Context context, final BaseRecyclerViewAdapter baseRecyclerViewAdapter, ProgressBar progressBar, QueryFilter queryFilter) {
        getProviderList().get(providerType.ordinal()).showList(context, baseRecyclerViewAdapter, progressBar, queryFilter);
    }

    /**
     * Show  All Jobs list
     *
     * @param context                 The current activity context
     * @param baseRecyclerViewAdapter The current {@link BaseRecyclerViewAdapter}
     * @param progressBar             The current {@link ProgressBar}
     * @param queryFilter             The current {@link QueryFilter}
     */
    public static void showAllJobsList(final Context context, final BaseRecyclerViewAdapter baseRecyclerViewAdapter, ProgressBar progressBar, QueryFilter queryFilter) {
        for (BaseProvider baseProvider : getProviderList()) {
            baseProvider.showList(context, baseRecyclerViewAdapter, progressBar, queryFilter);
        }
    }


}
