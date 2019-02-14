package com.example.mvp.myapplication.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @packge: com.example.mvp.myapplication.utils
 * @filename:WifiUtlis
 * @date :${DATA} 14:02
 */
public class WifiUtils {
    //判断当前是否在WIFi网络下
    public static boolean isWifi(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info= connectivityManager.getActiveNetworkInfo();
        if (info!= null
                && info.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }

}
