package com.example.mvp.myapplication.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.greedao.SearchDaoBean;
import com.example.mvp.myapplication.http.bean.callback.HotBean;
import com.example.mvp.myapplication.ui.news.activity.SearchActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.http.POST;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:HotAdatpter
 * @date :${DATA} 16:19
 */
public class HotAdatpter extends RecyclerView.Adapter {

    private final List<HotBean.SearchListBean> mSearchDaoBeans;
    private final SearchActivity mSearchActivity;

    public HotAdatpter(ArrayList<HotBean.SearchListBean> searchDaoBeans, SearchActivity searchActivity) {
        mSearchDaoBeans = searchDaoBeans;
        mSearchActivity = searchActivity;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View hotview = LayoutInflater.from(mSearchActivity).inflate(R.layout.item_search_, null);

        return new ViewHolder(hotview);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
               ViewHolder viewHolder= (ViewHolder) holder;

               if (position==0){
                   viewHolder.mTvPai.setTextColor(mSearchActivity.getResources().getColor(R.color.hot1));
                   viewHolder.mTvPai.setText(position+1+"");
               }else if (position==1){
                   viewHolder.mTvPai.setTextColor(mSearchActivity.getResources().getColor(R.color.hot2));
                   viewHolder.mTvPai.setText(position+1+"");

               }else if (position==2){
                   viewHolder.mTvPai.setTextColor(mSearchActivity.getResources().getColor(R.color.hot3));
                   viewHolder.mTvPai.setText(position+1+"");

               }else if (position==3){
                   viewHolder.mTvPai.setTextColor(mSearchActivity.getResources().getColor(R.color.hot4));
                   viewHolder.mTvPai.setText(position+1+"");

               }else if (position==4){
                   viewHolder.mTvPai.setTextColor(mSearchActivity.getResources().getColor(R.color.hot5));
                   viewHolder.mTvPai.setText(position+1+"");

               }
               viewHolder.mTvName.setText(mSearchDaoBeans.get(position).getContent());
               viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       mOnItemClickListener.onItemClick(v,mSearchDaoBeans.get(position).getContent());
                   }
               });
    }

    @Override
    public int getItemCount() {
        return mSearchDaoBeans.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_pai)
        TextView mTvPai;
        @BindView(R.id.tv_name)
        TextView mTvName;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private  OnItemClickListener mOnItemClickListener;
    public interface OnItemClickListener {
        void onItemClick(View view,String item);

    }
}
