package com.dimon.rxandroiddemo.network;

import com.dimon.rxandroiddemo.db.GDate;
import com.dimon.rxandroiddemo.db.GanWuData;
import com.dimon.rxandroiddemo.db.ImageData;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Dimon on 2016/3/17.
 */
public interface GanwuService {

    @GET("/data/福利/" + 10 + "/{page}")
    Observable<ImageData> getImageData(
            @Path("page") int page);

    @GET("day/{year}/{month}/{day}")
    Observable<GanWuData> getGanWuData(
            @Path("year") int year,
            @Path("month") int month,
            @Path("day") String day);

    @GET("day/history")
    Observable<GDate> getHistory();

}
