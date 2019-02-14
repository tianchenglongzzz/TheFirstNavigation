package com.example.mvp.myapplication.ui.my.frement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
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


@SuppressLint("ValidFragment")
public class ListNotifyGuanZuFragment extends BottomFragment {


    private final ArrayList<ListNotifyBean> mGuanzhu;
    @BindView(R.id.guanzhu_rv)
    RecyclerView mRecyclerView;
    @SuppressLint("ValidFragment")
    public ListNotifyGuanZuFragment(ArrayList<ListNotifyBean> guanzhu) {
        mGuanzhu = guanzhu;

    }


    @Override
    protected void initEvemtData() {
        ListNotifyAdapter adapter = new ListNotifyAdapter(mGuanzhu, getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public int createLayout() {
        return R.layout.fragment_list_notify_guan_zu;
    }
}
