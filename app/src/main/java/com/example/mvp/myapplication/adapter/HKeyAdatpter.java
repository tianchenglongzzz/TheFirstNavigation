package com.example.mvp.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.greedao.SearchDaoBean;
import com.example.mvp.myapplication.ui.news.activity.SearchActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.mvp.myapplication.adapter
 * @filename:HKeyAdatpter
 * @date :${DATA} 15:46
 */
public class HKeyAdatpter extends RecyclerView.Adapter {

    private final List<SearchDaoBean> mSearchDaoBeans;
    private final SearchActivity mSearchActivity;

    public HKeyAdatpter(List<SearchDaoBean> searchDaoBeans, SearchActivity searchActivity) {
        mSearchDaoBeans = searchDaoBeans;
        mSearchActivity = searchActivity;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mSearchActivity).inflate(R.layout.hkeyitem, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
               ViewHolder viewHolder= (ViewHolder) holder;
               viewHolder.mTvHk.setText(mSearchDaoBeans.get(position).getSearchName());
               viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       mOnItemClickListener.onItemClick(v,mSearchDaoBeans.get(position).getSearchName());
                   }
               });
    }

    @Override
    public int getItemCount() {
        return mSearchDaoBeans.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_hk)
        TextView mTvHk;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }
    public void setOnItemClickListener(HotAdatpter.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private HotAdatpter.OnItemClickListener mOnItemClickListener;
    public interface OnItemClickListener {
        void onItemClick(View view,String item);

    }
}
