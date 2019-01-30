package com.example.mvp.myapplication.http.bean.callback;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:downListNewsBean
 * @date :${DATA} 21:34
 */
public class DownListNewsBean {

    /**
     * cursor : 15233328018b1c0123258449c2ae7b4b91a54b5eb8
     * newList : [{"imageListThumb":["http://cn.ttfly.com/file/upload/201805/05/0957245212249.jpg"],"layoutType":"1","newsId":"82a8dedf1b8042a5b8a7996903084cfe","origin":"","pageviews":77,"publishTime":"2018-05-05","title":"跳伞中低空跳伞死伤超记录"},{"imageListThumb":["null"],"layoutType":"0","newsId":"8af93789a1134518aaa7e30a8883d5be","origin":"","pageviews":27,"publishTime":"2018-04-29","title":"华北首家轻型运动类飞机展开型号合格审定"},{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201804/28/201700x9ujvsvow9bsl0bs.jpg.thumb.jpg"],"layoutType":"2","newsId":"7137f419008c48b79a1fe80cc9aa3fb9","origin":"","pageviews":30,"publishTime":"2018-04-28","title":"10分钟内就可往返1200米高空！大棕熊跳伞飞机亮相郑州航展"},{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201804/13/155141ex55p3gwj21hkawg.jpg.thumb.jpg"],"layoutType":"2","newsId":"411365a7b2654140a8e5634af0d5ce5a","origin":"","pageviews":4,"publishTime":"2018-04-13","title":"３名奥地利滑翔伞爱好者在葡萄牙丧生"},{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201804/13/140710lt2ln023l5nn4434.jpg.thumb.jpg"],"layoutType":"2","newsId":"1773a0b208614691bbf18abc00495fd0","origin":"","pageviews":9,"publishTime":"2018-04-13","title":"乘滑翔翼航拍 \u201c海洋精灵\u201d的蜜月期日常"},{"imageListThumb":["http://cn.ttfly.com/file/upload/201804/12/0843424911696.jpg"],"layoutType":"1","newsId":"a2cd75af2a584e368dfd20edd3c2d91a","origin":"","pageviews":10,"publishTime":"2018-04-12","title":"涉嫌违规从事载人热气球被查处"},{"imageListThumb":["http://www.ga.cn/uploads/allimg/180410/1_180410125237_1-lp.jpg"],"layoutType":"1","newsId":"8b1c0123258449c2ae7b4b91a54b5eb8","origin":"","pageviews":4,"publishTime":"2018-04-10","title":"国家体育总局---加快航空运动产业发展 特制定本规划"}]
     */

    private String cursor;
    private List<NewListBean> newList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<NewListBean> getNewList() {
        return newList;
    }

    public void setNewList(List<NewListBean> newList) {
        this.newList = newList;
    }

    public static class NewListBean {
        /**
         * imageListThumb : ["http://cn.ttfly.com/file/upload/201805/05/0957245212249.jpg"]
         * layoutType : 1
         * newsId : 82a8dedf1b8042a5b8a7996903084cfe
         * origin :
         * pageviews : 77
         * publishTime : 2018-05-05
         * title : 跳伞中低空跳伞死伤超记录
         */

        private String layoutType;
        private String newsId;
        private String origin;
        private int pageviews;
        private String publishTime;
        private String title;
        private List<String> imageListThumb;

        public String getLayoutType() {
            return layoutType;
        }

        public void setLayoutType(String layoutType) {
            this.layoutType = layoutType;
        }

        public String getNewsId() {
            return newsId;
        }

        public void setNewsId(String newsId) {
            this.newsId = newsId;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public int getPageviews() {
            return pageviews;
        }

        public void setPageviews(int pageviews) {
            this.pageviews = pageviews;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImageListThumb() {
            return imageListThumb;
        }

        public void setImageListThumb(List<String> imageListThumb) {
            this.imageListThumb = imageListThumb;
        }
    }
}
