package com.example.jehad.jobfinder.data.rest;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jehad.jobfinder.base.BaseRecyclerViewAdapter;
import com.example.jehad.jobfinder.data.model.job.GitHubJob;
import com.example.jehad.jobfinder.data.model.filter.QueryFilter;
import com.example.jehad.jobfinder.data.model.job.SearchGovJob;
import com.example.jehad.jobfinder.util.DataTypeUtils;
import com.example.jehad.jobfinder.util.ToastUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * The Repository Class for get the jobs from every Provider.
 */
public class ProviderApiRepository extends BaseProviderApiRepositoryUtils {

    public static void getGitHubJobList(final Context context, QueryFilter queryFilter, ApiProviderInterface.Github apiProviderGithub) {
        getBaseActivity(context).onBegin();

        apiProviderGithub.getGitHubJobList(
                !DataTypeUtils.isNullOrEmpty(queryFilter.getPosition()) ? queryFilter.getPosition() : null,
                !DataTypeUtils.isNull(queryFilter.getLatLng()) ? queryFilter.getLatLng().latitude : null,
                !DataTypeUtils.isNull(queryFilter.getLatLng()) ? queryFilter.getLatLng().longitude : null)
                .enqueue(new Callback<List<GitHubJob>>() {
                    @Override
                    public void onResponse(Call<List<GitHubJob>> call, Response<List<GitHubJob>> response) {
                        getBaseActivity(context).onResponse(call, response);
                    }

                    @Override
                    public void onFailure(Call<List<GitHubJob>> call, Throwable t) {
                        ToastUtils.showToast(context, t.getMessage(), Toast.LENGTH_SHORT);
                        getBaseActivity(context).onFailure(call, t);
                    }
                });
    }

    public static void getSearchGovJobList(final Context context, QueryFilter queryFilter, ApiProviderInterface.SearchGov apiProviderSearchGov) {
        getBaseActivity(context).onBegin();

        apiProviderSearchGov.getSearchGovJobList(
                !DataTypeUtils.isNullOrEmpty(queryFilter.getPosition()) ? queryFilter.getPosition() : null,
                !DataTypeUtils.isNullOrEmpty(queryFilter.getLatLngSum()) ? queryFilter.getLatLngSum() : null)
                .enqueue(new Callback<List<SearchGovJob>>() {
                    @Override
                    public void onResponse(Call<List<SearchGovJob>> call, Response<List<SearchGovJob>> response) {
                        getBaseActivity(context).onResponse(call, response);

                    }

                    @Override
                    public void onFailure(Call<List<SearchGovJob>> call, Throwable t) {
                        ToastUtils.showToast(context, t.getMessage(), Toast.LENGTH_SHORT);
                        getBaseActivity(context).onFailure(call, t);
                    }
                });
    }

}
