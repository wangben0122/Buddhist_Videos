package com.arkui.fz_tools.dialog;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arkui.fz_tools.R;
import com.arkui.fz_tools.adapter.SelectorCityAdapter;
import com.arkui.fz_tools.entity.ProviceEntity;
import com.arkui.fz_tools.listener.OnSelectCityListener;
import com.arkui.fz_tools.view.WheelView;

import java.util.List;

/**
 *
 */

public class SelectCityPicker extends BaseDialogFragment implements View.OnClickListener {

    private WheelView mWvType;
    private List<ProviceEntity> mStringList;
    private String mItem;
    private OnSelectCityListener onSelectCityListener;
    private String mTitle;

    public void setOnTypeClickListener(OnSelectCityListener onSelectCityListener) {
        this.onSelectCityListener = onSelectCityListener;
    }

    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.layout_vehicle_type, container, false);
    }

    @Override
    protected void initView(View mRootView) {
        mWvType = (WheelView) mRootView.findViewById(R.id.wv_type);
        SelectorCityAdapter stringAdapter=new SelectorCityAdapter(getActivity(),mStringList);
        mWvType.setViewAdapter(stringAdapter);

        TextView mTvTitle= (TextView) mRootView.findViewById(R.id.tv_title);
        mTvTitle.setText(mTitle);
        mRootView.findViewById(R.id.tv_cancel).setOnClickListener(this);
        mRootView.findViewById(R.id.tv_confirm).setOnClickListener(this);
    }

    @Override
    public int getGravity() {
        return Gravity.BOTTOM;
    }

    public SelectCityPicker setData(List<ProviceEntity> stringList) {
        this.mStringList = stringList;
        return this;
    }

    public SelectCityPicker setTitle(String title) {
        mTitle = title;
        return this;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_cancel) {
        } else if (id == R.id.tv_confirm) {
            ProviceEntity selectedItem = mStringList.get(mWvType.getCurrentItem());
            if (onSelectCityListener != null) {
                onSelectCityListener.selectCityListener(selectedItem,mWvType.getCurrentItem());
            }
        }
        dismiss();
    }
}
