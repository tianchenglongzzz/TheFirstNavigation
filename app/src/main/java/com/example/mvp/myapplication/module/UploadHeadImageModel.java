package com.example.mvp.myapplication.module;

import android.util.Log;

import com.example.mvp.myapplication.contact.LoginInterface;
import com.example.mvp.myapplication.contact.UploadingInterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.UploadHeadImageBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.http.manager.HttpManager;
import com.example.mvp.myapplication.utils.RxUtils;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:UploadHeadImageModel
 * @date :${DATA} 21:17
 */
public class UploadHeadImageModel {

    public  void  getUploadHeadImage(final UploadingInterface.IUploadHeadImageM iUploadHeadImageM, File file, String userid){
        RequestBody body = RequestBody.create(MediaType.parse("image/*"), file);
        RequestBody part = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("userId", userid)
                .addFormDataPart("headImageFile", file.getName(), body)
                .build();
        Log.d("tian",file.getName());
        iUploadHeadImageM.shetShowProgressbar();
        ApiManager.getApi().getUploadHeadImageBean(part).compose(RxUtils.<InfoBean<UploadHeadImageBean>>rxObserableSchedulerHelper()).compose(RxUtils.<UploadHeadImageBean>handleResult()).subscribe(new BaseObserver<UploadHeadImageBean>(iUploadHeadImageM) {

            @Override
            public void onNext(UploadHeadImageBean value) {
                   iUploadHeadImageM.setploadHeadImageuBean(value);
            }
        });


    }
}
