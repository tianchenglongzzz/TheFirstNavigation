package com.example.mvp.myapplication.ui.my.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvp.myapplication.R;
import com.example.mvp.myapplication.base.activity.BottomActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonalProfileActivity extends BottomActivity implements TextWatcher {

    @BindView(R.id.ppf_enter)
    TextView mPpfEnter;
    @BindView(R.id.ppf_toolbar)
    Toolbar mPpfToolbar;
    @BindView(R.id.ppf_edit)
    EditText mPpfEdit;
    @BindView(R.id.ppf_count_tv)
    TextView mPpfCountTv;



    @Override
    public int createLayout() {
        return R.layout.activity_personal_profile;

    }

    @Override
    public void origination() {
        setToobar(mPpfToolbar);
        mPpfEdit.addTextChangedListener(this);
    }

    @OnClick({R.id.ppf_enter, R.id.ppf_toolbar, R.id.ppf_edit, R.id.ppf_count_tv})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.ppf_enter:
                Intent intent = getIntent();
                intent.putExtra("text",mPpfEdit.getText().toString());
                setResult(20,intent);
                finish();
                break;
            case R.id.ppf_toolbar:
                break;
            case R.id.ppf_edit:
                break;
            case R.id.ppf_count_tv:
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        int length = s.toString().length();
        mPpfCountTv.setText(length+"");
    }
}
