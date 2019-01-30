package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.base.persenter.IBasePresenter;
import com.example.mvp.myapplication.contact.SearchInterface;
import com.example.mvp.myapplication.http.bean.callback.UpListNewsBean;
import com.example.mvp.myapplication.module.SearchModel;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:SearchPresenterTow
 * @date :${DATA} 20:02
 */
public class SearchPresenterTow<V extends SearchInterface.IsearchNewsv> extends BasePresenter<V> implements SearchInterface.IsearchNewsM,SearchInterface.IsearchNewsP{
    SearchModel mSearchModel=new SearchModel();

    @Override
    public void setNewsBean(UpListNewsBean upListNewsBean) {
         mview.showNewsBean(upListNewsBean);
    }

    @Override
    public void getNewsBean(String json) {
       mSearchModel.getHotBean(this,json);
    }
}
