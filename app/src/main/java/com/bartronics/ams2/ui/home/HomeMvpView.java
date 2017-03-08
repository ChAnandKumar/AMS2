package com.bartronics.ams2.ui.home;

import com.bartronics.ams2.data.db.model.PModel;
import com.bartronics.ams2.ui.base.MvpView;

import java.util.List;

/**
 * Created by anand.chandaliya on 06-03-2017.
 */

public interface HomeMvpView extends MvpView {
    void showLoading();
    void showError();
    void showNetworkError();

    void hideLoading();

    void loadProfileDataInAdapter(List<PModel> profileList);

    void nextActivity();
    void showMessage(String message);

    void showNoDataMessage();

    void hideMessage();
}
