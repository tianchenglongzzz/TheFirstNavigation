package com.example.mvp.myapplication.module;

import com.example.mvp.myapplication.contact.UserCenterInterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.UserCenterBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.HttpUtils;
import com.example.mvp.myapplication.utils.RxUtils;

import okhttp3.RequestBody;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:UserModel
 * @date :${DATA} 12:26
 */
public class UserModel {

     public void getUserCenterData(final UserCenterInterface.IUserCenterM iUserCenterM, String json){

         ApiManager.getApi().getUserCenterBean(json).compose(RxUtils.<InfoBean<UserCenterBean>>rxObserableSchedulerHelper())
                 .compose(RxUtils.<UserCenterBean>handleResult()).subscribe(new BaseObserver<UserCenterBean>(iUserCenterM) {
             @Override
             public void onNext(UserCenterBean value) {
                   iUserCenterM.setCenterData(value);
             }
         });
     }

}
