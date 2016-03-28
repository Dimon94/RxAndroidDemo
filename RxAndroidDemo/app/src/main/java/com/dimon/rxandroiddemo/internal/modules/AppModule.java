package com.dimon.rxandroiddemo.internal.modules;

import android.app.Application;

import com.dimon.rxandroiddemo.AndroidApplication;

import javax.annotation.Resources;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dimon on 2016/3/17.
 */
@Module
public class AppModule {
    private final AndroidApplication mApp;

    public AppModule(AndroidApplication app){
        mApp = app;
    }

    @Provides
    @Singleton
    protected Application provideApp(){  //提供Application
        return mApp;
    }

    @Provides
    @Singleton
    protected Resources provideResources(){
        return (Resources) mApp.getResources();
    }
}
