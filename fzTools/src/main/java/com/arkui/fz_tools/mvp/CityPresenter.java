package com.arkui.fz_tools.mvp;

import android.app.Activity;

import com.arkui.fz_net.http.ApiException;
import com.arkui.fz_net.http.HttpMethod;
import com.arkui.fz_net.http.HttpResultFunc;
import com.arkui.fz_net.http.RetrofitFactory;
import com.arkui.fz_net.subscribers.ProgressSubscriber;
import com.arkui.fz_tools._interface.CityInterface;
import com.arkui.fz_tools.api.UserApi;
import com.arkui.fz_tools.entity.ProviceEntity;
import com.arkui.fz_tools.presenter.BasePresenter;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by 84658 on 2017/11/9.
 */

public class CityPresenter extends BasePresenter {
    CityInterface mCityInterface;
    UserApi mUserApi;

    public CityPresenter(CityInterface cityInterface, Activity activity) {
        mCityInterface = cityInterface;
        mUserApi = RetrofitFactory.createRetrofit(UserApi.class);
        mContext = activity;
    }

    public void getProvince(){
        Observable<List<ProviceEntity>> observable = mUserApi.getProvice().map(new HttpResultFunc<List<ProviceEntity>>());
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<List<ProviceEntity>>(mContext,false) {
            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }

            @Override
            public void onNext(List<ProviceEntity> value) {
             mCityInterface.loadProvinceSuccess(value);
            }

            @Override
            public void onApiError(ApiException e) {
                mCityInterface.loadFail(e.getMessage(),1);
            }
        });
    }
   // 获取市区
    public  void  getCity(String regionId){
        Observable<List<ProviceEntity>> observable = mUserApi.getCity(regionId).map(new HttpResultFunc<List<ProviceEntity>>());
        HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<List<ProviceEntity>>(mContext,false) {
            @Override
            protected void getDisposable(Disposable d) {
                mDisposables.add(d);
            }

            @Override
            public void onNext(List<ProviceEntity> value) {
               mCityInterface.loadCitySuccess(value) ;
            }

            @Override
            public void onApiError(ApiException e) {

                mCityInterface.loadFail(e.getMessage(),2);
            }
        });
    }
  // 获取医院
  public  void  getHospital(String regionId){
      Observable<List<ProviceEntity>> observable = mUserApi.getHospital(regionId).map(new HttpResultFunc<List<ProviceEntity>>());
      HttpMethod.getInstance().getNetData(observable, new ProgressSubscriber<List<ProviceEntity>>(mContext,false) {
          @Override
          protected void getDisposable(Disposable d) {
              mDisposables.add(d);
          }

          @Override
          public void onNext(List<ProviceEntity> value) {
              mCityInterface.loadHospitalSuccess(value); ;
          }

          @Override
          public void onApiError(ApiException e) {
              mCityInterface.loadFail(e.getMessage(),3);
          }
      });
  }

}
