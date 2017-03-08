package com.bartronics.ams2.data;

import com.bartronics.ams2.data.db.DbHelper;

import io.reactivex.Observable;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

public interface DataManager extends DbHelper{

    Observable<Boolean> loadProfileData();
    Observable<Boolean> loadReport();
}
