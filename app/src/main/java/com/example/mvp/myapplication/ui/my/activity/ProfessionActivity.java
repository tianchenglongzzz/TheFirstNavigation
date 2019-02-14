package com.example.mvp.myapplication.ui.my.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.ProfessionAdapter;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.base.activity.BottomActivity;
import com.example.mvp.myapplication.contact.UserInfoInterface;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListProfessionBean;
import com.example.mvp.myapplication.http.bean.callback.UploadHeadImageBean;
import com.example.mvp.myapplication.http.bean.callback.UserInfoEditBean;
import com.example.mvp.myapplication.presenter.UserInfoEditPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ProfessionActivity extends BaseActivity<UserInfoInterface.IUserInfoV,UserInfoEditPresenter<UserInfoInterface.IUserInfoV>> implements UserInfoInterface.IUserInfoV {



    @BindView(R.id.profession_rv)
    RecyclerView mProfessionRv;
    private Intent mIntent;
    private ArrayList<ListProfessionBean.ProfessionListBean> mListProfessionBeans;
    private ProfessionAdapter mProfessionAdapter;
     @BindView(R.id.pri_toobar)
    Toolbar mToolbar;
    private String mId;
    private String mPfi="";
    private String mName="";

    @Override
    public int createLayout() {
        return R.layout.activity_profession;
    }

    @Override
    public void origination() {
        initToobar();
        initProfessionlist();
    }

    private void initToobar() {
          mToolbar.setTitle("");
          mToolbar.setNavigationIcon(R.mipmap.smallfanhui);
          setSupportActionBar(mToolbar);
          mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                   mIntent.putExtra("id",mPfi);
                   mIntent.putExtra("name",mName);
                   ProfessionActivity.this.setResult(10,mIntent);
                    finish();
              }
          });
    }

    private void initProfessionlist() {
        mIntent = getIntent();
        mId = mIntent.getStringExtra("id");


        persemter.getProfessionlist();

    }


    @OnClick(R.id.profession_rv)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.profession_rv:
                break;
        }
    }

    @Override
    public UserInfoEditPresenter<UserInfoInterface.IUserInfoV> createPresenter() {
        return new UserInfoEditPresenter();
    }

    @Override
    public void showProfessionlist(ListProfessionBean list) {
        mProfessionAdapter = new ProfessionAdapter(list,mId,this);
        mProfessionRv.setLayoutManager(new LinearLayoutManager(this));
        mProfessionRv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mProfessionRv.setAdapter(mProfessionAdapter);
        mProfessionAdapter.setOnCheckListener(new ProfessionAdapter.onCheckListener() {



            @Override
            public void onCheck(String pfi,String name) {
                mPfi = pfi;
                mName = name;
            }
        });
    }

    @Override
    public void showUserInfoBean(UserInfoEditBean userInfoEditBean) {

    }

    @Override
    public void showUpData(InfoBean infoBean) {

    }

    @Override
    public void showUploadHeadImageBean(UploadHeadImageBean uploadHeadImageBean) {

    }
}
