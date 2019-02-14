package com.example.mvp.myapplication.module;

import com.example.mvp.myapplication.contact.QuestionInterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.QuestionBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.RxUtils;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:QuestionModel
 * @date :${DATA} 10:48
 */
public class QuestionModel {

      public  void   getQuestionList(final QuestionInterface.IQuestionM iQuestionM, String userId){
          iQuestionM.setHideProgressbar();
          ApiManager.getApi().getQuestionBean(userId).compose(RxUtils.<InfoBean<List<QuestionBean>>>rxObserableSchedulerHelper())
                  .compose(RxUtils.<List<QuestionBean>>handleResult()).subscribe(new BaseObserver<List<QuestionBean>>(iQuestionM) {
              @Override
              public void onNext(List<QuestionBean> value) {
                  iQuestionM.setQuestionList(value);
              }


          });
      }

}
