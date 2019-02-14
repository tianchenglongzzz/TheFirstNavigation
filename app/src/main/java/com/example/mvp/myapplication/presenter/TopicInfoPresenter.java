package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.TopicInfoInterface;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListCommentBean;
import com.example.mvp.myapplication.http.bean.callback.TopicListBean;
import com.example.mvp.myapplication.module.TopicInfoModel;
import com.example.mvp.myapplication.module.TopicModel;

import org.json.JSONObject;

import retrofit2.http.POST;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:TopicInfoPresenter
 * @date :${DATA} 14:35
 */
public class TopicInfoPresenter<V extends TopicInfoInterface.ITopicInfoIntefaceV> extends BasePresenter<V>
        implements TopicInfoInterface.ITopicInfoIntefaceP,TopicInfoInterface.ITopicInfoIntefaceM {
TopicInfoModel mTopicModel= new TopicInfoModel();
    @Override
    public void setTopicListBean(TopicListBean topicListBean) {
             mview.showTopicListBean(topicListBean);
    }

    @Override
    public void setlistComment(ListCommentBean listCommentBean) {
          mview.showlistComment(listCommentBean);
    }

    @Override
    public void setCommentData(InfoBean value) {
         mview.showCommentData(value);
    }

    @Override
    public void setFollow(InfoBean infoBean) {
         mview.showFollow(infoBean);
    }

    //获得搜藏数据
    @Override
    public void setFavouriteData(InfoBean infoBean) {
          mview.showFavouriteData(infoBean);
    }

    @Override
    public void getTopicListjson(String topicId, String userId) {
            mTopicModel.getTopicListBean(this,topicId,userId);
    }

    @Override
    public void getlistComment(String josn) {
          mTopicModel.getlistComment(this,josn);
    }

    @Override
    public void getCommentData(String json) {
          mTopicModel.putComment(this,json);
    }

    @Override
    public void followUser(String json) {
          mTopicModel.followUser(json,this);
    }
  //向M发送搜藏数据
    @Override
    public void getFavourite(String json) {
          mTopicModel.followUser(json,this);
    }
}
