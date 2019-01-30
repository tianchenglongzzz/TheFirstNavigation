package com.example.mvp.myapplication.base.activity;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.base.persenter.IBasePresenter;
import com.example.mvp.myapplication.base.view.IBaseView;

/**
 * @packge: com.example.mvp.myapplication.base.activity
 * @filename:BaseActivity
 * @date :${DATA} 11:35
 */
public abstract class BaseActivity<V,P extends IBasePresenter<V>> extends BottomActivity implements IBaseView {

   public P   persemter;
    private View mView;
    private static PopupWindow mWindow;
   // private AlertDialog mDialog;


    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void viewCreate() {
        super.viewCreate();

        persemter= createPresenter();
        persemter.attachView((V)this);
        createAleDalog();


    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    private void createAleDalog() {
         mView=LayoutInflater.from(this).inflate(R.layout.basepopwindow, null);
        mWindow = new PopupWindow();
        mWindow.setBackgroundDrawable(new ColorDrawable());
        mWindow.setWidth(getWindow().getAttributes().width);
        mWindow.setHeight(getWindow().getAttributes().height);
        mWindow.setContentView(mView);
        // mDialog = new AlertDialog.Builder(this).setView(mView, 0, 0, 0, 0).create();
/*
       WindowManager.LayoutParams attributes = mDialog.getWindow().getAttributes();
        attributes.height=100;
        attributes.width=100;
        mDialog.getWindow().setAttributes(attributes);
        mDialog.setCancelable(false);*/
      /*  mWindow = new PopupWindow(this);
        mWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mWindow.setContentView(mView);*/




    }

    public abstract P createPresenter();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        persemter.detachView();
    }

    @Override
    public void showProgessbar() {
      //mView.setVisibility(View.VISIBLE);
        Log.e("tianchenglong","Window");
       if (isFinishing()) {
       }else {
           mWindow.showAtLocation(mView, Gravity.NO_GRAVITY, 0, 0);
       }




     //   mDialog.show();


    }

    @Override
    public void showWarn(String string) {
        showTost(string);
    }

    @Override
    public void hideProgessbar() {
     // mDialog.dismiss();
       mWindow.dismiss();
    }

    @Override
    public void showError(String error) {
        mWindow.dismiss();
       // mDialog.dismiss();
        showTost(error);
    }
}
