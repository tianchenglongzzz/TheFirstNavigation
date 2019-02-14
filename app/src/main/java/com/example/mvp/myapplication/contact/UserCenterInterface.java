package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.UserCenterBean;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:UsuerCenterInterface
 * @date :${DATA} 12:14
 */
public interface UserCenterInterface {


      interface  IUserCenterV extends IBaseView {
          void showCenterData(UserCenterBean data);
      }
    interface  IUserCenterM extends HttpFinshCallBack {
        void setCenterData(UserCenterBean data);
    }
    interface  IUserCenterP {
        void setCenterData(String json);
    }


}
