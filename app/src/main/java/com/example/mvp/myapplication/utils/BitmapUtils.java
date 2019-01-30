package com.example.mvp.myapplication.utils;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @packge: com.example.mvp.myapplication.utils
 * @filename:BitmapUtils
 * @date :${DATA} 22:00
 */
public class BitmapUtils {
    public static File getFile(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 50, baos);
        File file = new File(Environment.getExternalStorageDirectory() +("/"+System.currentTimeMillis()+ ".png"));
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            InputStream is = new ByteArrayInputStream(baos.toByteArray());
            int x = 0;
            byte[] b = new byte[1024 * 100];
            while ((x = is.read(b)) != -1) {
                fos.write(b, 0, x);
            }
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

}
