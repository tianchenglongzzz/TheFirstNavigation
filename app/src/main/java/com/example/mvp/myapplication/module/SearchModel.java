package com.example.mvp.myapplication.module;

import android.content.SharedPreferences;

import com.example.mvp.myapplication.contact.SearchInterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.HotBean;
import com.example.mvp.myapplication.http.bean.callback.UpListNewsBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.HttpUtils;
import com.example.mvp.myapplication.utils.RxUtils;

import okhttp3.RequestBody;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:SearchModel
 * @date :${DATA} 15:55
 */
public class SearchModel  {

    public void  getHotBean(final SearchInterface.IsearchM isearchM, String body){
        RequestBody body1 = HttpUtils.getBody(body);
        ApiManager.getApi().htoBeabn(body1).compose(RxUtils.<HotBean>handleResult()).compose(RxUtils.<HotBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<HotBean>(isearchM) {
            @Override
            public void onNext(HotBean value) {
                   isearchM.setHotBean(value);
            }
        });


    }
    public void getHotBean(final SearchInterface.IsearchNewsM isearchNewsM, String json){
        RequestBody body = HttpUtils.getBody(json);
        ApiManager.getApi().searchUpListNewsBean(body).compose(RxUtils.<UpListNewsBean>handleResult())
                .compose(RxUtils.<UpListNewsBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<UpListNewsBean>(isearchNewsM) {
            @Override
            public void onNext(UpListNewsBean value) {
                   isearchNewsM.setNewsBean(value);
            }
        });
    }
}
