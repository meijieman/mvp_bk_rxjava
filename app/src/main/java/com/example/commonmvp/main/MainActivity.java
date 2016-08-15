package com.example.commonmvp.main;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.commonmvp.R;
import com.example.commonmvp.base.BaseActivity;
import com.example.commonmvp.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {

    private ProgressBar mPb;
    private ArrayAdapter<String> mAdapter;

    private OnItemClickListener mListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mPresenter.onItemClick(position);
        }
    };

    @Override
    public MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        ListView listView = (ListView)findViewById(R.id.maim_listview);
        mPb = (ProgressBar) findViewById(R.id.main_loading);
        assert listView != null;
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(mListener);
        mPresenter.getData();
    }

    @Override
    public void showLoading() {
        mPb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPb.setVisibility(View.GONE);
    }

    @Override
    public void setListItem(List<String> data) {
        mAdapter.clear();
        mAdapter.addAll(data);
    }

    @Override
    public void showMessage(String msg) {
        ToastUtil.show(msg);
    }
}
