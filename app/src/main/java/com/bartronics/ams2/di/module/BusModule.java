package com.bartronics.ams2.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by anand.chandaliya on 08-03-2017.
 */
@Module
public class BusModule {
    @Provides
    @Singleton
    static PublishSubject<String> provideSubject() {
        return PublishSubject.create();
    }

}
