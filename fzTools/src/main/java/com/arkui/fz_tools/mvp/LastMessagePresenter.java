package com.arkui.fz_tools.mvp;

import android.app.Activity;

import com.arkui.fz_net.http.ApiException;
import com.arkui.fz_net.http.HttpMethod;
import com.arkui.fz_net.http.HttpResultFunc;
import com.arkui.fz_net.http.RetrofitFactory;
import com.arkui.fz_net.subscribers.ProgressSubscriber;
import com.arkui.fz_tools._interface.LastMessageInterface;
import com.arkui.fz_tools.api.PublicApi;
import com.arkui.fz_tools.entity.FriendMessageEntity;
import com.arkui.fz_tools.presenter.BasePresenter;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by 84658 on 2017/11/16.
 */

public class LastMessagePresenter extends BasePresenter {
    private LastMessageInterface lastMessageInterface;
    private PublicApi publicApi;

    public LastMessagePresenter(LastMessageInterface lastMessageInterface, Activity activity) {
        this.lastMessageInterface = lastMessageInterface;
        publicApi = RetrofitFactory.createRetrofit(PublicApi.class);
        mContext = activity;
    }
    // 获取最近消息好友信息
    public  void getUserInfos(String  ids){
        Observable<List<FriendMessageEntity>> observable = publicApi.getUserInfo(ids).map(new HttpResultFunc<List<FriendMessageEntity>>());
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<List<FriendMessageEntity>>(mContext,false) {
            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }

            @Override
            public void onNext(List<FriendMessageEntity> value) {
               lastMessageInterface.onLoadSuccess(value);
            }

            @Override
            public void onApiError(ApiException e) {
                lastMessageInterface.Fail(e.getMessage());
            }
        });
    }
}
