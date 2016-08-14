package com.example.commonmvp.base;

import android.app.Application;

/**
 * @Desc: TODO
 */
public class BaseApp extends Application {

    private static Application sInstance;

    public static final boolean isDebug = true; // log 开关

    public static final int ENV = 1; // url 环境


    public static Application getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

    }
}
