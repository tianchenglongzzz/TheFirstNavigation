package com.example.mvp.myapplication.ui.news.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.RelevantAdapter;
import com.example.mvp.myapplication.adapter.TopicCommentAdapter;
import com.example.mvp.myapplication.app.Global;
import com.example.mvp.myapplication.base.activity.BaseActivity;
import com.example.mvp.myapplication.contact.InfoInterface;
import com.example.mvp.myapplication.http.bean.callback.InfiBean;
import com.example.mvp.myapplication.http.bean.callback.InfoBean;
import com.example.mvp.myapplication.http.bean.callback.ListCommentBean;
import com.example.mvp.myapplication.http.bean.callback.RelevantBean;
import com.example.mvp.myapplication.jsonbean.JsonFollow;
import com.example.mvp.myapplication.jsonbean.JsonLikesBean;
import com.example.mvp.myapplication.jsonbean.JsonListComment;
import com.example.mvp.myapplication.presenter.InfoPresenter;
import com.example.mvp.myapplication.utils.jsonUtils;
import com.example.mvp.myapplication.view.Html5Webview;
import com.example.mvp.myapplication.watcher.SoftKeyboardStateWatcher;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ShowDataActivity extends BaseActivity<InfoInterface.IinfoView, InfoPresenter<InfoInterface.IinfoView>> implements InfoInterface.IinfoView {
   @BindView(R.id.lL_info_gen)
    LinearLayout gen;
    @BindView(R.id.cv_tool)
    CardView mCardView;

    @BindView(R.id.info_toobar)
    Toolbar mToolbar;
    @BindView(R.id.wab_news_data)
    Html5Webview mWebView;
    @BindView(R.id.info_title)
    TextView infoTitle;
    @BindView(R.id.re_relevant)
    RecyclerView mRecyclerViewRelevant;
    @BindView(R.id.info_time)
    TextView infotime;
    @BindView(R.id.info_share)
    TextView mInfoShare;
    @BindView(R.id.info_comment)
    TextView mInfoComment;
    @BindView(R.id.info_favoured)
    TextView mInfoFavoured;
    @BindView(R.id.im_tool)
    ImageView mImTool;
    @BindView(R.id.news_comment_rc)
    RecyclerView mCommentRV;
    private boolean likes=true;
    /**
     * 取消
     */
    private TextView mPopcomentCancel;
    /**
     * 写评论
     */
    /*
    * 点赞
    */
    @BindView(R.id.likes_img)
    ImageView likesImg;
    private TextView mPopcomentReview;
    private PopupWindow mPopComment;
    private PopupWindow mPopRightTop;
    private String mTitle;
    private TopicCommentAdapter mNewsCommentAdapter;
    private ArrayList<ListCommentBean.CommentListBean> mCommentListBeans;
    private String mNewsId;

    @Override
    public int createLayout() {
        return R.layout.activity_show_data;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("JavascriptInterface")
    @Override
    public void origination() {
        setToobar();
        Intent intent = getIntent();
        mNewsId = intent.getStringExtra("newsId");
   //设置支持javascript 带码
        mWebView.setWebViewClient(new WebViewClient()/*{
            @Override
            public void onPageFinished(WebView view, String url) {
                mWebView.loadUrl("[removed](function(){"+"document.getElementsByTagName('body')[0].style.height = window.innerHeight+'px';"+"})()");
                super.onPageFinished(view, url);
            }
        }*/);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
       // settings.setUseWideViewPort(true);
        //settings.setTextZoom(110);
        //方案三
        /*mWebView.setWebViewClient(new WebViewClient() {

            @Override

            public void onPageFinished(WebView view, String url) {

                mWebView.loadUrl("javascript:App.resize(document.body.getBoundingClientRect().height)");

                super.onPageFinished(view, url);

            }

        });*/

        //mWebView.addJavascriptInterface(this, "App");
      settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        settings.setSupportZoom(true);
// 设置出现缩放工具
       settings.setBuiltInZoomControls(true);
  // settings.setBuiltInZoomControls(true
        //web.getSettings().setSupportZoom(true);
        //// 设置出现缩放工具
        //web.getSettings().setBuiltInZoomControls(true);); // 显示放大缩小
      //  settings.setSupportZoom(true); // 可以缩放*/
      /*  settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);*/
    /*  mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setVerticalScrollbarOverlay(false);
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.setHorizontalScrollbarOverlay(false);*/

     /*  settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(true);*/

        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);

        persemter.getInfoList(mNewsId);
        persemter.getRelevantlsit(mNewsId);
        SoftKeyboardStateWatcher watcher = new SoftKeyboardStateWatcher(gen, this);
        watcher.addSoftKeyboardStateListener(new SoftKeyboardStateWatcher.SoftKeyboardStateListener() {
            @Override
            public void onSoftKeyboardOpened(int keyboardHeightInPx) {

            }

            @Override
            public void onSoftKeyboardClosed() {
                    mCardView.setVisibility(View.VISIBLE);
                    mPopComment.dismiss();
            }
        });
        mCommentListBeans = new ArrayList<>();
        mNewsCommentAdapter = new TopicCommentAdapter(mCommentListBeans,this);
        mCommentRV.setLayoutManager(new LinearLayoutManager(this));
        mCommentRV.setAdapter(mNewsCommentAdapter);
        String json = jsonUtils.getStudent(new JsonListComment(mNewsId, "0", 0));
        persemter.getlistComment(json);
        //if (mWebView.isHardwareAccelerated()) mWebView.setLayerType(View.LAYER_TYPE_HARDWARE,null);


    }


    private void setToobar() {
        mToolbar.setNavigationIcon(R.mipmap.smallfanhui);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.info_comment,R.id.info_share,R.id.im_tool,R.id.likes_img})
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.info_comment:
            showCommentP();
            break;
            case  R.id.info_share:

                break;
            case  R.id.im_tool:
                showShareP();
                break;
            case  R.id.likes_img:

                if (likes) {
                    String json = jsonUtils.getStudent(new JsonLikesBean(Global.USER, mNewsId, "0","0"));
                    likesImg.setImageResource(R.mipmap.news_praise_high);
                    persemter.getLikeData(json);
                }else {
                    String json = jsonUtils.getStudent(new JsonLikesBean(Global.USER, mNewsId, "1","0"));
                    likesImg.setImageResource(R.mipmap.news_praise);
                    persemter.getLikeData(json);
                }
              break;
        }




    }

    private void showShareP() {
            PoPItemClick poPItemClick = new PoPItemClick();
            View inflate = LayoutInflater.from(this).inflate(R.layout.popshare, null);
            TextView wiboShare= inflate.findViewById(R.id.tv_share_weibo);
            TextView wxShare=inflate.findViewById(R.id.tv_share_wx);
            TextView qqShare=inflate.findViewById(R.id.tv_share_qq);
            TextView fcShare=inflate.findViewById(R.id.tv_share_fc);
            TextView tvCollect=inflate.findViewById(R.id.tv_share_collect);
            TextView tvNight=inflate.findViewById(R.id.tv_share_yeijian);
            TextView tvReport=inflate.findViewById(R.id.tv_share_report);
            CardView cardView=inflate.findViewById(R.id.cv_popshare_dismiss);
            mPopRightTop = new PopupWindow(this);
            mPopRightTop.setContentView(inflate);
            mPopRightTop.setBackgroundDrawable(new ColorDrawable());
            mPopRightTop.setWidth(GridLayout.LayoutParams.MATCH_PARENT);
            mPopRightTop.setHeight(GridLayout.LayoutParams.MATCH_PARENT);
            mPopRightTop.setAnimationStyle(R.style.anim_pop_bottombar);
            mPopRightTop.showAtLocation(mToolbar,Gravity.NO_GRAVITY,0,0);
            wiboShare.setOnClickListener(poPItemClick);
            qqShare.setOnClickListener(poPItemClick);
            fcShare.setOnClickListener(poPItemClick);
            wxShare.setOnClickListener(poPItemClick);
            tvNight.setOnClickListener(poPItemClick);
            cardView.setOnClickListener(poPItemClick);




    }


    private void showCommentP() {
        View popcoment = LayoutInflater.from(this).inflate(R.layout.popcoment, null);
        setPopC(popcoment);
        TextView cancel = popcoment.findViewById(R.id.popcoment_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCardView.setVisibility(View.VISIBLE);
                mPopComment.dismiss();
            }
        });
    }

    private void setPopC(View popcoment) {

        mCardView.setVisibility(View.GONE);
        mPopComment = new PopupWindow(this);
        mPopComment.setContentView(popcoment);
        mPopComment.setBackgroundDrawable(new ColorDrawable());
        mPopComment.setFocusable(true);
        mPopComment.setAnimationStyle(R.style.anim_pop_bottombar);
        mPopComment.setHeight(this.getWindowManager().getDefaultDisplay().getHeight());
        mPopComment.setWidth(this.getWindowManager().getDefaultDisplay().getWidth());
        mPopComment.showAtLocation(mToolbar, Gravity.NO_GRAVITY, 0, 0);
        InputMethodManager inputManager = (InputMethodManager) this.getSystemService(this.INPUT_METHOD_SERVICE);
        inputManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

    }


    @Override
    public InfoPresenter createPresenter() {
        return new InfoPresenter();
    }

    @Override
    public void showInfoBean(InfiBean InfiBean) {
        mTitle = InfiBean.getTitle();
        //Log.e("tian",InfiBean.getContent());
        mWebView.loadDataWithBaseURL(null,getHtmlData(InfiBean.getContent()), "text/html",  "utf-8", null);
        infoTitle.setText(InfiBean.getTitle());
        infotime.setText(InfiBean.getPublishTime());
      /*  mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                //这个是一定要加上那个的,配合scrollView和WebView的height=wrap_content属性使用
                int w = View.MeasureSpec.makeMeasureSpec(0,
                        View.MeasureSpec.UNSPECIFIED);
                int h = View.MeasureSpec.makeMeasureSpec(0,
                        View.MeasureSpec.UNSPECIFIED);
                //重新测量
                mWebView.measure(w, h);



            }
        });*/


    }

    @Override
    public void showRelevantlsit(List<RelevantBean> relevantlsit) {
        RelevantAdapter adapter = new RelevantAdapter(relevantlsit, this);
        mRecyclerViewRelevant.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewRelevant.setAdapter(adapter);

    }

    @Override
    public void showlistComment(ListCommentBean listCommentBean) {
         Log.d("info",listCommentBean.toString());
         mCommentListBeans.addAll(listCommentBean.getCommentList());
         mNewsCommentAdapter.notifyDataSetChanged();

    }

    @Override
    public void showLikeData(InfoBean infoBean){
        Log.d("showFollow",infoBean.getMessage());
          if (likes){
              likes=false;
          }else {
              likes=true;
          }
    }


    public void initViewPop(View view) {
        mPopcomentCancel = (TextView) findViewById(R.id.popcoment_cancel);
        mPopcomentReview = (TextView) findViewById(R.id.popcoment_review);
    }
    private String getHtmlData(String bodyHTML) {
        String head = "<head>"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> "
                + "<style>img{max-width: 100%; width:auto; height:auto;}</style>"
                + "</head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        //监听键盘 隐藏键
        Log.e("tian",event.getKeyCode()+"");
        return super.dispatchKeyEvent(event);
    }
    public static String getNewContent(String htmltext){
        Document doc= Jsoup.parse(htmltext);
        Elements elements=doc.getElementsByTag("img");
        for (Element element : elements) {
            element.attr("width","100%").attr("height","auto");
        }
        return doc.toString();
    }
  class  PoPItemClick implements View.OnClickListener{

      @Override
      public void onClick(View v) {
           switch (v.getId()){
               case R.id.tv_share_weibo:
                   UMWeb  webxinl = new UMWeb("http://www.baidu.com");
                   new ShareAction(ShowDataActivity.this)
                           .setPlatform(SHARE_MEDIA.SINA)//传入平台
                           .withMedia(webxinl)
                           .setCallback(shareListener)//回调监听器
                           .share();
               break;
               case R.id.tv_share_wx:
                   UMWeb  web = new UMWeb("http://www.baidu.com");
                   new ShareAction(ShowDataActivity.this)
                           .setPlatform(SHARE_MEDIA.WEIXIN)//传入平台
                           .withMedia(web)
                           .setCallback(shareListener)//回调监听器
                           .share();
                   break;
               case R.id.tv_share_qq:
                   UMWeb  webb = new UMWeb("http://www.baidu.com");
                   webb.setTitle(mTitle);//标题
                   new ShareAction(ShowDataActivity.this)
                           .setPlatform(SHARE_MEDIA.QQ)//传入平台
                           .withMedia(webb)
                           .setCallback(shareListener)//回调监听器
                           .share();
                   break;
               case R.id.tv_share_fc:
                   UMWeb  pengyouquan = new UMWeb("http://www.baidu.com");
                   pengyouquan.setTitle(mTitle);//标题
                   new ShareAction(ShowDataActivity.this)
                           .setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)//传入平台
                           .withMedia(pengyouquan)
                           .setCallback(shareListener)//回调监听器
                           .share();

                   break;
               case R.id.cv_popshare_dismiss:
                    mPopRightTop.dismiss();
                   break;

           }
      }
  }
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(ShowDataActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(ShowDataActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(ShowDataActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };

}
