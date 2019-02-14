package com.example.mvp.myapplication.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * @packge: com.jiyun.com.myapplication.utis
 * @filename:jsonUtis
 * @date :${DATA} 21:04
 */
public class jsonUtils {
      public  static  <T> String  getStudent(T t){
          GsonBuilder builder = new GsonBuilder();
          Gson gson = builder.create();
          return gson.toJson(t);
       }
}
