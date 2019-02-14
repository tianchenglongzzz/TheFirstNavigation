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
public class YFrementAdapterTitle extends FragmentStatePagerAdapter {

    private final ArrayList<Fragment> fragments;
    private final ArrayList<String> titles;


    public YFrementAdapterTitle(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> strings) {
        super(fm);
        this.fragments=fragments;
        this.titles=strings;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
