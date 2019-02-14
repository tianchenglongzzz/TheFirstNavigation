package com.example.mvp.myapplication.ui.my.activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.bigkoo.pickerview.OptionsPickerView;
import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.app.App;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.contact.EditInterface;
import com.example.mvp.myapplication.contact.TagsHotInterface;
import com.example.mvp.myapplication.http.bean.callback.AboutUsBean;
import com.example.mvp.myapplication.presenter.EditPresenter;
import com.example.mvp.myapplication.ui.main.activitys.MainActivity;
import com.example.mvp.myapplication.ui.news.activity.ShowDataActivity;
import com.example.mvp.myapplication.utils.DataCleanManager;
import com.example.mvp.myapplication.utils.MessageSocket;
import com.example.mvp.myapplication.utils.SharedPreferencesUtils;
import com.timmy.tdialog.TDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public  class SettingActivity extends BaseActivity<EditInterface.IEditV,EditPresenter<EditInterface.IEditV>>implements EditInterface.IEditV,CheckBox.OnCheckedChangeListener {
    @BindView(R.id.wifi_cb)
    Switch  mCbWifi;
    @BindView(R.id.my_edit)
    RelativeLayout mMyEdit;
    @BindView(R.id.cache_tv)
    TextView mCacheTv;
    @BindView(R.id.cache_close)
    RelativeLayout mCacheClose;
    @BindView(R.id.text_size)
    RelativeLayout mTextSize;
    @BindView(R.id.guanyu)
    RelativeLayout mGuanyu;
    //详情数据
    private String mXiangQingData;
    //设置TextsizeWindow的焦点
    private PopupWindow mTextSize1;

    private SharedPreferences.Editor mEdit;

    @Override
    public int createLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void origination() {

        //获取详情数据
        persemter.getAboutUsBean();
        initTotalCacheString();
        //获取是否在wifi下加载图片的状态
        boolean wifiimg = SharedPreferencesUtils.getSharedPreferences(this).getBoolean("wifiimg", false);
        //设置到Check上
        mCbWifi.setChecked(wifiimg);
        //绑定点击事件
        mCbWifi.setOnCheckedChangeListener(this);
    }
//获取缓存然后赋值
    private void initTotalCacheString() {
        try {
            mCacheTv.setText(DataCleanManager.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.my_edit, R.id.cache_tv, R.id.cache_close, R.id.text_size, R.id.wifi_cb, R.id.guanyu,R.id.quit_login})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.my_edit:
                Intent intent = new Intent(this, UpdateinfoActivity.class);
                startActivityForResult(intent,10);
                break;
            case R.id.cache_tv:
                break;
            case R.id.cache_close:
                //清除缓存
                DataCleanManager.clearAllCache(this);
                //在获取缓存赋值
                initTotalCacheString();
                break;
                //设置字体大小
            case R.id.text_size:
                 this.startActivity(new Intent(this,TextSizeActivity.class));
                break;
            case R.id.guanyu:
                //调到详情页面并赋值
                Intent intent1 = new Intent(this, WebActivity.class);
                intent1.putExtra("url",mXiangQingData);
                startActivity(intent1);
                break;
            case R.id.quit_login:
               SharedPreferencesUtils.getSharedPreferences(this).putBoolean("loginState", false);
                //设置登陆状态并退出登陆
                setResult(20);
                finish();
                break;

        }
    }




    @Override
    public EditPresenter<EditInterface.IEditV> createPresenter() {
        return new EditPresenter<>();
    }


    //获取详情数据
    @Override
    public void showAboutUsBean(AboutUsBean aboutUsBean) {
              //获取成功之后赋值
              mXiangQingData=aboutUsBean.getAboutUs();
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }

    @Override
    public void rxBusCall(MessageSocket message) {
        super.rxBusCall(message);
        switch (message.id){
            case 99://重启 不带动画
                Intent intent = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
                PendingIntent restartIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
                AlarmManager mgr = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 1000, restartIntent); // 1秒钟后重启应用
                System.exit(0);


                break;
        }
    }
}


