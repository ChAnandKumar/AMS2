package com.bartronics.ams2.ui.home;

import com.bartronics.ams2.data.DataManager;
import com.bartronics.ams2.data.db.model.PModel;
import com.bartronics.ams2.di.ConfigPersistent;
import com.bartronics.ams2.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by anand.chandaliya on 06-03-2017.
 */
@ConfigPersistent
public class HomePresenter extends BasePresenter<HomeMvpView> {


    private DataManager dataManager;

    private CompositeDisposable compositeDisposable;




    /*@Inject
    public HomePresenter( CompositeDisposable compositeDisposable) {
        super(compositeDisposable);
    }*/

    @Inject
    public HomePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }



    @Override
    public void attachView(HomeMvpView mvpView) {
        super.attachView(mvpView);
        if(compositeDisposable == null){
            compositeDisposable = getCompositeDisposable();
        }
        getMvpView().showLoading();
        Timber.i("HOme is attached..");
    }

    @Override
    public void detachView() {
        Timber.i("Home is detached...");
        if(compositeDisposable != null)
            compositeDisposable.dispose();
        super.detachView();
    }

    public void loadProfileData(){
        checkViewAttached();



        compositeDisposable.add(dataManager.getProfileData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<PModel>>() {
                    @Override
                    public void accept(List<PModel> profileList) throws Exception {
                        int profileSize = profileList.size();
                        getMvpView().showMessage("Profile list size is : "+profileSize);
                        getMvpView().hideLoading();
                        if(profileSize > 0){
                            getMvpView().hideMessage();
                            getMvpView().loadProfileDataInAdapter(profileList);
                        }else {
                            getMvpView().showNoDataMessage();
                        }
                    }
                }));
    }




    public void showLogMessage() {
        Timber.i("Home is showLogMessage...");

        //compositeDisposable.add()

        //getCompositeDisposable().add(dataManager);
    }
}
