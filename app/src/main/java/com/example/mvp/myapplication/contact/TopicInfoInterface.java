package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListCommentBean;
import com.example.mvp.myapplication.http.bean.callback.TopicListBean;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:TopicInfoInterface
 * @date :${DATA} 14:23
 */
public interface TopicInfoInterface {
       interface  ITopicInfoIntefaceV extends IBaseView {
             void showTopicListBean(TopicListBean topicListBean);
             void  showlistComment(ListCommentBean listCommentBean);
             void  showCommentData(InfoBean value);
             void  showFollow(InfoBean infoBean);
             //返回收藏成功的数据
             void showFavouriteData(InfoBean infoBean);


       }
    interface  ITopicInfoIntefaceM extends HttpFinshCallBack {
        void setTopicListBean(TopicListBean topicListBean);
        void setlistComment(ListCommentBean listCommentBean);
        void  setCommentData(InfoBean value);
        void  setFollow(InfoBean infoBean);
        //M层返回的搜藏成功的数据
        void setFavouriteData(InfoBean infoBean);

    }
    interface  ITopicInfoIntefaceP{
        void getTopicListjson(String topicId,String userId);
        void  getlistComment(String josn);
        void  getCommentData(String json);
        void   followUser(String json);
        //向P传递搜藏数据
        void   getFavourite(String json);


    }
}
