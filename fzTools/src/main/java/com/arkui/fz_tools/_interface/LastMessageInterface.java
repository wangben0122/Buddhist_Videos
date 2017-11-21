package com.arkui.fz_tools._interface;

import com.arkui.fz_tools.entity.FriendMessageEntity;

import java.util.List;

/**
 * Created by 84658 on 2017/11/16.
 */

public interface LastMessageInterface {
    void onLoadSuccess(List<FriendMessageEntity> friendMessageEntities);
    void  Fail(String errorMessage);
}
