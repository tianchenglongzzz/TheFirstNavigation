package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.HomePageInfoInterface;
import com.example.mvp.myapplication.http.bean.callback.HomePagelistBean;
import com.example.mvp.myapplication.http.bean.callback.UserhomePageBean;
import com.example.mvp.myapplication.module.UserHomePagerModel;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:UserHomePagePresenter
 * @date :${DATA} 15:19
 */
public class UserHomePagePresenter<V extends HomePageInfoInterface.IhomePageV> extends BasePresenter<V> implements HomePageInfoInterface.IhomePageM,HomePageInfoInterface.IhomePageP{
    UserHomePagerModel  mUserHomePagerModel=new UserHomePagerModel();

    @Override
    public void setInfoData(UserhomePageBean userhomePageBean) {
          mview.showInfoData(userhomePageBean);
    }

    @Override
    public void setlistData(List<HomePagelistBean> data) {
         mview.showlistData(data);
    }

    @Override
    public void getInfoData(String userId, String lookuserId) {
               mUserHomePagerModel.gerInfoData(this,userId,lookuserId);
    }

    @Override
    public void getlistData(String json) {
               mUserHomePagerModel.getlistData(this,json);
    }
}
