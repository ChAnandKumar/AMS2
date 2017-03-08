package com.bartronics.ams2.ui.base;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

import io.reactivex.disposables.CompositeDisposable;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class BasePresenter<T extends MvpView> implements Presenter<T> {

    //private final DataManager mDataManager;
    private T mMvpView;
    //private CompositeDisposable mCompositeDisposable;



    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
        //mCompositeDisposable.dispose();
    }

    public boolean isViewAttached(){
       return mMvpView != null;
    }

    public T getMvpView(){
        return mMvpView;
    }

    public void checkViewAttached(){
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }

   /* @Inject
    CompositeDisposable disposable;*/
   /* @Inject
    public BasePresenter(CompositeDisposable compositeDisposable){
        this.mCompositeDisposable = compositeDisposable;
    }
*/

   /* @Inject
    public BasePresenter(AppDataManager dataManager, CompositeDisposable compositeDisposable) {
        this.mDataManager = dataManager;
        this.mCompositeDisposable = compositeDisposable;
    }*/



   /* public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public AppDataManager getDataManager() {
        return mDataManager;
    }

    @Inject
    public BasePresenter(AppDataManager dataManager, CompositeDisposable compositeDisposable){
        this.mDataManager = dataManager;
        this.mCompositeDisposable = compositeDisposable;
    }
*/

   /*@Inject
    public BasePresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        this.mDataManager = dataManager;
        this.mCompositeDisposable = compositeDisposable;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }*/
   public CompositeDisposable getCompositeDisposable() {
       return new CompositeDisposable();
   }

}
