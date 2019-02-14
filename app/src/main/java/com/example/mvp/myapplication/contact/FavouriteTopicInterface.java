package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.FavouriteNewsBean;
import com.example.mvp.myapplication.http.bean.callback.FavouriteTopicBean;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:FavouriteNewsInterface
 * @date :${DATA} 20:53
 */
public interface FavouriteTopicInterface {
      interface  ItopicV extends IBaseView{
          void  showTopicData(FavouriteTopicBean  value);
      }
      interface ItopicM extends HttpFinshCallBack{
          void  setTopcicData(FavouriteTopicBean  value);
      }
      interface  ItopicP{
          void  getTopicData(String usetid, String cursor);
      }

}
