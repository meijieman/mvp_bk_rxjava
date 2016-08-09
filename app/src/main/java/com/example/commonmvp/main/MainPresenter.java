package com.example.commonmvp.main;

import android.os.Handler;
import android.os.Looper;

import com.example.commonmvp.base.BasePresenter;
import com.example.commonmvp.listener.OnRequestListener;

import java.util.List;

public class MainPresenter extends BasePresenter<MainView> {

    private MainBiz requestBiz;

    private Handler mHandler;

    public MainPresenter() {
        requestBiz = new MainBizImpl();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void getData() {
        mView.showLoading();
        requestBiz.requestForData(new OnRequestListener<String>() {

            @Override
            public void onSuccess(final List<String> data) {
                mHandler.post(new Runnable() {

                    @Override
                    public void run() {
                        mView.hideLoading();
                        mView.setListItem(data);
                    }
                });
            }

            @Override
            public void onFailure(final String msg) {
                mHandler.post(new Runnable() {

                    @Override
                    public void run() {
                        mView.showMessage(msg);
                    }
                });
            }
        });
    }

    public void onItemClick(int pos) {
        mView.showMessage("点击了 item " + pos);
    }
}
