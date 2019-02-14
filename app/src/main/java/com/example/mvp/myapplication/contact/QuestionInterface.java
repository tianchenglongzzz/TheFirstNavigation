package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.QuestionBean;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:QuestionInterface
 * @date :${DATA} 10:45
 */
public interface QuestionInterface {
     interface  IQuestionV extends IBaseView {
           void  showQuestionList(List<QuestionBean> list);
     }
    interface  IQuestionM extends HttpFinshCallBack {
        void  setQuestionList(List<QuestionBean> list);
    }
    interface  IQuestionP extends HttpFinshCallBack {
        void  getQuestionList(String userId);
    }
}
