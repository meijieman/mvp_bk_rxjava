package com.example.commonmvp.utils;

import android.util.Log;

import com.example.commonmvp.base.BaseApp;

/**
 * logUtil
 */
public class LogUtil {

    private static final String TAG = "LogUtil";

    public static void e(String msg) {
        if (!BaseApp.isDebug) {
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
        if (!BaseApp.isDebug) {
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

    /**
     * 打印详细调用栈
     */
    public static void m(String msg) {
        if (BaseApp.isDebug) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String str = "[debug "
                         + stackTrace[3].getFileName().replace(".java", "") + "#" + stackTrace[3].getMethodName() + " line:" + stackTrace[3].getLineNumber() + " "
                         + stackTrace[4].getFileName().replace(".java", "") + "#" + stackTrace[4].getMethodName() + " line:" + stackTrace[4].getLineNumber() + " "
                         + stackTrace[5].getFileName().replace(".java", "") + "#" + stackTrace[5].getMethodName() + " line:" + stackTrace[5].getLineNumber() + "]";
            Log.e(TAG, str + msg);
        }
    }
}