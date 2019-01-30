package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.DownListNewsBean;
import com.example.mvp.myapplication.http.bean.callback.UpListNewsBean;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:DownListNewsIntenface
 * @date :${DATA} 20:18
 */
public interface UpListNewsIntenface {
    interface IUpListNewsV extends IBaseView {
        void  showUpListNewsData(UpListNewsBean code);
        void  setDownListNewsHeadImageuBean(UpListNewsBean downListNewsBean);
    }
    interface  IUpListNewsM extends HttpFinshCallBack{
        void setUpListNewsData(UpListNewsBean json);
        void getDownListNewsHeadImageuBean(UpListNewsBean downListNewsBean);
    }
    interface  IUpListNewsP {
        void setUpListNewsData(String json);

        void getDownListNewsData(String json);
    }

}
