package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.listNewsBean;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:NewListTab
 * @date :${DATA} 19:27
 */
public interface NewListTab {
      interface  NewListView extends IBaseView {
           void showNewListBean(listNewsBean listNewsBean);
      }
       interface  ListNewTabPresenter{
           void getListNewTab(String json);
      }
       interface ListNewTabModule extends HttpFinshCallBack{
          void getListNewTab(listNewsBean listNewsBean);
      }
}
