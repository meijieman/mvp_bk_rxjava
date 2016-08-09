package com.example.commonmvp.base;


public abstract class BasePresenter<T> {

    protected T mView;

    public void attach(T t) {
        this.mView = t;
    }

    public void detach() {
        mView = null;
    }
}
