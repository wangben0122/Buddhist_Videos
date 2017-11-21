package com.example.administrator.buddhist_videos.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * 模仿dialog样式的popupwindow
 * Created by Administrator on 2017/11/21.
 */
public class PopWindowUtils  extends PopupWindow{
    public PopWindowUtils(Context context) {
        super(context);
    }

    public PopWindowUtils(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PopWindowUtils(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PopWindowUtils(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public PopWindowUtils(View contentView) {
        super(contentView);
    }

    public PopWindowUtils(int width, int height) {
        super(width, height);
    }

    public PopWindowUtils(View contentView, int width, int height) {
        super(contentView, width, height);
    }

    public PopWindowUtils(View contentView, int width, int height, boolean focusable) {
        super(contentView, width, height, focusable);
    }

    private boolean isdarken;
    private Activity activity;
    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        super.showAtLocation(parent, gravity, x, y);

    }
    public void showAtLocation(View parent, int gravity, int x, int y, Activity activity){

        /**
         * 设置背景只有设置了这个才可以点击外边和BACK消失
         */
        setBackgroundDrawable(new ColorDrawable());

        /**
         * 设置可以获取集点
         */
         setFocusable(true);

        /**
         * 设置点击外边可以消失
         */
        setOutsideTouchable(true);

        /**
         *设置可以触摸
         */
        setTouchable(true);


        /**
         * 设置点击外部可以消失
         */
        setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {//判断是不是点击了外部

                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    return true;
                }
                return false;
            }
        });

        showAtLocation(parent, gravity, x, y);
        this.activity = activity;
        WindowManager.LayoutParams params=activity.getWindow().getAttributes();
        params.alpha=0.7f;
        isdarken = true;
        activity.getWindow().setAttributes(params);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if(isdarken){
            WindowManager.LayoutParams params=activity.getWindow().getAttributes();
            params.alpha=1f;
            activity.getWindow().setAttributes(params);
        }
    }
}
