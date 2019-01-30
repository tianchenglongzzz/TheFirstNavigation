package com.example.mvp.myapplication.module;

import com.example.mvp.myapplication.contact.UpListNewsIntenface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.DownListNewsBean;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.UpListNewsBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.HttpUtils;
import com.example.mvp.myapplication.utils.RxUtils;

import okhttp3.RequestBody;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:UpListNewsModel
 * @date :${DATA} 20:35
 */
public class UpListNewsModel {

      public  void  getUpListDatd(final UpListNewsIntenface.IUpListNewsM upListNewsM, String json){

          RequestBody body = HttpUtils.getBody(json);
         upListNewsM.shetShowProgressbar();
          ApiManager.getApi().getUpListNews(body).compose(RxUtils.<InfoBean<UpListNewsBean>>rxObserableSchedulerHelper()).compose(RxUtils.<UpListNewsBean>handleResult())
                  .subscribe(new BaseObserver<UpListNewsBean>(upListNewsM) {
                      @Override
                      public void onNext(UpListNewsBean value) {
                          upListNewsM.setUpListNewsData(value);
                      }
                  });


      }
      public  void  getDownListNews(final UpListNewsIntenface.IUpListNewsM iUpListNewsM, String json){
          RequestBody body = HttpUtils.getBody(json);
           iUpListNewsM.shetShowProgressbar();
         ApiManager.getApi().getDownListNews(body).compose(RxUtils.<UpListNewsBean>handleResult())
                 .compose(RxUtils.<UpListNewsBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<UpListNewsBean>(iUpListNewsM) {
             @Override
             public void onNext(UpListNewsBean value) {
                 iUpListNewsM.getDownListNewsHeadImageuBean(value);
             }
         });
      }
}
