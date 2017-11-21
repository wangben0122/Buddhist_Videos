package com.arkui.fz_tools.mvp;

import android.app.Activity;

import com.arkui.fz_net.entity.BaseHttpResult;
import com.arkui.fz_net.http.ApiException;
import com.arkui.fz_net.http.HttpMethod;
import com.arkui.fz_net.http.RetrofitFactory;
import com.arkui.fz_net.subscribers.ProgressSubscriber;
import com.arkui.fz_tools._interface.PublicInterface;
import com.arkui.fz_tools.api.UserApi;
import com.arkui.fz_tools.presenter.BasePresenter;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by 84658 on 2017/11/9.
 * @author
 */

public class CompleteDataPresenter extends BasePresenter {
    public UserApi mUserApi;
    public PublicInterface mPublicInterface;

    public CompleteDataPresenter(Activity activity, PublicInterface mPublicInterface) {
         mUserApi= RetrofitFactory.createRetrofit(UserApi.class);
        this.mPublicInterface = mPublicInterface;
        mContext =activity;
    }

    // 完善 资料 修改资料
    public  void completeData(Map<String,Object> map){

        Observable<BaseHttpResult> ob = mUserApi.getUpdateUser(map);
        HttpMethod.getInstance().getNetData(ob, new ProgressSubscriber<BaseHttpResult>(mContext) {
            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }

            @Override
            public void onNext(BaseHttpResult value) {
                mPublicInterface.onSuccess();
            }

            @Override
            public void onApiError(ApiException e) {
                mPublicInterface.onFail(e.getMessage());
            }
        });
    }

}
