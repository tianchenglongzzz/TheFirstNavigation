package com.example.mvp.myapplication.base.model;

import com.example.mvp.myapplication.base.persenter.IBasePresenter;

/**
 * @packge: com.example.mvp.myapplication.base.model
 * @filename:IBaseModel
 * @date :${DATA} 9:57
 */
/*
* 这个接口给子model去继承
*   用于子modle调用view层的
*   正在加载方法
*   加载完成方法
*   错误数据方法
*
* */
public interface HttpFinshCallBack {

    void  shetShowProgressbar();
    void  setHideProgressbar();
    //用于处理网络请求错误等数据方法
    void  setError(String error);
    //用于处理用户输入错误服务器返回错误的方法
    void  setWarn(String string);
    void  setErrolayoutdismiss();


}
