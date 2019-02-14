package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.FavouriteNewsBean;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:FavouriteNewsInterface
 * @date :${DATA} 20:53
 */
public interface FavouriteNewsInterface {
      interface  InewsV extends IBaseView{
          void  showNewsData(FavouriteNewsBean newsBean);
          void  showbatchDelFavouriteData(InfoBean infoBean);
      }
      interface InewsM extends HttpFinshCallBack{
          void  setNewsData(FavouriteNewsBean newsBean);
          void  setbatchDelFavouriteData(InfoBean infoBean);
      }
      interface  InewsP{
          void  getNewsData(String usetid,String cursor);
          void  batchDelFavouriteData(String  userId,String favouritIdList);
      }

}
