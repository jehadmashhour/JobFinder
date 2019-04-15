package com.example.jehad.jobfinder.data.model.provider;

import android.content.Context;
import android.widget.ProgressBar;

import com.example.jehad.jobfinder.base.BaseRecyclerViewAdapter;
import com.example.jehad.jobfinder.base.BaseViewHolder;
import com.example.jehad.jobfinder.data.model.filter.QueryFilter;
import com.example.jehad.jobfinder.data.rest.ProviderStrategies;

/**
 * The base class for every Provider
 */
public abstract class BaseProvider {
    private String name;
    private ProviderStrategies.ProviderType providerType;


    public BaseProvider(String name, ProviderStrategies.ProviderType providerType) {
        this.name = name;
        this.providerType = providerType;
    }

    /**
     * The name for the Provider
     *
     * @return
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public ProviderStrategies.ProviderType getProviderType() {
        return providerType;
    }
    /**
     * Show the list for this Provider
     *
     * @param context
     * @param queryFilter
     */
    public abstract void showList(final Context context, QueryFilter queryFilter);

    /**
     * Get the {@link BaseViewHolder}  for this Provider
     *
     * @return
     */
    public abstract Class<? extends BaseViewHolder> getBaseViewHolder();
}
