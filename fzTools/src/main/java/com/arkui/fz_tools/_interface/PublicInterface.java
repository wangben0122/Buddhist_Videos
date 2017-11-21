package com.arkui.fz_tools._interface;

/**
 * Created by 84658 on 2017/11/9.
 * @author  qrc
 */

public interface PublicInterface {
    /**
     * 成功的回掉
     */
    void onSuccess();

    /**
     * 失败的回调
     * @param errorMessage
     */
    void onFail(String errorMessage);
}
