package com.bartronics.ams2.di.component;

import com.bartronics.ams2.di.ConfigPersistent;
import com.bartronics.ams2.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */
@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);


}
