package com.example.commonmvp.utils.log;

import android.os.Environment;

import java.io.File;

/**
 * Created by Administrator on 2016/8/30.
 */
public class LogConfig {

    public static final String TAG = "LogUtil";

    public static final int LOG_RECORD_LEVEL = LogLevel.LOG_RECORD_LEVEL_RECORD;
    public static final int DEBUG_LEVEL = LogLevel.DEBUG_LEVEL_SIMPLE; // log 级别

    public static final String LOG_DIR = Environment.getExternalStorageDirectory() + File.separator + "LogRecorder"; // 日志文件
    public static final String LOG_FILENAME = "record.txt";
}
