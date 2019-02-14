package com.example.mvp.myapplication.module;

import com.example.mvp.myapplication.contact.ListFollowInterface;
import com.example.mvp.myapplication.contact.ListNotifyInterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListNotifyBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.RxUtils;

import java.util.ArrayList;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:ListNotifyModel
 * @date :${DATA} 22:00
 */
public class ListNotifyModel {

    public void  getListNotifyData(final ListNotifyInterface.IListNotifyM iListFollowM, String userId){
        iListFollowM.shetShowProgressbar();
        ApiManager.getApi().getlistNotifyBean(userId).compose(RxUtils.<InfoBean<ArrayList<ListNotifyBean>>>rxObserableSchedulerHelper())
                .compose(RxUtils.<ArrayList<ListNotifyBean>>handleResult()).subscribe(new BaseObserver<ArrayList<ListNotifyBean>>(iListFollowM) {
            @Override
            public void onNext(ArrayList<ListNotifyBean> value) {
                   iListFollowM.setListNotifyData(value);
            }
        });
    }
    public void  deleteAllNotify(final ListNotifyInterface.IListNotifyM iListFollowM, String userId ){
          iListFollowM.shetShowProgressbar();
        ApiManager.getApi().deleteAllNotify(userId).compose(RxUtils.<InfoBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<InfoBean>(iListFollowM) {
                    @Override
                    public void onNext(InfoBean value) {
                          iListFollowM.setInfoBean(value);
                    }
                });

    }
}
