package com.example.commonmvp.main;

import com.example.commonmvp.listener.OnRequestListener;

import java.util.ArrayList;

public class MainBizImpl implements MainBiz {

    @Override
    public void requestForData(final OnRequestListener<String> listener) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    ArrayList<String> data = new ArrayList<>();
                    for (int i = 1; i < 16; i++) {
                        Thread.sleep(500);
                        data.add("item " + i);
                    }

                    if (listener != null) {
                        listener.onSuccess(data);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    if (listener != null) {
                        listener.onFailure("发生异常");
                    }
                }
            }
        }).start();
    }

}
