package com.example.jehad.jobfinder.data.rest.base;

import android.content.Context;

import com.example.jehad.jobfinder.base.BaseActivity;
import com.example.jehad.jobfinder.data.model.filter.QueryFilter;
import com.example.jehad.jobfinder.data.model.provider.BaseProvider;

import static com.example.jehad.jobfinder.data.rest.base.ProviderStrategies.getProviderList;

public abstract class BaseProviderApiRepositoryUtils {

    /**
     *
     * @param context The current activity context
     * @return The BaseActivity from the Context
     */
    public static BaseActivity getBaseActivity(Context context) {
        return (((BaseActivity) context));
    }

    /**
     * show one Job list
     *
     * @param context                 The current activity context
     * @param queryFilter             The current {@link QueryFilter}
     */
    public static void showOneJobsList(final Context context, QueryFilter queryFilter) {
        queryFilter.getBaseProvider().showList(context,  queryFilter);
    }

    /**
     * show one Job list
     *
     * @param providerType            The current selected {@link ProviderStrategies.ProviderType}
     * @param context                 The current activity context
     * @param queryFilter             The current {@link QueryFilter}
     */
    public static void showOneJobsList(ProviderStrategies.ProviderType providerType, final Context context, QueryFilter queryFilter) {
        getProviderList().get(providerType.ordinal()).showList(context,queryFilter);
    }

    /**
     * Show  All Jobs list
     *
     * @param context                 The current activity context
     * @param queryFilter             The current {@link QueryFilter}
     */
    public static void showAllJobsList(final Context context,  QueryFilter queryFilter) {
        for (BaseProvider baseProvider : getProviderList()) {
            baseProvider.showList(context, queryFilter);
        }
    }
}
