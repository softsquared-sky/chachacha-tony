package com.example.project_chachacha.template.src.Mypage.StoreShop;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.Mypage.Mypage;
import com.example.project_chachacha.template.src.Mypage.Mypage_main;

import java.util.ArrayList;


public class StoreShop extends Fragment {

    private RecyclerView recyclerView;
    private StoreShop_adapter adapter;
    private ArrayList<StoreShop_item> arrayList;

    private ImageView mivback;

    public static StoreShop newInstance(){
        return new StoreShop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_store_shop, container, false);

        mivback = rootView.findViewById(R.id.back);
        mivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Mypage)getActivity()).replaceFragment(Mypage_main.newInstance());
            }
        });

        recyclerView = (RecyclerView)rootView.findViewById(R.id.rv_store_shop);
        arrayList = new ArrayList<>();

        arrayList.add(new StoreShop_item("민혁이네 외국포차", "#와인 #새우 #친구와 함께"));

        adapter = new StoreShop_adapter(getContext(),arrayList);
        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return rootView;
    }

}
