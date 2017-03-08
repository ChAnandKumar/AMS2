package com.bartronics.ams2.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bartronics.ams2.R;
import com.bartronics.ams2.data.db.model.PModel;
import com.bartronics.ams2.ui.add_data.AddDataActivity;
import com.bartronics.ams2.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

public class Home extends BaseActivity implements HomeMvpView {

    @Inject
    HomePresenter homePresenter;
    @BindView(R.id.people_rv)
    RecyclerView peopleRv;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.add_data_button)
    Button addDataButton;

    private List<PModel> profileList = new ArrayList<>();
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        ButterKnife.bind(this);
        viewIns();
        activityComponent().inject(this);
        homePresenter.attachView(this);
        homePresenter.loadProfileData();
    }

    void viewIns(){

        mAdapter = new HomeAdapter(profileList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        peopleRv.setLayoutManager(mLayoutManager);
        peopleRv.setItemAnimator(new DefaultItemAnimator());
        peopleRv.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add_emp:
                startActivity(new Intent(this,AddDataActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showLoading() {
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError() {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void hideLoading() {
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void loadProfileDataInAdapter(List<PModel> profileList) {
        mAdapter.addProfileDataInList(profileList);
        peopleRv.scrollToPosition(profileList.size()-1);
    }

    @Override
    public void nextActivity() {

    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(getWindow().getDecorView().getRootView(),message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showNoDataMessage() {
        addDataButton.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideMessage() {
        addDataButton.setVisibility(View.GONE);
        textView.setVisibility(View.GONE);
    }

    @OnClick(R.id.add_data_button)
    public void onClick() {
        startActivity(new Intent(this, AddDataActivity.class));
    }
}
