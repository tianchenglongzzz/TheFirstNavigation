package com.example.mvp.myapplication.module;

import com.example.mvp.myapplication.contact.EditInterface;
import com.example.mvp.myapplication.http.api.Api;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.AboutUsBean;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.HttpUtils;
import com.example.mvp.myapplication.utils.RxUtils;

import okhttp3.RequestBody;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:EditModel
 * @date :${DATA} 8:00
 */
//设置的Model层接口
public class EditModel {

     //获取关于我们的数据
     public void  getAboutUsBean(final EditInterface.IEditM iEditM){
           iEditM.shetShowProgressbar();
           //把空字符串转body对象
         RequestBody body = HttpUtils.getBody("");

          //把body提交上去获得数据
         ApiManager.getApi().getAboutUsBean(body).compose(RxUtils.<InfoBean<AboutUsBean>>rxObserableSchedulerHelper())
                 .compose(RxUtils.<AboutUsBean>handleResult()).subscribe(new BaseObserver<AboutUsBean>(iEditM) {
             @Override
             public void onNext(AboutUsBean value) {
                 iEditM.setAboutUsBean(value);
             }
         });
     }

}
