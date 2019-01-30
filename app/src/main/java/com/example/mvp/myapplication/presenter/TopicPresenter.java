package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.TopicInterface;
import com.example.mvp.myapplication.http.bean.callback.TopicBean;
import com.example.mvp.myapplication.module.TopicModel;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:TopicPresenter
 * @date :${DATA} 15:54
 */
public class TopicPresenter<V extends TopicInterface.ITopicDataV> extends BasePresenter<V> implements TopicInterface.ITopicDataM,TopicInterface.ITopicDataP {
    TopicModel mTopicModel=new TopicModel();

    @Override
    public void setFreshTopicData(TopicBean value) {
          mview.showData(value);
    }

    @Override
    public void getFreshTopicData(String json,int i) {
             mTopicModel.getTopicFreshData(this,json,i);
    }
}
