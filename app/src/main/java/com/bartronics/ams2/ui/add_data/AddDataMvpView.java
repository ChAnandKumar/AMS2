package com.bartronics.ams2.ui.add_data;

import com.bartronics.ams2.ui.base.MvpView;

/**
 * Created by anand.chandaliya on 06-03-2017.
 */

public interface AddDataMvpView extends MvpView{

    void showLoading();
    void showError();
    void showNetworkError();

    void addDtata();
    void showMessage(String message);

    void finishActivity();
}
