package com.arkui.fz_tools._interface;

import com.arkui.fz_tools.entity.FriendsListEntity;

import java.util.List;

/**
 * Created by wuxingpei on 2017/11/15.
 */

public interface FriendListInterface {
    void onSucceed(List<FriendsListEntity> friendsListEntityList);

    void onFail(String message);
}
