package com.example.jehad.jobfinder.test.rest;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jehad.jobfinder.base.BaseRecyclerViewAdapter;
import com.example.jehad.jobfinder.test.model.job.GitHubJob;
import com.example.jehad.jobfinder.test.model.filter.QueryFilter;
import com.example.jehad.jobfinder.test.model.job.SearchGovJob;
import com.example.jehad.jobfinder.util.DataTypeUtils;
import com.example.jehad.jobfinder.util.ToastUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * The Repository Class for get the jobs from every Provider.
 */
public class ProviderApiRepository {

    public static void getGitHubJobList(final Context context, final BaseRecyclerViewAdapter baseRecyclerViewAdapter, final ProgressBar progressBar, QueryFilter queryFilter, ApiProviderInterface.Github apiProviderGithub) {
        if (!DataTypeUtils.isNull(progressBar)) {
            progressBar.setVisibility(View.VISIBLE);
        }
        apiProviderGithub.getGitHubJobList(
                !DataTypeUtils.isNullOrEmpty(queryFilter.getPosition()) ? queryFilter.getPosition() : null,
                !DataTypeUtils.isNull(queryFilter.getLatLng()) ? queryFilter.getLatLng().latitude : null,
                !DataTypeUtils.isNull(queryFilter.getLatLng()) ? queryFilter.getLatLng().longitude : null)
                .enqueue(new Callback<List<GitHubJob>>() {
                    @Override
                    public void onResponse(Call<List<GitHubJob>> call, Response<List<GitHubJob>> response) {
                        if (!DataTypeUtils.isNull(baseRecyclerViewAdapter)) {
                            baseRecyclerViewAdapter.updateList(response.body());
                        }

                        if (!DataTypeUtils.isNull(progressBar)) {
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<GitHubJob>> call, Throwable t) {
                        ToastUtils.showToast(context, t.getMessage(), Toast.LENGTH_SHORT);
                        if (!DataTypeUtils.isNull(progressBar)) {
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }

    public static void getSearchGovJobList(final Context context, final BaseRecyclerViewAdapter baseRecyclerViewAdapter, final ProgressBar progressBar, QueryFilter queryFilter, ApiProviderInterface.SearchGov apiProviderSearchGov) {
        if (!DataTypeUtils.isNull(progressBar)) {
            progressBar.setVisibility(View.VISIBLE);
        }
        apiProviderSearchGov.getSearchGovJobList(
                !DataTypeUtils.isNullOrEmpty(queryFilter.getPosition()) ? queryFilter.getPosition() : null,
                !DataTypeUtils.isNullOrEmpty(queryFilter.getLatLngSum()) ? queryFilter.getLatLngSum() : null)
                .enqueue(new Callback<List<SearchGovJob>>() {
                    @Override
                    public void onResponse(Call<List<SearchGovJob>> call, Response<List<SearchGovJob>> response) {
                        if (!DataTypeUtils.isNull(baseRecyclerViewAdapter)) {
                            baseRecyclerViewAdapter.updateList(response.body());
                        }

                        if (!DataTypeUtils.isNull(progressBar)) {
                            progressBar.setVisibility(View.GONE);
                        }

                    }

                    @Override
                    public void onFailure(Call<List<SearchGovJob>> call, Throwable t) {
                        ToastUtils.showToast(context, t.getMessage(), Toast.LENGTH_SHORT);
                        if (!DataTypeUtils.isNull(progressBar)) {
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }

}
