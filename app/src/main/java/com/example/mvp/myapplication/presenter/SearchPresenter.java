package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.SearchInterface;
import com.example.mvp.myapplication.http.bean.callback.HotBean;
import com.example.mvp.myapplication.http.bean.callback.UpListNewsBean;
import com.example.mvp.myapplication.module.SearchModel;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:SearchPresenter
 * @date :${DATA} 16:02
 */
public class SearchPresenter<V extends SearchInterface.IsearcchV> extends BasePresenter<V> implements SearchInterface.IsearchP,SearchInterface.IsearchM{
     SearchModel mSearchModel=new SearchModel();

    @Override
    public void setHotBean(HotBean hotBean) {
        mview.showHotBean(hotBean);
    }

    @Override
    public void getHotBean(String json) {
          mSearchModel.getHotBean(this,json);
    }


}
