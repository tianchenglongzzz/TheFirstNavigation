package com.example.mvp.myapplication.module;

import com.example.mvp.myapplication.contact.LoginInterface;
import com.example.mvp.myapplication.http.api.Api;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.VCBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.http.manager.HttpManager;
import com.example.mvp.myapplication.utils.HttpUtils;
import com.example.mvp.myapplication.utils.RxUtils;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:VerifyModel
 * @date :${DATA} 11:59
 */
public class VerifyModel {

      public  void getVerifyData(final LoginInterface.ILoginM loginM, String data){
          loginM.shetShowProgressbar();
          ApiManager.getApiv().getVerify().compose(RxUtils.<VCBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<VCBean>(loginM) {
              @Override
              public void onNext(VCBean value) {
                    loginM.setVerifyData(value.getData());
              }
          });

      }

}
