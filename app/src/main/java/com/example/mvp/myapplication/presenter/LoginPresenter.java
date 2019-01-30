package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.LoginInterface;
import com.example.mvp.myapplication.module.VerifyModel;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:LoginPresenter
 * @date :${DATA} 22:03
 */
public class LoginPresenter<V extends LoginInterface.ILoginV> extends BasePresenter<V> implements LoginInterface.ILoginP,LoginInterface.ILoginM{

    VerifyModel  mVerifyModel=new VerifyModel();
    @Override
    public void setVerifyData(String code) {
             mview.showVerifyData(code);
    }

    @Override
    public void setVerifyData() {
            mVerifyModel.getVerifyData(this,"");
    }
}



