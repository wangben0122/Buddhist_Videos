package com.arkui.fz_tools.mvp;

import com.arkui.fz_net.entity.BaseHttpResult;
import com.arkui.fz_net.http.ApiException;
import com.arkui.fz_net.http.HttpMethod;
import com.arkui.fz_net.http.HttpResultFunc;
import com.arkui.fz_net.http.RetrofitFactory;
import com.arkui.fz_net.subscribers.ProgressSubscriber;
import com.arkui.fz_tools._interface.MessageInterface;
import com.arkui.fz_tools.api.PublicApi;
import com.arkui.fz_tools.entity.MessageEntity;
import com.arkui.fz_tools.presenter.BasePresenter;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by 郭庆文 on 17/11/8 上午10:53
 */

public class MessagePresenter extends BasePresenter {
    private MessageInterface messageInterface;
    private PublicApi publicApi;

    public MessagePresenter() {
    }

    public void setMessageInterface(MessageInterface messageInterface) {
        this.messageInterface = messageInterface;
        publicApi = RetrofitFactory.createRetrofit(PublicApi.class);
    }

    //消息列表
    public void getMessageList(String userId, String page, String pagesize) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("page", page);
        map.put("pagesize", pagesize);
        Observable<List<MessageEntity>> observable = publicApi.getMessageList(map).map(new HttpResultFunc<List<MessageEntity>>());
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<List<MessageEntity>>(mContext,false) {
            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }

            @Override
            public void onNext(List<MessageEntity> value) {
                messageInterface.onSucceed(value);
            }

            @Override
            public void onApiError(ApiException e) {
                messageInterface.onFail(e.getMessage());
            }
        });
    }

    //已读消息
    public void readMessage(String id) {
        Observable<BaseHttpResult> observable = publicApi.readMessage(id);
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<BaseHttpResult>(mContext, false) {
            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }

            @Override
            public void onNext(BaseHttpResult value) {
                messageInterface.onSucceed();
            }

            @Override
            public void onApiError(ApiException e) {
                messageInterface.onFail(e.getMessage());
            }
        });

    }
}
