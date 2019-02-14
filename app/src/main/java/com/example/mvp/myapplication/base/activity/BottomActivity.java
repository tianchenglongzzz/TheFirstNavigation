package com.example.mvp.myapplication.base.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStructure;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.app.App;
import com.example.mvp.myapplication.utils.MessageSocket;
import com.example.mvp.myapplication.utils.RxBus;
import com.example.mvp.myapplication.utils.SharedPreferencesUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * @packge: com.example.mvp.myapplication.base.activity
 * @filename:BottomActivity
 * @date :${DATA} 11:30
 */
public abstract class BottomActivity  extends AppCompatActivity {
    private Unbinder binds;
    public Observable observable;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
 /*if (Build.VERSION.SDK_INT >= 21) {
     this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
 }*/
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
            Window window = getWindow();
            View decorView = window.getDecorView();
            //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            //导航栏颜色也可以正常设置
            //window.setNavigationBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            attributes.flags |= flagTranslucentStatus;
            //int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
            //attributes.flags |= flagTranslucentNavigation;
            window.setAttributes(attributes);
        }
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(this).inflate(createLayout(), null);
        setContentView(view);
        viewCreate(view);
        binds = ButterKnife.bind(this);
        observable = RxBus.getInstance().register(this.getClass().getSimpleName(), MessageSocket.class);
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<MessageSocket>() {

            @Override
            public void accept(MessageSocket message) throws Exception {
                rxBusCall(message);
            }
        });
        origination();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    public void  viewCreate(View view){

    }
    public abstract int   createLayout();

    //主方法 所有的步骤在这里进行
    public  abstract void origination();
    public void rxBusCall(MessageSocket message) {
    }

    public void  initData(){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unregister(this.getClass().getSimpleName(), observable);
        binds.unbind();



    }
    //设置字体的缩放比率
    @Override
    protected void onResume() {
        super.onResume();




    }

    //重写字体缩放比例 api<25
    @Override
    public Resources getResources() {
        Resources res =super.getResources();
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.N) {
            Configuration config = res.getConfiguration();
            config.fontScale= App.getMyApp().getFontScale();//1 设置正常字体大小的倍数
            res.updateConfiguration(config,res.getDisplayMetrics());
        }
        return res;
    }
    public  void  setToobar(Toolbar toobar){
        toobar.setNavigationIcon(R.mipmap.smallfanhui);
        toobar.setTitle("");
        setSupportActionBar(toobar);
        toobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public  void  showTost(String tost){
        Toast.makeText(this,tost,Toast.LENGTH_SHORT).show();
    }
    //重写字体缩放比例  api>25
    //重写字体缩放比例  api>25
    @Override
    protected void attachBaseContext(Context newBase) {
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.N){
            final Resources res = newBase.getResources();
            final Configuration config = res.getConfiguration();
            config.fontScale=App.getMyApp().getFontScale();//1 设置正常字体大小的倍数
            final Context newContext = newBase.createConfigurationContext(config);
            super.attachBaseContext(newContext);
        }else{
            super.attachBaseContext(newBase);
        }
    }

}
