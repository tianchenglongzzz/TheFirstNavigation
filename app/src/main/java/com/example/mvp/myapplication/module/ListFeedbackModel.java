package com.example.mvp.myapplication.module;

import com.example.mvp.myapplication.contact.ListFeedbackInterface;
import com.example.mvp.myapplication.contact.ListNotifyInterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.FeedBackBean;
import com.example.mvp.myapplication.http.bean.callback.InfiBean;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListFeedbackBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.RxUtils;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:ListFeedback
 * @date :${DATA} 12:48
 */
public class ListFeedbackModel {


      public  void  getListFeedbackData(final ListFeedbackInterface.IlistFeedbackM ilistFeedbackM, String userId){
                 ilistFeedbackM.shetShowProgressbar();
          ApiManager.getApi().getlistFeedData(userId).compose(RxUtils.<InfoBean<ListFeedbackBean>>rxObserableSchedulerHelper())
                  .compose(RxUtils.<ListFeedbackBean>handleResult()).subscribe(new BaseObserver<ListFeedbackBean>(ilistFeedbackM) {
              @Override
              public void onNext(ListFeedbackBean value) {
                      ilistFeedbackM.setListFeedbackData(value);
              }
          });
      }
      public  void getfeedbackData(final ListFeedbackInterface.IlistFeedbackM ilistFeedbackM, String userid, File imagFile, String type, String content){
          MultipartBody.Builder builder = new MultipartBody.Builder();
          builder.setType(MultipartBody.FORM);
          builder.addFormDataPart("userid",userid);
          if (imagFile!=null) {
              builder.addFormDataPart("imagFile", imagFile.getName(), RequestBody.create(MediaType.parse("*/image"), imagFile));
          }
          builder.addFormDataPart("type",type);
          if (content!=null) {
              builder.addFormDataPart("content", content);
          }
          MultipartBody build = builder.build();
          ApiManager.getApi().setFeedBackBean(build).compose(RxUtils.<InfoBean<FeedBackBean>>rxObserableSchedulerHelper())
                  .compose(RxUtils.<FeedBackBean>handleResult()).subscribe(new BaseObserver<FeedBackBean>(ilistFeedbackM) {
              @Override
              public void onNext(FeedBackBean value) {
                    ilistFeedbackM.setfeedbackData(value);
              }
          });
      }

}
