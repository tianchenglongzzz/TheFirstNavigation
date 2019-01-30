package com.example.mvp.myapplication.http.manager;

import android.support.annotation.Nullable;

import com.example.mvp.myapplication.app.Global;
import com.example.mvp.myapplication.http.api.Api;

/**
 * @packge: com.example.mvp.myapplication.http.manager
 * @filename:ApiManager
 * @date :${DATA} 14:05
 */
public class ApiManager {
        private static Api api;
        private   static  Api apiv;
        public  static  Api getApi(){
            if (api==null){
                synchronized (ApiManager.class){
                      if (api==null){
                          api=HttpManager.getInstance().getServer(Global.HOST,Api.class);
                      }

                }

            }
            return api;
        }
    public  static  Api getApiv(){
        if (apiv==null){
            synchronized (ApiManager.class){
                if (apiv==null){
                    apiv=HttpManager.getInstance().getServer(Global.VCode,Api.class);
                }

            }

        }
        return apiv;
    }

}
