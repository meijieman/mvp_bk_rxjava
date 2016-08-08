package com.example.commonmvp.listener;

import java.util.List;

public interface OnRequestListener {

    void onSuccess(final List<String> data);

    void onFailure();
}
