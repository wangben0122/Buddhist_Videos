package com.arkui.fz_tools.api;

import com.arkui.fz_net.entity.BaseHttpResult;
import com.arkui.fz_tools.entity.AdministrativeEntity;
import com.arkui.fz_tools.entity.ProfessionEntity;
import com.arkui.fz_tools.entity.ProviceEntity;
import com.arkui.fz_tools.entity.UserEntity;
import com.arkui.fz_tools.model.NetConstants;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by nmliz on 2017/8/7.
 * 用户的Api
 */

public interface UserApi {
    //注册接口
    @FormUrlEncoded
    @POST(NetConstants.REGISTER)
    Observable<BaseHttpResult<UserEntity>> getRegister(@FieldMap Map<String, Object> parameter);

    //登录接口
    @FormUrlEncoded
    @POST(NetConstants.LOGIN)
    Observable<BaseHttpResult<UserEntity>> getLogin(@FieldMap Map<String, Object> parameter);

    // 修改密码接口 FORGET_PASSWORD
    @FormUrlEncoded
    @POST(NetConstants.UPDATA_PASSWORD)
    Observable<BaseHttpResult> getForgetPassword(@FieldMap Map<String, Object> parameter);

    //初始化省   App/Users/initialize_province
    @POST(NetConstants.GET_PROVICE)
    Observable<BaseHttpResult<List<ProviceEntity>>> getProvice();

    //初始化市 App/Users/initialize_city
    @FormUrlEncoded
    @POST(NetConstants.GETCITY)
    Observable<BaseHttpResult<List<ProviceEntity>>> getCity(@Field("region_id") String region_id);

    // 初始化医院 App/Users/initialize_hospital
    @FormUrlEncoded
    @POST(NetConstants.GETHOSPITAL)
    Observable<BaseHttpResult<List<ProviceEntity>>> getHospital(@Field("region_id") String region_id);

    // 初始化科室  App/Users/administrative_list
    @POST(NetConstants.GETOFFICE)
    Observable<BaseHttpResult<List<AdministrativeEntity>>> getOffice();

    //修改完善资料 App/Users/edit
    @FormUrlEncoded
    @POST(NetConstants.UPDATAUSER)
    Observable<BaseHttpResult> getUpdateUser(@FieldMap Map<String, Object> parameter);

    // 个人资料
    @FormUrlEncoded
    @POST(NetConstants.GETUSERINFO)
    Observable<BaseHttpResult<UserEntity>> getUserInfo(@Field("user_id") String userId);
    //获取职位列表
    @POST(NetConstants.PROFESSIONAL_LIST)
    Observable<BaseHttpResult<List<ProfessionEntity>>> getProfessionalList();


}
