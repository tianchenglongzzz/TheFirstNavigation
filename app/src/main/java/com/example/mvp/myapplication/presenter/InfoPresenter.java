package com.example.mvp.myapplication.presenter;

import android.util.Log;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.InfoInterface;
import com.example.mvp.myapplication.http.bean.callback.InfiBean;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListCommentBean;
import com.example.mvp.myapplication.http.bean.callback.RelevantBean;
import com.example.mvp.myapplication.module.InfoMoudle;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:InfoPresenter
 * @date :${DATA} 11:49
 */
public class InfoPresenter<V extends InfoInterface.IinfoView> extends BasePresenter<V> implements InfoInterface.IinfoPresenter,InfoInterface.IinfoMoudel{
       InfoMoudle mInfoMoudle= new InfoMoudle();



    @Override
    public void getInfoList(String userId) {
           mInfoMoudle.getInfoMoudle(this,userId);
    }

    @Override
    public void getRelevantlsit(String newsid) {
        mInfoMoudle.getInfoRelevantlsit(this,newsid);
    }

    @Override
    public void getlistComment(String info) {
        Log.d("info",info);
        mInfoMoudle.getlistComment(this,info);
    }

    @Override
    public void getLikeData(String json) {
          mInfoMoudle.getLikesData(this,json);
    }

    @Override
    public void setInfolsit(InfiBean infiBean) {
            mview.showInfoBean(infiBean);
    }

    @Override
    public void setRelevantlsit(List<RelevantBean> relevantlsit) {
             mview.showRelevantlsit(relevantlsit);
    }

    @Override
    public void setlistComment(ListCommentBean listCommentBean) {
           mview.showlistComment(listCommentBean);
    }

    @Override
    public void setLikeData(InfoBean infoBean) {
           mview.showLikeData(infoBean);
    }

}
