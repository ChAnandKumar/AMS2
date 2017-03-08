package com.bartronics.ams2.di.component;

import android.app.Application;
import android.content.Context;

import com.bartronics.ams2.AmsApp;
import com.bartronics.ams2.data.DataManager;
import com.bartronics.ams2.di.ApplicationContext;
import com.bartronics.ams2.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {


    void inject(AmsApp amsApp);


    @ApplicationContext
    Context context();

    Application application();



    DataManager getDataManager();
}

