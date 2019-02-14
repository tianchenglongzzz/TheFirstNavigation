package com.example.mvp.myapplication.ui.topic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.RVCTopicApdate;
import com.example.mvp.myapplication.app.Global;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.base.persenter.IBasePresenter;
import com.example.mvp.myapplication.contact.TopicInterface;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.TopicBean;
import com.example.mvp.myapplication.http.bean.callback.TopicListBean;
import com.example.mvp.myapplication.jsonbean.JsonRefreshTopic;
import com.example.mvp.myapplication.presenter.TagsPresenter;
import com.example.mvp.myapplication.presenter.TopicPresenter;
import com.example.mvp.myapplication.utils.jsonUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class ShowTagsTopicActivity extends BaseActivity<TopicInterface.ITopicDataV,TopicPresenter<TopicInterface.ITopicDataV>> implements TopicInterface.ITopicDataV,XRecyclerView.LoadingListener{
     @BindView(R.id.show_tags_topic_cl)
     ConstraintLayout mConstraintLayout;
    @BindView(R.id.rv_showTagsTopic)
    XRecyclerView mRvShowTagsTopic;
    private ArrayList<TopicListBean> mTopicListBeans;
    private RVCTopicApdate mRVCTopicApdate;
    private String mMinCursor;
    private String mJson;
    @BindView(R.id.tb_show_tags_topic)
    Toolbar mToolbar;
    @BindView(R.id.tv_toobar_show)
    TextView mToobarTitle;
    private View mView;

    @Override
    public int createLayout() {
        return R.layout.activity_show_tags_topic;
    }

    @Override
    public void origination() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        mToolbar.setNavigationIcon(R.mipmap.smallfanhui);
        mToolbar.setTitle("");
        mToobarTitle.setText(name);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 finish();
            }
        });
        mTopicListBeans = new ArrayList<>();
        mRVCTopicApdate = new RVCTopicApdate(mTopicListBeans, this);
        mRvShowTagsTopic.setLayoutManager(new LinearLayoutManager(this));
        mRvShowTagsTopic.setAdapter(mRVCTopicApdate);
        mJson = jsonUtils.getStudent(new JsonRefreshTopic("2", "0", "c383f4c9026d471da0184ad5b24c0365", id));
        persemter.getFreshTopicData(mJson,Global.ONE);
        mRvShowTagsTopic.setLoadingListener(this);
    }

    @Override
    public TopicPresenter createPresenter() {
        return new TopicPresenter();
    }


    @Override
    public void showLike(InfoBean value) {

    }

    @Override
    public void showData(TopicBean value) {
        if (value.getTopicList().size()!=0){
        mMinCursor = value.getMinCursor();
        mTopicListBeans.addAll(value.getTopicList());
        mRVCTopicApdate.notifyDataSetChanged();
        if (mView!=null){
            mView.setVisibility(View.GONE);
        }
        }else {
            mView = LayoutInflater.from(this).inflate(R.layout.search_no, mConstraintLayout, true);
            mView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onRefresh() {
        mTopicListBeans.clear();
        persemter.getFreshTopicData(mJson,Global.ONE);
        mRVCTopicApdate.notifyDataSetChanged();
    }

    @Override
    public void onLoadMore() {

    }
}
