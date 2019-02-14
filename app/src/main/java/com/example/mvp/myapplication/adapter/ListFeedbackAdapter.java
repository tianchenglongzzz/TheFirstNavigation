package com.example.mvp.myapplication.adapter;

import android.app.Activity;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.ListFeedbackBean;
import com.example.mvp.myapplication.utils.GlideUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:ListFeedbackAdapter
 * @date :${DATA} 13:10
 */
public class ListFeedbackAdapter extends RecyclerView.Adapter {
    private static final int SYSTEM = 0;
    private static final int IMG = 1;
    private static final int TEXT = 2;
    private final ArrayList<ListFeedbackBean.FeedbackListBean> mListBeans;
    private final Activity mActivity;
    private final String mHeadImg;

    public ListFeedbackAdapter(ArrayList<ListFeedbackBean.FeedbackListBean> listBeans, FragmentActivity listFeedbackFragment, String headImg) {
        mListBeans = listBeans;
        mActivity = listFeedbackFragment;
        mHeadImg = headImg;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == SYSTEM) {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_listfeedback_system, null);
            return new ViewHolderSystem(view);
        }
        if (viewType == TEXT) {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_listfeedback_text, null);
            return new ViewHolderText(view);
        } else {

            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_listfeedback_img, null);
             return  new ViewHolderImg(view);

        }

    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == SYSTEM) {
            ViewHolderSystem  viewHolderSystem= (ViewHolderSystem) holder;
            viewHolderSystem.mHeadimg.setImageURI(mListBeans.get(position).getImagePath());
            viewHolderSystem.mText.setText(mListBeans.get(position).getContent());
        }
        if (viewType == TEXT) {
           ViewHolderText viewHolderText=(ViewHolderText)holder;
           viewHolderText.mText.setText(mListBeans.get(position).getContent());
           viewHolderText.mHeadimg.setImageURI(Uri.parse(mHeadImg));
        }
        if (viewType == IMG){
           ViewHolderImg  viewHolderImg= (ViewHolderImg) holder;
            GlideUtil.setImgBig(mListBeans.get(position).getContent(),viewHolderImg.mListfeedImg,mActivity);
            viewHolderImg.mHeadimg.setImageURI(Uri.parse(mHeadImg));
        }
    }

    @Override
    public int getItemCount() {
        return mListBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        ListFeedbackBean.FeedbackListBean bean = mListBeans.get(position);
        if (bean.getUserId().equals("0")) {
            return SYSTEM;
        }
        String type = bean.getType();
        int parseInt = Integer.parseInt(type);
        if (parseInt == 1) {
            return IMG;
        } else {
            return TEXT;
        }

    }

    static class ViewHolderSystem extends RecyclerView.ViewHolder {
        @BindView(R.id.text)
        TextView mText;
        @BindView(R.id.headimg)
        SimpleDraweeView mHeadimg;

        ViewHolderSystem(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolderText extends RecyclerView.ViewHolder {
        @BindView(R.id.headimg)
        SimpleDraweeView mHeadimg;
        @BindView(R.id.text)
        TextView mText;

        ViewHolderText(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolderImg extends RecyclerView.ViewHolder{
        @BindView(R.id.headimg)
        SimpleDraweeView mHeadimg;
        @BindView(R.id.listfeed_img)
        ImageView mListfeedImg;

        ViewHolderImg(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
