package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.DownListNewsBean;
import com.example.mvp.myapplication.http.bean.callback.UploadHeadImageBean;

import java.io.File;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:UploadHeadImageInterface
 * @date :${DATA} 21:19
 */
public interface UploadingInterface {

      interface  IUploadHeadImageM extends HttpFinshCallBack {
                void  setploadHeadImageuBean(UploadHeadImageBean uploadHeadImageBean);


      }
      interface  IUploadHeadImageP {
           void  getUploadHeadImageBean(File file,String userid);

      }
      interface  IUploadHeadImageV extends IBaseView {
          void  showUploadHeadImageBean(UploadHeadImageBean uploadHeadImageBean);
      }

}
