package com.example.mvp.myapplication.module;

import com.example.mvp.myapplication.contact.MoreFolllowInterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.MoreFollowBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.HttpUtils;
import com.example.mvp.myapplication.utils.RxUtils;

import okhttp3.RequestBody;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:MoreFollowIInterface
 * @date :${DATA} 15:54
 */
public class MoreFollowModel {
    public  void   MoreFollowData(final MoreFolllowInterface.IMoreFolllowM iMoreFolllowM, String json){
        RequestBody body = HttpUtils.getBody(json);
        ApiManager.getApi().getMoreFollowData(body).compose(RxUtils.<InfoBean<MoreFollowBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<MoreFollowBean>handleResult())
                .subscribe(new BaseObserver<MoreFollowBean>(iMoreFolllowM) {
                    @Override
                    public void onNext(MoreFollowBean value) {
                         iMoreFolllowM.setMoreFolllowData(value);
                    }
                });

    }
}
