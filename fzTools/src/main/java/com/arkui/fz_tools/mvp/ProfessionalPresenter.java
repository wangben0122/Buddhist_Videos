package com.arkui.fz_tools.mvp;

import android.app.Activity;

import com.arkui.fz_net.http.ApiException;
import com.arkui.fz_net.http.HttpMethod;
import com.arkui.fz_net.http.HttpResultFunc;
import com.arkui.fz_net.http.RetrofitFactory;
import com.arkui.fz_net.subscribers.ProgressSubscriber;
import com.arkui.fz_tools._interface.ProfessionInterface;
import com.arkui.fz_tools.api.UserApi;
import com.arkui.fz_tools.entity.ProfessionEntity;
import com.arkui.fz_tools.presenter.BasePresenter;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by 84658 on 2017/11/9.
 */

public class ProfessionalPresenter extends BasePresenter {

    ProfessionInterface mProfessionInterface;
    UserApi mUserApi;

    public ProfessionalPresenter(ProfessionInterface professionInterface, Activity activity) {
        mProfessionInterface = professionInterface;
        mUserApi = RetrofitFactory.createRetrofit(UserApi.class);
        mContext = activity;
    }

    public void getProfessionalList(){
        Observable<List<ProfessionEntity>> observable = mUserApi.getProfessionalList().map(new HttpResultFunc<List<ProfessionEntity>>());
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<List<ProfessionEntity>>(mContext,false) {
            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }

            @Override
            public void onNext(List<ProfessionEntity> value) {
                mProfessionInterface.loadProfessionalSuccess(value);
            }

            @Override
            public void onApiError(ApiException e) {
                mProfessionInterface.loadFail(e.getMessage());
            }
        });
    }
}
