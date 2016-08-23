package com.example.commonmvp.utils;

import android.widget.Toast;

import com.example.commonmvp.base.BaseApp;

/**
 * @Desc: TODO
 */
public class ToastUtil {

    private static Toast sToast;
    private static Toast sToastLong;

    public static void show(String msg) {
        if (sToast == null) {
            sToast = Toast.makeText(BaseApp.getInstance(), "", Toast.LENGTH_SHORT);
        }
        sToast.setText(msg);
        sToast.show();
    }

    public static void showLong(String msg) {
        if (sToastLong == null) {
            sToastLong = Toast.makeText(BaseApp.getInstance(), "", Toast.LENGTH_LONG);
        }
        sToastLong.setText(msg);
        sToastLong.show();
    }
}
