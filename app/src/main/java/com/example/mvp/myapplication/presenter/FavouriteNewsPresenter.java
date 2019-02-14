package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.FavouriteNewsInterface;
import com.example.mvp.myapplication.contact.FavouriteTopicInterface;
import com.example.mvp.myapplication.http.bean.callback.FavouriteNewsBean;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.module.FavouriteModel;
import com.example.mvp.myapplication.ui.my.frement.FavouriteNewsFragment;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:FavouriteNewsPresenter
 * @date :${DATA} 20:57
 */
public class FavouriteNewsPresenter<V extends FavouriteNewsInterface.InewsV> extends BasePresenter<V> implements FavouriteNewsInterface.InewsP,FavouriteNewsInterface.InewsM {
    FavouriteModel mFavouriteModel=new FavouriteModel();
    @Override
    public void setNewsData(FavouriteNewsBean newsBean) {
              mview.showNewsData(newsBean);
    }

    @Override
    public void setbatchDelFavouriteData(InfoBean infoBean) {
        if (mview!=null) {
            mview.showbatchDelFavouriteData(infoBean);
        }
        }

    @Override
    public void getNewsData(String usetid, String cursor) {
               mFavouriteModel.getFavouriteNewsData(this,usetid,cursor);
    }

    @Override
    public void batchDelFavouriteData(String userId, String favouritIdList) {
                 mFavouriteModel.batchDelFavourite(this,userId,favouritIdList);
    }
}
