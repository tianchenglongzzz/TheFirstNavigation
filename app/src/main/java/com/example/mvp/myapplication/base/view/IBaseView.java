package com.example.mvp.myapplication.base.view;

import android.view.View;
import android.view.ViewGroup;

/**
 * @packge: com.example.mvp.myapplication.base.view
 * @filename:IBaseView
 * @date :${DATA} 9:46
 */
public interface IBaseView {
    //在网络中请求数据的时候调用
    //因为是调用一个popwindow  要传递一个view
    //不确定申请数据的视图
     void showProgessbar();
     void  hideProgessbar();
    //用于处理网络请求错误等数据方法
    void  showError(String error);
    //用于处理网络错误的方法
    void  showWarn();
    //用于网络请求错误消失的接口
    void  dismissErrolayout();
}
