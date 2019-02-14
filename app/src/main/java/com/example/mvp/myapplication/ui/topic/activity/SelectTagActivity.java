package com.example.mvp.myapplication.ui.topic.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.TagsLodingAdapter;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.base.fragment.BaseFragment;
import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.base.persenter.IBasePresenter;
import com.example.mvp.myapplication.contact.TagsHotInterface;
import com.example.mvp.myapplication.contact.TopicInterface;
import com.example.mvp.myapplication.http.bean.callback.TagsHotBean;
import com.example.mvp.myapplication.http.bean.callback.TagsSearchDataBean;
import com.example.mvp.myapplication.presenter.TagsPresenter;
import com.example.mvp.myapplication.presenter.TopicPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SelectTagActivity extends BaseActivity<TagsHotInterface.ITagsHotV,TagsPresenter<TagsHotInterface.ITagsHotV>>implements TagsHotInterface.ITagsHotV{

    @BindView(R.id.tv_enter)
    TextView mTvEnter;
    @BindView(R.id.tb_sta)
    Toolbar mTbSta;
    @BindView(R.id.tv_my_tab)
    TextView mTvMyTab;
    @BindView(R.id.rv_hot_tag)
    RecyclerView mRvHotTag;
    private ArrayList<TagsHotBean> mHotBeans;
    private TagsLodingAdapter mTagsLodingAdapter;
    private ArrayList<String> mTag=new ArrayList<>();
    private String mTagString;
    private  boolean F;


    @OnClick({R.id.tv_enter, R.id.tb_sta, R.id.tv_my_tab, R.id.rv_hot_tag})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_enter:
                F=true;
                finish();
                break;
            case R.id.tb_sta:
                break;
            case R.id.tv_my_tab:
                break;
            case R.id.rv_hot_tag:
                break;
        }
    }

    @Override
    public TagsPresenter createPresenter() {
        return new TagsPresenter();
    }

    @Override
    public int createLayout() {
        return R.layout.activity_select_tag;
    }

    @Override
    public void origination() {
         mTbSta.setNavigationIcon(R.mipmap.smallfanhui);
         mTbSta.setTitle("");
         setSupportActionBar(mTbSta);
         mTbSta.setNavigationOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 F=false;
                  finish();
             }
         });

        persemter.shetTagsHotData("");
    }

    private void initApter(List<TagsHotBean> value) {
        mHotBeans = (ArrayList<TagsHotBean>) value;
        mTagsLodingAdapter = new TagsLodingAdapter(mHotBeans, this);

        mRvHotTag.setLayoutManager(new LinearLayoutManager(this));
        mRvHotTag.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRvHotTag.setAdapter(mTagsLodingAdapter);
        mTagsLodingAdapter.setItemOnChcke(new TagsLodingAdapter.ItemOnChcke() {
            @Override
            public void onCheckItem(View v, boolean check, String str, int position) {
                Log.d("tian", str);
                if (check) {
                    Log.d("tian", str);
                    mTag.add(str);
                    mTagString = "";
                    StringBuffer buffer = new StringBuffer();
                    for (int i = 0; i < mTag.size(); i++) {
                        if (i != mTag.size() - 1) {
                            buffer.append(mTag.get(i) + "，");
                        } else {
                            buffer.append(mTag.get(i));
                        }
                    }
                    mTagString = buffer.toString();
                    mTvMyTab.setText(mTagString);
                } else {

                    for (int i = 0; i < mTag.size(); i++) {
                        if (mTag.get(i).equals(str)) {
                            mTag.remove(i);
                        }
                    }
                    StringBuffer buffer = new StringBuffer();
                    for (int i = 0; i < mTag.size(); i++) {
                        if (i != mTag.size() - 1) {
                            buffer.append(mTag.get(i)).append(",");
                        } else {
                            buffer.append(mTag.get(i));
                        }
                    }
                    mTagString = buffer.toString();
                    mTvMyTab.setText(mTagString);
                }

            }

        });
    }

    @Override
    public void showTagsHotData(List<TagsHotBean> value) {
           initApter(value);


    }

    @Override
    public void showTagsSearchData(TagsSearchDataBean dataBean) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (F){
            if (mTagString==null) {
                EventBus.getDefault().post(mTagString);
            }
            }else {

        }
    }
}
