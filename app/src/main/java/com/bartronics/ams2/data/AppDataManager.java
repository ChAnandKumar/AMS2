package com.bartronics.ams2.data;

import android.content.Context;

import com.bartronics.ams2.data.db.DbHelper;
import com.bartronics.ams2.data.db.model.PModel;
import com.bartronics.ams2.data.db.model.RModel;
import com.bartronics.ams2.di.ApplicationContext;
import com.bartronics.ams2.util.AppConstants;
import com.bartronics.ams2.util.CommonUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

@Singleton
public class AppDataManager implements DataManager {

    private Context context;
    private DbHelper dbHelper;
    private DataManager dataManager;

    @Inject
    public AppDataManager(@ApplicationContext Context context,DbHelper dbHelper) {
        this.context = context;
        this.dbHelper = dbHelper;
    }


    @Override
    public Observable<Boolean> loadProfileData() {
        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();
        return dbHelper.isProfileEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty) throws Exception {

                        if(isEmpty){
                            Type type = new TypeToken<List<RModel>>() {
                            }
                                    .getType();
                            List<RModel> optionList = gson.fromJson(
                                    CommonUtils.loadJSONFromAsset(context,
                                            AppConstants.SEED_DATABASE_PROFILE),
                                    type);

                            return saveReportList(optionList);
                        }

                        return Observable.just(false);
                    }
                });
    }

    @Override
    public Observable<Boolean> loadReport() {
        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        return dbHelper.isProfileEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty)
                            throws Exception {
                        if (isEmpty) {
                            Type type = new TypeToken<List<PModel>>() {
                            }
                                    .getType();
                            List<PModel> optionList = gson.fromJson(
                                    CommonUtils.loadJSONFromAsset(context,
                                            AppConstants.SEED_DATABASE_REPORT),
                                    type);

                            return saveProfileList(optionList);
                        }
                        return Observable.just(false);
                    }
                });
    }

    @Override
    public Observable<List<RModel>> getAllReportData() {
        return dbHelper.getAllReportData();
    }

    @Override
    public Observable<Long> insertReport(RModel report) {
        return dbHelper.insertReport(report);
    }

    @Override
    public Observable<Long> insertProfile(PModel profile) {
        return dbHelper.insertProfile(profile);
    }

    @Override
    public Observable<List<PModel>> getProfileData() {
        return dbHelper.getProfileData();
    }

    @Override
    public Observable<Boolean> isProfileEmpty() {
        return dbHelper.isProfileEmpty();
    }

    @Override
    public Observable<Boolean> isReportEmpty() {
        return dbHelper.isReportEmpty();
    }

    @Override
    public Observable<Boolean> saveProfile(PModel profile) {
        return dbHelper.saveProfile(profile);
    }

    @Override
    public Observable<Boolean> saveReport(RModel report) {
        return dbHelper.saveReport(report);
    }

    @Override
    public Observable<Boolean> saveProfileList(List<PModel> profileList) {
        return dbHelper.saveProfileList(profileList);
    }

    @Override
    public Observable<Boolean> saveReportList(List<RModel> reportList) {
        return dbHelper.saveReportList(reportList);
    }
}
