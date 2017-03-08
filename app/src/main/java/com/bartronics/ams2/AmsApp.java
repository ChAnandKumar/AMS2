package com.bartronics.ams2;

import android.app.Application;

import com.amitshekhar.DebugDB;
import com.bartronics.ams2.data.DataManager;
import com.bartronics.ams2.di.component.ApplicationComponent;
import com.bartronics.ams2.di.component.BusComponent;
import com.bartronics.ams2.di.component.DaggerApplicationComponent;
import com.bartronics.ams2.di.component.DaggerBusComponent;
import com.bartronics.ams2.di.module.ApplicationModule;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

public class AmsApp extends Application{

    private ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;
    private static BusComponent sBusComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            DebugDB.getAddressLog();
        }

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        sBusComponent = DaggerBusComponent.create();

        applicationComponent.inject(this);

    }

    public static BusComponent getBusComponent() {
        return sBusComponent;
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }



    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }
}
