package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;


/**
 * @packge: com.jiyun.com.myapplication.contact
 * @filename:LoginInterface
 * @date :${DATA} 21:56
 */
public interface LoginInterface {

      interface ILoginV extends IBaseView {
            void  showVerifyData(String code);
     }
      interface  ILoginM extends HttpFinshCallBack{
            void setVerifyData(String data);
    }
     interface  ILoginP {
          void  setVerifyData();
    }
}
