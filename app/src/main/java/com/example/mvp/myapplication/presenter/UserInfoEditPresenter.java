package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.UserInfoInterface;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListProfessionBean;
import com.example.mvp.myapplication.http.bean.callback.UploadHeadImageBean;
import com.example.mvp.myapplication.http.bean.callback.UserInfoEditBean;
import com.example.mvp.myapplication.module.UserInfoModel;

import java.io.File;
import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:UserInfoEditPresenter
 * @date :${DATA} 20:46
 */
//修改个人数据层
public class UserInfoEditPresenter<V extends UserInfoInterface.IUserInfoV> extends BasePresenter<V> implements UserInfoInterface.IUserInfoM,UserInfoInterface.IUserInfoP{
     UserInfoModel mUserInfoModel=new UserInfoModel();

    @Override
    public void setUserInfoBean(UserInfoEditBean userInfoEditBean) {
          mview.showUserInfoBean(userInfoEditBean);
    }

    @Override
    public void setProfessionlist(ListProfessionBean list) {
              mview.showProfessionlist(list);
    }

    @Override
    public void setUpData(InfoBean infoBean) {
          mview.showUpData(infoBean);
    }

    @Override
    public void setUploadHeadImageBean(UploadHeadImageBean uploadHeadImageBean) {
          mview.showUploadHeadImageBean(uploadHeadImageBean);
    }

    @Override
    public void getUserInfoBean(String userid) {
          mUserInfoModel.getUserInfoData(userid,this);
    }

    @Override
    public void getProfessionlist() {
     mUserInfoModel.getProfessionlist(this);
    }

    @Override
    public void updateUserInfo(String json) {
      mUserInfoModel.updateUserInfo(this,json);
    }

    @Override
    public void updateIcon(File file,String userid) {
              mUserInfoModel.getUploadHeadImage(this,file,userid);
    }
}
