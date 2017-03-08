package com.bartronics.ams2.data.db;

import com.bartronics.ams2.data.db.model.DaoMaster;
import com.bartronics.ams2.data.db.model.DaoSession;
import com.bartronics.ams2.data.db.model.PModel;
import com.bartronics.ams2.data.db.model.RModel;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by anand.chandaliya on 08-03-2017.
 */

public class AppDbHelper implements DbHelper{

    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }


    @Override
    public Observable<List<RModel>> getAllReportData() {
        return Observable.fromCallable(new Callable<List<RModel>>() {
            @Override
            public List<RModel> call() throws Exception {
                return mDaoSession.getRModelDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Long> insertReport(final RModel report) {
        return Observable.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return mDaoSession.getRModelDao().insert(report);
            }
        });
    }

    @Override
    public Observable<Long> insertProfile(final PModel profile) {
        return Observable.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return mDaoSession.getPModelDao().insert(profile);
            }
        });
    }

    @Override
    public Observable<List<PModel>> getProfileData() {
        return Observable.fromCallable(new Callable<List<PModel>>() {
            @Override
            public List<PModel> call() throws Exception {
                return mDaoSession.getPModelDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Boolean> isProfileEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !(mDaoSession.getPModelDao().count()>0);
            }
        });
    }

    @Override
    public Observable<Boolean> isReportEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !(mDaoSession.getRModelDao().count() > 0);
            }
        });
    }

    @Override
    public Observable<Boolean> saveProfile(final PModel profile) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getPModelDao().saveInTx(profile);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveReport(final RModel report) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getRModelDao().saveInTx(report);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveProfileList(final List<PModel> profileList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getPModelDao().saveInTx(profileList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveReportList(final List<RModel> reportList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getRModelDao().saveInTx(reportList);
                return true;
            }
        });
    }
}
