package com.example.mvp.myapplication.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;

import com.example.mvp.myapplication.ui.login.activity.PersonalDataActivity;

import java.io.File;

/**
 * @packge: com.example.mvp.myapplication.utils
 * @filename:CameraUtils
 * @date :${DATA} 19:31
 */
public class CameraUtils {
    public  static  void  initCameraUtils(Activity activity,Uri mUri,int requesCode){
        // 步骤一：创建存储照片的文件
        String path = activity.getFilesDir() + File.separator + "images" + File.separator;
        File file = new File(path, "test.jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //步骤二：Android 7.0及以上获取文件 Uri
            mUri = FileProvider.getUriForFile(activity, "com.example.admin.custmerviewapplication", file);
        } else {
            //步骤三：获取文件Uri
            mUri = Uri.fromFile(file);
        }
        //步骤四：调取系统拍照
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, mUri);
        activity.startActivityForResult(intent,1);
    }
}
