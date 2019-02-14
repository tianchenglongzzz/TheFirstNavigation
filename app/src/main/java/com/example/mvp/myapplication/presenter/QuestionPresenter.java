package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.QuestionInterface;
import com.example.mvp.myapplication.http.bean.callback.QuestionBean;
import com.example.mvp.myapplication.module.QuestionModel;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:QuestionPresenter
 * @date :${DATA} 10:53
 */
public class QuestionPresenter<V extends QuestionInterface.IQuestionV>  extends BasePresenter<V> implements QuestionInterface.IQuestionM,QuestionInterface.IQuestionP{
     QuestionModel mQuestionModel=new QuestionModel();
    @Override
    public void setQuestionList(List<QuestionBean> list) {
           mview.showQuestionList(list);
    }

    @Override
    public void getQuestionList(String userId) {
       mQuestionModel.getQuestionList(this,userId);
    }
}
