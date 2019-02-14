package com.example.mvp.myapplication.contact;

import com.example.mvp.myapplication.base.model.HttpFinshCallBack;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.http.bean.callback.TagsHotBean;
import com.example.mvp.myapplication.http.bean.callback.TagsSearchDataBean;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.contact
 * @filename:TagsHotInterface
 * @date :${DATA} 20:28
 */
public interface TagsHotInterface {
     interface  ITagsHotV extends IBaseView{
          void showTagsHotData(List<TagsHotBean> value);
         void showTagsSearchData(TagsSearchDataBean dataBean);
     }

     interface  ITagsHotM extends HttpFinshCallBack{
         void  shetTagsHotData(List<TagsHotBean> value);
         void setTagsSearchData(TagsSearchDataBean dataBean);
     }
    interface  ITagsHotP extends HttpFinshCallBack{
        void  shetTagsHotData(String str);
        void  getTagsSearchData(String json);
    }


}
