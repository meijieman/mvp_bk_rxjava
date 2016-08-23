package com.example.commonmvp.main;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.commonmvp.R;
import com.example.commonmvp.base.BaseActivity;
import com.example.commonmvp.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {

    @BindView(R.id.main_loading)
    ProgressBar mPb;
    @BindView(R.id.maim_listview)
    ListView    mListView;

    private MainAdapter mAdapter;

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
        mAdapter = new MainAdapter(this);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(mListener);
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
        mAdapter.addDatas(data);
    }

    @Override
    public void showMessage(String msg) {
        ToastUtil.show(msg);
    }
}
