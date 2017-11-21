package com.arkui.fz_tools._interface;

import com.arkui.fz_tools.entity.NewFriendEntity;

import java.util.List;

/**
 * Created by wuxingpei on 2017/11/17.
 */

public interface NewFriendInterface {
    void onSucceed(List<NewFriendEntity> newFriendEntityList);
    void onFail(String message);
    void onSucceed();
}
