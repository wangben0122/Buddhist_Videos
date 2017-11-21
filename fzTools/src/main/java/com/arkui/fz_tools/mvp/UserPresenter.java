package com.arkui.fz_tools.mvp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Toast;

import com.arkui.fz_net.entity.BaseHttpResult;
import com.arkui.fz_net.http.ApiException;
import com.arkui.fz_net.http.HttpMethod;
import com.arkui.fz_net.http.HttpResultFunc;
import com.arkui.fz_net.http.RetrofitFactory;
import com.arkui.fz_net.subscribers.ProgressSubscriber;
import com.arkui.fz_tools._interface.UserInterface;
import com.arkui.fz_tools.api.UserApi;
import com.arkui.fz_tools.entity.UserEntity;
import com.arkui.fz_tools.presenter.BasePresenter;
import com.arkui.fz_tools.utils.Md5Util;
import com.arkui.fz_tools.utils.StrUtil;
import com.arkui.fz_tools.utils.TimeCountUtil;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by 84658 on 2017/11/8.
 */

public class UserPresenter extends BasePresenter {

    public UserInterface mUserInterface;
    public UserApi mUserApi;
    private int mVerificationCode = -1;
    private String mMobile = null;

    public UserPresenter(UserInterface userInterface, Activity activity) {
        mUserInterface = userInterface;
        mUserApi = RetrofitFactory.createRetrofit(UserApi.class);
        mContext = activity;
    }

    // 注册
    public void getRegister(@NonNull String mobile, @NonNull String code, @NonNull String password, String type) {

        if (mMobile == null) {
            Toast.makeText(mContext, "请获取验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!mMobile.equals(mobile)) {
            Toast.makeText(mContext, "请重新获取验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!StrUtil.isMobileNO(mobile)) {
            Toast.makeText(mContext, "手机号输入不正确", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(code)) {
            Toast.makeText(mContext, "请输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }
        int verificationCode = Integer.parseInt(code);

        if (verificationCode != mVerificationCode) {
            Toast.makeText(mContext, "验证码输入不正确", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(mContext, "密码长度不够", Toast.LENGTH_SHORT).show();
            return;
        }

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("mobile", mobile);
        parameter.put("password", Md5Util.getStringMD5(password));
        parameter.put("user_type", type);

        Observable<UserEntity> observable = mUserApi.getRegister(parameter).map(new HttpResultFunc<UserEntity>());
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<UserEntity>(mContext) {
            @Override
            public void onNext(UserEntity value) {
                Toast.makeText(mContext, "注册成功", Toast.LENGTH_SHORT).show();
                if (mUserInterface != null) {
                    mUserInterface.onSucceed(value);
                }
            }

            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }

            @Override
            public void onApiError(ApiException e) {
                //注册失败
                mUserInterface.onFail(e.getMessage());
            }
        });
    }

    //获取验证码
    public void getCode(@NonNull String mobile, TimeCountUtil timeCountUtil) {
        if (!StrUtil.isMobileNO(mobile)) {
            Toast.makeText(mContext, "手机号输入不正确", Toast.LENGTH_SHORT).show();
            return;
        }
        timeCountUtil.start();
        mMobile = mobile;
        mVerificationCode = (int) ((Math.random() * 9 + 1) * 100000);

        Toast.makeText(mContext, "验证码  " + mVerificationCode, Toast.LENGTH_SHORT).show();

//        VerifyDao.getInstance().sendVer(mContext, mMobile, mVerificationCode, new ResultCallBack() {
//            @Override
//            public void onSuccess(JsonData data) {
//
//            }
//
//            @Override
//            public void onSuccess(String string) {
//                super.onSuccess(string);
//                Toast.makeText(mContext, "发送成功", Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }

    //登录
    public void getLogin(@NonNull String mobile, @NonNull String password,String type) {
        if (!StrUtil.isMobileNO(mobile)) {
            Toast.makeText(mContext, "手机号输入不正确", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(mContext, "密码长度不够", Toast.LENGTH_SHORT).show();
            return;
        }

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("mobile", mobile);
        parameter.put("password", Md5Util.getStringMD5(password));
        parameter.put("user_type",type);
        Observable<UserEntity> observable = mUserApi.getLogin(parameter).map(new HttpResultFunc<UserEntity>());
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<UserEntity>(mContext) {
            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }

            @Override
            public void onNext(UserEntity userEntity) {
                if (mUserInterface != null) {
                    mUserInterface.onSucceed(userEntity);
                }
            }

            @Override
            public void onApiError(ApiException e) {
                super.onApiError(e);
                mUserInterface.onFail(e.getMessage());
            }
        });
    }

    // 修改密码
    public void updatePassword(@NonNull String mobile, @NonNull String password, @NonNull String code) {

        if (mMobile == null) {
            Toast.makeText(mContext, "请获取验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!mMobile.equals(mobile)) {
            Toast.makeText(mContext, "请重新获取验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!StrUtil.isMobileNO(mobile)) {
            Toast.makeText(mContext, "手机号输入不正确", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(code)) {
            Toast.makeText(mContext, "请输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }
        int verificationCode = Integer.parseInt(code);

        if (verificationCode != mVerificationCode) {
            Toast.makeText(mContext, "验证码输入不正确", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length() < 6) {
            Toast.makeText(mContext, "密码长度不够", Toast.LENGTH_SHORT).show();
            return;
        }

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("mobile", mobile);
        parameter.put("new_password", Md5Util.getStringMD5(password));
        Observable<BaseHttpResult> observable = mUserApi.getForgetPassword(parameter);
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<BaseHttpResult>(mContext) {
            @Override
            public void onNext(BaseHttpResult value) {
                mUserInterface.onSucceed(null);
            }

            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }

            @Override
            public void onApiError(ApiException e) {
                mUserInterface.onFail(e.getMessage());
            }
        });

    }

    // 获取个人信息
    public void getUserInfo(String userId) {
        Observable<UserEntity> observable = mUserApi.getUserInfo(userId).map(new HttpResultFunc<UserEntity>());
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<UserEntity>(mContext, false) {
            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }

            @Override
            public void onNext(UserEntity value) {
                mUserInterface.onSucceed(value);
            }

            @Override
            public void onApiError(ApiException e) {
                mUserInterface.onFail(e.getMessage());

            }
        });
    }

}
