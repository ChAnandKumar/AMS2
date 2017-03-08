package com.bartronics.ams2.data.db;

import com.bartronics.ams2.data.db.model.PModel;
import com.bartronics.ams2.data.db.model.RModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by anand.chandaliya on 08-03-2017.
 */

public interface DbHelper {

    Observable<List<RModel>> getAllReportData();

    Observable<Long> insertReport(RModel report);

    Observable<Long> insertProfile(PModel profile);

    Observable<List<PModel>> getProfileData();

    Observable<Boolean> isProfileEmpty();

    Observable<Boolean> isReportEmpty();

    Observable<Boolean> saveProfile(PModel profile);

    Observable<Boolean> saveReport(RModel report);

    Observable<Boolean> saveProfileList(List<PModel> profileList);

    Observable<Boolean> saveReportList(List<RModel> reportList);

}
