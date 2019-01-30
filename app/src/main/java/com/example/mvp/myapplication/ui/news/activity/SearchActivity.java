package com.example.mvp.myapplication.ui.news.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.FrementAdapter;
import com.example.mvp.myapplication.adapter.FrementAdapterTitle;
import com.example.mvp.myapplication.adapter.HKeyAdatpter;
import com.example.mvp.myapplication.adapter.HotAdatpter;
import com.example.mvp.myapplication.app.App;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.base.activity.BottomActivity;
import com.example.mvp.myapplication.contact.InfoInterface;
import com.example.mvp.myapplication.contact.SearchInterface;
import com.example.mvp.myapplication.greedao.SearchDaoBean;
import com.example.mvp.myapplication.http.bean.callback.HotBean;
import com.example.mvp.myapplication.http.bean.callback.InfiBean;
import com.example.mvp.myapplication.http.bean.callback.RelevantBean;
import com.example.mvp.myapplication.presenter.SearchPresenter;
import com.example.mvp.myapplication.ui.search.fremnet.SNFragment;
import com.example.mvp.myapplication.ui.search.fremnet.SPFragment;
import com.example.mvp.myapplication.utils.SoftInputUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.http.Body;

public class SearchActivity extends BaseActivity<SearchInterface.IsearcchV,SearchPresenter<SearchInterface.IsearcchV>> implements SearchInterface.IsearcchV {

    @BindView(R.id.rv_search_hk)
    RecyclerView mHkRecycler;
    @BindView(R.id.rv_hot_search)
    RecyclerView mHotRecycler;
    @BindView(R.id.search_ed)
    EditText mSearchEd;
    @BindView(R.id.empty_tv)
    TextView mEmptyTv;
    private String mSearchEdString;
    @BindView(R.id.search_group)
    LinearLayout mLinearLayout;
    @BindView(R.id.search_group_tow)
    LinearLayout mLinearLayouttow;
    @BindView(R.id.tab_search)
    TabLayout mTabLayoutSearch;
    @BindView(R.id.tv_search_esc)
    TextView  mTextViewEsc;
    @BindView(R.id.vp_search)
    ViewPager mViewPagerSearch;
    private ArrayList<Fragment> mSearchFragments;
    private FrementAdapterTitle mFrementAdapter;
    private ArrayList<HotBean.SearchListBean> mSearchListBeans;
    private HotAdatpter mHotAdatpter;
    private List<SearchDaoBean> mSearchDaoBeans;
    private HKeyAdatpter mHkAdapter;

    @Override
    public int createLayout() {
        return R.layout.activity_search;
    }

    @Override
    public void origination() {

        setViewGroup();
        //setFremnetNews();
        mHkAdapter.setOnItemClickListener(new HotAdatpter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, String item) {
                mSearchEdString=item;
                mLinearLayout.setVisibility(View.GONE);
                mLinearLayouttow.setVisibility(View.VISIBLE);
                setFremnetNews();
                mSearchEd.setCursorVisible(false);
            }
        });
        mHotAdatpter.setOnItemClickListener(new HotAdatpter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, String item) {
                mSearchEdString=item;
                mLinearLayout.setVisibility(View.GONE);
                mLinearLayouttow.setVisibility(View.VISIBLE);
                setFremnetNews();
                mSearchEd.setCursorVisible(false);
            }
        });

    }

    private void setFremnetNews() {
        mSearchFragments = new ArrayList<>();
        SNFragment snFragment = new SNFragment(mSearchEdString);
        SPFragment spFragment = new SPFragment(mSearchEdString);
        mSearchFragments.add(snFragment);
        mSearchFragments.add(spFragment);
        ArrayList<String> title = new ArrayList<>();
        title.add("文章");
        title.add("话题");
        mFrementAdapter = new FrementAdapterTitle(getSupportFragmentManager(), mSearchFragments, title);
        mViewPagerSearch.setAdapter(mFrementAdapter);
        mTabLayoutSearch.setupWithViewPager(mViewPagerSearch);
    }

    private void setViewGroup() {
        setReApdate();
        mSearchEd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchEd.setCursorVisible(true);
                mLinearLayout.setVisibility(View.VISIBLE);
                mLinearLayouttow.setVisibility(View.GONE);

            }
        });
        mSearchEd.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    //关掉键盘
                    SoftInputUtil.closeSoftInput(SearchActivity.this, mSearchEd);
                    mSearchEdString = SearchActivity.this.mSearchEd.getText().toString();
                    if (!TextUtils.isEmpty(mSearchEdString)) {

                        //存入数据库
                        App.getSession().getSearchDaoBeanDao().insert(new SearchDaoBean(null, mSearchEdString));
                        Log.e("tag", "我走到这里了");
                        mLinearLayout.setVisibility(View.GONE);
                        mLinearLayouttow.setVisibility(View.VISIBLE);
                        setFremnetNews();
                        mSearchEd.setCursorVisible(false);

                    }else {
                        showTost("输入不能为空");
                    }
                    return true;
                    //如果是返回键就消费掉
                }
                return false;
            }
        });
    }

    private void setReApdate() {
        mSearchDaoBeans = App.getSession().getSearchDaoBeanDao().loadAll();
        mHkAdapter = new HKeyAdatpter(mSearchDaoBeans, this);
        mHkRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        mHkRecycler.setAdapter(mHkAdapter);
        mSearchListBeans = new ArrayList<>();
        mHotAdatpter = new HotAdatpter(mSearchListBeans, this);
        mHotRecycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mHotRecycler.setLayoutManager(new LinearLayoutManager(this));
        mHotRecycler.setAdapter(mHotAdatpter);
        persemter.getHotBean("");


    }


    @OnClick({R.id.empty_tv,R.id.tv_clear,R.id.tv_search_esc})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.empty_tv:
                mSearchEd.setText("");
                break;
            case  R.id.tv_clear:
                App.getSession().getSearchDaoBeanDao().deleteAll();
                mSearchDaoBeans.clear();
                mHkAdapter.notifyDataSetChanged();
            case  R.id.tv_search_esc:
                finish();
                break;

        }
    }

    @Override
    public SearchPresenter<SearchInterface.IsearcchV> createPresenter() {
        return new SearchPresenter<>();
    }


    @Override
    public void showHotBean(HotBean hotBean) {
        mSearchListBeans.addAll(hotBean.getSearchList());
        mHotAdatpter.notifyDataSetChanged();
    }
}
