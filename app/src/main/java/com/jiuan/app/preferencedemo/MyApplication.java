package com.jiuan.app.preferencedemo;

import android.app.Application;

import com.facebook.stetho.Stetho;


/**
 * Created by ZhangKong on 2015/7/8.
 */
public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
