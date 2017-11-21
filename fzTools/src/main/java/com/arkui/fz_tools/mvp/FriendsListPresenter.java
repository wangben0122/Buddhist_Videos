package com.arkui.fz_tools.mvp;

import android.app.Activity;

import com.arkui.fz_net.http.ApiException;
import com.arkui.fz_net.http.HttpMethod;
import com.arkui.fz_net.http.HttpResultFunc;
import com.arkui.fz_net.http.RetrofitFactory;
import com.arkui.fz_net.subscribers.ProgressSubscriber;
import com.arkui.fz_tools._interface.FriendListInterface;
import com.arkui.fz_tools.api.PublicApi;
import com.arkui.fz_tools.entity.FriendsListEntity;
import com.arkui.fz_tools.presenter.BasePresenter;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 11/8 0008.
 */

public class FriendsListPresenter extends BasePresenter {
    private FriendListInterface friendListInterface;
    private PublicApi publicApi;


    public FriendsListPresenter(FriendListInterface friendListInterface, Activity activity) {
        this.friendListInterface = friendListInterface;
        mContext = activity;
        publicApi = RetrofitFactory.createRetrofit(PublicApi.class);
    }


    //获取好友列表
    public void getFriendsList(String userId, String page, String pageSize) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("user_id", userId);
        hashMap.put("page", page);
        hashMap.put("pagesize", pageSize);
        Observable<List<FriendsListEntity>> observable = publicApi.getFriendsList(hashMap).map(new HttpResultFunc<List<FriendsListEntity>>());
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<List<FriendsListEntity>>(mContext) {
            @Override
            public void onNext(List<FriendsListEntity> value) {
                friendListInterface.onSucceed(value);
            }

            @Override
            public void onApiError(ApiException e) {
                friendListInterface.onFail(e.getMessage());
            }

            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }
        });

    }

    //搜索好友
    public void getSearchFriend(String userId,String name, String page, String pageSize) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("user_id", userId);
        hashMap.put("user_name", name);
        hashMap.put("page", page);
        hashMap.put("pagesize", pageSize);
        Observable<List<FriendsListEntity>> observable = publicApi.getSearchFriend(hashMap).map(new HttpResultFunc<List<FriendsListEntity>>());
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<List<FriendsListEntity>>(mContext) {
            @Override
            public void onNext(List<FriendsListEntity> value) {
                friendListInterface.onSucceed(value);
            }

            @Override
            public void onApiError(ApiException e) {
                friendListInterface.onFail(e.getMessage());
            }

            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }
        });

    }



}
