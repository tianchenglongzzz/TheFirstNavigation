package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.EditInterface;
import com.example.mvp.myapplication.http.bean.callback.AboutUsBean;
import com.example.mvp.myapplication.module.EditModel;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:EditPresenter
 * @date :${DATA} 8:12
 */
//设置P层
public class EditPresenter<V extends EditInterface.IEditV> extends BasePresenter<V> implements EditInterface.IEditP,EditInterface.IEditM {

    //EditModle层对象
    EditModel mEditModel=new EditModel();
    //设置到详情数据View层
    @Override
    public void setAboutUsBean(AboutUsBean aboutUsBean) {
         mview.showAboutUsBean(aboutUsBean);
    }


    //获取详情数据
    @Override
    public void getAboutUsBean() {
           mEditModel.getAboutUsBean(this);
    }
}
