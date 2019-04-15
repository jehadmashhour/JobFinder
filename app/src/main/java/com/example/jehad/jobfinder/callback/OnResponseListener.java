package com.example.jehad.jobfinder.callback;

import retrofit2.Call;
import retrofit2.Response;

public interface OnResponseListener<T> {
    void onBegin();

    void onResponse(T t);

    void onFailure(Throwable t);
}
