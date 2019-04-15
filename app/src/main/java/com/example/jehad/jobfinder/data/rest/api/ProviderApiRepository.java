package com.example.jehad.jobfinder.data.rest.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import com.example.jehad.jobfinder.data.model.job.GitHubJob;
import com.example.jehad.jobfinder.data.model.filter.QueryFilter;
import com.example.jehad.jobfinder.data.model.job.SearchGovJob;
import com.example.jehad.jobfinder.data.rest.base.BaseProviderApiRepositoryUtils;
import com.example.jehad.jobfinder.util.DataTypeUtils;
import com.example.jehad.jobfinder.util.ToastUtils;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * The Repository Class for get the jobs from every Provider.
 */
@SuppressLint("CheckResult")
public class ProviderApiRepository extends BaseProviderApiRepositoryUtils {


    public static void getGitHubJobList(final Context context, QueryFilter queryFilter, ApiProviderInterface.Github apiProviderGithub) {

        apiProviderGithub.getGitHubJobList(
                !DataTypeUtils.isNullOrEmpty(queryFilter.getPosition()) ? queryFilter.getPosition() : null,
                !DataTypeUtils.isNull(queryFilter.getLatLng()) ? queryFilter.getLatLng().latitude : null,
                !DataTypeUtils.isNull(queryFilter.getLatLng()) ? queryFilter.getLatLng().longitude : null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new SingleObserver<List<GitHubJob>>() {
            @Override
            public void onSubscribe(Disposable d) {
                getBaseActivity(context).onBegin();
            }

            @Override
            public void onSuccess(List<GitHubJob> gitHubJobs) {
                getBaseActivity(context).onResponse(gitHubJobs);
            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(context, e.getMessage(), Toast.LENGTH_SHORT);
                getBaseActivity(context).onFailure(e);
            }
        });
    }

    public static void getSearchGovJobList(final Context context, QueryFilter queryFilter, ApiProviderInterface.SearchGov apiProviderSearchGov) {

        apiProviderSearchGov.getSearchGovJobList(
                !DataTypeUtils.isNullOrEmpty(queryFilter.getPosition()) ? queryFilter.getPosition() : null,
                !DataTypeUtils.isNullOrEmpty(queryFilter.getLatLngSum()) ? queryFilter.getLatLngSum() : null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new SingleObserver<List<SearchGovJob>>() {
            @Override
            public void onSubscribe(Disposable d) {
                getBaseActivity(context).onBegin();
            }

            @Override
            public void onSuccess(List<SearchGovJob> searchGovJobs) {
                getBaseActivity(context).onResponse(searchGovJobs);
            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(context, e.getMessage(), Toast.LENGTH_SHORT);
                getBaseActivity(context).onFailure(e);
            }
        });

    }

}
