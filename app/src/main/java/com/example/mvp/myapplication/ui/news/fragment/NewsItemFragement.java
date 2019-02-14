package com.example.mvp.myapplication.ui.news.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.NewlistApdate;
import com.example.mvp.myapplication.base.fragment.BaseFragment;
import com.example.mvp.myapplication.contact.UpListNewsIntenface;
import com.example.mvp.myapplication.http.bean.callback.DownListNewsBean;
import com.example.mvp.myapplication.http.bean.callback.UpListNewsBean;
import com.example.mvp.myapplication.jsonbean.downListNewsjsonBean;
import com.example.mvp.myapplication.presenter.UpListNewsPresenter;
import com.example.mvp.myapplication.utils.jsonUtils;
import com.example.mvp.myapplication.watcher.RecyclerViewDivider;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;


import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsItemFragement extends BaseFragment<UpListNewsIntenface.IUpListNewsV,UpListNewsPresenter<UpListNewsIntenface.IUpListNewsV>> implements UpListNewsIntenface.IUpListNewsV,XRecyclerView.LoadingListener{

    private  boolean isvisible;
    private  boolean isvisibleView;
    private String mTitle;
    private NewlistApdate mNewsApterdate;
    private String mJson;
    private  String  page="0";
   @BindView(R.id.newlist_recy)
    XRecyclerView  mXRecyclerView;
    private String mCurse;
    private int mKey;

    public NewsItemFragement() {
        // Required empty public constructor
    }
 //懒加载
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isvisible=isVisibleToUser;
        //懒加载
         if (isvisibleView&&isVisibleToUser){
               persenter.setUpListNewsData(mJson);
         }


    }

    @Override
    protected void initEvemtData() {
       mTitle = getArguments().getString("title");
       mKey = getArguments().getInt("key");

        Log.d("KEY",mTitle+"");
       downListNewsjsonBean downListNewsjsonBean = new downListNewsjsonBean("c383f4c9026d471da0184ad5b24c0365", mTitle, "0");
       mJson = jsonUtils.getStudent(downListNewsjsonBean);
       ArrayList<UpListNewsBean.NewListBean> newListBeansfash = new ArrayList<>();

       mNewsApterdate = new NewlistApdate(newListBeansfash, getActivity());
       mXRecyclerView.addItemDecoration(new RecyclerViewDivider(getContext(), DividerItemDecoration.HORIZONTAL));
       mXRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       mXRecyclerView.setAdapter(mNewsApterdate);
        isvisibleView = true;
       mXRecyclerView.setLoadingListener(this);
       if (isvisible) {
           persenter.setUpListNewsData(mJson);
       }


    }


    @Override
    public int createLayout() {
        return R.layout.fragment_news_item_fragement;
    }

    @Override
    public UpListNewsPresenter<UpListNewsIntenface.IUpListNewsV> createPresnter() {
        return new UpListNewsPresenter();
    }

    @Override
    public void showUpListNewsData(UpListNewsBean code) {
        mCurse = code.getMinCursor();
            mNewsApterdate.addAll((ArrayList<UpListNewsBean.NewListBean>) code.getNewList());
    }

    @Override
    public void setDownListNewsHeadImageuBean(UpListNewsBean upListNewsBean) {
            mCurse=upListNewsBean.getCursor();
            mNewsApterdate.addAll((ArrayList<UpListNewsBean.NewListBean>) upListNewsBean.getNewList());
    }


    @Override
    public void onRefresh() {
         mNewsApterdate.remove();
         persenter.setUpListNewsData(mJson);
         mXRecyclerView.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        page=mCurse;
        downListNewsjsonBean downListNewsjsonBean = new downListNewsjsonBean("c383f4c9026d471da0184ad5b24c0365", mTitle, page);
        String json = jsonUtils.getStudent(downListNewsjsonBean);
        persenter.getDownListNewsData(json);
        mXRecyclerView.loadMoreComplete();
    }

}
