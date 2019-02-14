package com.example.mvp.myapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mvp.myapplication.app.Global;

import java.util.Set;

/**
 * @packge: com.example.mvp.myapplication.utils
 * @filename:SharedPreferencesUtils
 * @date :${DATA} 20:04
 */
public class SharedPreferencesUtils {
    private static SharedPreferences mSharedPreferences;
    private static SharedPreferencesUtils msp;

    public  static  SharedPreferencesUtils  getSharedPreferences(Context context){
         if (mSharedPreferences==null){
             synchronized (SharedPreferences.class){
                 if (mSharedPreferences==null){
                      mSharedPreferences=context.getSharedPreferences(Global.TIMESP,Context.MODE_PRIVATE);
                    msp=new SharedPreferencesUtils();
                   }
             }

         }

        return msp;
    }
    public  int  getInt(String name,int  defValue){
        return mSharedPreferences.getInt(name, defValue);

    }
    public  boolean getBoolean(String name,boolean defValue){
           return   mSharedPreferences.getBoolean(name,defValue);
    }
    public void putBoolean(String key, boolean value){
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putBoolean(key,value);
        edit.commit();


    }
    public void  putInt(String key,int value){
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putInt(key,value);
        edit.commit();

    }
    public void putSet(String key,Set<String> value){
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putStringSet(key,value);
    }
   public  void  putFloat(float f,String key){
       SharedPreferences.Editor edit = mSharedPreferences.edit();
       edit.putFloat(key,f);
       edit.commit();
   }
   public  float  getFloat(String key,float  defValue){
          return  mSharedPreferences.getFloat(key,defValue);
   }



}
