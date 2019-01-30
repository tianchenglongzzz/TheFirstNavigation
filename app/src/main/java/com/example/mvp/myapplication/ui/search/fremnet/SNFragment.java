package com.example.mvp.myapplication.ui.search.fremnet;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.NewlistApdate;
import com.example.mvp.myapplication.adapter.SerchNewlistApdate;
import com.example.mvp.myapplication.base.activity.BottomActivity;
import com.example.mvp.myapplication.base.fragment.BaseFragment;
import com.example.mvp.myapplication.base.fragment.BottomFragment;
import com.example.mvp.myapplication.contact.SearchInterface;
import com.example.mvp.myapplication.http.bean.callback.UpListNewsBean;
import com.example.mvp.myapplication.jsonbean.SearchBeanNews;
import com.example.mvp.myapplication.presenter.SearchPresenterTow;
import com.example.mvp.myapplication.utils.jsonUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class SNFragment extends BaseFragment<SearchInterface.IsearchNewsv,SearchPresenterTow<SearchInterface.IsearchNewsv>>
implements SearchInterface.IsearchNewsv{
@BindView(R.id.rv_search_news)
    XRecyclerView mRecyclerView;

    private final String mSearchEdString;
    private ArrayList<UpListNewsBean.NewListBean> mNewListBeans;
    private SerchNewlistApdate mSerchNewlistApdate;
    private String mCursor;

    @SuppressLint("ValidFragment")
    public SNFragment(String searchEdString) {
        // Required empty public constructor
        mSearchEdString = searchEdString;

    }




    public void setSearch(String searchEdString) {
         showTost(searchEdString);
    }

    @Override
    protected void initEvemtData() {
        String json = jsonUtils.getStudent(new SearchBeanNews(mSearchEdString, "0"));
        persenter.getNewsBean(json);
        mNewListBeans = new ArrayList<>();
        mSerchNewlistApdate = new SerchNewlistApdate(mNewListBeans, getActivity());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mSerchNewlistApdate);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                persenter.getNewsBean(jsonUtils.getStudent(new SearchBeanNews(mSearchEdString, "0")));
                mRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                persenter.getNewsBean(jsonUtils.getStudent(new SearchBeanNews(mSearchEdString, mCursor)));
                mRecyclerView.loadMoreComplete();
            }
        });

    }

    @Override
    public int createLayout() {
        return R.layout.fragment_sn;
    }

    @Override
    public SearchPresenterTow createPresnter() {
        return new SearchPresenterTow();
    }

    @Override
    public void showNewsBean(UpListNewsBean upListNewsBean) {
        mCursor = upListNewsBean.getCursor();
        mNewListBeans.addAll(upListNewsBean.getNewList());
         mSerchNewlistApdate.notifyDataSetChanged();
    }
}
