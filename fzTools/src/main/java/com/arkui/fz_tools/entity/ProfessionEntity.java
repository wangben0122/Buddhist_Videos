package com.arkui.fz_tools.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 84658 on 2017/11/9.
 */

public class ProfessionEntity {

    /**
     * ps_id : 3
     * ps_name : 助手
     */

    @SerializedName("ps_id")
    private String psId;
    @SerializedName("ps_name")
    private String psName;

    public String getPsId() {
        return psId;
    }

    public void setPsId(String psId) {
        this.psId = psId;
    }

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
    }
}
