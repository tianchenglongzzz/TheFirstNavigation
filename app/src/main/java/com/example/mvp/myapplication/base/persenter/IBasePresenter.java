package com.example.mvp.myapplication.base.persenter;

/**
 * @packge: com.example.mvp.myapplication.base.persenter
 * @filename:IPresenter
 * @date :${DATA} 9:42
 */
public interface IBasePresenter<V> {
    //用来绑定mvp
    void  attachView(V v);
    //解梆mvp 处理项目的内存泄漏
    void detachView();

}
