package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.UploadingInterface;
import com.example.mvp.myapplication.http.bean.callback.UploadHeadImageBean;
import com.example.mvp.myapplication.module.UploadHeadImageModel;

import java.io.File;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:UploadHeadImagePresenter
 * @date :${DATA} 21:35
 */
public class UploadHeadImagePresenter<V extends UploadingInterface.IUploadHeadImageV> extends BasePresenter<V> implements UploadingInterface.IUploadHeadImageP,UploadingInterface.IUploadHeadImageM {
     UploadHeadImageModel mUploadHeadImageModel=new UploadHeadImageModel();

    @Override
    public void setploadHeadImageuBean(UploadHeadImageBean uploadHeadImageBean) {
                   mview.showUploadHeadImageBean(uploadHeadImageBean);
    }

    @Override
    public void shetShowProgressbar() {
          mview.showProgessbar();
    }

    @Override
    public void setHideProgressbar() {
           mview.hideProgessbar();
    }

    @Override
    public void setError(String error) {
       mview.showError(error);
    }

    @Override
    public void setWarn(String string) {

    }

    @Override
    public void getUploadHeadImageBean(File file, String userid) {
           mUploadHeadImageModel.getUploadHeadImage(this,file,userid);
    }
}
