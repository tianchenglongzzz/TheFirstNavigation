package com.example.mvp.myapplication.ui.my.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.MylistTopicAdapter;
import com.example.mvp.myapplication.app.Global;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.contact.MyListTopicInterface;
import com.example.mvp.myapplication.http.bean.callback.MyListTopicBean;
import com.example.mvp.myapplication.presenter.MyListTopicPresenter;
import com.example.mvp.myapplication.ui.topic.activity.InsertTopicActivity;
import com.example.mvp.myapplication.utils.PopWindowUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MyListTopicActivity extends BaseActivity<MyListTopicInterface.ITopicV,MyListTopicPresenter<MyListTopicInterface.ITopicV>>implements MyListTopicInterface.ITopicV,View.OnClickListener{
    @BindView(R.id.my_list_topic_Toolbar)
    Toolbar  mToolbar;
    @BindView(R.id.img_uploading_cf)
    ImageView mImgUploadingCf;
    @BindView(R.id.mylisttopic_rv)
    RecyclerView mMylisttopicRv;
    private ArrayList<MyListTopicBean.FavouritTopicListBean> mListBeans;
    private MylistTopicAdapter mTopicAdapter;
    private PopupWindow mWindow;


    @Override
    public MyListTopicPresenter<MyListTopicInterface.ITopicV> createPresenter() {
        return new MyListTopicPresenter<>();
    }

    @Override
    public int createLayout() {
        return R.layout.activity_my_list_topic;
    }

    @Override
    public void origination() {
        setToobar(mToolbar);
        mListBeans = new ArrayList<>();
        mTopicAdapter = new MylistTopicAdapter(mListBeans, this);
        mMylisttopicRv.setLayoutManager(new LinearLayoutManager(this));
        mMylisttopicRv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mMylisttopicRv.setAdapter(mTopicAdapter);
        persemter.getTopicData(Global.USER,"0");
        mTopicAdapter.setClickTheSettingsPopover(new MylistTopicAdapter.ClickTheSettingsPopover() {
            @Override
            public void onClick(MyListTopicBean.FavouritTopicListBean favouritTopicListBean) {
                showPopWindow();
            }
        });
      mImgUploadingCf.setOnClickListener(this);
    }

    private void showPopWindow() {
        View view = LayoutInflater.from(MyListTopicActivity.this).inflate(R.layout.popmytopic, null);
        setViewClick(view);
        mWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mWindow.setBackgroundDrawable(new ColorDrawable());
        mWindow.setAnimationStyle(R.style.anim_pop_bottombar);
        mWindow.showAtLocation(mImgUploadingCf, Gravity.NO_GRAVITY, 0, 0);

    }

    private void setViewClick(View view) {
        ViewGroup rl=view.findViewById(R.id.pop_rl);
        View  update=view.findViewById(R.id.update);
        View  del=view.findViewById(R.id.del);
        View cancel = view.findViewById(R.id.cancel);
        rl.setOnClickListener(this);
        update.setOnClickListener(this);
        del.setOnClickListener(this);
        cancel.setOnClickListener(this);


    }

    @Override
    public void showTopicData(MyListTopicBean listTopicBean) {
            mListBeans.addAll(listTopicBean.getFavouritTopicList());
            mTopicAdapter.notifyDataSetChanged();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pop_rl:
                mWindow.dismiss();
                break;
            case  R.id.del :

                break;
            case R.id.img_uploading_cf:
                 startActivity(new Intent(this,InsertTopicActivity.class));
                break;
        }
    }
}
