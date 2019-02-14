package com.example.mvp.myapplication.module;

import com.example.mvp.myapplication.contact.FavouriteNewsInterface;
import com.example.mvp.myapplication.contact.FavouriteTopicInterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.FavouriteNewsBean;
import com.example.mvp.myapplication.http.bean.callback.FavouriteTopicBean;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.RxUtils;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:FavouriteModel
 * @date :${DATA} 20:51
 */
public class FavouriteModel {

      public  void getFavouriteNewsData(final FavouriteNewsInterface.InewsM inewsM, String userId, String cuser){
          inewsM.shetShowProgressbar();
          ApiManager.getApi().getFavouriteNewsData(userId,cuser).compose(RxUtils.<InfoBean<FavouriteNewsBean>>rxObserableSchedulerHelper())
                  .compose(RxUtils.<FavouriteNewsBean>handleResult()).subscribe(new BaseObserver<FavouriteNewsBean>(inewsM) {
              @Override
              public void onNext(FavouriteNewsBean value) {
                     inewsM.setNewsData(value);
              }
          });

      }
      public  void batchDelFavourite(final FavouriteNewsInterface.InewsM inewsM, String userId, String fid){
          inewsM.shetShowProgressbar();
          ApiManager.getApi().batchDelFavourite(userId,fid).compose(RxUtils.<InfoBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<InfoBean>(inewsM) {
              @Override
              public void onNext(InfoBean value) {
                  inewsM.setbatchDelFavouriteData(value);
              }
          });
      }
    public  void getFavouriteTpoicData(final FavouriteTopicInterface.ItopicM itopiM, String userId, String cuser){
        itopiM.shetShowProgressbar();
        ApiManager.getApi().getFavouriteTopicData(userId,cuser).compose(RxUtils.<InfoBean<FavouriteTopicBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<FavouriteTopicBean>handleResult()).subscribe(new BaseObserver<FavouriteTopicBean>(itopiM) {
            @Override
            public void onNext(FavouriteTopicBean value) {
                itopiM.setTopcicData(value);
            }
        });

    }
}
