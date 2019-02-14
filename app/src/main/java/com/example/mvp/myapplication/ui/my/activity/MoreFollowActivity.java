package com.example.mvp.myapplication.ui.my.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ZoomControls;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.FrementAdapterTitle;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.base.fragment.BaseFragment;
import com.example.mvp.myapplication.contact.TagsHotInterface;
import com.example.mvp.myapplication.http.bean.callback.TagsHotBean;
import com.example.mvp.myapplication.http.bean.callback.TagsSearchDataBean;
import com.example.mvp.myapplication.jsonbean.JsonTagsSearch;
import com.example.mvp.myapplication.presenter.TagsPresenter;
import com.example.mvp.myapplication.ui.my.frement.MoreFollowFragment;
import com.example.mvp.myapplication.utils.jsonUtils;
import com.example.mvp.myapplication.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.youngkaaa.yviewpager.YViewPager;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.TabView;

public class MoreFollowActivity extends BaseActivity<TagsHotInterface.ITagsHotV,TagsPresenter<TagsHotInterface.ITagsHotV>> implements TagsHotInterface.ITagsHotV,TextWatcher {
    @BindView(R.id.moreFollow_ll)
    LinearLayout mLinearLayoutNo;
    @NonNull
    @BindView(R.id.search_ed)
    EditText   mEditText;
    @BindView(R.id.search_tv)
    TextView  tv;
    @BindView(R.id.morp_tab)
    VerticalTabLayout mMorpTab;
    @BindView(R.id.morp_vp)
    NoScrollViewPager mMorpVp;
    @BindView(R.id.more_ll)
    LinearLayout mLinearLayout;
    private ArrayList<String> mTitles;
    private ArrayList<Fragment> mFragments;
    private FrementAdapterTitle mFrementAdapterTitle;


    @Override
    public int createLayout() {
        return R.layout.activity_more_follow;
    }

    @Override
    public void origination() {

        persemter.shetTagsHotData("");
        mEditText.addTextChangedListener(this);

        mMorpTab.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                      tab.getTitleView().setTextColor(getResources().getColor(R.color.read));
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });
    }

    @OnClick(R.id.search_tv)
    public  void onClick(View view){
        String json = jsonUtils.getStudent(new JsonTagsSearch(mEditText.getText().toString(), "0"));
        persemter.getTagsSearchData(json);
    }
    @Override
    public TagsPresenter<TagsHotInterface.ITagsHotV> createPresenter() {
        return new  TagsPresenter();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void showTagsHotData(List<TagsHotBean> value) {

        mFrementAdapterTitle=null;
        mTitles=null;
        mFragments=null;
        mFragments = new ArrayList<>();
        mTitles = new ArrayList<>();
        mLinearLayoutNo.setVisibility(View.GONE);
        for (int i = 0; i <value.size() ; i++) {
              mTitles.add(value.get(i).getTag());
            MoreFollowFragment moreFollowFragment = new MoreFollowFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id",value.get(i).getId());
            moreFollowFragment.setArguments(bundle);
            mFragments.add(moreFollowFragment);
        }
        setAdapter();

    }

    private void setAdapter() {
        mFrementAdapterTitle = new FrementAdapterTitle(getSupportFragmentManager(), mFragments, mTitles);
        mMorpVp.setAdapter(mFrementAdapterTitle);
        mMorpTab.setupWithViewPager(mMorpVp);
        mMorpTab.getTabAt(0).getTitleView().setTextColor(getResources().getColor(R.color.read));


    }

    @Override
    public void showTagsSearchData(TagsSearchDataBean dataBean) {
        mFrementAdapterTitle=null;
        mTitles=null;
        mFragments=null;

        if (dataBean.getTagList().size()!=0) {
            mFragments = new ArrayList<>();
            mTitles = new ArrayList<>();
            mLinearLayoutNo.setVisibility(View.GONE);
            for (int i = 0; i < dataBean.getTagList().size(); i++) {
                mTitles.add(dataBean.getTagList().get(i).getTag());
                MoreFollowFragment moreFollowFragment = new MoreFollowFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id", dataBean.getTagList().get(i).getId());
                moreFollowFragment.setArguments(bundle);
                mFragments.add(moreFollowFragment);
            }

            setAdapter();
        }else {

            mLinearLayoutNo.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
             if (s.toString().length()==0){

                 persemter.shetTagsHotData("");
             }

    }
}
