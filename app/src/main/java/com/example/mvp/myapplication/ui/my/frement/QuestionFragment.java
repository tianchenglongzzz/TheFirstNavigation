package com.example.mvp.myapplication.ui.my.frement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.QuestionAdapter;
import com.example.mvp.myapplication.app.Global;
import com.example.mvp.myapplication.base.fragment.BaseFragment;
import com.example.mvp.myapplication.contact.QuestionInterface;
import com.example.mvp.myapplication.http.bean.callback.QuestionBean;
import com.example.mvp.myapplication.presenter.QuestionPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends BaseFragment<QuestionInterface.IQuestionV, QuestionPresenter<QuestionInterface.IQuestionV>> implements QuestionInterface.IQuestionV {


    private View view;
    @BindView(R.id.quest_rv)
    public RecyclerView mQuestRv;
    private List<QuestionBean> mList;
    private QuestionAdapter mQuestionAdapter;

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initEvemtData() {
        mList = new ArrayList<>();
        mQuestionAdapter = new QuestionAdapter(mList, getActivity());
        mQuestRv.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        mQuestRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mQuestRv.setAdapter(mQuestionAdapter);
      persenter.getQuestionList(Global.USER);
    }

    @Override
    public int createLayout() {
        return R.layout.fragment_question;
    }

    @Override
    public QuestionPresenter<QuestionInterface.IQuestionV> createPresnter() {
        return new QuestionPresenter<>();
    }

    @Override
    public void showQuestionList(List<QuestionBean> list) {
        Log.d("===========",list.size()+"");
        mList.addAll(list);
        mQuestionAdapter.notifyDataSetChanged();

    }



}
