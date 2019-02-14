package com.example.mvp.myapplication.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.greedao.DaoMaster;
import com.example.mvp.myapplication.greedao.DaoSession;
import com.example.mvp.myapplication.utils.PreferencesHelper;
import com.example.mvp.myapplication.utils.SharedPreferencesUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;


import okhttp3.MediaType;

/**
 * @packge: com.example.mvp.myapplication.app
 * @filename:MyApp
 * @date :${DATA} 13:48
 */
public class App extends Application {
    private static App mMyApp;
    private static DaoSession mDaoSession;
    private SharedPreferences mSharedPreferences;
    private PreferencesHelper mPh;

    @Override
    public void onCreate() {
        super.onCreate();
        mMyApp=this;
        mPh = new PreferencesHelper(this, "test");
        mSharedPreferences=getSharedPreferences("text",MODE_PRIVATE);
        Fresco.initialize(this);
        CrashReport.initCrashReport(this,"9c6e21f49d",true);
        //MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        UMConfigure.init(this, "5c43d31db465f5b2cc000b8e","Umeng",UMConfigure.DEVICE_TYPE_PHONE,null);
        //禁止默认的页面统计功能，这样将不会再自动统计Activity页面。（包含Activity、Fragment或View的应用）
        //MobclickAgent.openActivityDurationTrack(false);
        // 打开统计SDK调试模式（上线时记得关闭）
        UMConfigure.setLogEnabled(true);
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "TheFirstNavigation.db");
        SQLiteDatabase database = helper.getReadableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        mDaoSession=daoMaster.newSession();
        UMConfigure.setLogEnabled(true);
        //初始化操作
        UMConfigure.init(this, "5b248738a40fa37c010000a3", "MyYouMeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        //各个平台key的配置
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
       /* UMConfigure.init(this,"5c43d31db465f5b2cc000b8e"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad","http://sns.whalecloud.com");
        PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");*/
      // attachBaseContext(this);

    }
    public static  App getMyApp(){
        return mMyApp;


    }

    @Override
    public Resources getResources() {
        Resources resource = super.getResources();
        Configuration configuration = resource.getConfiguration();
        float text = mSharedPreferences.getFloat("text",1);
        if (configuration.fontScale!=text) {
            configuration.fontScale = text;//// 设置字体的缩放比例
            resource.updateConfiguration(configuration, resource.getDisplayMetrics());
        }

        return resource;

    }

    public  static  DaoSession getSession(){
         return  mDaoSession;
    }
   /* protected void attachBaseContext(Context newBase) {

    }*/
   public PreferencesHelper getPreferencesHelper() {
       return mPh;
   }
    public float getFontScale(){
        int currentIndex= mPh.getValueInt("currentIndex",1);
        return 1+currentIndex*0.1f;
    }
}
