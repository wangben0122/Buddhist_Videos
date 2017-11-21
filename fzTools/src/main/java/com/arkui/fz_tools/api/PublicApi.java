package com.arkui.fz_tools.api;

import com.arkui.fz_net.entity.BaseHttpResult;
import com.arkui.fz_tools.entity.FriendMessageEntity;
import com.arkui.fz_tools.entity.FriendsListEntity;
import com.arkui.fz_tools.entity.MessageEntity;
import com.arkui.fz_tools.entity.NewFriendEntity;
import com.arkui.fz_tools.entity.SearchAddEntity;
import com.arkui.fz_tools.model.NetConstants;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 郭庆文 on 17/11/8 上午10:42
 */

public interface PublicApi {
    //消息列表
    @FormUrlEncoded
    @POST(NetConstants.MESSAGE_LIST)
    Observable<BaseHttpResult<List<MessageEntity>>> getMessageList(@FieldMap Map<String, Object> map);

    //已读消息
    @FormUrlEncoded
    @POST(NetConstants.MESSAGE_READ)
    Observable<BaseHttpResult> readMessage(@Field("id") String id);

    //好友列表
    @FormUrlEncoded
    @POST(NetConstants.FRIENDSLIST)
    Observable<BaseHttpResult<List<FriendsListEntity>>> getFriendsList(@FieldMap Map<String, Object> parameter);

    //搜索好友
    @FormUrlEncoded
    @POST(NetConstants.SEARCH_FRIEND)
    Observable<BaseHttpResult<List<FriendsListEntity>>> getSearchFriend(@FieldMap Map<String, Object> parameter);

    //搜索添加
    @FormUrlEncoded
    @POST(NetConstants.SEARCH_ADD)
    Observable<BaseHttpResult<List<SearchAddEntity>>> getSearchAdd(@FieldMap Map<String, Object> parameter);

    //添加好友
    @FormUrlEncoded
    @POST(NetConstants.ADD_FRIENDS)
    Observable<BaseHttpResult> addFriends(@FieldMap Map<String, Object> parameter);
    //获取用户信息 http://yapei.181858.com/App/Chat/get_user_info

    @FormUrlEncoded
    @POST(NetConstants.GET_USER_INFO)
    Observable<BaseHttpResult<List<FriendMessageEntity>>> getUserInfo(@Field("ids") String ids);

    //新朋友列表
    @FormUrlEncoded
    @POST(NetConstants.NEW_FRIEND)
    Observable<BaseHttpResult<List<NewFriendEntity>>> getNewFriendList(@FieldMap Map<String, Object> parameter);

    //同意好友请求
    @FormUrlEncoded
    @POST(NetConstants.AGREE_FRIEND)
    Observable<BaseHttpResult> agreeFriend(@FieldMap Map<String, Object> parameter);

}
