package com.example.mvp.myapplication.http.base;

import android.app.Application;
import android.util.Log;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.erro.ApiException;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * @packge: com.example.mvp.myapplication.http.base
 * @filename:BaseObservable
 * @date :${DATA} 10:32
 */
public abstract class BaseObserver<T> implements Observer<T> {

    private static final String TAG = "ERRO";
    //回调结果处理
          private HttpFinshCallBack mFinshCallBack;


    public BaseObserver(HttpFinshCallBack finshCallBack) {
        mFinshCallBack = finshCallBack;
    }
CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public void onSubscribe(Disposable d) {
          mCompositeDisposable.add(d);
    }

    @Override
    public void onError(Throwable e) {
              String erro="";
            //网络请求错误方法
        mFinshCallBack.setHideProgressbar();
           if (mCompositeDisposable!=null){
               //释放内存
               mCompositeDisposable.clear();
           }
           if (e instanceof ApiException){

               Log.e(TAG, "onError: "+e.getMessage() );
               switch (((ApiException) e).getCode()) {
                   case 2001:
                      erro="验证码错误";
                       break;
                   case  2002:
                       erro="数据不存在";
                        break;
                   case  2003:
                       erro="非法手机号";
                        break;
                   case  2004:
                      erro="验证码一分钟内不能重复发送";
                        break;
                   case  2005:
                       erro="验证码一分钟内不能重复发送";
                        break;
                   case 2006:
                       erro="验证码发送失败";
               }
           }
            mFinshCallBack.setError(erro);
           if (e instanceof HttpException){
               erro="网络请求错误";
               mFinshCallBack.setWarn("");

           }else {
              erro="其他请求错误";
              mFinshCallBack.setWarn("");
           }
           if (erro!=null){
               mFinshCallBack.setError(erro);
           }

        Log.e(TAG, "onError: "+e.getMessage() );


    }

    @Override
    public void onComplete() {
        mFinshCallBack.setHideProgressbar();
        //Rxjava 事件处理完毕会调用这个方法
        if (mCompositeDisposable!=null){
             mCompositeDisposable.clear();
        }
        if (mFinshCallBack!=null){
            mFinshCallBack.setHideProgressbar();
        }
        mFinshCallBack.setErrolayoutdismiss();
    }


}
