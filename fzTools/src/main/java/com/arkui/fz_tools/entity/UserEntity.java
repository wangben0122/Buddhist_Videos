package com.arkui.fz_tools.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 84658 on 2017/11/8.
 */

public class UserEntity {

    /**
     * user_id : 1
     * mobile : 13681721927
     * user_name : 徐威
     * head : ./Public/images/no_avatar.png
     * is_forbid : 0
     * age : 24
     * age_kind :
     * region_id : 1475
     * sex : 0
     * user_type : 1
     * register_time : 2017-11-02 17:28:20
     * as_id : 3
     * ps_id : 1
     * password : baa4910c2383b95d4286441a10fb7efa
     * hospitalinfo : {"region_id":"1475","region_name":"永修县","parent_id":"163"}
     * cityinfo : {"region_id":"163","region_name":"九江市","parent_id":"14"}
     * provinceinfo : {"region_id":"14","region_name":"江西","parent_id":"0"}
     * administrativeInfo : 近视眼
     * administrativeTwoInfo : 眼科
     * ps_name : 医生
     *certificate_status
     * avatar
     */

    @SerializedName("user_id")
    private String userId;

    public String getCertificateStatus() {
        return certificateStatus;
    }

    public void setCertificateStatus(String certificateStatus) {
        this.certificateStatus = certificateStatus;
    }

    @SerializedName("certificate_status")
    private String certificateStatus;
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("head")
    private String head;
    @SerializedName("is_forbid")
    private String isForbid;
    @SerializedName("age")
    private String age;
    @SerializedName("age_kind")
    private String ageKind;
    @SerializedName("region_id")
    private String regionId;
    @SerializedName("sex")
    private String sex;
    @SerializedName("user_type")
    private String userType;
    @SerializedName("register_time")
    private String registerTime;
    @SerializedName("as_id")
    private String asId;
    @SerializedName("ps_id")
    private String psId;
    @SerializedName("password")
    private String password;
    @SerializedName("hospitalinfo")
    private HospitalinfoBean hospitalinfo;
    @SerializedName("cityinfo")
    private CityinfoBean cityinfo;
    @SerializedName("provinceinfo")
    private ProvinceinfoBean provinceinfo;
    @SerializedName("administrativeInfo")
    private String administrativeInfo;
    @SerializedName("administrativeTwoInfo")
    private String administrativeTwoInfo;
    @SerializedName("ps_name")
    private String psName;



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getIsForbid() {
        return isForbid;
    }

    public void setIsForbid(String isForbid) {
        this.isForbid = isForbid;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAgeKind() {
        return ageKind;
    }

    public void setAgeKind(String ageKind) {
        this.ageKind = ageKind;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getAsId() {
        return asId;
    }

    public void setAsId(String asId) {
        this.asId = asId;
    }

    public String getPsId() {
        return psId;
    }

    public void setPsId(String psId) {
        this.psId = psId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HospitalinfoBean getHospitalinfo() {
        return hospitalinfo;
    }

    public void setHospitalinfo(HospitalinfoBean hospitalinfo) {
        this.hospitalinfo = hospitalinfo;
    }

    public CityinfoBean getCityinfo() {
        return cityinfo;
    }

    public void setCityinfo(CityinfoBean cityinfo) {
        this.cityinfo = cityinfo;
    }

    public ProvinceinfoBean getProvinceinfo() {
        return provinceinfo;
    }

    public void setProvinceinfo(ProvinceinfoBean provinceinfo) {
        this.provinceinfo = provinceinfo;
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

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
    }

    public static class HospitalinfoBean {
        /**
         * region_id : 1475
         * region_name : 永修县
         * parent_id : 163
         */

        @SerializedName("region_id")
        private String regionId;
        @SerializedName("region_name")
        private String regionName;
        @SerializedName("parent_id")
        private String parentId;

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

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }
    }

    public static class CityinfoBean {
        /**
         * region_id : 163
         * region_name : 九江市
         * parent_id : 14
         */

        @SerializedName("region_id")
        private String regionId;
        @SerializedName("region_name")
        private String regionName;
        @SerializedName("parent_id")
        private String parentId;

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

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }
    }

    public static class ProvinceinfoBean {
        /**
         * region_id : 14
         * region_name : 江西
         * parent_id : 0
         */

        @SerializedName("region_id")
        private String regionId;
        @SerializedName("region_name")
        private String regionName;
        @SerializedName("parent_id")
        private String parentId;

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

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }
    }
}
