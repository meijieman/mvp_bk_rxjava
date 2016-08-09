package com.example.commonmvp.listener;

import java.util.List;

public interface OnRequestListener<T> {

    void onSuccess(final List<T> data);

    void onFailure(final String msg);
}
