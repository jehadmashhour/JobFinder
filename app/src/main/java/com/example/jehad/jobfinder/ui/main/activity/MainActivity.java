package com.example.jehad.jobfinder.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.jehad.jobfinder.R;
import com.example.jehad.jobfinder.base.BaseActivity;
import com.example.jehad.jobfinder.constants.RequestCodes;
import com.example.jehad.jobfinder.data.model.filter.QueryFilter;
import com.example.jehad.jobfinder.data.rest.api.ProviderApiRepository;
import com.example.jehad.jobfinder.ui.details.JobDetailsActivity;
import com.example.jehad.jobfinder.ui.main.adapter.JobsAdapter;
import com.example.jehad.jobfinder.ui.main.dialogs.FilterCustomViewAlertDialog;
import com.example.jehad.jobfinder.callback.OnFilterListener;
import com.example.jehad.jobfinder.callback.OnItemClickListener;
import com.example.jehad.jobfinder.util.DataTypeUtils;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import java.util.List;

import butterknife.BindView;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Response;

/**
 * The responsible Activity on Showing the Main Activity Jobs in {@link RecyclerView} with filtration
 */
public class MainActivity extends BaseActivity implements OnItemClickListener {


    @BindView(R.id.rv_jobs_mainAc)
    RecyclerView jobsRecyclerView;
    @BindView(R.id.pb_mainAct)
    ProgressBar progressBar;

    private JobsAdapter jobsAdapter;

    private FilterCustomViewAlertDialog filterCustomViewDialog;

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public void initializer() {
        setupRecyclerView();
        showAllJobsList(new QueryFilter());
    }


    /**
     * Setup the recycler view logic
     */
    private void setupRecyclerView() {
        jobsAdapter = new JobsAdapter(this);
        jobsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        jobsRecyclerView.setHasFixedSize(true);
        jobsRecyclerView.setAdapter(jobsAdapter);
    }

    /**
     * Show all the jobs list
     *
     * @param queryFilter the selected Query Filter Object
     */
    private void showAllJobsList(QueryFilter queryFilter) {
        ProviderApiRepository.showAllJobsList(this, queryFilter);
    }

    /**
     * Do filtering on the jobs list
     *
     * @param queryFilter the selected Query Filter Object
     */
    private void doFilter(QueryFilter queryFilter) {

        if (!DataTypeUtils.isNull(queryFilter.getBaseProvider())) {
            ProviderApiRepository.showOneJobsList(this, queryFilter);
        } else {
            showAllJobsList(queryFilter);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filter:
                filterCustomViewDialog = FilterCustomViewAlertDialog.getInstance(this, R.style.CustomDialog, true, true, new OnFilterListener() {
                    @Override
                    public void onDone(QueryFilter queryFilter) {
                        jobsAdapter.clearList();
                        doFilter(queryFilter);
                    }
                }).show();


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * On click on one item of the adapter jobs items
     *
     * @param view
     * @param position
     * @param o
     */
    @Override
    public void onClick(View view, int position, Object o) {
        startActivity(JobDetailsActivity.createIntent(this, o));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RequestCodes.AUTO_COMPLETE_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    Place place = PlaceAutocomplete.getPlace(this, data);
                    filterCustomViewDialog.setPlace(place);
                }
                break;
        }
    }

    @Override
    public void onBegin() {
        progressBar.setVisibility(View.VISIBLE);
        super.onBegin();
    }

    @Override
    public void onResponse(Object o) {
        super.onResponse(o);
        jobsAdapter.updateList((List) o);
        progressBar.setVisibility(View.GONE);
    }


    @Override
    public void onFailure(Throwable t) {
        super.onFailure(t);
        progressBar.setVisibility(View.GONE);
    }
}
