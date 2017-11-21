package com.arkui.fz_tools.dialog;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arkui.fz_tools.R;
import com.arkui.fz_tools.adapter.SelectorProfessionalAdapter;
import com.arkui.fz_tools.entity.ProfessionEntity;
import com.arkui.fz_tools.listener.OnSelectProfessionalListener;
import com.arkui.fz_tools.view.WheelView;

import java.util.List;

/**
 *
 */

public class SelectPrfessionalPicker extends BaseDialogFragment implements View.OnClickListener {

    private WheelView mWvType;
    private List<ProfessionEntity> mStringList;
    private String mItem;
    private OnSelectProfessionalListener mOnSelectProfessionalListener;
    private String mTitle;

    public void setOnTypeClickListener(OnSelectProfessionalListener mOnSelectProfessionalListener) {
        this.mOnSelectProfessionalListener = mOnSelectProfessionalListener;
    }

    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.layout_vehicle_type, container, false);
    }

    @Override
    protected void initView(View mRootView) {
        mWvType = (WheelView) mRootView.findViewById(R.id.wv_type);
        SelectorProfessionalAdapter stringAdapter=new SelectorProfessionalAdapter(getActivity(),mStringList);
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

    public SelectPrfessionalPicker setData(List<ProfessionEntity> stringList) {
        this.mStringList = stringList;
        return this;
    }

    public SelectPrfessionalPicker setTitle(String title) {
        mTitle = title;
        return this;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_cancel) {
        } else if (id == R.id.tv_confirm) {
            ProfessionEntity selectedItem = mStringList.get(mWvType.getCurrentItem());
            if (mOnSelectProfessionalListener != null) {
                mOnSelectProfessionalListener.onSelectProfessionListener(selectedItem,mWvType.getCurrentItem());
            }
        }
        dismiss();
    }
}
