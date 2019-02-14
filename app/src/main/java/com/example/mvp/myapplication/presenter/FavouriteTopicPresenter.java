package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.FavouriteNewsInterface;
import com.example.mvp.myapplication.contact.FavouriteTopicInterface;
import com.example.mvp.myapplication.http.bean.callback.FavouriteNewsBean;
import com.example.mvp.myapplication.http.bean.callback.FavouriteTopicBean;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.module.FavouriteModel;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:FavouriteNewsPresenter
 * @date :${DATA} 20:57
 */
public class FavouriteTopicPresenter<V extends FavouriteTopicInterface.ItopicV> extends BasePresenter<V> implements FavouriteTopicInterface.ItopicP,FavouriteTopicInterface.ItopicM {
    FavouriteModel mFavouriteModel=new FavouriteModel();


    @Override
    public void setTopcicData(FavouriteTopicBean value) {
          mview.showTopicData(value);
    }

    @Override
    public void getTopicData(String usetid, String cursor) {
               mFavouriteModel.getFavouriteTpoicData(this,usetid,cursor);
    }
}
