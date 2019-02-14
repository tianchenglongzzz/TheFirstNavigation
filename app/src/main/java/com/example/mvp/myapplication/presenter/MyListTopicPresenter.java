package com.example.mvp.myapplication.presenter;

import android.view.ViewStructure;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.MyListTopicInterface;
import com.example.mvp.myapplication.http.bean.callback.MyListTopicBean;
import com.example.mvp.myapplication.module.MyListTopicModel;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:MyListTopicPresenter
 * @date :${DATA} 15:30
 */
public class MyListTopicPresenter<V extends MyListTopicInterface.ITopicV> extends BasePresenter<V> implements MyListTopicInterface.ITopicM,MyListTopicInterface.ITopiP{
     MyListTopicModel mMyListTopicModel=new MyListTopicModel();
    @Override
    public void setTopicData(MyListTopicBean listTopicBean) {
           mview.showTopicData(listTopicBean);
    }

    @Override
    public void getTopicData(String userid, String cursor) {
          mMyListTopicModel.getMylistTopicBean(this,userid,cursor);

    }
}
