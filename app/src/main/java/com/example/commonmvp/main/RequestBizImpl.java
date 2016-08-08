package com.example.commonmvp.main;

import com.example.commonmvp.listener.OnRequestListener;

import java.util.ArrayList;

public class RequestBizImpl implements RequestBiz {

    @Override
    public void requestForData(final OnRequestListener listener) {
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
                }
            }
        }).start();
    }

}
