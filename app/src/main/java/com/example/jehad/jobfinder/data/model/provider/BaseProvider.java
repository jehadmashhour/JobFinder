package com.example.jehad.jobfinder.data.model.provider;

import android.content.Context;
import android.widget.ProgressBar;

import com.example.jehad.jobfinder.base.BaseRecyclerViewAdapter;
import com.example.jehad.jobfinder.base.BaseViewHolder;
import com.example.jehad.jobfinder.data.model.filter.QueryFilter;

/**
 * The base class for every Provider
 */
public abstract class BaseProvider {
    private String name;


    public BaseProvider(String name) {
        this.name = name;
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

    /**
     * Show the list for this Provider
     *
     * @param context
     * @param baseRecyclerViewAdapter
     * @param progressBar
     * @param queryFilter
     */
    public abstract void showList(final Context context, final BaseRecyclerViewAdapter baseRecyclerViewAdapter, ProgressBar progressBar, QueryFilter queryFilter);

    /**
     * Get the {@link BaseViewHolder}  for this Provider
     *
     * @return
     */
    public abstract Class<? extends BaseViewHolder> getBaseViewHolder();
}
