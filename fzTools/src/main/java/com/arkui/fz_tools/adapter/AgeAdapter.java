package com.arkui.fz_tools.adapter;

import android.content.Context;

import java.util.List;


/**
 *
 */
public class AgeAdapter extends AbstractWheelTextAdapter {
    private List<String> list;
    public AgeAdapter(Context context, List<String> list) {
        super(context);
        this.list=list;
    }

    @Override
    protected CharSequence getItemText(int index) {
        return list.get(index);
    }

    @Override
    public int getItemsCount() {
        return list==null?0:list.size();
    }
}
