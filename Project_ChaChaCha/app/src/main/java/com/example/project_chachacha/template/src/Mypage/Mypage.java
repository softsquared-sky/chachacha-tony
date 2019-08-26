package com.example.project_chachacha.template.src.Mypage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.MainChaChaCha.Chachacha;

public class Mypage extends BaseActivity {

    private FragmentManager fragmentManager;
    private Mypage_main mypage_main;
    private FragmentTransaction transaction;
    private ImageView mivstart;
    private ImageView search, page, mychachacha;
    private Search _search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        mivstart = findViewById(R.id.chastart);
        mivstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mypage.this, Chachacha.class);
                startActivity(intent);
            }
        });

        search = findViewById(R.id.search);
        page = findViewById(R.id.page);
        mychachacha = findViewById(R.id.mychachacha);


        fragmentManager = getSupportFragmentManager();

        mypage_main = new Mypage_main();
        _search = new Search();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout,mypage_main).commitAllowingStateLoss();

    }

    public void replaceFragment(Fragment fragment){
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment).commitAllowingStateLoss();
    }

    public void tabClick(View v){

        transaction = fragmentManager.beginTransaction();

        switch (v.getId()){
            case R.id.search:
                search.setImageResource(R.drawable.ic_red_msg);
                page.setImageResource(R.drawable.ic_empty_mypage);
                mychachacha.setImageResource(R.drawable.ic_like);
                transaction.replace(R.id.frame_layout, _search).commitAllowingStateLoss();
                break;
            case R.id.page:
                search.setImageResource(R.drawable.ic_msg);
                page.setImageResource(R.drawable.ic_mypage);
                mychachacha.setImageResource(R.drawable.ic_like);
                transaction.replace(R.id.frame_layout, mypage_main).commitAllowingStateLoss();
                break;
            case R.id.mychachacha:
                search.setImageResource(R.drawable.ic_msg);
                page.setImageResource(R.drawable.ic_empty_mypage);
                mychachacha.setImageResource(R.drawable.ic_red_like);
                break;
        }
    }
}
