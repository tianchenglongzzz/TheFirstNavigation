package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.TopicBean;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:TopicInterface
 * @date :${DATA} 15:35
 */
public interface TopicInterface {

      interface  ITopicDataV extends IBaseView{
           void    showLike(InfoBean value);
           void   showData(TopicBean value);
      }
    interface  ITopicDataM  extends HttpFinshCallBack {
        void    setLike(InfoBean value);
        void   setFreshTopicData(TopicBean value);
    }
        interface  ITopicDataP {
          void  getLike(String json);
          void  getFreshTopicData(String json,int i);
    }

}
