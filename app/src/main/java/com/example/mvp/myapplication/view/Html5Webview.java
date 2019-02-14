package com.example.mvp.myapplication.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * @packge: com.example.mvp.myapplication.view
 * @filename:Html5Webview
 * @date :${DATA} 11:02
 */
public class Html5Webview extends WebView {
    private ProgressView progressView;//进度条
    private Context context;

    public Html5Webview(Context context) {
        this(context, null);
    }

    public Html5Webview(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Html5Webview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        //初始化进度条
        progressView = new ProgressView(context);
        progressView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp2px(context, 4)));
        progressView.setColor(Color.BLUE);
        progressView.setProgress(10);
        //把进度条加到Webview中
        addView(progressView);
        //初始化设置

        setWebChromeClient(new MyWebCromeClient());
        setWebViewClient(new WebViewClient());
    }

    private class MyWebCromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                //加载完毕进度条消失
                progressView.setVisibility(View.GONE);
            } else {
                //更新进度
                progressView.setProgress(newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }
    }

    /**
     * dp转换成px
     *
     * @param context Context
     * @param dp      dp
     * @return px值
     */
    private int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

}
