package com.example.project_chachacha.template.src.Mypage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_chachacha.R;


public class Mypage_main extends Fragment {

    TextView mTvEdit;
    ImageView mIvreview;

    public static Mypage_main newInstance(){
        return new Mypage_main();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mypage_main,null);
        mTvEdit = (TextView)view.findViewById(R.id.edit);
        mTvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Mypage)getActivity()).replaceFragment(Profile_Edit.newInstance());
            }
        });

        mIvreview = (ImageView)view.findViewById(R.id.myreview);
        mIvreview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ((Mypage)getActivity()).replaceFragment(Myreview.newInstance());
            }
        });
        // Inflate the layout for this fragment
        return view;
//        return inflater.inflate(R.layout.fragment_mypage_main, container, false);
    }



}
