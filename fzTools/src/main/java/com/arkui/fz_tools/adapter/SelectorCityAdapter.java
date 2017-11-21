package com.arkui.fz_tools.adapter;

import android.content.Context;

import com.arkui.fz_tools.entity.ProviceEntity;

import java.util.List;


/**
 *
 */
public class SelectorCityAdapter extends AbstractWheelTextAdapter {
    private List<ProviceEntity> list;
    public SelectorCityAdapter(Context context, List<ProviceEntity> list) {
        super(context);
        this.list=list;
    }

    @Override
    protected CharSequence getItemText(int index) {
        return list.get(index).getRegionName();
    }

    @Override
    public int getItemsCount() {
        return list==null?0:list.size();
    }
}
