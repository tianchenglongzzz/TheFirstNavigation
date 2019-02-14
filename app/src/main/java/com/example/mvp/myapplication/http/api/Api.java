package com.example.mvp.myapplication.http.api;

import com.example.mvp.myapplication.http.bean.callback.AboutUsBean;
import com.example.mvp.myapplication.http.bean.callback.FavouriteNewsBean;
import com.example.mvp.myapplication.http.bean.callback.FavouriteTopicBean;
import com.example.mvp.myapplication.http.bean.callback.FeedBackBean;
import com.example.mvp.myapplication.http.bean.callback.HomeListBean;
import com.example.mvp.myapplication.http.bean.callback.HomePagelistBean;
import com.example.mvp.myapplication.http.bean.callback.HotBean;
import com.example.mvp.myapplication.http.bean.callback.InfiBean;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.InsertBean;
import com.example.mvp.myapplication.http.bean.callback.ListCommentBean;
import com.example.mvp.myapplication.http.bean.callback.ListFeedbackBean;
import com.example.mvp.myapplication.http.bean.callback.ListFollowBean;
import com.example.mvp.myapplication.http.bean.callback.ListProfessionBean;
import com.example.mvp.myapplication.http.bean.callback.LoginBean;
import com.example.mvp.myapplication.http.bean.callback.MoreFollowBean;
import com.example.mvp.myapplication.http.bean.callback.MyListTopicBean;
import com.example.mvp.myapplication.http.bean.callback.QuestionBean;
import com.example.mvp.myapplication.http.bean.callback.RelevantBean;
import com.example.mvp.myapplication.http.bean.callback.TagsHotBean;
import com.example.mvp.myapplication.http.bean.callback.TagsSearchDataBean;
import com.example.mvp.myapplication.http.bean.callback.TopicBean;
import com.example.mvp.myapplication.http.bean.callback.TopicListBean;
import com.example.mvp.myapplication.http.bean.callback.UpListNewsBean;
import com.example.mvp.myapplication.http.bean.callback.UploadHeadImageBean;
import com.example.mvp.myapplication.http.bean.callback.UserCenterBean;
import com.example.mvp.myapplication.http.bean.callback.UserInfoEditBean;
import com.example.mvp.myapplication.http.bean.callback.UserListCommentBean;
import com.example.mvp.myapplication.http.bean.callback.UserhomePageBean;
import com.example.mvp.myapplication.http.bean.callback.VCBean;

import com.example.mvp.myapplication.http.bean.callback.listNewsBean;
import com.example.mvp.myapplication.http.bean.callback.ListNotifyBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * @packge: com.example.mvp.myapplication.http.api
 * @filename:Api
 * @date :${DATA} 11:09
 */
public interface Api {


     @POST("users/phoneLogin")
    @Headers("Content-Type:application/json")
     @FormUrlEncoded
    Observable<InfoBean<LoginBean>>getLoginData(@Body RequestBody body);

 //获取职业列表
  @POST("news/listNewsChannel")
  @Headers("Content-Type:application/json")
    Observable<InfoBean<listNewsBean>>getNewBean(@Body RequestBody requestBody);
   @GET("index.php/verify")
    Observable<VCBean>getVerify();

   @POST("users/uploadHeadImage")
    Observable<InfoBean<UploadHeadImageBean>> getUploadHeadImageBean(@Body RequestBody requestBody);
    @POST("news/upListNews")
    @Headers("Content-Type:application/json")
    Observable<InfoBean<UpListNewsBean>>getUpListNews(@Body RequestBody requestBody);
    @POST("news/downListNews")
    @Headers("Content-Type:application/json")
    Observable<InfoBean<UpListNewsBean>>getDownListNews(@Body RequestBody requestBody);
     @POST("news/info")
     @Headers("Content-Type:application/x-www-form-urlencoded")
     @FormUrlEncoded
    Observable<InfoBean<InfiBean>>getInfoBean(@Field("userId")String userId, @Field("newsId") String newsId);
    @POST("news/relevant")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @FormUrlEncoded
    Observable<InfoBean<List<RelevantBean>>>getRelevantListBean(@Field("newsId") String newsId);
    @POST("search/hot")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<InfoBean<HotBean>>htoBeabn(@Body RequestBody requestBody);
    @POST("news/search")
    @Headers("Content-Type:application/json")
    Observable<InfoBean<UpListNewsBean>>searchUpListNewsBean(@Body RequestBody requestBody);
    @POST("topic/refreshTopic")
    @Headers("Content-Type:application/json")
    Observable<InfoBean<TopicBean>>getRefreshTopicBean(@Body RequestBody requestBody);
 @POST("topic/loadTopic")
    @Headers("Content-Type:application/json")
    Observable<InfoBean<TopicBean>>getLoadTopicBean(@Body RequestBody requestBody);
    @POST("tags/hot")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<InfoBean<List<TagsHotBean>>>getTagsHotData(@Body RequestBody requestBody);


    @POST("topic/insertTopic")
    Observable<InsertBean>getInsertTopic(@Body RequestBody requestBody);

    @POST("topic/insertTopic")
    Observable<InsertBean>getInsertTopicTow(@Body RequestBody requestBody);






    @POST("tags/search")
    @Headers("Content-Type:application/json")
    Observable<InfoBean<TagsSearchDataBean>>getTagsSearchData(@Body RequestBody requestBody);
    @POST("topic/info")
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<InfoBean<TopicListBean>>getTopicInfoData(@Field("topicId") String topicId, @Field("userId") String userId);
    @POST("comment/listComment")
    @Headers("Content-Type:application/json")
    Observable<InfoBean<ListCommentBean>>getlistCommentData(@Body RequestBody requestBody);
    @POST("users/like")
    @Headers("Content-Type:application/json")
    Observable<InfoBean>setLike(@Body RequestBody requestBody);
    @POST("users/comment")
    @Headers("Content-Type:application/json")
    Observable<InfoBean>putComment(@Body RequestBody requestBody);
    //个人信息主页
    @POST("users/center")
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<InfoBean<UserCenterBean>>getUserCenterBean(@Field("userId") String userid);
    @POST("users/follow")
    @Headers("Content-Type:application/json")
    Observable<InfoBean>followUser(@Body RequestBody body);
    @POST("users/homePage/info")
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<InfoBean<UserhomePageBean>>getUserhomePageData(@Field("userId") String userid,@Field("lookUserId") String lookId);
    @POST("users/homePage/list")
    @Headers("Content-Type:application/json")
    Observable<InfoBean<HomeListBean>>getHomePagelistBean(@Body RequestBody requestBody);
    @POST("users/info")
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<InfoBean<UserInfoEditBean>>getUserInfoEditBean(@Field("userId")String userId);

    @POST("users/listProfession")
    @Headers("Content-Type:application/json")
    Observable<InfoBean<ListProfessionBean>>getProfessionBean(@Body RequestBody requestBody);
    //修改个人信息
    @POST("users/updateInfo")
    @Headers("Content-Type:application/json")
    Observable<InfoBean>updateUserIfo(@Body RequestBody requestBody);

    //1.26收藏-新闻列表
    @POST("users/favourite/news")
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<InfoBean<FavouriteNewsBean>>getFavouriteNewsData(@Field("userId")String userId,@Field("cursor")String cursor);
    //收藏-删除我的收藏
    @POST("users/batchDelFavourite")
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<InfoBean>batchDelFavourite(@Field("userId") String userId,@Field("favouritIdList") String favouritIdList);
  //1.27收藏-话题列表
    @POST("users/favourite/topic")
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<InfoBean<FavouriteTopicBean>>getFavouriteTopicData(@Field("userId")String userId, @Field("cursor")String cursor);
  //关注-我的关注列表
    @POST("users/listFollow")
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<InfoBean<ListFollowBean>>getlistFollowData(@Field("userId")String userId);
   //关注-更多关注-关注列表
    @POST("users/moreFollow")
    @Headers("Content-Type:application/json")
    Observable<InfoBean<MoreFollowBean>>getMoreFollowData(@Body RequestBody requestBody);

    //消息通知-消息列表
    @POST("users/listNotify")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @FormUrlEncoded
    Observable<InfoBean<ArrayList<ListNotifyBean>>>getlistNotifyBean(@Field("userId") String listNotify);

    //我的评论
    @POST("users/listComment")
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<InfoBean<UserListCommentBean>>getUserListCommentBean(@Field("userId") String userid);
    //我的评论
    @POST("users/deleteAllNotify")
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<InfoBean>deleteAllNotify(@Field("userId") String userid);
    //用户主页-话题列表
    @POST("users/listTopic")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @FormUrlEncoded
    Observable<InfoBean<MyListTopicBean>>getMylistTopicData(@Field("userId")String userId,@Field("cursor")String cursor);
   //常见问题
    @POST("users/question")
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<InfoBean<List<QuestionBean>>>getQuestionBean(@Field("userId") String userId);

    //用户反馈-反馈列表

    @POST("users/listFeedback")
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<InfoBean<ListFeedbackBean>>getlistFeedData(@Field("userId")String userId);


    //用户反馈-提交反馈
    @POST("users/feedback")
    Observable<InfoBean<FeedBackBean>>setFeedBackBean(@Body RequestBody requestBody);


    //关于我们
    @POST("users/aboutUs")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<InfoBean<AboutUsBean>>getAboutUsBean(@Body RequestBody requestBody);


    //收藏-话题-新闻
    @POST("users/favourite")
    @Headers("Content-Type:application/json")
    Observable<InfoBean>favourite(@Body RequestBody requestBody);



}

