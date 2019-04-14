package com.example.jehad.jobfinder.ui.main.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jehad.jobfinder.R;
import com.example.jehad.jobfinder.base.BaseViewHolder;
import com.example.jehad.jobfinder.test.model.job.SearchGovJob;
import com.example.jehad.jobfinder.callback.OnItemClickListener;
import com.example.jehad.jobfinder.util.DateTimeUtils;

import butterknife.BindView;

public class SearchGovViewHolder extends BaseViewHolder<SearchGovJob> {
    @BindView(R.id.tv_jobTitle)
    TextView jobTitle;
    @BindView(R.id.tv_companyName)
    TextView companyName;
    @BindView(R.id.tv_location)
    TextView location;
    @BindView(R.id.tv_postDate)
    TextView postDate;
    @BindView(R.id.iv_companyLogo)
    ImageView companyLogo;

    private SearchGovJob searchGovJob;

    public SearchGovViewHolder(ViewGroup parent, OnItemClickListener onItemClickListener) {
        super(parent, R.layout.row_job, onItemClickListener);
    }

    @Override
    public void setData(SearchGovJob searchGovJob) {
        this.searchGovJob = searchGovJob;

        jobTitle.setText(searchGovJob.getPositionTitle());
        companyName.setText(searchGovJob.getOrganizationName());
        location.setText(searchGovJob.getLocations().get(0));
        postDate.setText(DateTimeUtils.fromStringToString(searchGovJob.getStartDate()
                , DateTimeUtils.yyyy_MM_dd
                , DateTimeUtils.dd_MMMM_yyyy));

    }

    @Override
    public SearchGovJob getData() {
        return searchGovJob;
    }
}
