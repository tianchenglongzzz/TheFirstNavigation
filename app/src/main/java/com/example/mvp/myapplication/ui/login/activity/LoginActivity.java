package com.example.mvp.myapplication.ui.login.activity;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.app.App;
import com.example.mvp.myapplication.app.Global;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.contact.LoginInterface;
import com.example.mvp.myapplication.greedao.PhoneDaoBean;
import com.example.mvp.myapplication.presenter.LoginPresenter;
import com.example.mvp.myapplication.utils.SharedPreferencesUtils;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.List;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

public  class LoginActivity extends BaseActivity<LoginInterface.ILoginV,LoginPresenter<LoginInterface.ILoginV>> implements CheckBox.OnCheckedChangeListener,LoginInterface.ILoginV {

    @BindView(R.id.login_check_pact)
    CheckBox  mCheckPact;
    @BindView(R.id.login_ESC)
    ImageView mLoginESC;
    @BindView(R.id.login_ed_phone)
    EditText mLoginEdPhone;
    @BindView(R.id.login_ed_vcode)
    EditText mLoginEdVcode;
    @BindView(R.id.login_tv_vcode)
    TextView mLoginTvVcode;
    @BindView(R.id.login_btn_enter)
    ImageView mLoginBtnEnter;
    @BindView(R.id.login_btn_qq)
    ImageView mLoginBtnQq;
    @BindView(R.id.login_btn_weixin)
    ImageView mLoginBtnWeixin;
    @BindView(R.id.login_btn_xinlang)
    ImageView mLoginBtnXinlang;
    private int mAlpha;
    private String verify;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public int createLayout() {
        return R.layout.activity_login;
    }


    @Override
    public void origination() {

         //设置选框状
        mCheckPact.setOnCheckedChangeListener(this);
        zhuangtaiB(false);
        mLoginEdPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                     if (mLoginEdPhone.getText().toString()!=null&&mLoginEdPhone.getText().toString().length()>0&&mLoginEdVcode.getText().toString()!=null&&mLoginEdVcode.getText().toString().length()>0&&mCheckPact.isChecked()){
                         zhuangtaiA(true);
                     }else {
                         zhuangtaiB(false);
                     }
            }
        });
        //输入监听
        mLoginEdVcode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //输入以后判断最后的结果是否为空
                if (mLoginEdPhone.getText().toString()!=null&&mLoginEdPhone.getText().toString().length()>0&&mLoginEdVcode.getText().toString()!=null&&mLoginEdVcode.getText().toString().length()>0&&mCheckPact.isChecked()){
                    zhuangtaiA(true);
                }else {
                    zhuangtaiB(false);
                }
            }
        });

    }


   @Override
       public boolean onCreateOptionsMenu(Menu menu) {
           // Inflate the menu; this adds items to the action bar if it is present.
           getMenuInflater().inflate(R.menu.search_menu, menu);

           // Get the SearchView and set the searchable configuration
           SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
           SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
           // Assumes current activity is the searchable activity
           searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

           searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
               @Override
               public boolean onQueryTextSubmit(String query) {
                     return  true;
                   }

               @Override
               public boolean onQueryTextChange(String newText) {
                   return false;
               }




       });
           return  true;
   }
    @OnClick({R.id.login_ESC, R.id.login_ed_phone, R.id.login_ed_vcode, R.id.login_tv_vcode, R.id.login_btn_enter, R.id.login_btn_qq, R.id.login_btn_weixin, R.id.login_btn_xinlang})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login_ESC:
                break;
            case R.id.login_ed_phone:
                break;
            case R.id.login_ed_vcode:
                break;
            case R.id.login_tv_vcode:
                //获取验证码
                 getVCode();
                break;
            case R.id.login_btn_enter:
                startPDataActivity();
                break;
            case R.id.login_btn_qq:
                break;
            case R.id.login_btn_weixin:
                break;
            case R.id.login_btn_xinlang:
                break;
        }
    }

    private void startPDataActivity() {
        //先获取EdText的手机号
        String phone = mLoginEdPhone.getText().toString();

        //查询数据库
        List<PhoneDaoBean> phoneDaoBeans = App.getSession().getPhoneDaoBeanDao().loadAll();

        boolean phoneBoolean=false;
        for (int i = 0; i <phoneDaoBeans.size() ; i++) {
            //如果能查到就设置成true
                if (phoneDaoBeans.get(i).getPhone().equals(phone)){
                    phoneBoolean=true;
                }
        }
        //如果验证码不和你获取的验证码相等
        if (phone!=null&&mLoginEdVcode.getText().toString().equals(verify)){
            //如果数据库中有这个手机号
              if (phoneBoolean){
                    //就打个Tost
                  showTost("老用户了--------你退群把");
              }else {
                  //存入数据库
                   //没有就存入数据库//并跳到第注册页面
                  App.getSession().getPhoneDaoBeanDao().insert(new PhoneDaoBean(null,phone));
                Intent intent = new Intent(this, PersonalDataActivity.class);
                intent.putExtra("phone",phone);
                mLoginEdVcode.setText("");
                startActivity(intent);
            }
        }else {
            //如果验证码不相等就弹Tost
            showTost("你输入的验证码有误---请输入："+verify);
        }

    }

    private void getVCode() {
        if (mLoginEdPhone.getText().toString().matches("[1][1-9][1-9][0-9]{8}")) {
            int count = SharedPreferencesUtils.getSharedPreferences(this).getInt("Count", 0);
            int time = SharedPreferencesUtils.getSharedPreferences(this).getInt("time", (int) System.currentTimeMillis());
            boolean timeboolean = SharedPreferencesUtils.getSharedPreferences(this).getBoolean("timeboolean", true);
            if (timeboolean) {
                if (count == 5) {
                    SharedPreferencesUtils.getSharedPreferences(this).putInt("time", (int) System.currentTimeMillis() + 1000);
                    showTost("你以获取验证码超过5次请等待10秒后再次获取");
                    SharedPreferencesUtils.getSharedPreferences(this).putBoolean("timeboolean", false);
                } else {
                    SharedPreferencesUtils.getSharedPreferences(this).putInt("Count", count+=1);
                    showTost("你还有"+(5-count)+"次机会");
                    persemter.setVerifyData();
                }
            }else {

                 if (time<(int) System.currentTimeMillis()){
                     SharedPreferencesUtils.getSharedPreferences(this).putBoolean("timeboolean", true);
                     SharedPreferencesUtils.getSharedPreferences(this).putInt("Count", 0);
                 }
                 showTost("时间未到");
            }

        }else {
            showTost("您输入的不是手机号");
        }
     /*   Vcode vcode = new Vcode(mLoginEdPhone.getText().toString(), 0);
        String student = jsonUtils.getStudent(vcode);
        showTost(student);*/
    }

    @SuppressLint({"Range", "ResourceAsColor"})
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (!TextUtils.isEmpty(mLoginEdPhone.getText().toString())&&!TextUtils.isEmpty(mLoginEdVcode.getText().toString())&&mCheckPact.isChecked()){
            zhuangtaiA(true);
        }else {
            zhuangtaiB(false);
        }
    }

    private void zhuangtaiB(boolean b) {
        mLoginBtnEnter.setEnabled(b);
        mLoginBtnEnter.setImageResource(R.mipmap.deng);
    }
    private void zhuangtaiA(boolean b) {
        mLoginBtnEnter.setEnabled(b);
        mLoginBtnEnter.setImageResource(R.mipmap.dengdeng);
    }


    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }


    @Override
    public void showVerifyData(String code) {
        mLoginEdVcode.setText(code);
        this.verify=code;
        if (code!=null) {
            mLoginEdVcode.setText(code);
        }
    }
}
