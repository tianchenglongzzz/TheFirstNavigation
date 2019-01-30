package com.example.mvp.myapplication.ui.search.fremnet;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.base.fragment.BottomFragment;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class SPFragment extends BottomFragment {


    private final String mSearchEdString;

    @SuppressLint("ValidFragment")
    public SPFragment(String searchEdString) {
        // Required empty public constructor
        mSearchEdString = searchEdString;

    }
    @Override
    protected void initEvemtData() {

    }

    @Override
    public int createLayout() {
        return R.layout.fragment_s;
    }

    public void setSearch(String searchEdString) {
        showTost(searchEdString);
    }
}
