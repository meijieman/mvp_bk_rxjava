package com.example.commonmvp.main;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.commonmvp.R;
import com.example.commonmvp.base.BaseActivity;

import java.util.List;

public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {

    private ListView    mListView;
    private ProgressBar mPb;

    private OnItemClickListener mListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mPresenter.onItemClick(position);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView)findViewById(R.id.maim_listview);
        assert mListView != null;
        mListView.setOnItemClickListener(mListener);
        mPb = (ProgressBar)findViewById(R.id.main_loading);
    }


    @Override
    public MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
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
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        mListView.setAdapter(adapter);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
