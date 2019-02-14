package com.example.mvp.myapplication.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.contact.QuestionInterface;
import com.example.mvp.myapplication.http.bean.callback.QuestionBean;
import com.example.mvp.myapplication.ui.my.activity.WebActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:QuestionAdapter
 * @date :${DATA} 10:59
 */
public class QuestionAdapter extends RecyclerView.Adapter {

    private final List<QuestionBean> mList;
    private final FragmentActivity mActivity;

    public QuestionAdapter(List<QuestionBean> list, FragmentActivity activity) {
        mList = list;
        mActivity = activity;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_question, null);
        return  new ViewHolderQuestion(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
                ViewHolderQuestion viewHolderQuestion= (ViewHolderQuestion) holder;
                viewHolderQuestion.mQuestionTitle.setText(mList.get(position).getQuestion());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mActivity,WebActivity.class);
                        intent.putExtra("url",mList.get(position).getAnswer());
                        mActivity.startActivity(intent);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolderQuestion extends RecyclerView.ViewHolder {
        @BindView(R.id.question_title)
        TextView mQuestionTitle;
        @BindView(R.id.img)
        TextView mImg;

        ViewHolderQuestion(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
