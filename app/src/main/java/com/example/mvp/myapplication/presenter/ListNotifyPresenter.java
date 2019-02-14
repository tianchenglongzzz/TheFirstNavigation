package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.ListNotifyInterface;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListNotifyBean;
import com.example.mvp.myapplication.module.ListFollowModel;
import com.example.mvp.myapplication.module.ListNotifyModel;

import java.util.ArrayList;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:ListNotifyPresenter
 * @date :${DATA} 22:06
 */
public class ListNotifyPresenter<V extends ListNotifyInterface.IListNotifyV> extends BasePresenter<V> implements ListNotifyInterface.IListNotifyM,ListNotifyInterface.IListNotifyP{
    ListNotifyModel mListNotifyModel=new ListNotifyModel();
    @Override
    public void setListNotifyData(ArrayList<ListNotifyBean> listNotifyBean) {
        if (mview!=null) {
            mview.showListNotifyData(listNotifyBean);
        }
        }

    @Override
    public void setInfoBean(InfoBean infoBean) {

        if (mview!=null) {
            mview.showInfoData(infoBean);
        }
        }

    @Override
    public void getListNotifyData(String userId) {
              mListNotifyModel.getListNotifyData(this,userId);
                }

    @Override
    public void deleteAllNotify(String userId) {
           mListNotifyModel.deleteAllNotify(this,userId);
    }
}
