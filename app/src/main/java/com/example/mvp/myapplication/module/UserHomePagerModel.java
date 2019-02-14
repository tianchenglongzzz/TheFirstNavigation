package com.example.mvp.myapplication.module;

import android.view.ViewGroup;

import com.example.mvp.myapplication.contact.HomePageInfoInterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.HomeListBean;
import com.example.mvp.myapplication.http.bean.callback.HomePagelistBean;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.UserhomePageBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.HttpUtils;
import com.example.mvp.myapplication.utils.RxUtils;

import java.util.ArrayList;

import okhttp3.RequestBody;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:UserHomePagerModel
 * @date :${DATA} 15:14
 */
public class UserHomePagerModel {

   public void  gerInfoData(final HomePageInfoInterface.IhomePageM ihomePageM, String userid, String lookUserId){
       ihomePageM.shetShowProgressbar();
       ApiManager.getApi().getUserhomePageData(userid,lookUserId).compose(RxUtils.<InfoBean<UserhomePageBean>>rxObserableSchedulerHelper())
               .compose(RxUtils.<UserhomePageBean>handleResult()).subscribe(new BaseObserver<UserhomePageBean>(ihomePageM) {

           @Override
           public void onNext(UserhomePageBean value) {
                 ihomePageM.setInfoData(value);
           }
       });

   }
   //获取个人详情页面list数据
   public void getlistData(final HomePageInfoInterface.IhomePageM ihomePageM,String json){
         ihomePageM.shetShowProgressbar();
       RequestBody body = HttpUtils.getBody(json);
       ApiManager.getApi().getHomePagelistBean(body).compose(RxUtils.<InfoBean<HomeListBean>>rxObserableSchedulerHelper())
               .compose(RxUtils.<HomeListBean>handleResult()).subscribe(new BaseObserver<HomeListBean>(ihomePageM) {


           @Override
           public void onNext(HomeListBean value) {
                     ihomePageM.setlistData(value.getTopicList());
           }
       });
   }
}
