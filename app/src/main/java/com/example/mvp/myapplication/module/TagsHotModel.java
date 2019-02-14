package com.example.mvp.myapplication.module;

import com.example.mvp.myapplication.contact.TagsHotInterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.TagsHotBean;
import com.example.mvp.myapplication.http.bean.callback.TagsSearchDataBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.HttpUtils;
import com.example.mvp.myapplication.utils.RxUtils;

import java.util.List;

import okhttp3.RequestBody;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:TagsHotModel
 * @date :${DATA} 20:32
 */
public class TagsHotModel {
     public  void  getTagsHotData(final TagsHotInterface.ITagsHotM iTagsHotM, String json){
             iTagsHotM.shetShowProgressbar();
         RequestBody body = HttpUtils.getBody(json);
         ApiManager.getApi().getTagsHotData(body).compose(RxUtils.<List<TagsHotBean>>handleResult())
                 .compose(RxUtils.<List<TagsHotBean>>rxObserableSchedulerHelper())
                 .subscribe(new BaseObserver<List<TagsHotBean>>(iTagsHotM) {
                     @Override
                     public void onNext(List<TagsHotBean> value) {
                           iTagsHotM.shetTagsHotData(value);
                     }
                 });
     }
     public  void  getTagsSearchData(final TagsHotInterface.ITagsHotM iTagsSearchM, String json){
         RequestBody body = HttpUtils.getBody(json);
         ApiManager.getApi().getTagsSearchData(body).compose(RxUtils.<InfoBean<TagsSearchDataBean>>rxObserableSchedulerHelper())
                 .compose(RxUtils.<TagsSearchDataBean>handleResult()).subscribe(new BaseObserver<TagsSearchDataBean>(iTagsSearchM) {
             @Override
             public void onNext(TagsSearchDataBean value) {
                   iTagsSearchM.setTagsSearchData(value);
             }
         });
     }

}
