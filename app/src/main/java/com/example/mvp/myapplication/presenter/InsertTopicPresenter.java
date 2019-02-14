package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.InfoInterface;
import com.example.mvp.myapplication.contact.InsertTopicInterface;
import com.example.mvp.myapplication.http.bean.callback.InsertBean;
import com.example.mvp.myapplication.http.bean.callback.VCBean;
import com.example.mvp.myapplication.module.IinsertTopicModel;

import java.io.File;
import java.util.List;

import okhttp3.RequestBody;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:InsertTopicPresenter
 * @date :${DATA} 21:44
 */
public class InsertTopicPresenter<V extends InsertTopicInterface.IinsertTopicV>  extends BasePresenter<V> implements InsertTopicInterface.IinsertTopicM,InsertTopicInterface.IinsertTopicP {
IinsertTopicModel mIinsertTopicModel=     new IinsertTopicModel();

    @Override
    public void setInsertTopicData(InsertBean vcBean) {
          mview.showInsertTopicData(vcBean);
    }



    @Override
    public void getIinsertTopicData(String topicId,String userId, String title, String tagList, String shareLink, List<File>files) {
        mIinsertTopicModel.getInsertTopicData(this,topicId,userId,title,tagList,shareLink,files);
    }
}
