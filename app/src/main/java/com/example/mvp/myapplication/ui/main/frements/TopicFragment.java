package com.example.mvp.myapplication.ui.main.frements;


import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.FrementAdapter;
import com.example.mvp.myapplication.adapter.FrementAdapterTitle;
import com.example.mvp.myapplication.base.activity.BottomActivity;
import com.example.mvp.myapplication.base.fragment.BaseFragment;
import com.example.mvp.myapplication.base.fragment.BottomFragment;
import com.example.mvp.myapplication.base.persenter.IBasePresenter;
import com.example.mvp.myapplication.presenter.NewListPresenter;
import com.example.mvp.myapplication.ui.topic.fragment.ChoicenessFragment;
import com.example.mvp.myapplication.ui.topic.fragment.SortFragment;
import com.example.mvp.myapplication.ui.topic.fragment.TopicFragementTow;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopicFragment extends BottomFragment {
    @BindView(R.id.vp_topic)
    ViewPager mViewPager;
    @BindView(R.id.tab_topic)
    TabLayout mTabLayout;

    private ArrayList<Fragment> mTiopcFragements;

    public TopicFragment() {
        // Required empty public constructor
    }




    @Override
    protected void initEvemtData() {
        ArrayList<String> title = new ArrayList<>();
        title.add("话题");
        title.add("精选");
        title.add("分类");
        mTiopcFragements = new ArrayList<>();
        TopicFragementTow topicFragementTow = new TopicFragementTow();
        ChoicenessFragment choicenessFragment = new ChoicenessFragment();
        SortFragment sortFragment = new SortFragment();
        mTiopcFragements.add(topicFragementTow);
        mTiopcFragements.add(choicenessFragment);
        mTiopcFragements.add(sortFragment);
        FrementAdapterTitle frementAdapterTitle = new FrementAdapterTitle(getChildFragmentManager(), mTiopcFragements, title);
        mViewPager.setAdapter(frementAdapterTitle);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public int createLayout() {
        return R.layout.fragment_topic;
    }





}
