package com.example.mvp.myapplication.http.bean.callback;

import java.util.List;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:FavouriteNewsBean
 * @date :${DATA} 20:48
 */
public class FavouriteNewsBean {

    /**
     * cursor : 0
     * favouritNewsList : [{"favouritId":"64bc42b6f7574daea9b3d78300bc3882","newsId":"01a2dec8191b4ddd8d91e419a36a9002","title":"中航货运成功首航，助力国内航空物流建设"}]
     */

    private String cursor;
    private List<FavouritNewsListBean> favouritNewsList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<FavouritNewsListBean> getFavouritNewsList() {
        return favouritNewsList;
    }

    public void setFavouritNewsList(List<FavouritNewsListBean> favouritNewsList) {
        this.favouritNewsList = favouritNewsList;
    }

    public static class FavouritNewsListBean {
        /**
         * favouritId : 64bc42b6f7574daea9b3d78300bc3882
         * newsId : 01a2dec8191b4ddd8d91e419a36a9002
         * title : 中航货运成功首航，助力国内航空物流建设
         */

        private String favouritId;
        private String newsId;
        private String title;

        public String getFavouritId() {
            return favouritId;
        }

        public void setFavouritId(String favouritId) {
            this.favouritId = favouritId;
        }

        public String getNewsId() {
            return newsId;
        }

        public void setNewsId(String newsId) {
            this.newsId = newsId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
