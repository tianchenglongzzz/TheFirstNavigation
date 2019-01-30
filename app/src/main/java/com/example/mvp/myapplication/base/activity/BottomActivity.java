package com.example.mvp.myapplication.base.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @packge: com.example.mvp.myapplication.base.activity
 * @filename:BottomActivity
 * @date :${DATA} 11:30
 */
public abstract class BottomActivity  extends AppCompatActivity {
    private Unbinder binds;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
 /*if (Build.VERSION.SDK_INT >= 21) {
     this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
 }*/
        super.onCreate(savedInstanceState);
        setContentView(createLayout());
        viewCreate();
        binds = ButterKnife.bind(this);
        origination();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void  viewCreate(){

    }
    public abstract int   createLayout();

    //主方法 所有的步骤在这里进行
    public  abstract void origination();

    public void  initData(){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binds.unbind();

    }
    public  void  showTost(String tost){
        Toast.makeText(this,tost,Toast.LENGTH_SHORT).show();
    }
}
