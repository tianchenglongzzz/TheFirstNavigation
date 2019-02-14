package com.example.mvp.myapplication.base.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.app.App;
import com.example.mvp.myapplication.base.persenter.IBasePresenter;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.example.mvp.myapplication.ui.my.activity.UpdateinfoActivity;
import com.example.mvp.myapplication.utils.MessageSocket;
import com.example.mvp.myapplication.utils.RxBus;
import com.example.mvp.myapplication.utils.SharedPreferencesUtils;
import com.timmy.tdialog.TDialog;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * @packge: com.example.mvp.myapplication.base.activity
 * @filename:BaseActivity
 * @date :${DATA} 11:35
 */
public abstract class BaseActivity<V,P extends IBasePresenter<V>> extends BottomActivity implements IBaseView {

   public P   persemter;
    private View mView;
    private View mBaseView;
    private View mErroview;
    private TDialog mTDialog;
    private AlertDialog mAlertDialog;
    // private AlertDialog mDialog;


    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void viewCreate(View view) {
        super.viewCreate(view);
        mBaseView = view;
        persemter= createPresenter();
        persemter.attachView((V)this);
        createAleDalog();
        mAlertDialog = new AlertDialog.Builder(this).setView(LayoutInflater.from(this).inflate(R.layout.loding, null)).create();




    }
    public void goActivity(Class<?> activity) {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), activity);
        startActivity(intent);
    }





    @RequiresApi(api = Build.VERSION_CODES.M)
    private void createAleDalog() {

    }



    public abstract P createPresenter();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        persemter.detachView();
    }

    @Override
    public void showProgessbar() {
        if (mAlertDialog!=null) {
            mAlertDialog.show();
            WindowManager.LayoutParams attributes = mAlertDialog.getWindow().getAttributes();
            attributes.width=300;
            attributes.height=300;
            mAlertDialog.getWindow().setAttributes(attributes);

        }
    }



    @Override
    public void showWarn() {

            mErroview = LayoutInflater.from(this).inflate(R.layout.http_erro, (ViewGroup) mBaseView);

    }


    @Override
    public void hideProgessbar() {
        if (mAlertDialog!=null) {
            mAlertDialog.dismiss();
        }


    }

    @Override
    public void showError(String error) {
       // mDialog.dismiss();
        showTost(error);
    }

    @Override
    public void dismissErrolayout() {
        if (mErroview!=null){
            mBaseView.setVisibility(View.GONE);
        }
    }


}
