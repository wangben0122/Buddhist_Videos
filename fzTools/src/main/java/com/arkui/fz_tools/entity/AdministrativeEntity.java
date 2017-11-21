package com.arkui.fz_tools.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 84658 on 2017/11/9.
 */

public class AdministrativeEntity {


    /**
     * as_name : 眼科
     * as_id : 2
     * two_administrative : [{"as_name":"近视眼","as_id":"3"},{"as_name":"白内障","as_id":"4"}]
     */

    @SerializedName("as_name")
    private String asName;
    @SerializedName("as_id")
    private String asId;
    @SerializedName("two_administrative")
    private List<AdministrativeEntity> twoAdministrative;

    public String getAsName() {
        return asName;
    }

    public void setAsName(String asName) {
        this.asName = asName;
    }

    public String getAsId() {
        return asId;
    }

    public void setAsId(String asId) {
        this.asId = asId;
    }

    public List<AdministrativeEntity> getTwoAdministrative() {
        return twoAdministrative;
    }

    public void setTwoAdministrative(List<AdministrativeEntity> twoAdministrative) {
        this.twoAdministrative = twoAdministrative;
    }


}
