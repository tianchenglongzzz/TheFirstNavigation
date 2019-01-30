package com.example.mvp.myapplication.utils;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 项目名：MyViewDemo2
 * 包名：  com.jiyun.firstnavigation.utils
 * 文件名：HttpUtils
 * 创建者：liangxq
 * 创建时间：2019/1/18  9:51
 * 描述：TODO
 */
public class HttpUtils {


    public static RequestBody getBody(String json){
        RequestBody requestBody=null;
        if(json!=null){
             requestBody=RequestBody.create(MediaType.parse(""),json);
        }
        return requestBody;
    }
}
