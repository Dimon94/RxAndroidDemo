package com.dimon.rxandroiddemo.network;

import com.dimon.rxandroiddemo.db.HttpResult;
import com.dimon.rxandroiddemo.db.Subject;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Dimon on 2016/3/17.
 */
public interface MovieService {
    @GET("top250")
    Observable<HttpResult<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);
}
