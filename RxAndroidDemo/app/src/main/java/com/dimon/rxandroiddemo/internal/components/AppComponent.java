package com.dimon.rxandroiddemo.internal.components;

import com.dimon.rxandroiddemo.AndroidApplication;
import com.dimon.rxandroiddemo.AndroidGraph;
import com.dimon.rxandroiddemo.internal.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Dimon on 2016/3/17.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent extends AndroidGraph {
    final class Initializer{
        private Initializer(){
            // No instances.
        }

        //初始化组件
        public static AppComponent init(AndroidApplication app){
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .build();
        }
    }

}
