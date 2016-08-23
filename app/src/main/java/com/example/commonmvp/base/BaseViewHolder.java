package com.example.commonmvp.base;

import android.view.View;

import butterknife.ButterKnife;

/**
 * @Desc: TODO
 * @Author: Major
 * @Since: 2016/8/24 0:52
 */
public class BaseViewHolder {

    public BaseViewHolder(View view) {
        ButterKnife.bind(this, view);
    }
}
