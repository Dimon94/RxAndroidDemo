package com.dimon.rxandroiddemo;

import android.app.Application;

import com.dimon.rxandroiddemo.internal.components.AppComponent;

/**
 * 应用信息:项目的应用, 把Application添加至组件, 并提供注册类的图接口.
 * Created by Dimon on 2016/3/17.
 */

public class AndroidApplication extends Application {
    private static AndroidGraph mAndroidGraph;
    private static AndroidApplication mInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        buildComponentAndInject();
    }


    public static AndroidGraph component() {
        return mAndroidGraph;
    }

    public static void buildComponentAndInject() {
        mAndroidGraph = AppComponent.Initializer.init(mInstance);
    }

}