package com.example.administrator.buddhist_videos;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/11/21.
 */

public class App extends Application{

    /**
     * 全局的上下文
     */
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    /**
     * 获取context
     * @return
     */
    public static Context getContext(){
        return mContext;
    }

}
