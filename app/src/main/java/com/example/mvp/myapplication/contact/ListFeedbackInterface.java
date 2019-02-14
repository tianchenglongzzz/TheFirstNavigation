package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.FeedBackBean;
import com.example.mvp.myapplication.http.bean.callback.ListFeedbackBean;

import java.io.File;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:ListFeedbackModel
 * @date :${DATA} 12:49
 */
public interface ListFeedbackInterface {
         interface  IlistFeedbackV extends IBaseView {
                void   showListFeedbackData(ListFeedbackBean listFeedbackBean);
                void  showfeedbackData(FeedBackBean feedBackBean);
         }
    interface  IlistFeedbackM extends  HttpFinshCallBack  {
        void   setListFeedbackData(ListFeedbackBean listFeedbackBean);
        void    setfeedbackData(FeedBackBean feedBackBean);

    }
    interface  IListFeedbackP {
             void  getlistFeedbackData(String userId);
             void  getfeedbackData(String userid, File imagFile,String type,String content);

    }

}
