package com.example.mvp.myapplication.ui.my.frement;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.ApdaterFavouritTopic;
import com.example.mvp.myapplication.base.fragment.BaseFragment;
import com.example.mvp.myapplication.contact.FavouriteTopicInterface;
import com.example.mvp.myapplication.http.bean.callback.FavouriteTopicBean;
import com.example.mvp.myapplication.http.bean.callback.TopicBean;
import com.example.mvp.myapplication.presenter.FavouriteTopicPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteTopicFragment extends BaseFragment<FavouriteTopicInterface.ItopicV, FavouriteTopicPresenter<FavouriteTopicInterface.ItopicV>> implements FavouriteTopicInterface.ItopicV {


    @BindView(R.id.rv)
    RecyclerView mRv;
    private View view;
    private ArrayList<FavouriteTopicBean.FavouritTopicListBean> mFavouritTopicListBeans;
    private ApdaterFavouritTopic mApdaterFavouritTopic;


    public FavouriteTopicFragment() {
        // Required empty public constructor
    }



    @Override
    protected void initEvemtData() {
        mFavouritTopicListBeans = new ArrayList<>();
        mApdaterFavouritTopic = new ApdaterFavouritTopic(mFavouritTopicListBeans, getActivity());
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mRv.setAdapter(mApdaterFavouritTopic);
        persenter.getTopicData("c383f4c9026d471da0184ad5b24c0365","0");

    }

    @Override
    public int createLayout() {
        return R.layout.fragment_favourite_topic;
    }

    @Override
    public FavouriteTopicPresenter<FavouriteTopicInterface.ItopicV> createPresnter() {
        return new FavouriteTopicPresenter();
    }

    @Override
    public void showTopicData(FavouriteTopicBean value) {
        showTost(value.toString());
            mFavouritTopicListBeans.addAll(value.getFavouritTopicList());
            mApdaterFavouritTopic.notifyDataSetChanged();
    }

    @OnClick(R.id.rv)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rv:
                break;
        }
    }

}
