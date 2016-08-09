package com.example.commonmvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    private static Toast sToast;
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mPresenter = initPresenter();

        init();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mPresenter.attach((V) this);
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

    /**
     * toast
     */
    protected void show(String msg) {
        if (sToast == null) {
            sToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        }
        sToast.setText(msg);
        sToast.show();
    }
}
