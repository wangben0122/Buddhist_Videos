package com.arkui.fz_tools.mvp;

import android.app.Activity;

import com.arkui.fz_net.http.ApiException;
import com.arkui.fz_net.http.HttpMethod;
import com.arkui.fz_net.http.HttpResultFunc;
import com.arkui.fz_net.http.RetrofitFactory;
import com.arkui.fz_net.subscribers.ProgressSubscriber;
import com.arkui.fz_tools._interface.FriendListInterface;
import com.arkui.fz_tools._interface.SearchAddInterface;
import com.arkui.fz_tools.api.PublicApi;
import com.arkui.fz_tools.entity.FriendsListEntity;
import com.arkui.fz_tools.entity.SearchAddEntity;
import com.arkui.fz_tools.presenter.BasePresenter;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by wuxingpei on 2017/11/15.
 */

public class SearchAddPresenetr extends BasePresenter {
    private SearchAddInterface searchAddInterface;
    private PublicApi publicApi;


    public SearchAddPresenetr(SearchAddInterface searchAddInterface, Activity activity) {
        this.searchAddInterface = searchAddInterface;
        mContext = activity;
        publicApi = RetrofitFactory.createRetrofit(PublicApi.class);
    }


    //搜索
    public void getSearchAdd(String userId, String name, String page, String pageSize) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("user_id", userId);
        hashMap.put("user_name", name);
        hashMap.put("page", page);
        hashMap.put("pagesize", pageSize);
        Observable<List<SearchAddEntity>> observable = publicApi.getSearchAdd(hashMap).map(new HttpResultFunc<List<SearchAddEntity>>());
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<List<SearchAddEntity>>(mContext) {
            @Override
            public void onNext(List<SearchAddEntity> value) {
                searchAddInterface.onSucceed(value);
            }

            @Override
            public void onApiError(ApiException e) {
                searchAddInterface.onFail(e.getMessage());
            }

            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }
        });

    }
}
