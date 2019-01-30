package com.example.mvp.myapplication.base.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.base.persenter.IBasePresenter;
import com.example.mvp.myapplication.base.view.IBaseView;

/**
 * @packge: com.example.mvp.myapplication.base.fragment
 * @filename:BaseFragment
 * @date :${DATA} 14:27
 */
public abstract class BaseFragment<V ,P extends IBasePresenter<V>>extends BottomFragment implements IBaseView {
 public    P  persenter;
    private View mView;
    private PopupWindow mWindow;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onViewCreateView(View view) {
        persenter=createPresnter();
        persenter.attachView((V) this);
        mView=LayoutInflater.from(getContext()).inflate(R.layout.basepopwindow, null);
        mWindow = new PopupWindow();
        mWindow.setBackgroundDrawable(new ColorDrawable());
        mWindow.setWidth(getActivity().getWindow().getAttributes().width);
        mWindow.setHeight(getActivity().getWindow().getAttributes().height);
        mWindow.setContentView(mView);
    }

    public abstract P createPresnter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        persenter.detachView();
    }

    @Override
    public void showProgessbar(){
              mView.post(new Runnable() {
                  @Override
                  public void run() {
                      mWindow.showAtLocation(mView,Gravity.NO_GRAVITY,0,0);
                  }
              });





    }

    @Override
    public void showWarn(String string) {
            showTost(string);
    }


    @Override
    public void hideProgessbar() {
         mWindow.dismiss();
    }

    @Override
    public void showError(String error) {
          showTost(error);
    }
}
