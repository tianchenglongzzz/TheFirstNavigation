package com.example.mvp.myapplication.ui.my.frement;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.ListNotifyAdapter;
import com.example.mvp.myapplication.base.fragment.BottomFragment;
import com.example.mvp.myapplication.http.bean.callback.ListNotifyBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class ListNotifyPinglunFragment extends BottomFragment {
    private final ArrayList<ListNotifyBean> mPinglun;
    @BindView(R.id.pinglun_rv)
    RecyclerView mRecyclerView;

    public ListNotifyPinglunFragment(ArrayList<ListNotifyBean> pinglun) {
        // Required empty public constructor
        mPinglun = pinglun;

    }


    @Override
    protected void initEvemtData() {
        ListNotifyAdapter adapter = new ListNotifyAdapter(mPinglun, getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public int createLayout() {
        return R.layout.fragment_list_notify_pinglun;
    }

}
