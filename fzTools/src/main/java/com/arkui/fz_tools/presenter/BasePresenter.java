package com.arkui.fz_tools.presenter;

import android.app.Activity;
import android.widget.Toast;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Author: 姚智胜
 * Version: V1.0版本
 * Description:基类presenter
 * Date: 2017/6/13
 * Email: 541567595@qq.com
 */
public abstract class BasePresenter {
    public Activity mContext;
    public CompositeDisposable mDisposables = new CompositeDisposable();

    public void showToast(String str){
        Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
    }

    public void onDestroy(){
        mDisposables.clear();
    }
}
