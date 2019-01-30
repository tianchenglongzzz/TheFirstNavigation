package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.UpListNewsIntenface;
import com.example.mvp.myapplication.http.bean.callback.DownListNewsBean;
import com.example.mvp.myapplication.http.bean.callback.UpListNewsBean;
import com.example.mvp.myapplication.module.UpListNewsModel;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:UpListNewsPresenter
 * @date :${DATA} 20:46
 */
public class UpListNewsPresenter<V extends UpListNewsIntenface.IUpListNewsV> extends BasePresenter<V> implements UpListNewsIntenface.IUpListNewsP,UpListNewsIntenface.IUpListNewsM {

    UpListNewsModel mUploadHeadImageModel=  new UpListNewsModel();

    @Override
    public void setUpListNewsData(String json) {
          mUploadHeadImageModel.getUpListDatd(this,json);
    }

    @Override
    public void getDownListNewsData(String json) {
          mUploadHeadImageModel.getDownListNews(this,json);
    }

    @Override
    public void setUpListNewsData(UpListNewsBean json) {
          mview.showUpListNewsData(json);
    }

    @Override
    public void getDownListNewsHeadImageuBean(UpListNewsBean downListNewsBean) {
            mview.setDownListNewsHeadImageuBean(downListNewsBean);
    }

}
