package com.example.mvp.myapplication.adapter;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.ui.topic.activity.TopicDataActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URI;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:TopicInfoImgAdapter
 * @date :${DATA} 16:28
 */
public class TopicInfoImgAdapter extends RecyclerView.Adapter {

    private final TopicDataActivity mTopicDataActivity;
    private final List<String> mImageListThumb;

    public TopicInfoImgAdapter(TopicDataActivity topicDataActivity, List<String> imageListThumb) {
        mTopicDataActivity = topicDataActivity;
        mImageListThumb = imageListThumb;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mTopicDataActivity).inflate(R.layout.item_topic_info_img, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
         ViewHolder viewHolder= (ViewHolder) holder;
         viewHolder.mTopicImgItemSdv.setImageURI(Uri.parse(mImageListThumb.get(position)));
    }

    @Override
    public int getItemCount() {
        if (mImageListThumb!=null) {
            return mImageListThumb.size();
        }else {
            return  0;
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.topic_img_item_sdv)
        SimpleDraweeView mTopicImgItemSdv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
