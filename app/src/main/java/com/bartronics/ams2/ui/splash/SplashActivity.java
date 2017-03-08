package com.bartronics.ams2.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bartronics.ams2.R;
import com.bartronics.ams2.ui.base.BaseActivity;
import com.bartronics.ams2.ui.home.Home;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements SplashMvpView {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textView)
    TextView textView;


    /*@Inject
    SplashMvpPresenter<SplashMvpView> splashPresenter;*/


    @Inject
    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        activityComponent().inject(this);
        splashPresenter.attachView(this);
        splashPresenter.loadSplashScreen();
       // splashPresenter.attachView(this);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void nextActivity() {
        startActivity(new Intent(this, Home.class));
        finish();
    }

    @Override
    public void showMessage(String message) {
        textView.append(message);
        textView.append("\n");
    }
}
