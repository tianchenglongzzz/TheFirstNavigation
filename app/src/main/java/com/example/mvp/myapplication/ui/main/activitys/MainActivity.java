package com.example.mvp.myapplication.ui.main.activitys;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.FrementAdapter;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.base.activity.BottomActivity;
import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.NewListTab;
import com.example.mvp.myapplication.http.bean.callback.listNewsBean;
import com.example.mvp.myapplication.presenter.NewListPresenter;
import com.example.mvp.myapplication.ui.main.frements.CircleFragment;
import com.example.mvp.myapplication.ui.main.frements.MyFrement;
import com.example.mvp.myapplication.ui.main.frements.NewsFragment;
import com.example.mvp.myapplication.ui.main.frements.TopicFragment;
import com.example.mvp.myapplication.ui.news.activity.SearchActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BottomActivity {
@BindView(R.id.toobar_search)
  ImageView mImageView;
 @BindView(R.id.man_vp)
    ViewPager mViewPager;
@BindView(R.id.man_tab)
    TabLayout mTabLayout;
@BindView(R.id.main_toobar)
    Toolbar mToolbar;
    private FrementAdapter mFrementAdapter;

    @Override
    public int createLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void origination() {

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        NewsFragment newsFragment = new NewsFragment();
        TopicFragment topicFragment = new TopicFragment();

        MyFrement myFrement = new MyFrement();
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(newsFragment);
        fragments.add(topicFragment);
        fragments.add(myFrement);


        mFrementAdapter = new FrementAdapter(getSupportFragmentManager(), fragments);

        mViewPager.setAdapter(mFrementAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i <fragments.size() ; i++) {
            Tab tabAt = mTabLayout.getTabAt(i);
            if (i==0){
                tabAt.setIcon(R.drawable.newsselector).setText("资讯");
            }else if (i==1){
                tabAt.setIcon(R.drawable.huatiselector).setText("话题");
            }else if (i==2){
                tabAt.setIcon(R.drawable.myselector).setText("我的");
            }
        }
        initParam();

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==0){
                    mToolbar.setVisibility(View.VISIBLE);
                }else {
                    mToolbar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    @OnClick(R.id.toobar_search)
    public  void  onClick(){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
    private void initParam() {
        int tabCount = mTabLayout.getTabCount();

    }

    @Override
    public void initData() {
        super.initData();


    }


    protected void onResume() {
        super.onResume();

      //  MobclickAgent.onResume(this);
    }

    protected void onPause() {
        super.onPause();
      //  MobclickAgent.onPause(this);
    }

}
