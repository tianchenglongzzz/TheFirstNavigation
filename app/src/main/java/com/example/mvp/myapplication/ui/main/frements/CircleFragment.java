package com.example.mvp.myapplication.ui.main.frements;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CircleFragment extends Fragment {


    public CircleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_circle, container, false);
    }

}
