package com.example.jehad.jobfinder.ui.main.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.jehad.jobfinder.R;
import com.example.jehad.jobfinder.base.BaseViewHolder;
import com.example.jehad.jobfinder.test.model.job.GitHubJob;
import com.example.jehad.jobfinder.callback.OnItemClickListener;
import com.example.jehad.jobfinder.util.DateTimeUtils;
import com.example.jehad.jobfinder.util.GlideImageDownloaderUtil;

import butterknife.BindView;

public class GitHubViewHolder extends BaseViewHolder<GitHubJob> {
    @BindView(R.id.tv_jobTitle)
    TextView jobTitle;
    @BindView(R.id.tv_companyName)
    TextView companyName;
    @BindView(R.id.tv_location)
    TextView location;
    @BindView(R.id.tv_postDate)
    TextView postDate;
    @BindView(R.id.iv_companyLogo)
    ImageView companyLogoImageView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private GitHubJob gitHubJob;

    public GitHubViewHolder(ViewGroup parent, OnItemClickListener onItemClickListener) {
        super(parent, R.layout.row_job, onItemClickListener);
    }


    @Override
    public void setData(GitHubJob gitHubJob) {
        this.gitHubJob = gitHubJob;

        jobTitle.setText(gitHubJob.getTitle());
        companyName.setText(gitHubJob.getCompany());
        location.setText(gitHubJob.getLocation());
        postDate.setText(DateTimeUtils.fromStringToString(gitHubJob.getCreatedAt()
                , DateTimeUtils.EEE_MMM_d_HH_mm_ss_UTC_yyyy
                , DateTimeUtils.dd_MMMM_yyyy));

        GlideImageDownloaderUtil.display(getContext(), gitHubJob.getCompanyLogo(), companyLogoImageView, R.drawable.default_image, progressBar);
    }

    @Override
    public GitHubJob getData() {
        return gitHubJob;
    }

}
