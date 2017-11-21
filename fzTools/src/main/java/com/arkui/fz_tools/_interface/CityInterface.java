package com.arkui.fz_tools._interface;

import com.arkui.fz_tools.entity.ProviceEntity;

import java.util.List;

/**
 * Created by 84658 on 2017/11/9.
 */

public interface CityInterface {

    void loadProvinceSuccess(List<ProviceEntity> proviceEntityList);
    void loadCitySuccess(List<ProviceEntity> proviceEntityList);
    void loadHospitalSuccess(List<ProviceEntity> proviceEntityList);

    void loadFail(String errorMessage,int type);



}
