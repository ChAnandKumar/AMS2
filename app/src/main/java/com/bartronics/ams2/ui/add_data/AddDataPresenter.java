package com.bartronics.ams2.ui.add_data;

import com.bartronics.ams2.AmsApp;
import com.bartronics.ams2.data.DataManager;
import com.bartronics.ams2.data.db.model.PModel;
import com.bartronics.ams2.di.ConfigPersistent;
import com.bartronics.ams2.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anand.chandaliya on 06-03-2017.
 */

@ConfigPersistent
public class AddDataPresenter extends BasePresenter<AddDataMvpView>{


    private final DataManager dataManager;
    private CompositeDisposable compositeDisposable;

    @Inject
    public AddDataPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(AddDataMvpView mvpView) {
        super.attachView(mvpView);
        if(compositeDisposable == null){
            compositeDisposable = getCompositeDisposable();
        }
    }

    @Override
    public void detachView() {
        if(compositeDisposable != null)
            compositeDisposable.dispose();
        super.detachView();
    }

    public void saveData(PModel profile){

        checkViewAttached();

        compositeDisposable.add(dataManager.saveProfile(profile)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if(aBoolean) {
                    getMvpView().showMessage("Data added");
                    getMvpView().finishActivity();
                    AmsApp.getBusComponent().getSubject().onNext("Refresh");

                }
                else {
                    getMvpView().showMessage("Data not added");
                }
            }
        }));



    }




}
