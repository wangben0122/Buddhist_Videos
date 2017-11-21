package com.arkui.fz_tools.mvp;

import android.app.Activity;

import com.arkui.fz_net.http.ApiException;
import com.arkui.fz_net.http.HttpMethod;
import com.arkui.fz_net.http.HttpResultFunc;
import com.arkui.fz_net.http.RetrofitFactory;
import com.arkui.fz_net.subscribers.ProgressSubscriber;
import com.arkui.fz_tools._interface.AdministartiveInterface;
import com.arkui.fz_tools.api.UserApi;
import com.arkui.fz_tools.entity.AdministrativeEntity;
import com.arkui.fz_tools.presenter.BasePresenter;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by 84658 on 2017/11/9.
 *
 */

public class AdministrativePresenter extends BasePresenter {
    public UserApi mUserApi;
    AdministartiveInterface administartiveInterface ;

    public AdministrativePresenter(AdministartiveInterface administartiveInterface , Activity activity) {
        this.administartiveInterface = administartiveInterface;
        mUserApi = RetrofitFactory.createRetrofit(UserApi.class);
        mContext=activity;
    }
    //加载科室
    public  void  getDepartment(){
        Observable<List<AdministrativeEntity>> observable = mUserApi.getOffice().map(new HttpResultFunc<List<AdministrativeEntity>>());
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<List<AdministrativeEntity>>(mContext,false) {
            @Override
            protected void getDisposable(Disposable d) {
            mDisposables.add(d);
            }

            @Override
            public void onNext(List<AdministrativeEntity> value) {
                administartiveInterface.loadDepartmentSuccess(value);
            }

            @Override
            public void onApiError(ApiException e) {
                administartiveInterface.loadFail(e.getMessage());
            }
        });
    }
}
