package com.example.mvp.myapplication.ui.my.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.FrementAdapter;
import com.example.mvp.myapplication.base.activity.BottomActivity;
import com.example.mvp.myapplication.ui.my.frement.FavouriteNewsFragment;
import com.example.mvp.myapplication.ui.my.frement.FavouriteTopicFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MyCollectActivity extends BottomActivity implements CheckBox.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.toobar_shouchang)
    Toolbar mToobarShouchang;
    @BindView(R.id.favourite_vp)
    ViewPager mViewPager;
    @BindView(R.id.news_and_topic_cb)
    CheckBox mCheckBox;
    @BindView(R.id.favour_edit_toobar_tv)
    TextView mEdiitTv;
    private ArrayList<Fragment> mFragments;
    private static boolean   eiditAndCancel=true;
    @Override
    public int createLayout() {
        return R.layout.activity_my_collect;
    }
    @Override
    public void origination() {
            setToobar(mToobarShouchang);
        mFragments = new ArrayList<>();
        mFragments.add(new FavouriteNewsFragment());
        mFragments.add(new FavouriteTopicFragment());
        FrementAdapter frementAdapter = new FrementAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(frementAdapter);
        mCheckBox.setOnCheckedChangeListener(this);
        mViewPager.addOnPageChangeListener(this);
    }

     @OnClick(R.id.favour_edit_toobar_tv)
    public  void  onClick(View view){
         int currentItem = mViewPager.getCurrentItem();
         Fragment fragment = mFragments.get(currentItem);
        if (eiditAndCancel) {
            mEdiitTv.setText("取消");
            eiditAndCancel=false;

            if (fragment instanceof FavouriteNewsFragment) {
                FavouriteNewsFragment newsFragment = (FavouriteNewsFragment) fragment;
                newsFragment.cancelFavourite();
            }else {

            }
        }else {
            mEdiitTv.setText("编辑");
                eiditAndCancel = true;

                if (fragment instanceof FavouriteNewsFragment) {
                    FavouriteNewsFragment newsFragment = (FavouriteNewsFragment) fragment;
                    newsFragment.cancel();
                } else {

                }

            }
        }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


               if (isChecked) {
                   mViewPager.setCurrentItem(1);
               } else {
                   mViewPager.setCurrentItem(0);
               }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
          if (position==0){
              mCheckBox.setChecked(false);
          }else {
              mCheckBox.setChecked(true);
          }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
