package com.example.commonmvp.main;

import android.os.Handler;
import android.os.Looper;

import com.example.commonmvp.base.BasePresenter;
import com.example.commonmvp.listener.OnRequestListener;
import com.example.commonmvp.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainView> {

    private MainBiz requestBiz;
    private Handler mHandler;
    private Subscriber<List<String>> mSubscriber;

    public MainPresenter() {
        requestBiz = new MainBizImpl();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void getData() {
        mView.showLoading();
        new Thread(new Runnable() {
            @Override
            public void run() {
                requestBiz.requestForData(new OnRequestListener<String>() {

                    @Override
                    public void onSuccess(final List<String> data) {
                        mHandler.post(new Runnable() {

                            @Override
                            public void run() {
                                if (mView != null) {
                                    mView.hideLoading();
                                    mView.setListItem(data);
                                }
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
        }).start();
    }

    public void getData1() {
        mSubscriber = new Subscriber<List<String>>() {
            @Override
            public void onStart() {
                LogUtil.w("onStart");
                mView.showLoading();
            }

            @Override
            public void onCompleted() {
                LogUtil.w("onCompleted");
                if (mView != null) {
                    mView.hideLoading();
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtil.w("onError");
                if (mView != null) {
                    mView.hideLoading();
                }
            }

            @Override
            public void onNext(List<String> strings) {
                LogUtil.w("onNext");
                if (mView != null) {
                    mView.setListItem(strings);
                }
            }
        };


        Observable<List<String>> observable = Observable.create(new Observable.OnSubscribe<List<String>>() {
            @Override
            public void call(Subscriber<? super List<String>> subscriber) {
                ArrayList<String> data = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    data.add("rxjava " + i);
                }

                subscriber.onNext(data);
                subscriber.onCompleted();
            }
        });

        observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(mSubscriber);
    }

    public void onItemClick(int pos) {
        mView.showMessage("点击了 item " + pos);
        LogUtil.w("点击了 item " + pos);
    }

    public void destory() {
        // FIXME: 2016/8/24 InterruptedException
        // 销毁时取消加载
        mSubscriber.unsubscribe();
    }
}
