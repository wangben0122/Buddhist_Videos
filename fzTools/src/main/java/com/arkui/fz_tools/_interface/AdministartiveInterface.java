package com.arkui.fz_tools._interface;

import com.arkui.fz_tools.entity.AdministrativeEntity;

import java.util.List;

/**
 * Created by 84658 on 2017/11/9.
 */

public interface AdministartiveInterface {
    void loadDepartmentSuccess(List<AdministrativeEntity> entitys);
    void loadFail(String errorMessage);
}
