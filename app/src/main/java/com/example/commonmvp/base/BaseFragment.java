package com.example.commonmvp.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * @Desc: TODO
 * @Author: Major
 * @Since: 2016/8/24 0:23
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null);
        ButterKnife.bind(this, inflate);
        init();
        return inflate;
    }

    /**
     * 设置 layout id
     */
    public abstract int getLayoutId();

    /**
     * 初始化
     */
    public abstract void init();
}
