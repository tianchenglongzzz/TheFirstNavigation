package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.HomePagelistBean;
import com.example.mvp.myapplication.http.bean.callback.UserhomePageBean;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:HomePageInfoInterface
 * @date :${DATA} 15:11
 */
public interface HomePageInfoInterface {
       interface  IhomePageV extends IBaseView {
           void showInfoData(UserhomePageBean userhomePageBean);
           void  showlistData(List<HomePagelistBean> data);
       }
    interface  IhomePageM extends HttpFinshCallBack {
        void setInfoData(UserhomePageBean userhomePageBean);
        void  setlistData(List<HomePagelistBean> data);
    }
    interface  IhomePageP extends HttpFinshCallBack {
        void getInfoData(String  userId,String lookuserId);
        void getlistData(String json);
    }

    }


