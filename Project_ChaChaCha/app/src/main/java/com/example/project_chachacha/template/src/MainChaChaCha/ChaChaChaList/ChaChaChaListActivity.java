package com.example.project_chachacha.template.src.MainChaChaCha.ChaChaChaList;

import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.Mypage.StoreShop.StoreShopItemData;

import java.util.ArrayList;

public class ChaChaChaListActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private ChaChaChaListAdapter adapter;
    private ArrayList<StoreShopItemData> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cha_cha_cha2);

        arrayList = new ArrayList<>();

        recyclerView = findViewById(R.id.rvchachacha);
        adapter = new ChaChaChaListAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);
    }
}
