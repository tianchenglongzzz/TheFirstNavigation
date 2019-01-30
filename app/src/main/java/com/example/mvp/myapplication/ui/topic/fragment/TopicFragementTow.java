package com.example.mvp.myapplication.ui.topic.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.RVTopicApdate;
import com.example.mvp.myapplication.app.App;
import com.example.mvp.myapplication.app.Global;
import com.example.mvp.myapplication.base.fragment.BaseFragment;
import com.example.mvp.myapplication.base.persenter.IBasePresenter;
import com.example.mvp.myapplication.contact.TopicInterface;
import com.example.mvp.myapplication.http.bean.callback.TopicBean;
import com.example.mvp.myapplication.jsonbean.JsonRefreshTopic;
import com.example.mvp.myapplication.presenter.TopicPresenter;
import com.example.mvp.myapplication.utils.jsonUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopicFragementTow extends BaseFragment<TopicInterface.ITopicDataV,TopicPresenter<TopicInterface.ITopicDataV>> implements TopicInterface.ITopicDataV,XRecyclerView.LoadingListener {


//    @BindView(R.id.img_uploading)
//    ImageView mImgUploading;
    @BindView(R.id.rv_topic)
    XRecyclerView mRvTopic;
    private RVTopicApdate mApdate;
    private ArrayList<TopicBean.TopicListBean> mTopicListBeans;
    private String mJson;
    private String mCursor;

    public TopicFragementTow() {
        // Required empty public constructor
    }


    @Override
    public TopicPresenter createPresnter() {
        return new TopicPresenter();
    }

    @Override
    protected void initEvemtData() {
        mTopicListBeans = new ArrayList<>();
        mApdate = new RVTopicApdate(mTopicListBeans, getActivity());
        mRvTopic.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvTopic.setAdapter(mApdate);
        mJson = jsonUtils.getStudent(new JsonRefreshTopic("0", "0", "", "c383f4c9026d471da0184ad5b24c0365"));
        persenter.getFreshTopicData(mJson,Global.ONE);
        mRvTopic.setLoadingListener(this);

            }

    @Override
    public int createLayout() {
        return R.layout.fragment_topic_fragement_tow;
    }

    @Override
    public void showData(TopicBean value) {
        mCursor = value.getMinCursor();
        mTopicListBeans.addAll(value.getTopicList());
         mApdate.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
         mTopicListBeans.clear();
         persenter.getFreshTopicData(mJson,Global.ONE);
         mRvTopic.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        String json = jsonUtils.getStudent(new JsonRefreshTopic("0", mCursor, "", "c383f4c9026d471da0184ad5b24c0365"));
        persenter.getFreshTopicData(json,Global.THREE);
        mRvTopic.loadMoreComplete();


    }
}
