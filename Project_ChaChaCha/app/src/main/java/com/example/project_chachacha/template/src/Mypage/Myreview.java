package com.example.project_chachacha.template.src.Mypage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_chachacha.R;

import java.util.ArrayList;


public class Myreview extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<review_item> arrayList;
    private reviewlist_adapter adapter;
    private LinearLayoutManager linearLayoutManager;

    private ImageView mivback;

    public static Myreview newInstance(){
        return new Myreview();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_myreview, container, false);

        mivback = rootView.findViewById(R.id.back);
        mivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Mypage)getActivity()).replaceFragment(Mypage_main.newInstance());
            }
        });

        recyclerView = (RecyclerView)rootView.findViewById(R.id.review_list);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        adapter = new reviewlist_adapter(arrayList); // 생성에 context필요할수도?

        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return rootView;
    }

}
