package com.arkui.fz_net.http;


import com.arkui.fz_net.entity.BaseHttpResult;

/**
 * Created by wjn on 2016/7/4.
 * 自定义API异常
 */
public class ApiException extends RuntimeException {

    private int status;
    private BaseHttpResult mHttpResult;


    public ApiException(BaseHttpResult httpResult){
        this(getApiExceptionMessage(httpResult));
        this.mHttpResult = httpResult;
    }

    public ApiException(String errorInfo){
        super(errorInfo);
    }

    /**
     * 把服务器的错误信息和错误码返回给前端
     * @param httpResult
     * @return
     */
    private static String getApiExceptionMessage(BaseHttpResult httpResult){
        return  httpResult.getMessage();
    }

    public int getStatus() {
        return mHttpResult.getCode();
    }
}
