package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.InfiBean;
import com.example.mvp.myapplication.http.bean.callback.RelevantBean;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:InFoInterface
 * @date :${DATA} 11:33
 */
public interface InfoInterface {
       interface  IinfoMoudel extends HttpFinshCallBack {
            void   setInfolsit(InfiBean InfiBean);
            void   setRelevantlsit(List<RelevantBean> relevantlsit);
       }
       interface  IinfoPresenter {
              void  getInfoList(String newsid);
              void  getRelevantlsit(String newsid);
       }
       interface  IinfoView extends IBaseView {
               void  showInfoBean(InfiBean InfiBean);
           void   showRelevantlsit(List<RelevantBean> relevantlsit);
       }
}
