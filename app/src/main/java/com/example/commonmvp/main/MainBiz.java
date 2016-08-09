package com.example.commonmvp.main;

import com.example.commonmvp.listener.OnRequestListener;

public interface MainBiz {

    void requestForData(final OnRequestListener<String> listener);
}
