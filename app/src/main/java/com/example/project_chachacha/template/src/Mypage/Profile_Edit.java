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


public class Profile_Edit extends Fragment {

    ImageView mIvback;
    TextView mTvcommit;

    public static Profile_Edit newInstance(){
        return new Profile_Edit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile__edit,null);
        mIvback = view.findViewById(R.id.back);
        mIvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Mypage)getActivity()).replaceFragment(Mypage_main.newInstance());
            }
        });
        mTvcommit = view.findViewById(R.id.commit);
        // Inflate the layout for this fragment
        return view;
//        return inflater.inflate(R.layout.fragment_profile__edit, container, false);
    }

}
