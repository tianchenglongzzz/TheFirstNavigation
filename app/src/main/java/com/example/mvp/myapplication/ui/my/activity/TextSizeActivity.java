package com.example.mvp.myapplication.ui.my.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.app.App;
import com.example.mvp.myapplication.base.activity.BottomActivity;
import com.example.mvp.myapplication.contact.MoreFolllowInterface;
import com.example.mvp.myapplication.ui.main.activitys.MainActivity;
import com.example.mvp.myapplication.utils.DisplayUtils;
import com.example.mvp.myapplication.utils.MessageSocket;
import com.example.mvp.myapplication.utils.RxBus;
import com.example.mvp.myapplication.utils.SharedPreferencesUtils;
import com.example.mvp.myapplication.view.FontSliderBar;

import butterknife.BindView;
import butterknife.OnClick;

public class TextSizeActivity extends BottomActivity {
    @BindView(R.id.fontSliderBar)
    FontSliderBar fontSliderBar;
    @BindView(R.id.tv_chatcontent1)
    TextView tvContent1;
    @BindView(R.id.tv_chatcontent)
    TextView tvContent2;
    @BindView(R.id.tv_chatcontent3)
    TextView tvContent3;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_userhead)
    ImageView ivUserhead;
    private float textsize1, textsize2, textsize3;
    private float textSizef;//缩放比例
    private int currentIndex;
    private boolean isClickable = true;




    @Override
    public int createLayout() {
        return R.layout.activity_text_size;
    }

    @Override
    public void origination() {
        initData();
    }

    public void initData() {
        currentIndex = App.getMyApp().getPreferencesHelper().getValueInt("currentIndex", 1);
        textSizef = 1 + currentIndex * 0.1f;
        textsize1 = tvContent1.getTextSize() / textSizef;
        textsize2 = tvContent2.getTextSize() / textSizef;
        textsize3 = tvContent3.getTextSize() / textSizef;
        fontSliderBar.setTickCount(6).setTickHeight(DisplayUtils.convertDip2Px(this, 15)).setBarColor(Color.GRAY)
                .setTextColor(Color.BLACK).setTextPadding(DisplayUtils.convertDip2Px(this, 10)).setTextSize(DisplayUtils.convertDip2Px(this, 14))
                .setThumbRadius(DisplayUtils.convertDip2Px(this, 10)).setThumbColorNormal(Color.GRAY).setThumbColorPressed(Color.GRAY)
                .setOnSliderBarChangeListener(new FontSliderBar.OnSliderBarChangeListener() {
                    @Override
                    public void onIndexChanged(FontSliderBar rangeBar, int index) {
                        if(index>5){
                            return;
                        }
                        index = index - 1;
                        float textSizef = 1 + index * 0.1f;
                        setTextSize(textSizef);
                    }
                }).setThumbIndex(currentIndex).withAnimation(false).applay();
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fontSliderBar.getCurrentIndex() != currentIndex) {
                    if (isClickable) {
                        isClickable = false;
                        refresh();
                    }
                } else {
                    finish();
                }
            }
        });
    }

    private void setTextSize(float textSize) {
        //改变当前页面的字体大小
        tvContent1.setTextSize(DisplayUtils.px2sp(this, textsize1 * textSize));
        tvContent2.setTextSize(DisplayUtils.px2sp(this, textsize2 * textSize));
        tvContent3.setTextSize(DisplayUtils.px2sp(this, textsize3 * textSize));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (currentIndex != fontSliderBar.getCurrentIndex()) {
                if (isClickable) {
                    isClickable = false;
                    refresh();
                }
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void refresh() {
        //存储标尺的下标
       App.getMyApp().getPreferencesHelper().setValue("currentIndex", fontSliderBar.getCurrentIndex());
        //通知主页面重启
        RxBus.getInstance().post(SettingActivity.class.getSimpleName(), new MessageSocket(99, null, null, null));
        //重启mainActivity
        RxBus.getInstance().post(SettingActivity.class.getSimpleName(), new MessageSocket(99, null, null, null));
//        showMyDialog();
        //2s后关闭  延迟执行任务 重启完主页
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                hideMyDialog();
                finish();
            }
        }, 2000);
    }
}
