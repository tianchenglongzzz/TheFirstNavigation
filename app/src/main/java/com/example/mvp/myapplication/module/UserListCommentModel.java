package com.example.mvp.myapplication.module;

import com.example.mvp.myapplication.contact.UserlistCommentIterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.UserListCommentBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.RxUtils;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:UserListCommetModel
 * @date :${DATA} 20:58
 */
public class UserListCommentModel {

       public  void  getUserListCommentData(final UserlistCommentIterface.IUserlistCommentM iUserlistCommentM, String userId){
             iUserlistCommentM.setHideProgressbar();
             ApiManager.getApi().getUserListCommentBean(userId).compose(RxUtils.<InfoBean<UserListCommentBean>>rxObserableSchedulerHelper())
                      .compose(RxUtils.<UserListCommentBean>handleResult())
                      .subscribe(new BaseObserver<UserListCommentBean>(iUserlistCommentM) {
                             @Override
                             public void onNext(UserListCommentBean value) {
                                    iUserlistCommentM.setUserlistCommentData(value);
                             }
                      });

       }


}
