package com.example.mvp.myapplication.ui.topic.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.RVTopicApdate;
import com.example.mvp.myapplication.app.App;
import com.example.mvp.myapplication.app.Global;
import com.example.mvp.myapplication.base.fragment.BaseFragment;
import com.example.mvp.myapplication.base.persenter.IBasePresenter;
import com.example.mvp.myapplication.contact.TopicInterface;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.TopicBean;
import com.example.mvp.myapplication.http.bean.callback.TopicListBean;
import com.example.mvp.myapplication.jsonbean.JsonLikesBean;
import com.example.mvp.myapplication.jsonbean.JsonRefreshTopic;
import com.example.mvp.myapplication.presenter.TopicPresenter;
import com.example.mvp.myapplication.ui.topic.activity.InsertTopicActivity;
import com.example.mvp.myapplication.ui.topic.activity.TopicDataActivity;
import com.example.mvp.myapplication.utils.jsonUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnViewClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopicFragementTow extends BaseFragment<TopicInterface.ITopicDataV,TopicPresenter<TopicInterface.ITopicDataV>> implements TopicInterface.ITopicDataV,XRecyclerView.LoadingListener{


//    @BindView(R.id.img_uploading)
//    ImageView mImgUploading;
    @BindView(R.id.rv_topic)
    XRecyclerView mRvTopic;
    private RVTopicApdate mApdate;
    private ArrayList<TopicListBean> mTopicListBeans;
    private String mJson;
    private String mCursor;
   @BindView(R.id.img_uploading)
   ImageView mImgUpLoading;
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
        mApdate.setOnItemLikes(new RVTopicApdate.OnItemLikes() {
            @Override
            public void onlike(String objectId) {
                String json = jsonUtils.getStudent(new JsonLikesBean("c383f4c9026d471da0184ad5b24c0365", objectId, "1", "0"));
               persenter.getLike(json);
            }
        });
        mApdate.setOnItemUp(new RVTopicApdate.OnItemUp() {
            @Override
            public void onItemUpClick() {
                  new TDialog.Builder(getFragmentManager()).setLayoutRes(R.layout.popmask).setScreenHeightAspect(getActivity(),1f)
                          .setScreenWidthAspect(getActivity(),1f)
                          .addOnClickListener(new int[]{R.id.dissmiss})
                          .setOnViewClickListener(new OnViewClickListener() {
                              @Override
                              public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                                       switch (view.getId()){
                                           case R.id.dissmiss:
                                               tDialog.dismiss();
                                               break;
                                       }
                              }
                          })
                          .create().dismiss();

            }
        });

            }

    @Override
    public int createLayout() {
        return R.layout.fragment_topic_fragement_tow;
    }

    @Override
    public void showLike(InfoBean value) {
         showTost(value.getMessage());
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
        if (mCursor!=null) {
            String json = jsonUtils.getStudent(new JsonRefreshTopic("0", mCursor, "", "c383f4c9026d471da0184ad5b24c0365"));
            persenter.getFreshTopicData(json, Global.THREE);
            mRvTopic.loadMoreComplete();
        }else {
            showTost("没有更多内容了");
        }


    }

    @OnClick(R.id.img_uploading)
    public void onClick(View v) {
         startActivity(new Intent(getContext(),InsertTopicActivity.class));
    }

}
