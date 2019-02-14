package com.example.mvp.myapplication.presenter;

import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.TagsHotInterface;
import com.example.mvp.myapplication.http.bean.callback.TagsHotBean;
import com.example.mvp.myapplication.http.bean.callback.TagsSearchDataBean;
import com.example.mvp.myapplication.module.TagsHotModel;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.presenter
 * @filename:TagsPresenter
 * @date :${DATA} 20:36
 */
public class TagsPresenter<V extends TagsHotInterface.ITagsHotV> extends BasePresenter<V> implements TagsHotInterface.ITagsHotM,TagsHotInterface.ITagsHotP {

    TagsHotModel mTagsHotModel=   new TagsHotModel();
    @Override
    public void shetTagsHotData(List<TagsHotBean> value) {
            if (mview != null) {
                mview.showTagsHotData(value);
            }

    }

    @Override
    public void setTagsSearchData(TagsSearchDataBean dataBean) {
            mview.showTagsSearchData(dataBean);
    }

    @Override
    public void shetTagsHotData(String str) {
              mTagsHotModel.getTagsHotData(this,str);

    }

    @Override
    public void getTagsSearchData(String json) {
                mTagsHotModel.getTagsSearchData(this,json);
    }
}
