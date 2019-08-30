package com.example.project_chachacha.template.src.ShopInfo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_chachacha.R;

import java.util.ArrayList;

public class Review extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Shop_review_data> arrayList;
    private Shop_review_adapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_review, container, false);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.rvreview);

        arrayList = new ArrayList<>();

        arrayList.add(new Shop_review_data("장승민", "4", "여기 진짜 맛집"));

        adapter = new Shop_review_adapter(getActivity(),arrayList); // 생성에 context필요할수도?

        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return rootView;
    }


}
