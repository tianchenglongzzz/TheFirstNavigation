package com.example.mvp.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import cn.youngkaaa.yviewpager.YViewPager;

/**
 * @packge: com.example.mvp.myapplication.view
 * @filename:NoScrollViewPager
 * @date :${DATA} 17:05
 */

public class NoScrollViewPager extends YViewPager {
    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item,false);
    }
}
