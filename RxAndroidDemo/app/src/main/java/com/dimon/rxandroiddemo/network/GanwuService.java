package com.dimon.rxandroiddemo.network;

import com.dimon.rxandroiddemo.db.GanWuData;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Dimon on 2016/3/17.
 */
public interface GanwuService {
//    @GET("/data/福利/" + 10 + "/{page}")
//    Observable<MeizhiData> getMeizhiData(
//            @Path("page") int page);

    @GET("day/{year}/{month}/{day}")
    Observable<GanWuData> getGanWuData(
            @Path("year") int year,
            @Path("month") int month,
            @Path("day") int day);
}
