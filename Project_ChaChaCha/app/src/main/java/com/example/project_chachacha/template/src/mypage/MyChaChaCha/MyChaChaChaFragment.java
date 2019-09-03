package com.example.project_chachacha.template.src.mypage.MyChaChaCha;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_chachacha.R;

import java.util.ArrayList;

public class MyChaChaChaFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyChaChaChaListAdapter adapter;
    private ArrayList<MyChaChaChaItemData> arrayList;
    private GridLayoutManager gridLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_my_cha_cha_cha, container, false);

        arrayList = new ArrayList<>();

        arrayList.add(new MyChaChaChaItemData("https://ifh.cc/g/Qslvb.jpg","내용1"));
        arrayList.add(new MyChaChaChaItemData("https://ifh.cc/g/Qslvb.jpg","내용2"));
        arrayList.add(new MyChaChaChaItemData("https://ifh.cc/g/Qslvb.jpg","내용3"));
        arrayList.add(new MyChaChaChaItemData("https://ifh.cc/g/Qslvb.jpg","내용4"));

        recyclerView = rootview.findViewById(R.id.myChaChaCha_rv_list);
        adapter = new MyChaChaChaListAdapter(getContext(), arrayList);

        gridLayoutManager = new GridLayoutManager(getContext(), 2);

        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootview;
    }


}
