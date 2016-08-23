package com.example.commonmvp.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.commonmvp.R;
import com.example.commonmvp.base.BaseViewHolder;
import com.example.commonmvp.base.MBaseAdapter;

import butterknife.BindView;

/**
 * @Desc: TODO
 * @Author: Major
 * @Since: 2016/8/24 0:30
 */
public class MainAdapter extends MBaseAdapter<String> {

    public MainAdapter(Context ctx) {
        super(ctx);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_main, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder)convertView.getTag();
        }

        vh.text.setText(getItem(position));

        return convertView;
    }

    static class ViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_item_text)
        TextView text;

        public ViewHolder(View view) {
            super(view);
        }
    }
}
