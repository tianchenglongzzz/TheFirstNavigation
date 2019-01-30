package com.example.mvp.myapplication.module;

import android.os.IInterface;
import android.util.Log;

import com.example.mvp.myapplication.contact.InfoInterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.InfiBean;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.RelevantBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.HttpUtils;
import com.example.mvp.myapplication.utils.RxUtils;

import java.util.List;

import okhttp3.RequestBody;

import static android.content.ContentValues.TAG;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:InfoMoudle
 * @date :${DATA} 11:41
 */
public class InfoMoudle  {

        public void   getInfoMoudle(final InfoInterface.IinfoMoudel iinfoMoudel, String newsId){

            ApiManager.getApi().getInfoBean("c383f4c9026d471da0184ad5b24c0365",newsId).compose(RxUtils.<InfoBean<InfiBean>>rxObserableSchedulerHelper())
                    .compose(RxUtils.<InfiBean>handleResult()).subscribe(new BaseObserver<InfiBean>(iinfoMoudel) {
                @Override
                public void onNext(InfiBean value) {
                      iinfoMoudel.setInfolsit(value);
                }
            });
        }
        public  void  getInfoRelevantlsit(final InfoInterface.IinfoMoudel iinfoMoudel, String newsId){
            ApiManager.getApi().getRelevantListBean(newsId).compose(RxUtils.<InfoBean<List<RelevantBean>>>rxObserableSchedulerHelper()).compose(RxUtils.<List<RelevantBean>>handleResult())
                    .subscribe(new BaseObserver<List<RelevantBean>>(iinfoMoudel) {
                        @Override
                        public void onNext(List<RelevantBean> value) {
                              iinfoMoudel.setRelevantlsit(value);
                        }
                    });
        }

}
