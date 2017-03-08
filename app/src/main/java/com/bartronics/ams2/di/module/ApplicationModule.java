package com.bartronics.ams2.di.module;

import android.app.Application;
import android.content.Context;

import com.bartronics.ams2.data.AppDataManager;
import com.bartronics.ams2.data.DataManager;
import com.bartronics.ams2.data.db.AppDbHelper;
import com.bartronics.ams2.data.db.DbHelper;
import com.bartronics.ams2.di.ApplicationContext;
import com.bartronics.ams2.di.DatabaseInfo;
import com.bartronics.ams2.util.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }
}
