package com.bartronics.ams2.di.component;

import com.bartronics.ams2.di.PerActivity;
import com.bartronics.ams2.di.module.ActivityModule;
import com.bartronics.ams2.ui.add_data.AddDataActivity;
import com.bartronics.ams2.ui.home.Home;
import com.bartronics.ams2.ui.splash.SplashActivity;

import dagger.Subcomponent;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

@PerActivity
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(SplashActivity activity);

    void inject(Home home);

    void inject(AddDataActivity addDataActivity);
    //@ConfigPersistent CompositeDisposable getCompositeDisposable();


}
