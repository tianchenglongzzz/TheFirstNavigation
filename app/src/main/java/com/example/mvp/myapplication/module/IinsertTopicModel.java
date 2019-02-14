package com.example.mvp.myapplication.module;

import android.util.Log;

import com.example.mvp.myapplication.contact.InsertTopicInterface;
import com.example.mvp.myapplication.http.base.BaseObserver;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.InsertBean;
import com.example.mvp.myapplication.http.bean.callback.VCBean;
import com.example.mvp.myapplication.http.manager.ApiManager;
import com.example.mvp.myapplication.utils.RxUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;

/**
 * @packge: com.example.mvp.myapplication.module
 * @filename:IinsertTopicModel
 * @date :${DATA} 21:40
 */
public class IinsertTopicModel {


    public  void  getInsertTopicData(final InsertTopicInterface.IinsertTopicM iinsertTopicM,String topicId, String userId, String title, String tagList, String shareLink, List<File>files){
              iinsertTopicM.shetShowProgressbar();
        Log.d("tian","我上传到这里拉");
        MultipartBody.Builder body=null;
        if (files!=null) {
            if (files.size()>0) {
                body = new MultipartBody.Builder();
                body.setType(MultipartBody.FORM);
                body.addFormDataPart("userId", userId);
                body .addFormDataPart("title", title);
                body .addFormDataPart("tagList", tagList);
                body  .addFormDataPart("shareLink", shareLink);
                for (int i = 0; i <files.size() ; i++) {
                    body.addFormDataPart("fileList",files.get(i).getName(),MultipartBody.create(MediaType.parse("image/*"),files.get(i)));
                }
                MultipartBody build = body.build();

                ApiManager.getApi().getInsertTopic(build).compose(RxUtils.<InsertBean>rxObserableSchedulerHelper())
                        .subscribe(new BaseObserver<InsertBean>(iinsertTopicM) {
                            @Override
                            public void onNext(InsertBean value) {
                                Log.d("tian","我上传到这里拉");
                                iinsertTopicM.setInsertTopicData(value);
                            }
                        });
            }
        }else {
            MultipartBody build = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("userId", userId)
                    .addFormDataPart("title", title)
                    .addFormDataPart("tagList", tagList)
                    .addFormDataPart("shareLink", shareLink)
                    .build();
            ApiManager.getApi().getInsertTopicTow(build).compose(RxUtils.<InsertBean>rxObserableSchedulerHelper())
                    .subscribe(new BaseObserver<InsertBean>(iinsertTopicM) {
                        @Override
                        public void onNext(InsertBean value) {
                            Log.d("tian","我上传到这里拉");
                            iinsertTopicM.setInsertTopicData(value);
                        }
                    });
        }




    }

}
