package com.example.commonmvp.utils;

import android.util.Log;

/**
 * logUtil
 */
public class LogUtil {

    public static final boolean isDebug = true; // 应放到 Application
    private static final String TAG = "LogUtils";

    public static void e(String msg) {
        if (!isDebug) {
            return;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String methodInfo = "";
        if (stackTrace.length >= 3) {
            // stackTrace[3],取第四个的原因是前两个分别为vm和Thread的方法，第三个是当前的方法e()，调用e()的方法是第四个。
            StackTraceElement element = stackTrace[3];
            String fileName = element.getFileName();
            fileName = fileName.replace(".java", "");
            methodInfo = "[" + fileName + "#" + element.getMethodName() + "() Line:" + element.getLineNumber() + "]";
        }
        Log.e(TAG, methodInfo + msg);
    }

    public static void d(String msg) {
        if (!isDebug) {
            return;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String methodInfo = "";
        if (stackTrace.length >= 3) {
            // stackTrace[3],取第四个的原因是前两个分别为vm和Thread的方法，第三个是当前的方法e()，调用e()的方法是第四个。
            StackTraceElement element = stackTrace[3];
            String fileName = element.getFileName();
            fileName = fileName.replace(".java", "");
            methodInfo = "[" + fileName + "#" + element.getMethodName() + "() Line:" + element.getLineNumber() + "]";
        }
        Log.d(TAG, methodInfo + msg);
    }
}