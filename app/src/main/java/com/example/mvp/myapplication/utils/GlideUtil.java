package com.example.mvp.myapplication.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.example.mvp.myapplication.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * @packge: com.example.mvp.myapplication.utils
 * @filename:GlideUtil
 * @date :${DATA} 20:11
 */
public class GlideUtil {
   //Glide 加载大图片的方法
     public  static  void  setImgBig(String  url, final ImageView imageView, Activity activity){
         boolean wifiimg = SharedPreferencesUtils.getSharedPreferences(activity).getBoolean("wifiimg", false);
         if (wifiimg){
             boolean wifi = WifiUtils.isWifi(activity);
             if (wifi){
                 Glide.with(activity).load(url).placeholder(R.mipmap.zanweitu).error(R.drawable.errp).into(imageView);

             }else {
                 imageView.setImageResource(R.drawable.wifioff);
             }

         }else {

             Glide.with(activity).load(url).placeholder(R.mipmap.zanweitu).error(R.drawable.errp).into(imageView);
         }
         }





}
