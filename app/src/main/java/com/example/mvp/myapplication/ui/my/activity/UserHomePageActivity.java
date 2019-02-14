package com.example.mvp.myapplication.ui.my.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.RVUserTopicApdate;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.contact.HomePageInfoInterface;
import com.example.mvp.myapplication.http.bean.callback.HomePagelistBean;
import com.example.mvp.myapplication.http.bean.callback.UserhomePageBean;
import com.example.mvp.myapplication.jsonbean.JsonHomePage;
import com.example.mvp.myapplication.presenter.UserHomePagePresenter;
import com.example.mvp.myapplication.utils.jsonUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserHomePageActivity extends BaseActivity<HomePageInfoInterface.IhomePageV,UserHomePagePresenter<HomePageInfoInterface.IhomePageV>>implements HomePageInfoInterface.IhomePageV {

    @BindView(R.id.home_icon_sdv)
    SimpleDraweeView mHomeIconSdv;
    @BindView(R.id.home_nikeame_tv)
    TextView mHomeNikeameTv;
    @BindView(R.id.home_tpics)
    TextView mHomeTpics;
    @BindView(R.id.home_followers_tv)
    TextView mHomeFollowersTv;
    @BindView(R.id.home_personalProfile)
    TextView mHomePersonalProfile;
    @BindView(R.id.home_toobar)
    Toolbar mHomeToobar;
    @BindView(R.id.home_rv)
    RecyclerView mRecyclerView;
    private RVUserTopicApdate mApdate;
    private ArrayList<HomePagelistBean> mHomePagelistBeans;
    private String mPrpfessionId;


    @Override
    public UserHomePagePresenter createPresenter() {
        return new UserHomePagePresenter();
    }

    @Override
    public int createLayout() {
        return R.layout.activity_user_home_page;
    }

    @Override
    public void origination() {
        mHomeToobar.setTitle("");
        mHomeToobar.setNavigationIcon(R.mipmap.smallfanhui);
        setSupportActionBar(mHomeToobar);
        mHomeToobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 finish();
            }
        });
        String id = getIntent().getStringExtra("id");
        persemter.getInfoData("c383f4c9026d471da0184ad5b24c0365",id);
        String json = jsonUtils.getStudent(new JsonHomePage("c383f4c9026d471da0184ad5b24c0365", id, "0"));
        mHomePagelistBeans = new ArrayList<>();
        mApdate = new RVUserTopicApdate(mHomePagelistBeans, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mApdate);
        persemter.getlistData(json);


    }

    @Override
    public void showInfoData(UserhomePageBean userhomePageBean) {
               mHomeFollowersTv.setText(userhomePageBean.getFollowers()+"");
               mHomeIconSdv.setImageURI(userhomePageBean.getHeadImagePath());
               mHomeNikeameTv.setText(userhomePageBean.getNickname());
               mHomePersonalProfile.setText(userhomePageBean.getTopics()+"");
               mHomePersonalProfile.setText(userhomePageBean.getPersonalProfile());

    }

    @Override
    public void showlistData(List<HomePagelistBean> data) {
                mHomePagelistBeans.addAll(data);
                mApdate.notifyDataSetChanged();
    }


}
