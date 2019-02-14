package com.example.mvp.myapplication.module;

import com.example.mvp.myapplication.contact.ListFollowInterface;
import com.example.mvp.myapplication.contact.TopicInfoInterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListFollowBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.HttpUtils;
import com.example.mvp.myapplication.utils.RxUtils;

import okhttp3.RequestBody;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:ListFollowModel
 * @date :${DATA} 18:44
 */
public class ListFollowModel {

    public void getlistFollwData(final ListFollowInterface.IListFollowM iListFollowM, String userId) {
        iListFollowM.shetShowProgressbar();
        ApiManager.getApi().getlistFollowData(userId).compose(RxUtils.<InfoBean<ListFollowBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<ListFollowBean>handleResult()).subscribe(new BaseObserver<ListFollowBean>(iListFollowM) {
            @Override
            public void onNext(ListFollowBean value) {
                iListFollowM.setListFollowData(value);
            }
        });
    }
    public  void  followUser(String json, final ListFollowInterface.IListFollowM iListFollowM){
        RequestBody body = HttpUtils.getBody(json);
        ApiManager.getApi().followUser(body).compose(RxUtils.<InfoBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<InfoBean>(iListFollowM) {
            @Override
            public void onNext(InfoBean value) {
                iListFollowM.setfollow(value);
            }
        });
    }



}