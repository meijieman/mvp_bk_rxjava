package com.example.commonmvp.main;

import com.example.commonmvp.listener.OnRequestListener;

public interface RequestBiz {

    void requestForData(final OnRequestListener listener);
}
