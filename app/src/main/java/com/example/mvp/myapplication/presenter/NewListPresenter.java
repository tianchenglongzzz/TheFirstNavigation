package com.example.mvp.myapplication.presenter;

import android.util.Log;
import android.widget.ProgressBar;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.base.persenter.IBasePresenter;
import com.example.mvp.myapplication.contact.NewListTab;
import com.example.mvp.myapplication.http.bean.callback.listNewsBean;
import com.example.mvp.myapplication.module.ListTabMoudle;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:NewListPresenter
 * @date :${DATA} 19:34
 */
public class NewListPresenter<V extends NewListTab.NewListView> extends BasePresenter<V> implements NewListTab.ListNewTabPresenter,NewListTab.ListNewTabModule {

      ListTabMoudle mListTabMoudle=new ListTabMoudle();
    @Override
    public void getListNewTab(String json) {
           mListTabMoudle.getTabList(this,json);
    }

    @Override
    public void getListNewTab(listNewsBean listNewsBean) {


           mview.showNewListBean(listNewsBean);
    }


}
