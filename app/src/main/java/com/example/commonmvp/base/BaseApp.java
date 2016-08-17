package com.example.commonmvp.base;

import android.app.Application;

/**
 * @Desc: TODO
 */
public class BaseApp extends Application {

    public static final int DEBUG_LEVEL_NONE = 0;
    public static final int DEBUG_LEVEL_SIMPLE = 1;
    public static final int DEBUG_LEVEL_DETAIL = 2;

    public static int DEBUG_LEVEL = DEBUG_LEVEL_DETAIL; // log 级别
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
