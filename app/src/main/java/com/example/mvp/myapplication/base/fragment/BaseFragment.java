package com.example.mvp.myapplication.base.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.base.persenter.IBasePresenter;
import com.example.mvp.myapplication.base.view.IBaseView;
import com.timmy.tdialog.TDialog;

/**
 * @packge: com.example.mvp.myapplication.base.fragment
 * @filename:BaseFragment
 * @date :${DATA} 14:27
 */
public abstract class BaseFragment<V ,P extends IBasePresenter<V>>extends BottomFragment implements IBaseView {
 public    P  persenter;

    private View mBaseView;

    private View mErroview;
    private AlertDialog mAlertDialog;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onViewCreateView(View view) {
        mBaseView = view;
        persenter=createPresnter();
        persenter.attachView((V) this);
        mAlertDialog = new AlertDialog.Builder(getContext()).setView(LayoutInflater.from(getContext()).inflate(R.layout.loding, null)).create();
    }

    public abstract P createPresnter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        persenter.detachView();
    }

    @Override
    public void showProgessbar(){
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
        if (mErroview == null){
            mErroview = LayoutInflater.from(getContext()).inflate(R.layout.http_erro, (ViewGroup) mBaseView);
        }else {
            mErroview.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void hideProgessbar() {
        if (mAlertDialog!=null) {
            mAlertDialog.dismiss();
        }

    }

    @Override
    public void showError(String error) {
          showTost(error);
    }

    @Override
    public void dismissErrolayout() {
        if (mErroview!=null) {
            mErroview.setVisibility(View.GONE);
        }
    }
}
