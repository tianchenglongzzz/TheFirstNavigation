package com.example.mvp.myapplication.utils;

import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.VCBean;
import com.example.mvp.myapplication.http.bean.erro.ApiException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 项目名：MyProject
 * 包名：  com.liangxq.mydemo.utils
 * 文件名：RxUtils
 * 创建者：liangxq
 * 创建时间：2018/12/21  9:46
 * 描述：TODO
 */
public class RxUtils {


    public static <T> ObservableTransformer<T, T> rxObserableSchedulerHelper() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
  public static  <T> ObservableTransformer<InfoBean<T>, T> handleResult(){
        return  new ObservableTransformer<InfoBean<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<InfoBean<T>> upstream) {
                return upstream.flatMap(new Function<InfoBean<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(InfoBean<T> tInfoBean) throws Exception {
                                    if (tInfoBean.getCode()==0){
                                        return  createData(tInfoBean.getData());
                                    }else {
                                         new Throwable("");
                                         return  Observable.error(new ApiException(tInfoBean.getMessage(), tInfoBean.getCode()));
                                    }
                                    }
                });
            }
        };
  }

    public  static   <T> Observable<T> createData(final T code) {
           return Observable.create(new ObservableOnSubscribe<T>() {
               @Override
               public void subscribe(ObservableEmitter<T> e) {

                         try {
                             e.onNext(code);
                             e.onComplete();
                         }catch (Exception e1){
                                e.onError(e1);
                         }
               }
           });
    }


}
