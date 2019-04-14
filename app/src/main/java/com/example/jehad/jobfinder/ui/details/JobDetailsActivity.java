package com.example.jehad.jobfinder.ui.details;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jehad.jobfinder.R;
import com.example.jehad.jobfinder.base.BaseActivity;
import com.example.jehad.jobfinder.constants.Tags;
import com.example.jehad.jobfinder.data.model.job.BaseJob;
import com.example.jehad.jobfinder.data.model.job.GitHubJob;
import com.example.jehad.jobfinder.data.model.job.SearchGovJob;
import com.example.jehad.jobfinder.util.ToastUtils;


import java.io.Serializable;

import butterknife.BindView;

/**
 * The responsible Activity on Showing the Job Details Url in {@link WebView}
 */
public class JobDetailsActivity extends BaseActivity {

    @BindView(R.id.wv_jobDetailsAct)
    WebView webView;
    @BindView(R.id.pb_jobDetailsAct)
    ProgressBar progressBar;

    private BaseJob baseJob;

    @Override
    protected int layoutRes() {
        return R.layout.activity_job_details;
    }

    /**
     * Recommended to do it like this for purposes of Unit Testing & Reusability code
     * @param context
     * @param o
     * @return Create Intent to show {@link JobDetailsActivity}
     */
    public static Intent createIntent(Context context, Object o) {
        Intent intent = new Intent(context, JobDetailsActivity.class);
        intent.putExtra(Tags.JOB_DETAILS_URL, (Serializable) o);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initializer() {
        getExtrasIntent();
        setUpWebView();
    }

    private void getExtrasIntent() {
        Intent mIntent = getIntent();
        baseJob = (BaseJob) mIntent.getSerializableExtra(Tags.JOB_DETAILS_URL);
    }

    /**
     * It a public accessible because the Unit Test
     *
     * @return
     */
    public BaseJob getBaseJob() {
        return baseJob;
    }

    /**
     * Load after {@link WebView} be ready
     */
    private void setUpWebView() {
        webView.post(new Runnable() {
            @Override
            public void run() {
                loadWebViewUrl();
            }
        });
    }

    /**
     * Load the {@link WebView} Url
     */
    private void loadWebViewUrl() {
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            public void onLoadResource(WebView view, String url) {
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

            }

            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                progressBar.setVisibility(View.GONE);
                ToastUtils.showToast(getContext(), error.toString(), Toast.LENGTH_LONG);
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(getValue(baseJob));
    }

    /**
     * @return the Url depending on the passed {@link BaseJob} instance
     */
    public String getValue(Object o) {
        String url = null;
        if (o instanceof GitHubJob) {
            url = ((GitHubJob) o).getCompanyUrl();
        } else if (o instanceof SearchGovJob) {
            url = ((SearchGovJob) o).getUrl();
        }
        return url;
    }
}

