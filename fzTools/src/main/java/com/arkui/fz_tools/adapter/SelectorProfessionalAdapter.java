package com.arkui.fz_tools.adapter;

import android.content.Context;

import com.arkui.fz_tools.entity.ProfessionEntity;

import java.util.List;


/**
 *
 */
public class SelectorProfessionalAdapter extends AbstractWheelTextAdapter {
    private List<ProfessionEntity> list;
    public SelectorProfessionalAdapter(Context context, List<ProfessionEntity> list) {
        super(context);
        this.list=list;
    }

    @Override
    protected CharSequence getItemText(int index) {
        return list.get(index).getPsName();
    }

    @Override
    public int getItemsCount() {
        return list==null?0:list.size();
    }
}
