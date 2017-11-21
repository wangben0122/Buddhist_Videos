package com.arkui.fz_tools.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 84658 on 2017/11/16.
 */

public class FriendMessageEntity {

    /**
     * ps_name :
     * as_id : 0
     * user_name : 徐一号
     * sex : 1
     * administrativeInfo :
     * region_id : 1
     * head : ./Public/images/no_avatar.png
     * hospitalinfo : 北京
     * provinceinfo :
     * user_type : 1
     * user_id : 2
     * cityinfo :
     * ps_id : 0
     * administrativeTwoInfo :
     */

    @SerializedName("ps_name")
    private String psName;
    @SerializedName("as_id")
    private String asId;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("sex")
    private String sex;
    @SerializedName("administrativeInfo")
    private String administrativeInfo;
    @SerializedName("region_id")
    private String regionId;
    @SerializedName("head")
    private String head;
    @SerializedName("hospitalinfo")
    private String hospitalinfo;
    @SerializedName("provinceinfo")
    private String provinceinfo;
    @SerializedName("user_type")
    private String userType;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("cityinfo")
    private String cityinfo;
    @SerializedName("ps_id")
    private String psId;
    @SerializedName("administrativeTwoInfo")
    private String administrativeTwoInfo;

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
    }

    public String getAsId() {
        return asId;
    }

    public void setAsId(String asId) {
        this.asId = asId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdministrativeInfo() {
        return administrativeInfo;
    }

    public void setAdministrativeInfo(String administrativeInfo) {
        this.administrativeInfo = administrativeInfo;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHospitalinfo() {
        return hospitalinfo;
    }

    public void setHospitalinfo(String hospitalinfo) {
        this.hospitalinfo = hospitalinfo;
    }

    public String getProvinceinfo() {
        return provinceinfo;
    }

    public void setProvinceinfo(String provinceinfo) {
        this.provinceinfo = provinceinfo;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCityinfo() {
        return cityinfo;
    }

    public void setCityinfo(String cityinfo) {
        this.cityinfo = cityinfo;
    }

    public String getPsId() {
        return psId;
    }

    public void setPsId(String psId) {
        this.psId = psId;
    }

    public String getAdministrativeTwoInfo() {
        return administrativeTwoInfo;
    }

    public void setAdministrativeTwoInfo(String administrativeTwoInfo) {
        this.administrativeTwoInfo = administrativeTwoInfo;
    }
}
