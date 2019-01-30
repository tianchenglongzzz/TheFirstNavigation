package com.example.mvp.myapplication.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:FrementAdapter
 * @date :${DATA} 15:23
 */
public class FrementAdapter extends FragmentStatePagerAdapter {

    private final ArrayList<Fragment> fragments;


    public FrementAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


}
