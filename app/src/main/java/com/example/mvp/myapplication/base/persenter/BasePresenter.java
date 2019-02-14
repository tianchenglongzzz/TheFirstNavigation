package com.example.mvp.myapplication.base.persenter;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;

import java.lang.ref.WeakReference;

/**
 * @packge: com.example.mvp.myapplication.base.persenter
 * @filename:BasePresenter
 * @date :${DATA} 10:05
 */
public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V>,HttpFinshCallBack {
    public V  mview;
      WeakReference<V> mWeakReference;

     //进行mvp绑定
    @Override
    public void attachView(V v) {
        mWeakReference=new WeakReference<>(v);
        mview= mWeakReference.get();
    }

    //进行mvp解
    @Override
    public void detachView() {
        mWeakReference.clear();
        mview=null;
    }
    @Override
    public void shetShowProgressbar() {
        if (mview!=null) {
            mview.showProgessbar();
        }
    }

    @Override
    public void setHideProgressbar() {
        if (mview!=null) {
            mview.hideProgessbar();
        }
    }

    @Override
    public void setError(String error) {
        if (error!=null) {
            if (mview!=null) {
                mview.showError(error);
            }
        }
    }

    @Override
    public void setWarn(String string) {
        if (mview!=null) {
            mview.showWarn();
        }
    }

    @Override
    public void setErrolayoutdismiss() {
         mview.dismissErrolayout();
    }
}
