package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.TopicBean;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:TopicInterface
 * @date :${DATA} 15:35
 */
public interface TopicInterface {

      interface  ITopicDataV extends IBaseView{
           void   showData(TopicBean value);
      }
    interface  ITopicDataM  extends HttpFinshCallBack {
        void   setFreshTopicData(TopicBean value);
    }
        interface  ITopicDataP {
          void  getFreshTopicData(String json,int i);
    }

}
