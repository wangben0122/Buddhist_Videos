package com.arkui.fz_tools._interface;

import com.arkui.fz_tools.entity.SearchAddEntity;

import java.util.List;

/**
 * Created by wuxingpei on 2017/11/15.
 */

public interface SearchAddInterface {
    void onSucceed(List<SearchAddEntity> searchAddEntityList);

    void onFail(String message);
}
