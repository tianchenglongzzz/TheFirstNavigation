package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.ListFollowInterface;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListFollowBean;
import com.example.mvp.myapplication.module.ListFollowModel;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:ListFollowPresenter
 * @date :${DATA} 18:47
 */
public class ListFollowPresenter<V extends ListFollowInterface.IListFollowV> extends BasePresenter<V> implements ListFollowInterface.IListFollowM,ListFollowInterface.IListFollowP {
     ListFollowModel mListFollowModel=new ListFollowModel();
    @Override
    public void setListFollowData(ListFollowBean listFollowBean) {
         mview.showListFollowData(listFollowBean);
    }

    @Override
    public void setfollow(InfoBean infoBean) {
          mview.showfollow(infoBean);
    }

    @Override
    public void getListFollqData(String userId) {
        mListFollowModel.getlistFollwData(this,userId);
    }

    @Override
    public void follow(String json) {
             mListFollowModel.followUser(json,this);
    }
}
