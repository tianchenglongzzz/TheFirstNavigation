package com.example.mvp.myapplication.ui.login.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.contact.UploadingInterface;
import com.example.mvp.myapplication.http.bean.callback.UploadHeadImageBean;
import com.example.mvp.myapplication.presenter.UploadHeadImagePresenter;
import com.example.mvp.myapplication.ui.main.activitys.MainActivity;
import com.example.mvp.myapplication.utils.BitmapUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonalDataActivity  extends BaseActivity<UploadingInterface.IUploadHeadImageV,UploadHeadImagePresenter<UploadingInterface.IUploadHeadImageV>> implements UploadingInterface.IUploadHeadImageV {
    private static final int REQUEST_PERMISSION_CODE = 101;
  @BindView(R.id.tv_tiao)
    TextView tvtiao;
    @BindView(R.id.img_icon)
    SimpleDraweeView icon;
    @BindView(R.id.login_pd_ESC)
    ImageView mLoginPdESC;
    @BindView(R.id.login_pd_dafanhui)
    ImageView mLoginPdDafanhui;
    @BindView(R.id.btn_upload_done)
    Button   uplond_dne;
    private  PoPlisear mPoPlisear=new PoPlisear();
     private PopupWindow mWindow;
    private Uri mUri;
    private Bitmap mBm;
    private File mFile;
    private PopupWindow mWindowskip ;


    @Override
    public int createLayout() {
        return R.layout.activity_personal_data;
    }

    @Override
    public void origination() {
        //把默认图片给定到Bitmap
        mBm=BitmapFactory.decodeResource(this.getResources(),R.mipmap.bighead);
     mFile=  BitmapUtils.getFile(mBm);
    }

    @OnClick({R.id.login_pd_ESC, R.id.login_pd_dafanhui, R.id.img_icon,R.id.btn_upload_done,R.id.tv_tiao})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login_pd_ESC:
                finish();
                break;
            case R.id.login_pd_dafanhui:
                startActivity(new Intent(this,LoginActivity.class));
                break;
            case R.id.img_icon:
                getImg();

                break;
            case  R.id.btn_upload_done:
                  upload();
                break;
            case  R.id.tv_tiao:
                 poptiao();
                break;

        }
    }

    private void poptiao() {
        //跳过
        View view = LayoutInflater.from(this).inflate(R.layout.popwindow_tiao, null);
        mWindowskip = new PopupWindow(this);
        mWindowskip.setContentView(view);
        mWindowskip.setHeight(this.getWindowManager().getDefaultDisplay().getHeight());
        mWindowskip.setWidth(this.getWindowManager().getDefaultDisplay().getWidth());
        mWindowskip.setBackgroundDrawable(new ColorDrawable());
        mWindowskip.showAtLocation(mLoginPdESC,Gravity.NO_GRAVITY,0,0);
       TextView tvTiaoguo=  view.findViewById(R.id.tiao_yes);
       TextView quxiugai=view.findViewById(R.id.tiao_no);
       tvTiaoguo.setOnClickListener(mPoPlisear);
       quxiugai.setOnClickListener(mPoPlisear);
    }

    private void upload() {

        Log.d("tianchenglonh", "upload: "+mFile);
        persemter.getUploadHeadImageBean(mFile,"c383f4c9026d471da0184ad5b24c0365");
    }


    private void getImg() {
        View view = LayoutInflater.from(this).inflate(R.layout.get_img_window, null);
        mWindow = new PopupWindow(this);
        mWindow.setContentView(view);
        mWindow.setBackgroundDrawable(new ColorDrawable());//设置背景透明以便点击外部消失
        mWindow.setOutsideTouchable(true);//点击外部收起
        mWindow.setFocusable(true);//设置焦点生效
        mWindow.setHeight(this.getWindowManager().getDefaultDisplay().getHeight());
        mWindow.setWidth(this.getWindowManager().getDefaultDisplay().getWidth());
        mWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        //布局对象
        LinearLayout layout= view.findViewById(R.id.pop_layout);
        //打开相机
        CardView wCamera=view.findViewById(R.id.window_Camera);
        wCamera.setOnClickListener(mPoPlisear);
        layout.setOnClickListener(mPoPlisear);
        //打开相册
    CardView window_photo=view.findViewById(R.id.window_photo);
         window_photo.setOnClickListener(mPoPlisear);
    }




    @Override
    public void showUploadHeadImageBean(UploadHeadImageBean uploadHeadImageBean) {
        showTost("打印成功");
        String headImagePath = uploadHeadImageBean.getHeadImagePath();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("icon",headImagePath);
        startActivity(intent);
    }





    @Override
    public UploadHeadImagePresenter<UploadingInterface.IUploadHeadImageV> createPresenter() {
        return new UploadHeadImagePresenter<>();
    }

    class PoPlisear implements View.OnClickListener {


         @RequiresApi(api = Build.VERSION_CODES.M)
         @Override
         public void onClick(View v) {
              switch (v.getId()){
                  case R.id.pop_layout:
                   mWindow.dismiss();
                     break;
                  case  R.id.window_Camera:
                      initCapture();
                     /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //调用系统相机
                      String fileName = DateFormat.format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
                     File picture = new File(Environment.getExternalStorageDirectory()
                              .getAbsolutePath()+"/service",fileName);
                      Uri imageUri = Uri.fromFile(picture);
                      intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);          //直接使用，没有缩小
                      startActivityForResult(intent, 100);// 100 是请求码*/
                      break;
                  case R.id.window_photo:
                       initPhoto();
                      break;
                  case R.id.tiao_yes:
                      Intent intent;
                      intent = new Intent(PersonalDataActivity.this, MainActivity.class);
                      intent.putExtra("icon","mmmmmmm");
                      startActivity(intent);
                       break;
                  case R.id.tiao_no:
                      mWindowskip.dismiss();
                      break;



              }
         }
     }

    private void initPhoto() {

        mWindow.dismiss();
        Intent albumIntent = new Intent(Intent.ACTION_PICK);
        albumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(albumIntent, 2);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initCapture() {
        mWindow.dismiss();
              takePhoto();

    }



    //打开照相机
    private void takePhoto() {
        // 步骤一：创建存储照片的文件
        String path = getFilesDir() + File.separator + "images" + File.separator;
        File file = new File(path, "test.jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //步骤二：Android 7.0及以上获取文件 Uri
            mUri = FileProvider.getUriForFile(PersonalDataActivity.this, "com.example.admin.custmerviewapplication", file);
        } else {
            //步骤三：获取文件Uri
            mUri = Uri.fromFile(file);
        }
        //步骤四：调取系统拍照
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, mUri);
        startActivityForResult(intent,1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1) {//获取系统照片上传

            mBm = null;
            try {
                icon.setImageURI(mUri);
                mBm = getBitmapFormUri(mUri);
                mFile = BitmapUtils.getFile(mBm);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if ( requestCode==2){
            Uri uri = data.getData();
            try {
                mBm = getBitmapFormUri(uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            mFile = BitmapUtils.getFile(mBm);
            icon.setImageURI(uri);

        }
    }

    public Bitmap getBitmapFormUri(Uri uri) throws FileNotFoundException, IOException {
        InputStream input = getContentResolver().openInputStream(uri);

        //这一段代码是不加载文件到内存中也得到bitmap的真是宽高，主要是设置inJustDecodeBounds为true
        BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
        onlyBoundsOptions.inJustDecodeBounds = true;//不加载到内存
        onlyBoundsOptions.inDither = true;//optional
        onlyBoundsOptions.inPreferredConfig = Bitmap.Config.RGB_565;//optional
        BitmapFactory.decodeStream(input, null, onlyBoundsOptions);
        input.close();
        int originalWidth = onlyBoundsOptions.outWidth;
        int originalHeight = onlyBoundsOptions.outHeight;
        if ((originalWidth == -1) || (originalHeight == -1))
            return null;

        //图片分辨率以480x800为标准
        float hh = 800f;//这里设置高度为800f
        float ww = 480f;//这里设置宽度为480f
        //缩放比，由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;//be=1表示不缩放
        if (originalWidth > originalHeight && originalWidth > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (int) (originalWidth / ww);
        } else if (originalWidth < originalHeight && originalHeight > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (int) (originalHeight / hh);
        }
        if (be <= 0)
            be = 1;
        //比例压缩
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = be;//设置缩放比例
        bitmapOptions.inDither = true;
        bitmapOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        input = getContentResolver().openInputStream(uri);
        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
        input.close();
        return compressImage(bitmap);//再进行质量压缩
    }
    public Bitmap compressImage(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 100;
        while (baos.toByteArray().length / 1024 > 100) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset();//重置baos即清空baos
            //第一个参数 ：图片格式 ，第二个参数： 图片质量，100为最高，0为最差  ，第三个参数：保存压缩后的数据的流
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options，把压缩后的数据存放到baos中
            options -= 10;//每次都减少10
            if (options<=0)
                break;
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片

        return bitmap;
    }




    }

/*//检查权限
    private boolean checkPermission() {
        //是否有权限
        boolean haveCameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;

        boolean haveWritePermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

        return haveCameraPermission && haveWritePermission;

    }

    // 请求所需权限
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void requestPermissions() {
        requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION_CODE);
    }

    // 请求权限后会在这里回调
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_PERMISSION_CODE:

                boolean allowAllPermission = false;

                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {//被拒绝授权
                        allowAllPermission = false;
                        break;
                    }
                    allowAllPermission = true;
                }

                if (allowAllPermission) {
                    takePhotoOrPickPhoto();//开始拍照或从相册选取照片
                } else {
                    Toast.makeText(this, "该功能需要授权方可使用", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }*/


