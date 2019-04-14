package com.example.jehad.jobfinder.callback;

import com.example.jehad.jobfinder.test.model.filter.QueryFilter;


public interface OnFilterListener {
    /**
     * Execute when the user press done filter button
     * @param queryFilter
     */
    void onDone(QueryFilter queryFilter);
}
