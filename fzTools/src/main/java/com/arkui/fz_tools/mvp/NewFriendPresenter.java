package com.arkui.fz_tools.mvp;

import android.app.Activity;

import com.arkui.fz_net.entity.BaseHttpResult;
import com.arkui.fz_net.http.ApiException;
import com.arkui.fz_net.http.HttpMethod;
import com.arkui.fz_net.http.HttpResultFunc;
import com.arkui.fz_net.http.RetrofitFactory;
import com.arkui.fz_net.subscribers.ProgressSubscriber;
import com.arkui.fz_tools._interface.NewFriendInterface;
import com.arkui.fz_tools.api.PublicApi;
import com.arkui.fz_tools.entity.NewFriendEntity;
import com.arkui.fz_tools.presenter.BasePresenter;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by wuxingpei on 2017/11/17.
 */

public class NewFriendPresenter extends BasePresenter {
    private NewFriendInterface newFriendInterface;
    private PublicApi publicApi;

    public NewFriendPresenter(NewFriendInterface newFriendInterface, Activity activity) {
        this.newFriendInterface = newFriendInterface;
        mContext = activity;
        publicApi = RetrofitFactory.createRetrofit(PublicApi.class);
    }

    //新朋友列表
    public void getNewFriendList(String userId,String page,String pagesize) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("page", page);
        map.put("pagesize", pagesize);
        Observable<List<NewFriendEntity>> observable = publicApi.getNewFriendList(map).map(new HttpResultFunc<List<NewFriendEntity>>());
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<List<NewFriendEntity>>(mContext, false) {
            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }

            @Override
            public void onNext(List<NewFriendEntity> value) {
                newFriendInterface.onSucceed(value);
            }

            @Override
            public void onApiError(ApiException e) {
                newFriendInterface.onFail(e.getMessage());
            }
        });
    }

    //同一成为好友
    public void agreeFriend(String userId, String friendId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("friend_id", friendId);
        Observable<BaseHttpResult> observable = publicApi.agreeFriend(map);
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<BaseHttpResult>(mContext, false) {
            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }

            @Override
            public void onNext(BaseHttpResult value) {
                newFriendInterface.onSucceed();
            }

            @Override
            public void onApiError(ApiException e) {
                newFriendInterface.onFail(e.getMessage());
            }
        });

    }
}
