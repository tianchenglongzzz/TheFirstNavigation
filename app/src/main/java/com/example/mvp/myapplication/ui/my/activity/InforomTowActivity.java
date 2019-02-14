package com.example.mvp.myapplication.ui.my.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;


import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.FrementAdapterTitle;
import com.example.mvp.myapplication.app.Global;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.contact.ListNotifyInterface;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListNotifyBean;
import com.example.mvp.myapplication.presenter.ListNotifyPresenter;
import com.example.mvp.myapplication.ui.my.frement.ListNotifyGuanZuFragment;
import com.example.mvp.myapplication.ui.my.frement.ListNotifyPinglunFragment;
import com.example.mvp.myapplication.ui.my.frement.ListNotifySytemFragment;
import com.example.mvp.myapplication.ui.my.frement.ListNotifydianZanFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class InforomTowActivity extends BaseActivity<ListNotifyInterface.IListNotifyV, ListNotifyPresenter<ListNotifyInterface.IListNotifyV>> implements ListNotifyInterface.IListNotifyV {


    @BindView(R.id.inforom_tobar)
    Toolbar mInforomTobar;
    @BindView(R.id.inform_vp)
    ViewPager mInformVp;
    @BindView(R.id.inforom_table)
    TabLayout mTabLayout;
    private ArrayList<String> mTitle;
    private ArrayList<Fragment> mFragments;
    @BindView(R.id.ll_notify)
    ViewGroup mViewGroup;

    @Override
    public int createLayout() {
        return R.layout.activity_inforom_tow;
    }

    @Override
    public void origination() {
        mTitle = new ArrayList<>();
        mTitle.add("通知");
        mTitle.add("评论我");
        mTitle.add("关注我");
        mTitle.add("点赞我");
        mFragments = new ArrayList<>();
        persemter.getListNotifyData(Global.USER);
    }


    //获取数据
    @Override
    public void showListNotifyData(ArrayList<ListNotifyBean> listNotifyBean) {
        if (listNotifyBean.size()==0){
            mViewGroup.setVisibility(View.VISIBLE);
        }
        //区分点赞评论
        ArrayList<ListNotifyBean> guanzhu = new ArrayList<>();
        ArrayList<ListNotifyBean> dianzan = new ArrayList<>();
        ArrayList<ListNotifyBean> pinglun = new ArrayList<>();
        ArrayList<ListNotifyBean> sytem = new ArrayList<>();
        for (int i = 0; i <listNotifyBean.size() ; i++) {
            String type = listNotifyBean.get(i).getNotifyType();
            int typef = Integer.parseInt(type);
            if (typef==0){
                sytem.add(listNotifyBean.get(i));
            }else if (typef==1) {
                guanzhu.add(listNotifyBean.get(i));
            }else if (typef==3){
                 dianzan.add(listNotifyBean.get(i));
            }else {
                 pinglun.add(listNotifyBean.get(i));
            }
        }
        //创建并绑定适配器
        mFragments.add(new ListNotifySytemFragment(sytem));
        mFragments.add(new ListNotifyPinglunFragment(pinglun));
        mFragments.add(new ListNotifyGuanZuFragment(guanzhu));
        mFragments.add(new ListNotifydianZanFragment(dianzan));
        FrementAdapterTitle frementAdapterTitle = new FrementAdapterTitle(getSupportFragmentManager(), mFragments, mTitle);
        mInformVp.setAdapter(frementAdapterTitle);
        mTabLayout.setupWithViewPager(mInformVp);
        for (int i = 0; i <mFragments.size() ; i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);

            View view = LayoutInflater.from(this).inflate(R.layout.tabnotify, null);
         TextView textView=   view.findViewById(R.id.tv_notify);
         textView.setText(mTitle.get(i));
            TextView textViewCont=   view.findViewById(R.id.tv_notify_cont);
      if (mTitle.get(i).equals("通知")){
                if (sytem.size()==0) {
                   textViewCont.setVisibility(View.GONE);
                }else {
                    textViewCont.setText(sytem.size() + "");
                }
                }else if (mTitle.get(i).equals("评论我")){
                    if (pinglun.size()==0){
                        textViewCont.setVisibility(View.GONE);
                    }else {
                        textViewCont.setText(pinglun.size()+"");
                    }
                }else if (mTitle.get(i).equals("关注我")){
                if (guanzhu.size()==0){
                    textViewCont.setVisibility(View.GONE);
                }else {
                    textViewCont.setText(guanzhu.size()+"");
                }
            }else if (mTitle.get(i).equals("点赞我")){
                if (dianzan.size()==0){
                    textViewCont.setVisibility(View.GONE);
                }else {
                    textViewCont.setText(dianzan.size()+"");
                }
            }
            tab.setCustomView(view);
            }
        View view = mTabLayout.getTabAt(0).getCustomView();
        TextView textView=   view.findViewById(R.id.tv_notify);
        textView.setTextColor(getResources().getColor(R.color.read));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               View view = tab.getCustomView();
               TextView textView=   view.findViewById(R.id.tv_notify);
               textView.setTextColor(getResources().getColor(R.color.read));
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {
               View view = tab.getCustomView();
               TextView textView=   view.findViewById(R.id.tv_notify);
               textView.setTextColor(getResources().getColor(R.color.black));
           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });



    }


    @Override
    public void showInfoData(InfoBean infoBean) {

    }
   //创建P层
    @Override
    public ListNotifyPresenter<ListNotifyInterface.IListNotifyV> createPresenter() {
        return new ListNotifyPresenter<>();
    }


}
