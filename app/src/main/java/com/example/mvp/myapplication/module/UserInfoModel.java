package com.example.mvp.myapplication.module;

import android.util.Log;

import com.example.mvp.myapplication.contact.UploadingInterface;
import com.example.mvp.myapplication.contact.UserInfoInterface;
import com.example.mvp.myapplication.http.api.Api;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListProfessionBean;
import com.example.mvp.myapplication.http.bean.callback.UploadHeadImageBean;
import com.example.mvp.myapplication.http.bean.callback.UserInfoEditBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.HttpUtils;
import com.example.mvp.myapplication.utils.RxUtils;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:UserInfoModel
 * @date :${DATA} 20:40
 */
public class UserInfoModel {


    public  void  getUserInfoData(String userId, final UserInfoInterface.IUserInfoM iUserInfoM){
          iUserInfoM.shetShowProgressbar();
        ApiManager.getApi().getUserInfoEditBean(userId).compose(RxUtils.<InfoBean<UserInfoEditBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<UserInfoEditBean>handleResult()).subscribe(new BaseObserver<UserInfoEditBean>(iUserInfoM) {
            @Override
            public void onNext(UserInfoEditBean value) {
                 iUserInfoM.setUserInfoBean(value);
            }
        });


    }
    public void getProfessionlist(final UserInfoInterface.IUserInfoM iUserInfoM){
        RequestBody body = HttpUtils.getBody("");
        ApiManager.getApi().getProfessionBean(body).compose(RxUtils.<InfoBean<ListProfessionBean>>rxObserableSchedulerHelper())
                           .compose(RxUtils.<ListProfessionBean>handleResult())
                           .subscribe(new BaseObserver<ListProfessionBean>(iUserInfoM) {
                               @Override
                               public void onNext(ListProfessionBean value) {
                                              iUserInfoM.setProfessionlist(value);
                               }
                           });



    }
    public  void  updateUserInfo(final UserInfoInterface.IUserInfoM iUserInfoM,String json){
        RequestBody body = HttpUtils.getBody(json);
        ApiManager.getApi().updateUserIfo(body).compose(RxUtils.<InfoBean>rxObserableSchedulerHelper())
        .subscribe(new BaseObserver<InfoBean>(iUserInfoM) {
            @Override
            public void onNext(InfoBean value) {
                  iUserInfoM.setUpData(value);
            }
        });

    }
    public  void  getUploadHeadImage(final UserInfoInterface.IUserInfoM iUserInfoM, File file, String userid){
        RequestBody body = RequestBody.create(MediaType.parse("image/*"), file);
        RequestBody part = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("userId", userid)
                .addFormDataPart("headImageFile", file.getName(), body)
                .build();
        Log.d("tian",file.getName());
        iUserInfoM.shetShowProgressbar();
        ApiManager.getApi().getUploadHeadImageBean(part).compose(RxUtils.<InfoBean<UploadHeadImageBean>>rxObserableSchedulerHelper()).compose(RxUtils.<UploadHeadImageBean>handleResult()).subscribe(new BaseObserver<UploadHeadImageBean>(iUserInfoM) {

            @Override
            public void onNext(UploadHeadImageBean value) {
                iUserInfoM.setUploadHeadImageBean(value);
            }
        });


    }
}
