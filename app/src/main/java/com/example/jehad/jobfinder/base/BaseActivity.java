package com.example.jehad.jobfinder.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jehad.jobfinder.R;
import com.example.jehad.jobfinder.callback.OnResponseListener;

import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Response;

/**
 * The super class for every instance of {@link android.app.Activity} so every activity should be extend from {@link BaseActivity}
 */
public abstract class BaseActivity extends AppCompatActivity implements OnResponseListener {

    /**
     * @return Get the current activity layout res id
     */
    @LayoutRes
    protected abstract int layoutRes();

    /**
     * Using {@link ButterKnife} library to bind the view of XMl with its fields
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutRes());
        ButterKnife.bind(this);
        initializer();
    }


    protected abstract void initializer();

    protected Context getContext() {
        return this;
    }

    @Override
    public void onBegin() {

    }

    @Override
    public void onResponse(Object o) {

    }

    @Override
    public void onFailure(Throwable t) {

    }
}
