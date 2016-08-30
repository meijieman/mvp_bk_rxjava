package com.example.commonmvp.utils.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/8/30.
 */
public class LogRecorder {

    private static LogRecorder sInstance;

    public static LogRecorder getInstance() {
        if (sInstance == null) {
            sInstance = new LogRecorder();
        }
        return sInstance;
    }

    private LogRecorder() {

    }

    public void write2File(String msg) throws IOException {
        if (msg == null) {
            return;
        }
        File path = new File(LogConfig.LOG_DIR, LogConfig.LOG_FILENAME);
        createIfNotExist(LogConfig.LOG_DIR, LogConfig.LOG_FILENAME);
        PrintWriter pw = new PrintWriter(new FileWriter(path, true)); // 追加模式
        pw.println(msg);
        pw.flush();
        pw.close();
    }

    private void createIfNotExist(String dir, String filename) throws IOException {
        File root = new File(dir);
        if (!root.exists()) {
            root.mkdirs();
        }
        if (root.isFile()) {
            root.delete();
            root.mkdirs();
        }
        File file = new File(root, filename);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.isDirectory()) {
            file.delete();
            file.createNewFile();
        }
    }
}
