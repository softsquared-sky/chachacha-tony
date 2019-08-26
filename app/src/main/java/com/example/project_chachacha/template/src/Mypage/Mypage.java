package com.example.project_chachacha.template.src.Mypage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;

public class Mypage extends BaseActivity {

    private FragmentManager fragmentManager;
    private Mypage_main mypage_main;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        fragmentManager = getSupportFragmentManager();

        mypage_main = new Mypage_main();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout,mypage_main).commitAllowingStateLoss();

    }

    public void replaceFragment(Fragment fragment){
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment).commitAllowingStateLoss();
    }
}
