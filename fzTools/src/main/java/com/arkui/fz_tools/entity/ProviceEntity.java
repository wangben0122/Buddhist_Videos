package com.arkui.fz_tools.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 84658 on 2017/11/9.
 */

public class ProviceEntity {

    /**
     * region_id : 1
     * region_name : 北京
     */

    @SerializedName("region_id")
    private String regionId;
    @SerializedName("region_name")
    private String regionName;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
