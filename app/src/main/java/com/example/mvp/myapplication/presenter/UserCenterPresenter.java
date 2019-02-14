package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.UserCenterInterface;
import com.example.mvp.myapplication.http.bean.callback.UserCenterBean;
import com.example.mvp.myapplication.module.UserModel;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:UserCenterPresenter
 * @date :${DATA} 12:31
 */
public class UserCenterPresenter<V extends UserCenterInterface.IUserCenterV> extends BasePresenter<V> implements UserCenterInterface.IUserCenterM,UserCenterInterface.IUserCenterP{
   UserModel mUserModel= new UserModel();
    @Override
    public void setCenterData(UserCenterBean data) {
        if (data!=null) {
            mview.showCenterData(data);
        }
        }

    @Override
    public void setCenterData(String json) {
            mUserModel.getUserCenterData(this,json);
    }
}
