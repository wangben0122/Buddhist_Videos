package com.arkui.fz_tools._interface;

import com.arkui.fz_tools.entity.UserEntity;

/**
 * Created by 84658 on 2017/11/8.
 */

public interface UserInterface {
     // 注册 登陆成功
    void onSucceed(UserEntity userEntity);

    void onFail(String errorMessage);
}
