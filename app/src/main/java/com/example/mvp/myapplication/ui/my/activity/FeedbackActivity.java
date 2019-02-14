package com.example.mvp.myapplication.ui.my.activity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.FrementAdapterTitle;
import com.example.mvp.myapplication.base.activity.BottomActivity;
import com.example.mvp.myapplication.ui.my.frement.ListFeedbackFragment;
import com.example.mvp.myapplication.ui.my.frement.QuestionFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeedbackActivity extends BottomActivity {

    @BindView(R.id.feedback_toobar)
    Toolbar mFeedbackToobar;
    @BindView(R.id.feedback_tab)
    TabLayout mFeedbackTab;
    @BindView(R.id.feedback_vp)
    ViewPager mViewPager;


    @Override
    public int createLayout() {
        return R.layout.activity_feedback;
    }

    @Override
    public void origination() {

        ButterKnife.bind(this);
        Intent intent = getIntent();
        String headImg = intent.getStringExtra("headImg");
        ArrayList<String> title = new ArrayList<>();
        title.add("提交反馈");
        title.add("常见问题");
        ArrayList<android.support.v4.app.Fragment> fragments = new ArrayList<>();
        fragments.add(new ListFeedbackFragment(headImg));
        fragments.add(new QuestionFragment());
        FrementAdapterTitle adapterTitle = new FrementAdapterTitle(getSupportFragmentManager(), fragments, title);
        mViewPager.setAdapter(adapterTitle);
        mFeedbackTab.setupWithViewPager(mViewPager);
    }

    @OnClick({R.id.feedback_toobar, R.id.feedback_tab})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.feedback_toobar:
                break;
            case R.id.feedback_tab:
                break;

        }
    }
}
