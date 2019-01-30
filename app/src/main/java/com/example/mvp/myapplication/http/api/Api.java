package com.example.mvp.myapplication.http.api;

import com.example.mvp.myapplication.http.bean.callback.DownListNewsBean;
import com.example.mvp.myapplication.http.bean.callback.HotBean;
import com.example.mvp.myapplication.http.bean.callback.InfiBean;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.LoginBean;
import com.example.mvp.myapplication.http.bean.callback.RelevantBean;
import com.example.mvp.myapplication.http.bean.callback.TagsHotBean;
import com.example.mvp.myapplication.http.bean.callback.TopicBean;
import com.example.mvp.myapplication.http.bean.callback.UpListNewsBean;
import com.example.mvp.myapplication.http.bean.callback.UploadHeadImageBean;
import com.example.mvp.myapplication.http.bean.callback.VCBean;
import com.example.mvp.myapplication.http.bean.callback.listNewsBean;

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
    Observable<InfoBean<InfiBean>>getInfoBean(@Field("userId")String userId,@Field("newsId") String newsId);
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

}
