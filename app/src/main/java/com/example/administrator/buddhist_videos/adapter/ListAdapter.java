package com.example.administrator.buddhist_videos.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.buddhist_videos.util.AutoUtils;


import java.util.List;

/**
 * ListView的通用适配器
 */

public abstract class ListAdapter<T> extends BaseAdapter {
    protected Context mContext; //上下文对象
    protected List<T> list; //数据源
    protected int resId;

    public ListAdapter(Context mContext, List<T> list, int resId) {
        this.mContext = mContext;
        this.list = list;
        this.resId = resId;
    }

    @Override
    public int getCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.getViewHolder(convertView, resId, mContext);
        try {
            conver(viewHolder, list.get(position), position);
        } catch (Exception e) {
            conver(viewHolder, null, position);
        }
        return viewHolder.getConvertView();
    }

    public abstract void conver(ViewHolder viewHolder, T t, int position);

    public static class ViewHolder {
        private SparseArray<View> sparseArray = new SparseArray<>();//用于存储view
        private int postion;
        private Context context;
        private View convertView;


        private ViewHolder(View convertView, int resId, Context context) {
            this.convertView = convertView;
            this.context = context;
        }


        public static ViewHolder getViewHolder(View convertView, int resId, Context context) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(resId, null);
                viewHolder = new ViewHolder(convertView, resId, context);
                convertView.setTag(viewHolder);
                AutoUtils.autoSize(convertView);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            return viewHolder;
        }

        public View findView(int resid) {
            View view = null;
            if (sparseArray.get(resid) == null) {
                view = convertView.findViewById(resid);
                sparseArray.put(resid, view);
            } else {
                view = sparseArray.get(resid);
            }
            return view;
        }

        public void setText(int resid, String text) {
            TextView textView = (TextView) findView(resid);
            textView.setText(text);
        }

        public void setImageResouse(int resid, int imgResouse) {
            ImageView imageView = (ImageView) findView(resid);
            imageView.setImageResource(imgResouse);
        }

        public void setRoundImage(int resid, String url) {
            ImageView imageView = (ImageView) findView(resid);
            Glide.with(context).load(url).into(imageView);
        }

        public void setRoundImage(int resid, String url, int errId) {
            ImageView imageView = (ImageView) findView(resid);
            Glide.with(context).load(url).placeholder(errId).error(errId).into(imageView);
        }

        public void setImage(int resid, String url) {
            ImageView imageView = (ImageView) findView(resid);
            Glide.with(context).load(url).into(imageView);
        }

        public View getConvertView() {

            return convertView;
        }
    }


}
