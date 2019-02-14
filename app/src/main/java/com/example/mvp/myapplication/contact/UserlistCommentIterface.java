package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.UserListCommentBean;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:UserlistCommentIterface
 * @date :${DATA} 20:56
 */
public interface UserlistCommentIterface {
      interface IUserlistCommentV extends IBaseView{
           void showUserlistCommentData(UserListCommentBean userListCommentBean);
      }
    interface IUserlistCommentM extends HttpFinshCallBack {
        void setUserlistCommentData(UserListCommentBean userListCommentBean);
    }
    interface IUserlistCommentP {
        void getUserlistCommentData(String userId);
    }
}
