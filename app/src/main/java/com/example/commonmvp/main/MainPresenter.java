package com.example.commonmvp.main;

import android.os.Handler;
import android.os.Looper;

import com.example.commonmvp.base.BasePresenter;
import com.example.commonmvp.listener.OnRequestListener;

import java.util.List;

public class MainPresenter extends BasePresenter<MainView> {

    private RequestBiz requestBiz;

    private Handler mHandler;

    public MainPresenter() {
        requestBiz = new RequestBizImpl();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void onResume() {
        requestBiz.requestForData(new OnRequestListener() {

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
            public void onFailure() {
                mHandler.post(new Runnable() {

                    @Override
                    public void run() {
                        mView.showMessage("����ʧ��");
                    }
                });
            }
        });
    }

    public void onItemClick(int pos) {
        mView.showMessage("�����item " + pos);
    }
}
