package com.example.commonmvp.base;

import android.app.Application;

/**
 * @Desc: TODO
 */
public class BaseApp extends Application {

    public static final int ENV = 1; // url 环境

    private static Application sInstance;

    public static Application getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

    }
}
