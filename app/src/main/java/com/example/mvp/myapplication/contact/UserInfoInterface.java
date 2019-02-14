package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListProfessionBean;
import com.example.mvp.myapplication.http.bean.callback.UploadHeadImageBean;
import com.example.mvp.myapplication.http.bean.callback.UserInfoEditBean;

import java.io.File;
import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:UserInfoInterface
 * @date :${DATA} 20:41
 */
public interface UserInfoInterface {
     interface IUserInfoV extends IBaseView{
         void  showProfessionlist(ListProfessionBean list);
           void  showUserInfoBean(UserInfoEditBean userInfoEditBean);
           void  showUpData(InfoBean infoBean);
           void  showUploadHeadImageBean(UploadHeadImageBean uploadHeadImageBean);
     }
    interface IUserInfoM extends HttpFinshCallBack {
        void  setUserInfoBean(UserInfoEditBean userInfoEditBean);
        void  setProfessionlist(ListProfessionBean list);
        void  setUpData(InfoBean infoBean);
        void  setUploadHeadImageBean(UploadHeadImageBean uploadHeadImageBean);
    }


    interface IUserInfoP {
         void getUserInfoBean(String userid);
         void getProfessionlist();
         void updateUserInfo(String json);
         void updateIcon(File file,String userId);
    }
}
