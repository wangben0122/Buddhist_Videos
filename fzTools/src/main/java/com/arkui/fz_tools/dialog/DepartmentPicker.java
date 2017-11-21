package com.arkui.fz_tools.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arkui.fz_tools.R;
import com.arkui.fz_tools.adapter.DepartmentAdapter;
import com.arkui.fz_tools.entity.AdministrativeEntity;
import com.arkui.fz_tools.listener.OnWheelChangedListener;
import com.arkui.fz_tools.view.WheelView;

import java.util.List;

/**
 * Created by nmliz on 2017/6/23.
 */

public class DepartmentPicker extends BaseDialogFragment implements OnWheelChangedListener, View.OnClickListener {

    private List<AdministrativeEntity> cities;
    private WheelView mWvProvince;
    private WheelView mWvCity;
    private OnEnsureClickListener onEnsureClickListener;
    public TextView tv_reset;
    private AdministrativeEntity administrativeEntity1;

    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.dialog_address, container, false);
    }

    @Override
    protected void initView(View mRootView) {
        mWvProvince = (WheelView) mRootView.findViewById(R.id.wv_province);
        mWvCity = (WheelView) mRootView.findViewById(R.id.wv_city);

        TextView mtv_cancel= (TextView) mRootView.findViewById(R.id.tv_cancel);
        TextView tv_submit= (TextView) mRootView.findViewById(R.id.tv_submit);
        tv_reset = (TextView) mRootView.findViewById(R.id.rest_address);
        mtv_cancel.setOnClickListener(this);
        tv_submit.setOnClickListener(this);
        initCity(getActivity());
    }

    private void initCity(Context context) {
        DepartmentAdapter provinceAdapter = new DepartmentAdapter(context, cities);
        provinceAdapter.setTextSize(14);
        mWvProvince.setViewAdapter(provinceAdapter);

        boolean b = cities.get(0).getTwoAdministrative() == null;
        List<AdministrativeEntity> twoAdministrative =null ;

        if (!b){
            twoAdministrative=cities.get(0).getTwoAdministrative();
        }else {
            AdministrativeEntity entity = new AdministrativeEntity();
            entity.setAsName("无");
            twoAdministrative.add(entity);
        }

         if (twoAdministrative!=null){
             DepartmentAdapter departmentAdapter = new DepartmentAdapter(getContext(),twoAdministrative );
             mWvCity.setViewAdapter(departmentAdapter);
         }

        mWvProvince.addChangingListener(this);
    }

    @Override
    public int getGravity() {
        return Gravity.BOTTOM;
    }

    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {
        boolean b = cities.get(newValue).getTwoAdministrative() == null;
        List<AdministrativeEntity> twoAdministrative =null ;
        if (!b){
            twoAdministrative=cities.get(newValue).getTwoAdministrative();
        }
        if (twoAdministrative!=null){
            DepartmentAdapter departmentAdapter = new DepartmentAdapter(getContext(),twoAdministrative);
            mWvCity.setViewAdapter(departmentAdapter);
           // mWvCity.setCurrentItem(0);
        }

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.tv_submit) {
            if (onEnsureClickListener != null) {

                int pIndex=mWvProvince.getCurrentItem();
                // strings[0]=cities.get(pIndex).getName();
                AdministrativeEntity administrativeEntity = cities.get(pIndex);
                List<AdministrativeEntity> twoAdministrative = cities.get(pIndex).getTwoAdministrative();
                if (twoAdministrative!=null&&twoAdministrative.size()>0){
                    administrativeEntity1 = twoAdministrative.get(mWvCity.getCurrentItem());
                }
                onEnsureClickListener.onCityClick(administrativeEntity,administrativeEntity1);
                dismiss();
            }

        } else if (i == R.id.tv_cancel) {
            dismiss();
        }
    }

    public interface OnEnsureClickListener {
        void onCityClick(AdministrativeEntity administrativeEntity1,AdministrativeEntity administrativeEntity2);
    }
    public void setOnEnsureClickListener(OnEnsureClickListener onEnsureClickListener) {
        this.onEnsureClickListener = onEnsureClickListener;
    }

    public String getSelect(){
        String[] strings=new String[2];
        int pIndex=mWvProvince.getCurrentItem();
        // strings[0]=cities.get(pIndex).getName();
        strings[0]=cities.get(pIndex).getAsName();
        if (cities.get(pIndex).getTwoAdministrative()==null){
            strings[1]="";
        } else {
            strings[1] = cities.get(pIndex).getTwoAdministrative().get(mWvCity.getCurrentItem()).getAsName();
        }
        return strings[0]+"-"+strings[1];
    }


    public void setCities(List<AdministrativeEntity> cities) {
        this.cities = cities;
    }

}
