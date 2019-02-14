package com.example.mvp.myapplication.ui.topic.activity;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.IinsertApdater;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.base.activity.BottomActivity;
import com.example.mvp.myapplication.base.persenter.BasePresenter;
import com.example.mvp.myapplication.contact.InsertTopicInterface;
import com.example.mvp.myapplication.http.bean.callback.InsertBean;
import com.example.mvp.myapplication.http.bean.callback.VCBean;
import com.example.mvp.myapplication.module.IinsertTopicModel;
import com.example.mvp.myapplication.presenter.InfoPresenter;
import com.example.mvp.myapplication.presenter.InsertTopicPresenter;
import com.example.mvp.myapplication.utils.BitmapUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;

public class  InsertTopicActivity extends BaseActivity<InsertTopicInterface.IinsertTopicV,InsertTopicPresenter<InsertTopicInterface.IinsertTopicV>> implements InsertTopicInterface.IinsertTopicV {

    @BindView(R.id.url_ed)
    EditText mEditUrl;


    @BindView(R.id.toobar_topicinsert)
    Toolbar mToobarTopicinsert;
    @BindView(R.id.tv_tally)
    TextView mTvTally;
    @BindView(R.id.rl_inset_tally)
    RelativeLayout mRlInsetTally;
    @BindView(R.id.ed_topic_upload)
    EditText mEdTopicUpload;
    @BindView(R.id.img_addimg)
    ImageView mImgAddimg;
    @BindView(R.id.ll_topic_add_img)
    LinearLayout mLlTopicAddImg;
    @BindView(R.id.rv_addimg)
    RecyclerView mRvAddimg;
    @BindView(R.id.tv_insert)
    TextView insert;
    @BindView(R.id.topic_inset_addimg_fl)
    FrameLayout mTopicInsetAddimgFrameLayout;
    @BindView(R.id.topic_inset_addurl_fl)
    FrameLayout mTopicInsetAddUrlFrameLayout;
    @BindView(R.id.img_link)
    ImageView mAddUrlImage;
    private String mTags="无人机";
    private ArrayList<Uri> mUris;
    private ArrayList<File> mFiles;
    private IinsertApdater mIinsertApdater;
    private PopupWindow mIfAddImgPopWindow;
    private String mLink;


    @OnClick({R.id.toobar_topicinsert, R.id.tv_tally, R.id.rl_inset_tally, R.id.ed_topic_upload, R.id.img_addimg, R.id.ll_topic_add_img, R.id.rv_addimg,R.id.tv_insert,R.id.img_addimage,R.id.img_link,R.id.paste_tv,R.id.clear})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.toobar_topicinsert:
                break;
            case R.id.tv_tally:
                break;
            case R.id.rl_inset_tally:
                startActivity(new Intent(this,SelectTagActivity.class));
                break;
            case R.id.ed_topic_upload:
                break;
            case R.id.img_addimg:
                mImgAddimg.setAlpha(200);
                mAddUrlImage.setAlpha(100);
                mTopicInsetAddUrlFrameLayout.setVisibility(View.GONE);
                mTopicInsetAddimgFrameLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.ll_topic_add_img:
                break;
            case R.id.rv_addimg:
                break;
            case  R.id.tv_insert:
                initInsert();
                break;
            case R.id.img_addimage:
                initPhoto();
                break;
            case R.id.img_link:
                mImgAddimg.setAlpha(100);
                mAddUrlImage.setAlpha(200);
                mTopicInsetAddUrlFrameLayout.setVisibility(View.VISIBLE);
                mTopicInsetAddimgFrameLayout.setVisibility(View.GONE);
                break;
            case R.id.paste_tv:
         ClipboardManager clipboardManager= (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
         if (!(clipboardManager.hasPrimaryClip())){}else if (!(clipboardManager.getPrimaryClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN))){}else {
             ClipData.Item itemAt = clipboardManager.getPrimaryClip().getItemAt(0);
             mLink = itemAt.getText().toString();
             mEditUrl.setText(mLink);
         }
         break;
            case  R.id.clear:
                mLink="";
               mEditUrl.setText(mLink);
                break;
        }
    }

    private void initInsert() {
    //    MultipartBody.Builder builder = new MultipartBody.Builder();
      /*  builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("userId","c383f4c9026d471da0184ad5b24c0365");
        builder.addFormDataPart("title",mEdTopicUpload.getText().toString());
        mTags="";
        builder.addFormDataPart("tagList",mTags);
        builder.addFormDataPart("shareLink","http://www.baidu.com/");*/
//        MultipartBody build = builder.build();
        Log.d("TAG",mEdTopicUpload.getText().toString());
        if (!TextUtils.isEmpty(mEdTopicUpload.getText().toString())) {
           if (mFiles.size()==0){
                getPoPIfImgWindow();
            } else {
                persemter.getIinsertTopicData("", "c383f4c9026d471da0184ad5b24c0365", mEdTopicUpload.getText().toString(), mTags, "https://www.baidu.com/", mFiles);
            }
        }else {
            showTost("发表内容不能为空");
        }
    }

    private void getPoPIfImgWindow() {
         showTost("=========================");

        View view = LayoutInflater.from(this).inflate(R.layout.popwindow_insert, null);
        TextView tvYes=view.findViewById(R.id.insert_yes);
        TextView tvNo=view.findViewById(R.id.insert_no);
        mIfAddImgPopWindow = new PopupWindow(this);
        mIfAddImgPopWindow.setContentView(view);
        mIfAddImgPopWindow.setBackgroundDrawable(new ColorDrawable());
        mIfAddImgPopWindow.setWidth(getWindow().getAttributes().height);
        mIfAddImgPopWindow.setHeight(getWindow().getAttributes().width);
        mIfAddImgPopWindow.showAtLocation(mToobarTopicinsert,Gravity.NO_GRAVITY,0,0);
        tvYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIfAddImgPopWindow.dismiss();
                persemter.getIinsertTopicData("", "c383f4c9026d471da0184ad5b24c0365", mEdTopicUpload.getText().toString(), mTags, "https://www.baidu.com/", null);
            }
        });
        tvNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIfAddImgPopWindow.dismiss();
            }
        });
    }


    @Override
    public int createLayout() {
        return R.layout.activity_insert_topic;
    }

    @Override
    public void origination() {
        mImgAddimg.setAlpha(100);
        EventBus.getDefault().register(this);
       setToobar();
        mUris = new ArrayList<>();
        mFiles = new ArrayList<>();
        mIinsertApdater = new IinsertApdater(mUris,this);
        mRvAddimg.setLayoutManager(new GridLayoutManager(this,3));
        mRvAddimg.setAdapter(mIinsertApdater);

    }

    private void setToobar() {
       mToobarTopicinsert.setNavigationIcon(R.mipmap.smallfanhui);
       mToobarTopicinsert.setTitle("");
       setSupportActionBar(mToobarTopicinsert);
       mToobarTopicinsert.setNavigationOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                   finish();
           }
       });
    }
   @Subscribe
   public  void   getEvenbus(String tags){
        showTost(tags);
       mTags = tags;
   }

    @Override
    public InsertTopicPresenter<InsertTopicInterface.IinsertTopicV> createPresenter() {
        return new InsertTopicPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      EventBus.getDefault().unregister(this );
    }

    @Override
    public void showInsertTopicData(InsertBean vcBean) {
              showTost(vcBean.getMessage());
    }
    private void initPhoto() {
        Log.e("TAG","============");
        Intent albumIntent = new Intent(Intent.ACTION_PICK);
        albumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(albumIntent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==2){
            Uri data1 = data.getData();
            mUris.add(data1);
            mIinsertApdater.notifyDataSetChanged();
            try {
                mFiles.add(BitmapUtils.getFile(BitmapUtils.getBitmapFormUri(this,data1)));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
