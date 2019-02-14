package com.example.mvp.myapplication.ui.my.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.OnDismissListener;
import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.app.Global;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.base.persenter.IBasePresenter;
import com.example.mvp.myapplication.contact.UserInfoInterface;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListProfessionBean;
import com.example.mvp.myapplication.http.bean.callback.UploadHeadImageBean;
import com.example.mvp.myapplication.http.bean.callback.UserInfoEditBean;
import com.example.mvp.myapplication.jsonbean.JsonUpdateUserInfo;
import com.example.mvp.myapplication.presenter.UserInfoEditPresenter;
import com.example.mvp.myapplication.utils.BitmapUtils;
import com.example.mvp.myapplication.utils.jsonUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.OnClick;

public class UpdateinfoActivity extends BaseActivity<UserInfoInterface.IUserInfoV,UserInfoEditPresenter<UserInfoInterface.IUserInfoV>> implements UserInfoInterface.IUserInfoV{



    @BindView(R.id.updatainfo_toobar)
    Toolbar mUpdatainfoToobar;
    @BindView(R.id.updateinfo_icon_sdv)
    SimpleDraweeView mUpdateinfoIconSdv;
    @BindView(R.id.updateinfo_icon_rl)
    RelativeLayout mUpdateinfoIconRl;
    @BindView(R.id.updateinfo_nickname_tv)
    TextView mUpdateinfoNicknameTv;
    @BindView(R.id.updateinfo_nickname_rl)
    RelativeLayout mUpdateinfoNicknameRl;
    @BindView(R.id.updateinfo_sex_nan)
    TextView mUpdateinfoSexNan;
    @BindView(R.id.updateinfo_sex_rl)
    RelativeLayout mUpdateinfoSexRl;
    @BindView(R.id.updateinfo_birthday_tv)
    TextView mUpdateinfoBirthdayTv;
    @BindView(R.id.updateinfo_birthday_rl)
    RelativeLayout mUpdateinfoBirthdayRl;
    @BindView(R.id.updateinfo_professionId_tv)
    TextView mUpdateinfoProfessionId;
    @BindView(R.id.updateinfo_professionId_rl)
    RelativeLayout mUpdateinfoProfessionIdRl;
    @BindView(R.id.updateinfo_personalProfile_rl)
    RelativeLayout mUpdateinfoPersonalProfileRl;

    private UserInfoEditBean mUserInfoEditBean;
    private String mFormat;
    private List<ListProfessionBean> mListProfessionBeans;

    //所有要修改的值
    //职业id
    private String mProfessionId;
    //性别mid
     int  sexId;
     //姓名
    String mNickname="";
    //个人简介
    private String mProfile;
    //返回修改条件
    boolean alter;
    //图片
    boolean alterImg;
    //返回图片用于上传图片的file
    private File mFile;
    //图片和数据都上传成功的条件
   private boolean alterWan;


    @Override
    public int createLayout() {
        return R.layout.activity_updateinfo;
    }

    @Override
    public void origination() {
        setToobar();
       persemter.getUserInfoBean("c383f4c9026d471da0184ad5b24c0365");



    }

    private void setToobar() {
            mUpdatainfoToobar.setTitle("");
            mUpdatainfoToobar.setNavigationIcon(R.mipmap.smallfanhui);
            setSupportActionBar(mUpdatainfoToobar);
            mUpdatainfoToobar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (alter||alterImg){
                        initTDialog();

                    }else {
                        finish();
                    }
                }
            });
    }

    private void initTDialog() {
        TDialog tDialog = new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.dialog_up)
                .setScreenWidthAspect(UpdateinfoActivity.this, 0.6f)
                .setScreenHeightAspect(UpdateinfoActivity.this, 0.2f)
                .addOnClickListener(R.id.yes_tv, R.id.no_tv)
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.yes_tv:
                                updateInfoUser();
                                break;
                            case R.id.no_tv:
                                tDialog.dismiss();
                                finish();
                                break;
                        }

                    }
                }).create();
        tDialog.show();
    }

    private void updateInfoUser() {
        if (alter) {
            persemter.updateUserInfo(jsonUtils.getStudent(new JsonUpdateUserInfo("c383f4c9026d471da0184ad5b24c0365", mFormat, mNickname, mProfile, mProfessionId + "", sexId + "")));
        }
        if (alterImg) {
            persemter.updateIcon(mFile, "c383f4c9026d471da0184ad5b24c0365");
        }


    }

    @Override
    public UserInfoEditPresenter createPresenter() {
        return new UserInfoEditPresenter();
    }


    @OnClick({R.id.updatainfo_toobar, R.id.updateinfo_icon_sdv, R.id.updateinfo_icon_rl, R.id.updateinfo_nickname_tv, R.id.updateinfo_nickname_rl, R.id.updateinfo_sex_nan, R.id.updateinfo_sex_rl, R.id.updateinfo_birthday_tv, R.id.updateinfo_birthday_rl, R.id.updateinfo_professionId_tv, R.id.updateinfo_professionId_rl, R.id.updateinfo_personalProfile_rl})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.updatainfo_toobar:
                break;
            case R.id.updateinfo_icon_sdv:
                break;
            case R.id.updateinfo_icon_rl:
                Matisse.from(this)
                        .choose( MimeType.allOf()) // 选择 mime 的类型
                        .countable(true)
                        .maxSelectable(1) // 图片选择的最多数量
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f) // 缩略图的比例
                        .imageEngine(new GlideEngine()) // 使用的图片加载引擎
                        .forResult(Global.REQUEST_CODE_CHOOSE); // 设置作为标记的请求码
                break;
            case R.id.updateinfo_nickname_tv:
                break;
            case R.id.updateinfo_nickname_rl:
                setEditNickname();
                break;
            case R.id.updateinfo_sex_nan:
                break;
            case R.id.updateinfo_sex_rl:
                setOptionsPicker();
                break;
            case R.id.updateinfo_birthday_tv:
                break;
            case R.id.updateinfo_birthday_rl:
                showTimPicker();
                break;
            case R.id.updateinfo_professionId_tv:

                break;
            case R.id.updateinfo_professionId_rl:
                startProfessionActivity();
                break;
            case R.id.updateinfo_personalProfile_rl:
                startActivityForResult(new Intent(this,PersonalProfileActivity.class),20);
                break;
        }
    }

    private void setEditNickname() {
        final EditText inputServer = new EditText(this);
        inputServer.setMaxLines(1);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("输入要更改的姓名").setIcon(android.R.drawable.ic_dialog_info).setView(inputServer)
                .setNegativeButton("取消", null);
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                        mNickname=inputServer.getText().toString();
                        mUpdateinfoNicknameTv.setText(mNickname);
                        alter=true;
            }
        });
        builder.show();
    }

    private void startProfessionActivity() {
        Intent intent = new Intent(this,ProfessionActivity.class);
         intent.putExtra("id",mProfessionId);
        startActivityForResult(intent,10);

    }

    private void setOptionsPicker() {
        final ArrayList<String> sexs = new ArrayList<>();
        sexs.add("男");
        sexs.add("女");
        OptionsPickerView build = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String data = sexs.get(options1);
                mUpdateinfoSexNan.setText(data);
                if (options1==0){
                    sexId=1;

                }else {
                    sexId=2;
                }
                alter=true;
            }
        }).setSubmitText("确定")
                .setCancelText("取消")
                .build();
        build.setPicker(sexs);
        build.show();

    }

    private void showTimPicker() {

        Calendar satrtCalendat = Calendar.getInstance();
        Calendar endCalendat = Calendar.getInstance();
        satrtCalendat.set(1900,1,1);
        endCalendat.set(endCalendat.get(Calendar.YEAR),endCalendat.get(Calendar.MONTH),endCalendat.get(Calendar.DAY_OF_MONTH));
         TimePickerView build = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                showTost("=======================");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                mFormat = sdf.format(date);
                alter=true;

            }


        }

        ).setCancelText("取消")
                .setType(new boolean[]{true,true,true,false,false,false})
                .setSubmitText("确定")
                .setRangDate(satrtCalendat,endCalendat)
                .build();

        build.show();
        build.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(Object o) {
                mUpdateinfoBirthdayTv.setText(mFormat);
            }
        });



    }

    @Override
    public void showProfessionlist(ListProfessionBean list) {

    }

    @Override
    public void showUserInfoBean(UserInfoEditBean userInfoEditBean) {
        mUserInfoEditBean = userInfoEditBean;
            mUpdateinfoIconSdv.setImageURI(Uri.parse(userInfoEditBean.getHeadImagePath()));
            mUpdateinfoNicknameTv.setText(userInfoEditBean.getNickname());
            mNickname=userInfoEditBean.getNickname();
            mUpdateinfoBirthdayTv.setText(userInfoEditBean.getBirthday());

            if (userInfoEditBean.getSex().equals("男")){
                sexId=1;
            }else {
                sexId=2;
            }
        mUpdateinfoSexNan.setText(userInfoEditBean.getSex());
        mProfile = userInfoEditBean.getPersonalProfile();
        mProfessionId = userInfoEditBean.getProfessionId();
        mUpdateinfoProfessionId.setText(userInfoEditBean.getProfessionName());


    }

    @Override
    public void showUpData(InfoBean infoBean) {
        showTost("修改成功");
        setResult(10);
       if (!alterImg){
           finish();
       }
    }

    @Override
    public void showUploadHeadImageBean(UploadHeadImageBean uploadHeadImageBean) {
            showTost("上传头像成功");
        setResult(10);
           finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==10&&resultCode==10){
            alter=true;
            mProfessionId = data.getStringExtra("id");
            String name = data.getStringExtra("name");
            if (!name.equals("")&&!name.equals(mUpdateinfoProfessionId.getText().toString())){
                  mUpdateinfoProfessionId.setText(name);
            }
        }else if (requestCode==20&&resultCode==20){
           alter=true;
           mProfile = data.getStringExtra("text");

        }else if (requestCode==Global.REQUEST_CODE_CHOOSE&&resultCode==RESULT_OK){
            List<Uri> uris = Matisse.obtainResult(data);
            mUpdateinfoIconSdv.setImageURI(uris.get(0));
            try {
                alterImg=true;
                mFile = BitmapUtils.getFile(BitmapUtils.getBitmapFormUri(this, uris.get(0)));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
