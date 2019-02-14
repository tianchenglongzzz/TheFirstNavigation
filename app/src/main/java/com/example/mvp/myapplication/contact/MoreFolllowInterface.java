package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.MoreFollowBean;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:MoreFolllowInterface
 * @date :${DATA} 15:51
 */
public interface MoreFolllowInterface {
     interface IMoreFolllowV extends IBaseView {
           void showMoreFolllowData(MoreFollowBean moreFollowBean);
     }
     interface IMoreFolllowM extends HttpFinshCallBack {
         void setMoreFolllowData(MoreFollowBean moreFollowBean);
     }
     interface IMoreFolllowP{
         void getMoreFolllowData(String json);
     }



}
