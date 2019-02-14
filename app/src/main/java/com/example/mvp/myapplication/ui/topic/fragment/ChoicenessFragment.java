package com.example.mvp.myapplication.ui.topic.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.RVCTopicApdate;
import com.example.mvp.myapplication.adapter.RVTopicApdate;
import com.example.mvp.myapplication.app.Global;
import com.example.mvp.myapplication.base.fragment.BaseFragment;
import com.example.mvp.myapplication.contact.TopicInterface;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.TopicBean;
import com.example.mvp.myapplication.http.bean.callback.TopicListBean;
import com.example.mvp.myapplication.jsonbean.JsonLikesBean;
import com.example.mvp.myapplication.jsonbean.JsonRefreshTopic;
import com.example.mvp.myapplication.presenter.TopicPresenter;
import com.example.mvp.myapplication.ui.topic.activity.InsertTopicActivity;
import com.example.mvp.myapplication.utils.jsonUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChoicenessFragment extends BaseFragment<TopicInterface.ITopicDataV, TopicPresenter<TopicInterface.ITopicDataV>> implements TopicInterface.ITopicDataV, XRecyclerView.LoadingListener {

    @BindView(R.id.rv_topic_c)
    XRecyclerView mRvTopicC;
    private ArrayList<TopicListBean> mMTopicListBeans;
    private RVCTopicApdate mRVCTopicApdate;
    private String mMJson;
    private String mCursor;

    public ChoicenessFragment() {
        // Required empty public constructor
    }
    @OnClick(R.id.img_uploading_cf)
    public  void  onClick(View v){
         startActivity(new Intent(getContext(),InsertTopicActivity.class));
   }
    @Override
    protected void initEvemtData() {
        mMTopicListBeans = new ArrayList<>();
        mRVCTopicApdate = new RVCTopicApdate(mMTopicListBeans, getActivity());
        mRvTopicC.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvTopicC.setAdapter(mRVCTopicApdate);
        mMJson = jsonUtils.getStudent(new JsonRefreshTopic("1", "0", "", "c383f4c9026d471da0184ad5b24c0365"));
        persenter.getFreshTopicData(mMJson,Global.ONE);
        mRvTopicC.setLoadingListener(this);
        mRVCTopicApdate.setOnItemLikes(new RVTopicApdate.OnItemLikes() {
            @Override
            public void onlike(String objectId) {
                String json = jsonUtils.getStudent(new JsonLikesBean("c383f4c9026d471da0184ad5b24c0365", objectId, "1", "0"));
                persenter.getLike(json);
            }
        });
    }
    @Override
    public int createLayout() {
        return R.layout.fragment_choiceness;
    }

    @Override
    public TopicPresenter<TopicInterface.ITopicDataV> createPresnter() {
        return new TopicPresenter<>();
    }

    @Override
    public void showLike(InfoBean value) {
         showTost(value.getMessage());
    }

    @Override
    public void showData(TopicBean value) {
        mCursor = value.getMinCursor();
        mMTopicListBeans.addAll(value.getTopicList());
        mRVCTopicApdate.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        mMTopicListBeans.clear();
        persenter.getFreshTopicData(mMJson,Global.ONE);
        mRvTopicC.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        if (mCursor!=null) {
            Log.d("TAG", "loadMore");
            String json = jsonUtils.getStudent(new JsonRefreshTopic("1", mCursor, "", "c383f4c9026d471da0184ad5b24c0365"));
            persenter.getFreshTopicData(json, Global.THREE);
            mRvTopicC.loadMoreComplete();
        }else {
            showTost("没有更多内容了");
        }
    }



}
