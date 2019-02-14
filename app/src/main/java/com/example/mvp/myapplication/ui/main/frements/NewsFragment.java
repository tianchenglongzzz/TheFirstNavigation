package com.example.mvp.myapplication.ui.main.frements;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.FrementAdapter;
import com.example.mvp.myapplication.adapter.FrementAdapterTitle;
import com.example.mvp.myapplication.app.App;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.base.fragment.BaseFragment;
import com.example.mvp.myapplication.contact.NewListTab;
import com.example.mvp.myapplication.greedao.ItemDaoBean;
import com.example.mvp.myapplication.http.bean.callback.listNewsBean;
import com.example.mvp.myapplication.presenter.NewListPresenter;
import com.example.mvp.myapplication.ui.news.activity.AddActivity;
import com.example.mvp.myapplication.ui.news.fragment.NewsItemFragement;
import com.example.mvp.myapplication.utils.SharedPreferencesUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment<NewListTab.NewListView,NewListPresenter<NewListTab.NewListView>> implements NewListTab.NewListView {
@BindView(R.id.news_add)
    ImageView mAddNews;
    private ArrayList<String> mStrings;
  @BindView(R.id.news_tab)
    TabLayout mNewsTabLayout;
  @BindView(R.id.news_vp)
    ViewPager mNewsVp;
    private  boolean isvisible;
    private  boolean isvisibleView;
    private ArrayList<Fragment> mFragmentsNwsItem;
    private FrementAdapterTitle mFrementAdapter;
    private boolean mState;
    private FragmentManager mManager;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isvisibleView&&isVisibleToUser){
            initFrement();
        }

    }

    @Override
    protected void initEvemtData() {


        EventBus.getDefault().register(this);
        initFrement();

    }

    private void initFrement() {
        mStrings = new ArrayList<>();
        mFragmentsNwsItem = new ArrayList<>();
        mState = SharedPreferencesUtils.getSharedPreferences(getContext()).getBoolean("shuju", true);
        //第一回进来先从网上拿取数据
        //第二回就去数据库拿取数具
        mAddNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(), AddActivity.class), 100);
            }
        });

        if (mState) {
            App.getSession().getItemDaoBeanDao().deleteAll();
            if (mFrementAdapter == null) {
                mFrementAdapter = new FrementAdapterTitle(getActivity().getSupportFragmentManager(), mFragmentsNwsItem, mStrings);
                mNewsVp.setAdapter(mFrementAdapter);
                mNewsTabLayout.setupWithViewPager(mNewsVp);
            }
            persenter.getListNewTab("");
        } else {

            List<ItemDaoBean> itemDaoBeans = App.getSession().getItemDaoBeanDao().loadAll();
            Log.e("tang", itemDaoBeans.size() + "");
            for (int i = 0; i < itemDaoBeans.size(); i++) {
                if (itemDaoBeans.get(i).getState()) {
                    Log.e("name", itemDaoBeans.get(i).getTitle());
                    Log.e("name", itemDaoBeans.get(i).getNewsId());
                    mStrings.add(itemDaoBeans.get(i).getTitle());
                    NewsItemFragement fragement = new NewsItemFragement();
                    Bundle bundle = new Bundle();
                    bundle.putString("title", itemDaoBeans.get(i).getNewsId());
                    bundle.putInt("key", i);
                    fragement.setArguments(bundle);
                    mFragmentsNwsItem.add(fragement);

                    }
                }
            mFrementAdapter = new FrementAdapterTitle(getChildFragmentManager(), mFragmentsNwsItem, mStrings);
            mNewsVp.setAdapter(mFrementAdapter);
            mNewsTabLayout.setupWithViewPager(mNewsVp);

            }
        }










    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public int createLayout() {
        return R.layout.fragment_news;
    }


    @Override
    public void showNewListBean(listNewsBean listNewsBean) {
       // App.getSession().getItemDaoBeanDao().deleteAll();
        //第一次先在网络种获取数具并插入数据库
        SharedPreferencesUtils.getSharedPreferences(getContext()).putBoolean("shuju",false);
        for (int i = 0; i <listNewsBean.getNewsChannelList().size() ; i++) {
            String channelName = listNewsBean.getNewsChannelList().get(i).getChannelName();
            String newsId = listNewsBean.getNewsChannelList().get(i).getChannelId();
            //存入一个boolean 值  如果是true 就显示 相反则不显示
            if (i<11) {
                App.getSession().getItemDaoBeanDao().insert(new ItemDaoBean(null, channelName, true, newsId));
            }else {
                App.getSession().getItemDaoBeanDao().insert(new ItemDaoBean(null, channelName, false, newsId));

            }
        }
        List<com.example.mvp.myapplication.http.bean.callback.listNewsBean.NewsChannelListBean> newsChannelList = listNewsBean.getNewsChannelList();
        for (int i = 0; i <newsChannelList.size() ; i++) {
             mStrings.add(newsChannelList.get(i).getChannelName());
            NewsItemFragement newsItemFragement = new NewsItemFragement();
            Bundle bundle = new Bundle();
            bundle.putString("title",newsChannelList.get(i).getChannelId());
            bundle.putInt("key",i);
            newsItemFragement.setArguments(bundle);
            mFragmentsNwsItem.add(newsItemFragement);
            //如果 有11 条数据就跳出循环
            if (i==11){
                break;
            }

        }
        mFrementAdapter.notifyDataSetChanged();

    }

    @Override
    public NewListPresenter<NewListTab.NewListView> createPresnter() {
        return new NewListPresenter<>();
    }
 @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
 public  void  setEvenbus(int p){
        initFrement();
 }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         if (requestCode==100&&resultCode==100){
             int p = data.getIntExtra("item", 0);
             mNewsVp.setCurrentItem(p);
         }
         if (requestCode==100&&resultCode==10){
             initFrement();
         }
    }

}
