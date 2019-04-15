package com.example.jehad.jobfinder.callback;

import retrofit2.Call;
import retrofit2.Response;

public interface OnResponseListener<T> {
    void onBegin();

    <T>void onResponse(Call<T> call, Response<T> response);

    <T>void onFailure(Call<T> call, Throwable t);
}
