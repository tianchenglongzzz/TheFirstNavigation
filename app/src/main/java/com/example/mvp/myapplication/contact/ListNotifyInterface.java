package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListNotifyBean;

import java.util.ArrayList;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:ListNotifyInterface
 * @date :${DATA} 22:01
 */
public interface ListNotifyInterface {
     interface  IListNotifyV extends IBaseView{
          void showListNotifyData(ArrayList<ListNotifyBean> listNotifyBean);
          void showInfoData(InfoBean infoBean);
     }
     interface  IListNotifyM extends HttpFinshCallBack{
         void  setListNotifyData(ArrayList<ListNotifyBean> listNotifyBean);
         void  setInfoBean(InfoBean infoBean);
     }
     interface IListNotifyP {
         void  getListNotifyData(String userId);
         void   deleteAllNotify(String userId);
     }
}
