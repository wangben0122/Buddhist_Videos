package com.arkui.fz_tools.mvp;

import android.app.Activity;

import com.arkui.fz_net.entity.BaseHttpResult;
import com.arkui.fz_net.http.ApiException;
import com.arkui.fz_net.http.HttpMethod;
import com.arkui.fz_net.http.HttpResultFunc;
import com.arkui.fz_net.http.RetrofitFactory;
import com.arkui.fz_net.subscribers.ProgressSubscriber;
import com.arkui.fz_tools._interface.AddFriendsInterface;
import com.arkui.fz_tools._interface.SearchAddInterface;
import com.arkui.fz_tools.api.PublicApi;
import com.arkui.fz_tools.entity.SearchAddEntity;
import com.arkui.fz_tools.presenter.BasePresenter;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by wuxingpei on 2017/11/15.
 */

public class AddFriendPresenter extends BasePresenter {

    private AddFriendsInterface addFriendsInterface;
    private PublicApi publicApi;


    public AddFriendPresenter(AddFriendsInterface addFriendsInterface, Activity activity) {
        this.addFriendsInterface = addFriendsInterface;
        mContext = activity;
        publicApi = RetrofitFactory.createRetrofit(PublicApi.class);
    }


    //添加好友
    public void getAddfriends(String userId, String friendId) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("user_id", userId);
        hashMap.put("friend_id", friendId);
        Observable<BaseHttpResult> observable = publicApi.addFriends(hashMap);
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<BaseHttpResult>(mContext) {
            @Override
            public void onNext(BaseHttpResult value) {
                addFriendsInterface.onSucceed();
            }

            @Override
            public void onApiError(ApiException e) {
                addFriendsInterface.onFail(e.getMessage());
            }

            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }
        });

    }
}
