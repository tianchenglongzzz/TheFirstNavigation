package com.example.mvp.myapplication.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.mvp.myapplication.greedao.DaoMaster;
import com.example.mvp.myapplication.greedao.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;


import okhttp3.MediaType;

/**
 * @packge: com.example.mvp.myapplication.app
 * @filename:MyApp
 * @date :${DATA} 13:48
 */
public class App extends Application {
    private static App mMyApp;
    private static DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mMyApp=this;
        Fresco.initialize(this);
        CrashReport.initCrashReport(this,"9c6e21f49d",true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        UMConfigure.init(this, "5c43d31db465f5b2cc000b8e","Umeng",UMConfigure.DEVICE_TYPE_PHONE,null);
        //禁止默认的页面统计功能，这样将不会再自动统计Activity页面。（包含Activity、Fragment或View的应用）
        MobclickAgent.openActivityDurationTrack(false);
        // 打开统计SDK调试模式（上线时记得关闭）
        UMConfigure.setLogEnabled(true);
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "TheFirstNavigation.db");
        SQLiteDatabase database = helper.getReadableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        mDaoSession=daoMaster.newSession();
       /* UMConfigure.init(this,"5c43d31db465f5b2cc000b8e"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad","http://sns.whalecloud.com");
        PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");*/
    }
    public static  App getMyApp(){
        return mMyApp;

    }

    public  static  DaoSession getSession(){
         return  mDaoSession;
    }
}
