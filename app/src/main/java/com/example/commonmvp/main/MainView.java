package com.example.commonmvp.main;

import com.example.commonmvp.base.BaseView;

import java.util.List;


public interface MainView extends BaseView {

    void setListItem(List<String> data);

    void showMessage(String msg);
}
