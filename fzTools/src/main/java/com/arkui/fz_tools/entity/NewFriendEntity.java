package com.arkui.fz_tools.entity;

/**
 * Created by wuxingpei on 2017/11/17.
 */

public class NewFriendEntity {

    /**
     * friend_name : 你
     * head : ./Public/images/no_avatar.png
     * friend_id : 8
     * hospitalinfo :
     * provinceinfo :
     * ps_name :
     * user_type : 1
     * cityinfo :
     * sex : 0
     * administrativeInfo :
     * administrativeTwoInfo :
     *  "friend_status": 1
     */
    private String friend_status;
    private String friend_name;
    private String head;
    private String friend_id;
    private String hospitalinfo;
    private String provinceinfo;
    private String ps_name;
    private String user_type;
    private String cityinfo;
    private String sex;
    private String administrativeInfo;
    private String administrativeTwoInfo;

    public String getFriend_status() {
        return friend_status;
    }

    public void setFriend_status(String friend_status) {
        this.friend_status = friend_status;
    }

    public String getFriend_name() {
        return friend_name;
    }

    public void setFriend_name(String friend_name) {
        this.friend_name = friend_name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(String friend_id) {
        this.friend_id = friend_id;
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

    public String getPs_name() {
        return ps_name;
    }

    public void setPs_name(String ps_name) {
        this.ps_name = ps_name;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getCityinfo() {
        return cityinfo;
    }

    public void setCityinfo(String cityinfo) {
        this.cityinfo = cityinfo;
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

    public String getAdministrativeTwoInfo() {
        return administrativeTwoInfo;
    }

    public void setAdministrativeTwoInfo(String administrativeTwoInfo) {
        this.administrativeTwoInfo = administrativeTwoInfo;
    }
}
