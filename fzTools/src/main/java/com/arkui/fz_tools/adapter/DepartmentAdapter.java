package com.arkui.fz_tools.adapter;

import android.content.Context;

import com.arkui.fz_tools.entity.AdministrativeEntity;

import java.util.List;


/**
 * Created by 任少东 on 2016/07/13 16:51
 */
public class DepartmentAdapter extends AbstractWheelTextAdapter {
    private List<AdministrativeEntity> list;
    public DepartmentAdapter(Context context, List<AdministrativeEntity> list) {
        super(context);
        this.list=list;
    }

    @Override
    protected CharSequence getItemText(int index) {
        return list.get(index).getAsName();
    }

    @Override
    public int getItemsCount() {
        return list==null?0:list.size();
    }
}
