package com.arkui.fz_tools._interface;

import com.arkui.fz_tools.entity.ProfessionEntity;

import java.util.List;

/**
 * Created by 84658 on 2017/11/9.
 */

public interface ProfessionInterface {
    void loadProfessionalSuccess(List<ProfessionEntity> entities);
    void loadFail(String errorMessage);
}
