package com.example.mvp.myapplication.module;

import android.icu.text.IDNA;
import android.util.Log;

import com.example.mvp.myapplication.contact.InfoInterface;
import com.example.mvp.myapplication.contact.TopicInfoInterface;
import com.example.mvp.myapplication.contact.TopicInterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.InfiBean;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListCommentBean;
import com.example.mvp.myapplication.http.bean.callback.RelevantBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.HttpUtils;
import com.example.mvp.myapplication.utils.RxUtils;

import java.util.List;

import okhttp3.RequestBody;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:InfoMoudle
 * @date :${DATA} 11:41
 */
public class InfoMoudle  {

        public void   getInfoMoudle(final InfoInterface.IinfoMoudel iinfoMoudel, String newsId){
            iinfoMoudel.shetShowProgressbar();
            ApiManager.getApi().getInfoBean("c383f4c9026d471da0184ad5b24c0365",newsId).compose(RxUtils.<InfoBean<InfiBean>>rxObserableSchedulerHelper())
                    .compose(RxUtils.<InfiBean>handleResult()).subscribe(new BaseObserver<InfiBean>(iinfoMoudel) {
                @Override
                public void onNext(InfiBean value) {
                      iinfoMoudel.setInfolsit(value);
                }
            });
        }
        public  void  getInfoRelevantlsit(final InfoInterface.IinfoMoudel iinfoMoudel, String newsId){
            iinfoMoudel.shetShowProgressbar();
            ApiManager.getApi().getRelevantListBean(newsId).compose(RxUtils.<InfoBean<List<RelevantBean>>>rxObserableSchedulerHelper()).compose(RxUtils.<List<RelevantBean>>handleResult())
                    .subscribe(new BaseObserver<List<RelevantBean>>(iinfoMoudel) {
                        @Override
                        public void onNext(List<RelevantBean> value) {
                              iinfoMoudel.setRelevantlsit(value);
                        }
                    });
        }
    public void  getlistComment(final InfoInterface.IinfoMoudel iinfoMoudel, String json){
        Log.d("info",json);
        iinfoMoudel.shetShowProgressbar();
        RequestBody body = HttpUtils.getBody(json);
        ApiManager.getApi().getlistCommentData(body).compose(RxUtils.<InfoBean<ListCommentBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<ListCommentBean>handleResult()).subscribe(new BaseObserver<ListCommentBean>(iinfoMoudel) {
            @Override
            public void onNext(ListCommentBean value) {
                Log.d("info",value.getCommentList().size()+"==============");
                iinfoMoudel.setlistComment(value);
            }
        });

    }
    public void  getLikesData(final InfoInterface.IinfoMoudel iinfoMoudel, String json){
        RequestBody requestBody = HttpUtils.getBody(json);
        ApiManager.getApi().setLike(requestBody).compose(RxUtils.<InfoBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<InfoBean>(iinfoMoudel) {
            @Override
            public void onNext(InfoBean value) {
                iinfoMoudel.setLikeData(value);
            }
        });
    }

}
