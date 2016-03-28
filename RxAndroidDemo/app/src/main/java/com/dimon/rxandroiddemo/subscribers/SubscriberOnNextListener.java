package com.dimon.rxandroiddemo.subscribers;

/**
 * Created by Dimon on 2016/3/28.
 */
public interface SubscriberOnNextListener<T> {
    void onNext(T t);
}