package com.bartronics.ams2.ui.splash;

import android.os.SystemClock;

import com.bartronics.ams2.data.DataManager;
import com.bartronics.ams2.di.ConfigPersistent;
import com.bartronics.ams2.ui.base.BasePresenter;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */
@ConfigPersistent
/*public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> implements SplashMvpPresenter<V>*/
public class SplashPresenter extends BasePresenter<SplashMvpView> {


    private DataManager dataManager;

    /*@Inject
    SplashPresenter( CompositeDisposable compositeDisposable) {
        super( compositeDisposable);
    }*/


    //CompositeDisposable compositeDisposable;

    @Inject
    public SplashPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }



    @Override
    public void attachView(SplashMvpView mvpView) {
        super.attachView(mvpView);
        if(compositeDisposable == null){
            compositeDisposable = getCompositeDisposable();
        }
        Timber.e("in load attachView...........");

    }

    @Override
    public void detachView() {
        Timber.d("in load detachView...........");
        //getCompositeDisposable().dispose();
        if(compositeDisposable != null)
            compositeDisposable.dispose();
        super.detachView();
    }


    //@Inject
    CompositeDisposable compositeDisposable;
    public void loadSplashScreen(){


        checkViewAttached();
        Timber.i("in load splash...........");

        compositeDisposable.add(sampleObservable()
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<String>() {
                    @Override
                    public void onComplete() {
                        Timber.d( " onComplete");
                        //getMvpView().showMessage(" onComplete");
                        getMvpView().nextActivity();

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.d(" onError : " + e.getMessage());
                        getMvpView().showMessage(" onError : " + e.getMessage());

                    }

                    @Override
                    public void onNext(String value) {
                        Timber.d(" onNext value : " + value);
                        //getMvpView().showMessage(" onNext : value : " + value);
                    }
                }));
    }

    static Observable<String> sampleObservable() {
        return Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                // Do some long running operation
                SystemClock.sleep(2000);
                return Observable.just("one", "two", "three", "four", "five");
            }
        });
    }


}
