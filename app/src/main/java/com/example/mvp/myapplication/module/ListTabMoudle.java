package com.example.mvp.myapplication.module;

import android.util.Log;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.contact.NewListTab;
import com.example.mvp.myapplication.http.api.Api;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.LoginBean;
import com.example.mvp.myapplication.http.bean.callback.listNewsBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.http.manager.HttpManager;
import com.example.mvp.myapplication.presenter.NewListPresenter;
import com.example.mvp.myapplication.utils.HttpUtils;
import com.example.mvp.myapplication.utils.RxUtils;

import retrofit2.http.POST;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:ListTabMoudle
 * @date :${DATA} 19:05
 */
public class ListTabMoudle {

    public  void getTabList(final NewListTab.ListNewTabModule httpFinshCallBack,String  json) {
        httpFinshCallBack.shetShowProgressbar();
        ApiManager.getApi().getNewBean(HttpUtils.getBody("")).compose(RxUtils.<InfoBean<listNewsBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<listNewsBean>handleResult())
                .subscribe(new BaseObserver<listNewsBean>(httpFinshCallBack) {
                    @Override
                    public void onNext(listNewsBean value) {
                        Log.e("TAG",value.toString());
                           httpFinshCallBack.getListNewTab(value);
                    }
                });
    }
}
