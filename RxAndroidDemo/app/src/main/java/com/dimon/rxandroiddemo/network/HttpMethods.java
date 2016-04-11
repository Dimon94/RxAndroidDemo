package com.dimon.rxandroiddemo.network;

import com.dimon.rxandroiddemo.db.GDate;
import com.dimon.rxandroiddemo.db.entity.Image;
import com.dimon.rxandroiddemo.db.entity.Item;
import com.dimon.rxandroiddemo.util.GanWuDataToItemsMapper;
import com.socks.library.KLog;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dimon on 2016/3/17.
 */
public class HttpMethods {

    public static final String BASE_URL = "http://gank.io/api/";

    private static final int DEFAULT_TIMEOUT = 5;


    private Retrofit retrofit;
    private GanwuService ganwuService;
    protected Subscription subscription;

    //构造方法私有
    private HttpMethods(){
        //手动创建一个OKHttpClient并设置超时时间

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClientBuilder.build())
                .build();
        ganwuService = retrofit.create(GanwuService.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder{
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    //获取单例
    public static HttpMethods getInstance(){
        return SingletonHolder.INSTANCE;
    }


    /**
     * 用于获取Gank里新闻消息
     * @param subscriber 由调用者传过来的观察者对象
     *
     */
    public void getGanWu(Subscriber<List<Item>> subscriber){
        KLog.a(ganwuService);
        unsubscribe();
        Observable observable = ganwuService.getGanWuData(2016,04,"08")
                .map(GanWuDataToItemsMapper.getInstance());
        KLog.a(observable);
        toSubscribe(observable, subscriber);
    }

    /**
     * 用于获取Gank里图片
     * @param subscriber
     */
    public void getImage(Subscriber<List<Image>> subscriber){
        unsubscribe();

    }

    /**
     * 用于获取Gank里历史日期
     * @param subscriber
     */
    public void getGDate(Subscriber<GDate> subscriber){

    }
    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s){
        subscription = o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }




}
