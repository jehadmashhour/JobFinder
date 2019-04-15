package com.example.jehad.jobfinder.data.rest.api;

import com.example.jehad.jobfinder.data.model.job.GitHubJob;
import com.example.jehad.jobfinder.data.model.job.SearchGovJob;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiProviderInterface {


    interface Github  {
        @GET("https://jobs.github.com/positions.json")
        Call<List<GitHubJob>> getGitHubJobList(@Query("description") String description, @Query("lat") Double lat, @Query("long") Double lon);
    }

    interface SearchGov {
        @GET("https://jobs.search.gov/jobs/search")
        Call<List<SearchGovJob>> getSearchGovJobList(@Query("query") String query, @Query("lat_lon") String latLon);
    }
}
