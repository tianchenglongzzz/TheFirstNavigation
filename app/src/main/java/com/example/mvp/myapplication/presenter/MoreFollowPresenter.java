package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.MoreFolllowInterface;
import com.example.mvp.myapplication.http.bean.callback.MoreFollowBean;
import com.example.mvp.myapplication.module.MoreFollowModel;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:MoreFollowPresenter
 * @date :${DATA} 15:57
 */
public class MoreFollowPresenter<V extends MoreFolllowInterface.IMoreFolllowV>   extends BasePresenter<V>implements MoreFolllowInterface.IMoreFolllowP,MoreFolllowInterface.IMoreFolllowM {
     MoreFollowModel mMoreFollowModel=new MoreFollowModel();
    @Override
    public void setMoreFolllowData(MoreFollowBean moreFollowBean) {
         mview.showMoreFolllowData(moreFollowBean);
    }

    @Override
    public void getMoreFolllowData(String json) {
           mMoreFollowModel.MoreFollowData(this,json);
    }
}
