package com.example.mvp.myapplication.http.bean.callback;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:TagsSearchDataBean
 * @date :${DATA} 17:54
 */
public class TagsSearchDataBean {

    /**
     * tagList : [{"id":"e49222bf3b0611e8b64c00163e30445d","tag":"通航展论"}]
     * cursor : 3
     */

    private String cursor;
    private List<TagsHotBean> tagList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<TagsHotBean> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagsHotBean> tagList) {
        this.tagList = tagList;
    }


}
