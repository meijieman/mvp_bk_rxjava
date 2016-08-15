package com.example.commonmvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @Desc: TODO
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mPresenter = initPresenter();
        mPresenter.attach((V) this);

        init();
    }

    @Override
    protected void onDestroy() {
        mPresenter.detach();
        super.onDestroy();
    }

    /**
     * 设置 layout id
     */
    public abstract int getLayoutId();

    /**
     * 初始化
     */
    public abstract void init();

    /**
     * 初始化 presenter
     */
    public abstract T initPresenter();
}
