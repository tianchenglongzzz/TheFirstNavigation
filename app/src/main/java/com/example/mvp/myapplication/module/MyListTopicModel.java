package com.example.mvp.myapplication.module;

import com.example.mvp.myapplication.contact.MyListTopicInterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.MyListTopicBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.RxUtils;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:MyListTopicModel
 * @date :${DATA} 13:06
 */
public class MyListTopicModel {

       public  void  getMylistTopicBean(final MyListTopicInterface.ITopicM iTopicM, String userId, String cursor){
              iTopicM.shetShowProgressbar();
           ApiManager.getApi().getMylistTopicData(userId,cursor).compose(RxUtils.<InfoBean<MyListTopicBean>>rxObserableSchedulerHelper())
            .compose(RxUtils.<MyListTopicBean>handleResult()).subscribe(new BaseObserver<MyListTopicBean>(iTopicM) {
               @Override
               public void onNext(MyListTopicBean value) {
                     iTopicM.setTopicData(value);
               }
           });
       }
}
