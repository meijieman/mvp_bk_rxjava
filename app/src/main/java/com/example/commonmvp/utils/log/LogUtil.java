package com.example.commonmvp.utils.log;

import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * logUtil
 */
public class LogUtil {

    /**
     * log 的打印
     */
    public static void e(String msg) {
        if (LogConfig.DEBUG_LEVEL == LogLevel.DEBUG_LEVEL_SIMPLE) {
            // 简单打印
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String methodInfo = "";
            if (stackTrace.length >= 3) {
                // stackTrace[3],取第四个的原因是前两个分别为vm和Thread的方法，第三个是当前的方法e()，调用e()的方法是第四个。
                StackTraceElement element = stackTrace[3];
                String fileName = element.getFileName();
                fileName = fileName.replace(".java", "");
                methodInfo = "[" + fileName + "#" + element.getMethodName() + "() Line:" + element.getLineNumber() + "] ";
            }
            Log.e(LogConfig.TAG, methodInfo + msg);
            recordLog(new Date().toLocaleString(), LogConfig.TAG, methodInfo + msg);
        } else if (LogConfig.DEBUG_LEVEL == LogLevel.DEBUG_LEVEL_DETAIL) {
            //  打印详细调用栈
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String str = "["
                    + stackTrace[3].getFileName().replace(".java", "") + "#" + stackTrace[3].getMethodName() + " line:" + stackTrace[3].getLineNumber() + "-->"
                    + stackTrace[4].getFileName().replace(".java", "") + "#" + stackTrace[4].getMethodName() + " line:" + stackTrace[4].getLineNumber() + "-->"
                    + stackTrace[5].getFileName().replace(".java", "") + "#" + stackTrace[5].getMethodName() + " line:" + stackTrace[5].getLineNumber() + "] ";
            Log.e(LogConfig.TAG, str + msg);
            recordLog(new Date().toLocaleString(), LogConfig.TAG, str + msg);
        }
    }

    public static void w(String msg) {
        if (LogConfig.DEBUG_LEVEL == LogLevel.DEBUG_LEVEL_SIMPLE) {
            // 简单打印
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String methodInfo = "";
            if (stackTrace.length >= 3) {
                // stackTrace[3],取第四个的原因是前两个分别为vm和Thread的方法，第三个是当前的方法e()，调用e()的方法是第四个。
                StackTraceElement element = stackTrace[3];
                String fileName = element.getFileName();
                fileName = fileName.replace(".java", "");
                methodInfo = "[" + fileName + "#" + element.getMethodName() + "() Line:" + element.getLineNumber() + "] ";
            }
            Log.w(LogConfig.TAG, methodInfo + msg);
            recordLog(new Date().toLocaleString(), LogConfig.TAG, methodInfo + msg);
        } else if (LogConfig.DEBUG_LEVEL == LogLevel.DEBUG_LEVEL_DETAIL) {
            //  打印详细调用栈
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String str = "["
                    + stackTrace[3].getFileName().replace(".java", "") + "#" + stackTrace[3].getMethodName() + " line:" + stackTrace[3].getLineNumber() + "-->"
                    + stackTrace[4].getFileName().replace(".java", "") + "#" + stackTrace[4].getMethodName() + " line:" + stackTrace[4].getLineNumber() + "-->"
                    + stackTrace[5].getFileName().replace(".java", "") + "#" + stackTrace[5].getMethodName() + " line:" + stackTrace[5].getLineNumber() + "] ";
            Log.w(LogConfig.TAG, str + msg);
            recordLog(new Date().toLocaleString(), LogConfig.TAG, str + msg);
        }
    }

    private static void recordLog(String time, String tag, String msg) {
        String str = time + "\t" + tag + "\t" + msg;
        if (LogConfig.LOG_RECORD_LEVEL == LogLevel.LOG_RECORD_LEVEL_RECORD) {
            try {
                LogRecorder.getInstance().write2File(str);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}