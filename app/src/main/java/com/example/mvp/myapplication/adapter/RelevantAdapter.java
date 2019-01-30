package com.example.mvp.myapplication.adapter;

import android.app.Activity;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.http.bean.callback.RelevantBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:RelevantAdapter
 * @date :${DATA} 11:00
 */
public class RelevantAdapter extends RecyclerView.Adapter {
    private final List<RelevantBean> relevantlsit;
    private final Activity activity;

    public RelevantAdapter(List<RelevantBean> relevantlsit, Activity activity) {
        this.activity = activity;
        this.relevantlsit = relevantlsit;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_relevant, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ViewHolder holder1= (ViewHolder) holder;
        Uri uri = Uri.parse(relevantlsit.get(position).getImageListThumb().get(0));
        holder1.mRelevantIcon.setImageURI(uri);
        holder1.mRelevantTitle.setText(relevantlsit.get(position).getTitle());
        holder1.mRelevantTime.setText(relevantlsit.get(position).getPublishTime());
        holder1.mRelevantName.setText(relevantlsit.get(position).getOrigin());

    }

    @Override
    public int getItemCount() {
        return relevantlsit.size();
    }


     class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.relevant_title)
        TextView mRelevantTitle;
        @BindView(R.id.relevant_icon)
        SimpleDraweeView mRelevantIcon;
        @BindView(R.id.relevant_name)
        TextView mRelevantName;
        @BindView(R.id.relevant_time)
        TextView mRelevantTime;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
