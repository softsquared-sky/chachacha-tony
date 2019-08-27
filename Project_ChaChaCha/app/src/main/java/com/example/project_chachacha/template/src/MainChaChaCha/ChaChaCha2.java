package com.example.project_chachacha.template.src.MainChaChaCha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.Mypage.StoreShop.StoreShop_item;

import java.util.ArrayList;

public class ChaChaCha2 extends BaseActivity {

    private RecyclerView recyclerView;
    private ChaChaCha2_adapter adapter;
    private ArrayList<StoreShop_item> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cha_cha_cha2);

        arrayList = new ArrayList<>();
        arrayList.add(new StoreShop_item("상수리바", "#조용한 #한잔하기 좋은"));

        recyclerView = findViewById(R.id.rvchachacha);
        adapter = new ChaChaCha2_adapter(this, arrayList);
        recyclerView.setAdapter(adapter);
    }
}
