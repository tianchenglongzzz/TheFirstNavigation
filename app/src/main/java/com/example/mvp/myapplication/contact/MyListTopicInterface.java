package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.MyListTopicBean;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:MyListTopic
 * @date :${DATA} 13:01
 */
public interface MyListTopicInterface {
        interface  ITopicV extends IBaseView {
              void  showTopicData(MyListTopicBean listTopicBean);
        }
        interface ITopicM extends HttpFinshCallBack{

             void  setTopicData(MyListTopicBean listTopicBean);
        }
        interface ITopiP extends HttpFinshCallBack{
              void  getTopicData(String userid,String cursor);
        }
}
