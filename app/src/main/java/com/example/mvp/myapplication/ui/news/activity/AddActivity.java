package com.example.mvp.myapplication.ui.news.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.adapter.AddRecyclerViewApdate;
import com.example.mvp.myapplication.adapter.ReMoveRecyclerViewApdate;
import com.example.mvp.myapplication.app.App;
import com.example.mvp.myapplication.base.activity.BottomActivity;
import com.example.mvp.myapplication.greedao.ItemDaoBean;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.http.Query;

public class AddActivity extends BottomActivity implements  AddRecyclerViewApdate.OnItemClickListener, View.OnClickListener, CheckBox.OnCheckedChangeListener {


    @BindView(R.id.add_toobar)
    Toolbar mAddToobar;
    @BindView(R.id.rb_editor)
    CheckBox mRbEditor;
    @BindView(R.id.my_re)
    RecyclerView mMyRe;
    @BindView(R.id.delect_re)
    RecyclerView mDelectRe;
    private  boolean mBoolean=false;
    private ArrayList<String> mAdd;
    private ArrayList<String> mRemove;
    private AddRecyclerViewApdate mAddRecyclerViewApdate;
    private ReMoveRecyclerViewApdate mReMoveRecyclerViewApdate;
    private List<ItemDaoBean> mItemDaoBeans;
    private ItemTouchHelper mHelper;
    private int appposition;

    @Override
    public int createLayout() {
        return R.layout.activity_add;
    }

    @Override
    public void origination() {
        setToobar();

        setRecyclerView();
        mRbEditor.setOnCheckedChangeListener(this);
        mAddRecyclerViewApdate.setIButtonRemove(new AddRecyclerViewApdate.IButtonRemove() {
            @Override
            public void reove(Button button, final int p) {
                   button.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           ItemDaoBean itemDaoBean = null;
                           for (int i = 0; i <mItemDaoBeans.size() ; i++) {
                                  if (mItemDaoBeans.get(i).getTitle().equals(mAdd.get(p))){
                                          itemDaoBean=mItemDaoBeans.get(i);
                                          itemDaoBean.setState(false);
                                  }
                           }
                           App.getSession().getItemDaoBeanDao().update(itemDaoBean);
                           mRemove.add(mAdd.get(p));
                             mAdd.remove(p);
                             mReMoveRecyclerViewApdate.notifyDataSetChanged();
                             mAddRecyclerViewApdate.notifyDataSetChanged();

                       }
                   });
            }
        });
        mReMoveRecyclerViewApdate.setOnItemClickListener(new ReMoveRecyclerViewApdate.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                 mItemDaoBeans.get(position).setState(true);
                 ItemDaoBean itemDaoBean=null;
                for (int i = 0; i <mItemDaoBeans.size() ; i++) {
                    if (mItemDaoBeans.get(i).getTitle().equals(mRemove.get(position))) {
                        itemDaoBean=mItemDaoBeans.get(i);
                        itemDaoBean.setState(true);
                    }

                }
                App.getSession().getItemDaoBeanDao().update(itemDaoBean);
                mAdd.add(mRemove.get(position));
                 mAddRecyclerViewApdate.notifyDataSetChanged();
                 mRemove.remove(position);
                 mReMoveRecyclerViewApdate.notifyDataSetChanged();



            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }



    private void setRecyclerView() {
        mHelper = new ItemTouchHelper(getCallback());
        mHelper.attachToRecyclerView(mMyRe);
        mItemDaoBeans = App.getSession().getItemDaoBeanDao().loadAll();

        mAdd = new ArrayList<>();
        mRemove = new ArrayList<>();
        for (int i = 0; i < mItemDaoBeans.size() ; i++) {
            Log.d("tianchenglong", mItemDaoBeans.get(i).getTitle());
            if (mItemDaoBeans.get(i).getState()) {
                mAdd.add(mItemDaoBeans.get(i).getTitle());
            }else {
                mRemove.add(mItemDaoBeans.get(i).getTitle());
            }
        }
        mAddRecyclerViewApdate = new AddRecyclerViewApdate(mAdd,this,mHelper);
        mReMoveRecyclerViewApdate = new ReMoveRecyclerViewApdate(mRemove,this);
        mAddRecyclerViewApdate.setOnItemClickListener(this);
        mMyRe.setLayoutManager(new GridLayoutManager(this,4));
        mDelectRe.setLayoutManager(new GridLayoutManager(this,4));
        mMyRe.setAdapter(mAddRecyclerViewApdate);
        mDelectRe.setAdapter(mReMoveRecyclerViewApdate);
        mAddRecyclerViewApdate.setOnItemClickListener(new AddRecyclerViewApdate.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int position) {
                if (!mBoolean) {
                    Intent intent = getIntent();
                    intent.putExtra("item",position);
                    setResult(100,intent);
                    finish();

                }
                }


            @Override
            public void onItemLongClick(View view, int position) {

            }
        });



    }

    private void setToobar() {
        mAddToobar.setTitle("");
        mAddToobar.setNavigationIcon(R.mipmap.zhongcha);
        setSupportActionBar(mAddToobar);
        mAddToobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                setResult(10);
                finish();
            }
        });
    }



    private ItemTouchHelper.Callback getCallback() {
        return new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                int dragFlags = 0;
                    if (recyclerView.getLayoutManager()instanceof GridLayoutManager) {
                        dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT;
                    }


                return makeMovementFlags(dragFlags, 0);
            }

            @Override
            //拖动之前的viewHolder               //拖动之后的viewHoler
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int form = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(mAdd, form, to);
                int formTow=0;
                int toTow=0;
                for (int i = 0; i <mItemDaoBeans.size() ; i++) {
                      if (mItemDaoBeans.get(i).getTitle().equals(mAdd.get(form))){
                            formTow=i;
                      }else if (mItemDaoBeans.get(i).getTitle().equals(mAdd.get(to))){
                            toTow=i;
                      }
                }
                Collections.swap(mItemDaoBeans,formTow,toTow);
                App.getSession().getItemDaoBeanDao().deleteAll();
                //排序完之后从新插入数据库
                for (int i = 0; i <mItemDaoBeans.size() ; i++) {
                    App.getSession().getItemDaoBeanDao().insert(new ItemDaoBean(null,mItemDaoBeans.get(i).getTitle(),mItemDaoBeans.get(i).getState(),mItemDaoBeans.get(i).getNewsId()));
                }
               mAddRecyclerViewApdate .notifyItemMoved(form, to);
                return false;
            }
            //被拖拽之后的方法可以不用管
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            }

            @Override
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                viewHolder.itemView.setBackgroundColor(0);
            }

            @Override
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                if (actionState !=ItemTouchHelper.ACTION_STATE_IDLE){
                    viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
                }
                super.onSelectedChanged(viewHolder, actionState);

            }

            @Override
            public boolean isLongPressDragEnabled() {

                return false;
            }
        };


    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemLongClick(View view, int position) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked){
                mAddRecyclerViewApdate.setIsdrag(true);
                buttonView.setText("完成");
                mAddRecyclerViewApdate.setIsButton(true);



            }else {
                mAddRecyclerViewApdate.setIsdrag(true);
                buttonView.setText("设置");
                mAddRecyclerViewApdate.setIsButton(false);
            }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      EventBus.getDefault().post(1);
    }

    @Override
    public void onClick(View v) {

    }


}
