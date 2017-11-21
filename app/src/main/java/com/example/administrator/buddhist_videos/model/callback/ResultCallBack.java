package com.example.administrator.buddhist_videos.model.callback;

/**
 * Created by Administrator on 2017/11/21.
 */

public interface ResultCallBack {

    void onSuccess(Object object);

    void onError(String errorMsg);

    void notNet(String netData);

    void onErrorParams(String errorParams);
}
