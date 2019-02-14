package com.example.mvp.myapplication.ui.my.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.base.activity.BottomActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class WebActivity extends BottomActivity {

    @BindView(R.id.web_toobar)
    Toolbar mWebToobar;
    @BindView(R.id.web)
    WebView mWeb;
    @Override
    public int createLayout() {
        return R.layout.activity_web;
    }

    @Override
    public void origination() {
        setToobar(mWebToobar);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        mWeb.setWebViewClient(new WebViewClient());
        WebSettings settings = mWeb.getSettings();
        settings.setTextZoom(150);
        settings.setJavaScriptEnabled(true);
        mWeb.loadData(url,"",url);
    }

    @OnClick({R.id.web_toobar, R.id.web})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.web_toobar:
                break;
            case R.id.web:
                break;
        }
    }
}
