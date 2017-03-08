package com.bartronics.ams2.ui.splash;

import com.bartronics.ams2.ui.base.MvpView;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

public interface SplashMvpView extends MvpView {

    void showLoading();
    void showError();
    void showNetworkError();

    void nextActivity();
    void showMessage(String message);
}
