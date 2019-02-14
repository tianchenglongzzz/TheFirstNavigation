package com.example.mvp.myapplication.ui.topic.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.TagsHotAdapter;
import com.example.mvp.myapplication.base.fragment.BaseFragment;
import com.example.mvp.myapplication.base.persenter.IBasePresenter;
import com.example.mvp.myapplication.contact.TagsHotInterface;
import com.example.mvp.myapplication.http.bean.callback.TagsHotBean;
import com.example.mvp.myapplication.http.bean.callback.TagsSearchDataBean;
import com.example.mvp.myapplication.jsonbean.JsonTagsSearch;
import com.example.mvp.myapplication.presenter.TagsPresenter;
import com.example.mvp.myapplication.utils.jsonUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SortFragment extends BaseFragment<TagsHotInterface.ITagsHotV,TagsPresenter<TagsHotInterface.ITagsHotV>>implements TagsHotInterface.ITagsHotV {


    @BindView(R.id.ed_search_topic)
    EditText mEdSearchTopic;
    @BindView(R.id.tv_topic_search)
    TextView mTvTopicSearch;
    @BindView(R.id.rv_topic_sort)
    RecyclerView mRvTopicSort;
    private ArrayList<TagsHotBean> mTagsHotBeans;
    private TagsHotAdapter mTagsHotAdapter;
    private String mCursor="0";


    public SortFragment() {
        // Required empty public constructor
    }
    @OnClick(R.id.tv_topic_search)
    public  void onClick(View view){
        String student = jsonUtils.getStudent(new JsonTagsSearch(mEdSearchTopic.getText().toString(), mCursor));
        persenter.getTagsSearchData(student);
    }
    @Override
    public TagsPresenter createPresnter() {
            return new TagsPresenter();
    }

    @Override
    protected void initEvemtData() {
        mTagsHotBeans = new ArrayList<>();
        mTagsHotAdapter = new TagsHotAdapter(mTagsHotBeans, getActivity());
        mRvTopicSort.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        mRvTopicSort.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvTopicSort.setAdapter(mTagsHotAdapter);
        persenter.shetTagsHotData("");
        mEdSearchTopic.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = s.toString().length();
                if (length==0){
                    persenter.shetTagsHotData("");
                }
            }
        });
    }

    @Override
    public int createLayout() {
        return R.layout.fragment_sort;
    }

    @Override
    public void showTagsHotData(List<TagsHotBean> value) {

         mTagsHotBeans.addAll(value);
         mTagsHotAdapter.setSare(true,"");
         mTagsHotAdapter.notifyDataSetChanged();
    }

    @Override
    public void showTagsSearchData(TagsSearchDataBean dataBean) {
        mCursor = dataBean.getCursor();
        List<TagsHotBean> tagList = dataBean.getTagList();
        mTagsHotAdapter.setSare(false,mEdSearchTopic.getText().toString());
        mTagsHotBeans.clear();
        mTagsHotBeans.addAll(tagList);
        mTagsHotAdapter.notifyDataSetChanged();
    }
}
