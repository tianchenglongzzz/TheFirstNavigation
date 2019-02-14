package com.example.mvp.myapplication.ui.my.frement;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.ApdaterFavouriteNews;
import com.example.mvp.myapplication.base.fragment.BaseFragment;
import com.example.mvp.myapplication.base.persenter.IBasePresenter;
import com.example.mvp.myapplication.contact.FavouriteNewsInterface;
import com.example.mvp.myapplication.http.bean.callback.FavouriteNewsBean;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.presenter.FavouriteNewsPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteNewsFragment extends BaseFragment<FavouriteNewsInterface.InewsV,FavouriteNewsPresenter<FavouriteNewsInterface.InewsV>> implements FavouriteNewsInterface.InewsV
,ApdaterFavouriteNews.ApdaterCheckedChangedListener{
    @BindView(R.id.count)
    TextView  mCount;
    @BindView(R.id.f_news_rv)
    RecyclerView mRecyclerView;

    private ApdaterFavouriteNews mApdaterFavouriteNews;
    private ArrayList<FavouriteNewsBean.FavouritNewsListBean> mFavouriteNewsBeans;
    @BindView(R.id.favourite_delete_ll)
    ViewGroup mViewGroup;
    //用来储存要删除收藏id的集合
      ArrayList<String>mFavouriteIdList=new ArrayList<>();
     //用来储存列表位置的集合
      ArrayList<Integer>mIntegerArrayList=new ArrayList<>();
    public FavouriteNewsFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initEvemtData() {
        initData();



    }

    private void initData() {

        mFavouriteNewsBeans = new ArrayList<>();
        mApdaterFavouriteNews = new ApdaterFavouriteNews(mFavouriteNewsBeans, getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mApdaterFavouriteNews);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        persenter.getNewsData("c383f4c9026d471da0184ad5b24c0365","0");
        mApdaterFavouriteNews.setApdaterCheckedChangedListener(this);
    }

    @Override
    public int createLayout() {
        return R.layout.fragment_favourite_news;
    }

    @Override
    public FavouriteNewsPresenter createPresnter() {
        return new FavouriteNewsPresenter();
    }

    @Override
    public void showNewsData(FavouriteNewsBean newsBean) {
             mFavouriteNewsBeans.addAll(newsBean.getFavouritNewsList());
             mApdaterFavouriteNews.notifyDataSetChanged();
            mApdaterFavouriteNews.setMap();
    }

    @Override
    public void showbatchDelFavouriteData(InfoBean infoBean) {
        Log.e("TAG",infoBean.getMessage()+"===="+infoBean.getCode());

    }



   @OnClick({R.id.favourite_delete_ll})
    public void  onClick(View view){
        switch (view.getId()){
            case R.id.favourite_delete_ll:
                batchDelFavourite();
                break;
        }

    }

    private void batchDelFavourite() {
        StringBuffer bufferFId = new StringBuffer();
        for (int i = 0; i <mFavouriteIdList.size() ; i++) {
            if (i!=mFavouriteIdList.size()-1) {
                bufferFId.append(mFavouriteIdList.get(i) + ",");
            }
        }
        String s = bufferFId.toString();
        persenter.batchDelFavouriteData("c383f4c9026d471da0184ad5b24c0365",s);

    }

    public void cancelFavourite(){
       int itemCount = mApdaterFavouriteNews.getItemCount();
       for (int i = 0; i <itemCount ; i++) {
           View childAt = mRecyclerView.getChildAt(i);
         CheckBox cd=  childAt.findViewById(R.id.favour_news_item_cb);
          cd.setVisibility(View.VISIBLE);
       }
       mViewGroup.setVisibility(View.VISIBLE);
   }
   public void  cancel(){
       int itemCount = mApdaterFavouriteNews.getItemCount();
       for (int i = 0; i <itemCount ; i++) {
           View childAt = mRecyclerView.getChildAt(i);
           CheckBox cd=  childAt.findViewById(R.id.favour_news_item_cb);
           cd.setVisibility(View.GONE);
       }
       mViewGroup.setVisibility(View.GONE);
   }

    @Override
    public void onCheckedChang(String favouritId, boolean isCheck,int p) {
              if (isCheck){
                  mFavouriteIdList.add(favouritId);
                  mIntegerArrayList.add(p);
              }else {
                  for (int i = 0; i <mFavouriteIdList.size() ; i++) {
                        if (mFavouriteIdList.get(i).equals(favouritId)){
                            mFavouriteIdList.remove(i);
                            mIntegerArrayList.remove(i);
                        }
                  }
              }
              mCount.setText(mFavouriteIdList.size()+"");
    }
}
