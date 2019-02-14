package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.UserlistCommentIterface;
import com.example.mvp.myapplication.http.bean.callback.UserListCommentBean;
import com.example.mvp.myapplication.module.UserListCommentModel;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:UserListCommentPresenter
 * @date :${DATA} 21:02
 */
public class UserListCommentPresenter<V extends UserlistCommentIterface.IUserlistCommentV> extends BasePresenter<V> implements UserlistCommentIterface.IUserlistCommentM,UserlistCommentIterface.IUserlistCommentP{
   UserListCommentModel mUserListCommentModel=new UserListCommentModel();

    @Override
    public void setUserlistCommentData(UserListCommentBean userListCommentBean) {
               mview.showUserlistCommentData(userListCommentBean);
    }

    @Override
    public void getUserlistCommentData(String userId) {
               mUserListCommentModel.getUserListCommentData(this,userId);
    }
}
