package com.example.mvp.myapplication.base.fragment;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mvp.myapplication.utils.SharedPreferencesUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @packge: com.example.mvp.myapplication.base.fragment
 * @filename:BottomFragment
 * @date :${DATA} 14:27
 */
public abstract class BottomFragment extends Fragment {

    private Unbinder mBind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(createLayout(), null);
        onViewCreateView(view);
        mBind = ButterKnife.bind(this,view);
        initEvemtData();
        return view;
    }

    protected  void onViewCreateView(View view){

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    protected abstract void initEvemtData();

    @Override
    public void onResume() {
        super.onResume();
    /* Resources resource = this.getResources();
        Configuration configuration = resource.getConfiguration();
        configuration.fontScale =1;//SharedPreferencesUtils.getSharedPreferences(getContext()).getFloat("text",1);// 设置字体的缩放比例
        resource.updateConfiguration(configuration, resource.getDisplayMetrics());*/
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mBind.unbind();
    }
    public  abstract  int createLayout();
    public  void  showTost(String tost) {
        if (!TextUtils.isEmpty(tost)) {

                if (this != null) {
                    Toast.makeText(getContext(), tost, Toast.LENGTH_SHORT).show();
                }

        }
    }
}
