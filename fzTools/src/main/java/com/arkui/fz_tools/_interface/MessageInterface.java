package com.arkui.fz_tools._interface;

import com.arkui.fz_tools.entity.MessageEntity;

import java.util.List;

/**
 * Created by 郭庆文 on 17/11/8 上午10:54
 */

public interface MessageInterface {
    //这里 你就做出对应处理吧 用户相关的 操作成功 暂时性无参数 后续可能有参数
    void onSucceed(List<MessageEntity> messageEntityList);
    void onFail(String message);
    void onSucceed();
}
