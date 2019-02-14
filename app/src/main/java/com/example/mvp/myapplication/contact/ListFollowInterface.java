package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListFollowBean;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:ListFollowInterface
 * @date :${DATA} 18:40
 */
public interface ListFollowInterface {
       interface   IListFollowV extends IBaseView {
           void showListFollowData(ListFollowBean listFollowBean);
           void  showfollow(InfoBean infoBean);

       }
        interface IListFollowM extends HttpFinshCallBack {
            void setListFollowData(ListFollowBean listFollowBean);
            void  setfollow(InfoBean infoBean);
        }
        interface IListFollowP {

           void  getListFollqData(String userId);
            void  follow(String json);
        }


}
