package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.HotBean;
import com.example.mvp.myapplication.http.bean.callback.UpListNewsBean;

import butterknife.BindView;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:SearchInterface
 * @date :${DATA} 15:56
 */
public interface SearchInterface {
      interface  IsearchM extends HttpFinshCallBack{
           void  setHotBean(HotBean hotBean);
      }
      interface IsearchP {
          void  getHotBean(String  body);
      }
      interface IsearcchV extends IBaseView {
          void showHotBean(HotBean hotBean);
      }
      interface IsearchNewsM extends HttpFinshCallBack{
          void  setNewsBean(UpListNewsBean upListNewsBean);
      }
    interface IsearchNewsP{
        void  getNewsBean(String json);
    }
    interface IsearchNewsv extends IBaseView {
        void  showNewsBean(UpListNewsBean upListNewsBean);
    }
}
