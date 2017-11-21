package com.arkui.fz_tools.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arkui.fz_tools.R;
import com.arkui.fz_tools.adapter.AgeAdapter;
import com.arkui.fz_tools.view.WheelView;

import java.util.List;

/**
 * Created by 84658 on 2017/11/8.
 */

public class AgePicker  extends BaseDialogFragment implements View.OnClickListener {

    public void setAges(List<String> ages) {
        this.ages = ages;
    }

    private List<String> ages;

    public void setUnits(List<String> units) {
        this.units = units;
    }

    private List<String> units;
    private WheelView mWvProvince;
    private WheelView mWvCity;
    private OnEnsureClickListener onEnsureClickListener;
    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.dialog_address, container, false);
    }

    @Override
    protected void initView(View mRootView) {
        mWvProvince = (WheelView) mRootView.findViewById(R.id.wv_province);
        mWvCity = (WheelView) mRootView.findViewById(R.id.wv_city);
        //  wmWvCounty = (WheelView) mRootView.findViewById(R.id.wv_county);
        TextView mtv_cancel= (TextView) mRootView.findViewById(R.id.tv_cancel);
        TextView tv_submit= (TextView) mRootView.findViewById(R.id.tv_submit);
        mtv_cancel.setOnClickListener(this);
        tv_submit.setOnClickListener(this);
        initData(getActivity());
    }

    private void initData(Context context) {
        AgeAdapter ageAdapter = new AgeAdapter(context, ages);
        ageAdapter.setTextSize(14);
        mWvProvince.setViewAdapter(ageAdapter);
        mWvCity .setViewAdapter(new AgeAdapter(context,units));
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.tv_submit) {
            if (onEnsureClickListener != null) {
                onEnsureClickListener.onAgeSelect(getSelect());
                dismiss();
            }
        } else if (i == R.id.tv_cancel) {
            dismiss();
        }
    }

    private String getSelect() {
        String[] strings=new String[2];
        int pIndex=mWvProvince.getCurrentItem();
        // strings[0]=cities.get(pIndex).getName();
        strings[0]=ages.get(pIndex);
        int currentItem = mWvCity.getCurrentItem();
        strings[1]=units.get(currentItem);

        return strings[0]+" "+strings[1];
    }

    @Override
    public int getGravity() {
        return Gravity.BOTTOM;
    }
    public interface OnEnsureClickListener {
        void onAgeSelect(String age);
    }
    public void setOnEnsureClickListener(OnEnsureClickListener onEnsureClickListener) {
        this.onEnsureClickListener = onEnsureClickListener;
    }
}
