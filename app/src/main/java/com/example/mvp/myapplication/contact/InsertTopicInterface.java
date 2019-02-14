package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.InsertBean;
import com.example.mvp.myapplication.http.bean.callback.VCBean;

import java.io.File;
import java.util.List;

import okhttp3.RequestBody;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:InsertTopicInterface
 * @date :${DATA} 21:37
 */
public interface InsertTopicInterface {
       interface  IinsertTopicV extends IBaseView{
            void  showInsertTopicData(InsertBean vcBean);
       }
    interface  IinsertTopicM extends HttpFinshCallBack {
        void  setInsertTopicData(InsertBean vcBean);
    }
    interface  IinsertTopicP{
           void  getIinsertTopicData(String topicId,String userId, String title, String tagList, String shareLink, List<File>files);
    }

}
