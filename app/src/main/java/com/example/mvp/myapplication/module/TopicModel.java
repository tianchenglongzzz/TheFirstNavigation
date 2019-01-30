package com.example.mvp.myapplication.module;

import android.util.Log;

import com.example.mvp.myapplication.app.Global;
import com.example.mvp.myapplication.contact.TopicInterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.TopicBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.HttpUtils;
import com.example.mvp.myapplication.utils.RxUtils;

import okhttp3.RequestBody;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:TopicModel
 * @date :${DATA} 15:44
 */
public class TopicModel {
      public  void  getTopicFreshData(final TopicInterface.ITopicDataM dataM, String json,int i) {
          dataM.shetShowProgressbar();
          RequestBody body = HttpUtils.getBody(json);
          if (i == Global.ONE) {
              ApiManager.getApi().getRefreshTopicBean(body).compose(RxUtils.<TopicBean>handleResult())
                      .compose(RxUtils.<TopicBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<TopicBean>(dataM) {
                  @Override
                  public void onNext(TopicBean value) {
                      dataM.setFreshTopicData(value);
                  }
              });
          }
          if (i==Global.THREE){
              Log.d("TAG","===================================");
              ApiManager.getApi().getLoadTopicBean(body).compose(RxUtils.<TopicBean>handleResult())
                      .compose(RxUtils.<TopicBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<TopicBean>(dataM) {
                  @Override
                  public void onNext(TopicBean value) {
                      dataM.setFreshTopicData(value);
                  }
              });

          }

      }

}
