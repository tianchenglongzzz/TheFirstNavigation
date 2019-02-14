package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.ListFeedbackInterface;
import com.example.mvp.myapplication.http.bean.callback.FeedBackBean;
import com.example.mvp.myapplication.http.bean.callback.ListFeedbackBean;
import com.example.mvp.myapplication.module.ListFeedbackModel;

import java.io.File;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:ListFeedbackPresenter
 * @date :${DATA} 13:00
 */
public class ListFeedbackPresenter<V extends ListFeedbackInterface.IlistFeedbackV> extends BasePresenter<V>  implements ListFeedbackInterface.IlistFeedbackM,ListFeedbackInterface.IListFeedbackP {
    ListFeedbackModel mListFeedbackModel=new ListFeedbackModel();
    @Override
    public void setListFeedbackData(ListFeedbackBean listFeedbackBean) {
          mview.showListFeedbackData(listFeedbackBean);

    }

    @Override
    public void setfeedbackData(FeedBackBean feedBackBean) {
           mview.showfeedbackData(feedBackBean);
    }

    @Override
    public void getlistFeedbackData(String userId) {
            mListFeedbackModel.getListFeedbackData(this,userId);
    }

    @Override
    public void getfeedbackData(String userid, File imagFile, String type, String content) {
             mListFeedbackModel.getfeedbackData(this,userid,imagFile,type,content);
    }
}
