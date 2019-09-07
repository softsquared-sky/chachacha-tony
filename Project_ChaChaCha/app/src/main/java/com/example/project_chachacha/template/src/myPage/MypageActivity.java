package com.example.project_chachacha.template.src.myPage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.mainChaChaCha.chachachaSelect.ChachachaActivity;
import com.example.project_chachacha.template.src.myPage.MyChaChaCha.MyChaChaChaFragment;
import com.example.project_chachacha.template.src.myPage.MyPageMain.MypageMainFragment;
import com.example.project_chachacha.template.src.myPage.Search.SearchFragment;

public class MypageActivity extends BaseActivity {

    private FragmentManager fragmentManager;
    private MypageMainFragment mMypageMainFragment;
    private SearchFragment mSearchFragment;
    private MyChaChaChaFragment mMyChaChaChaFragment;
    private FragmentTransaction transaction;
    private ImageView mIvStart, mIvSearch, mIvMain, mIvMychachacha;

    private String userid;
    private boolean checkMyCha;

    private long pressedTime = 0;

//    public static ProfileEditFragment profile_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

//        Intent intent = getIntent();
//        userid = intent.getStringExtra("userid");

        Intent intent = getIntent();
        checkMyCha = intent.getBooleanExtra("checkMyCha",false);

        mIvStart = findViewById(R.id.myPage_iv_chaStart);
        mIvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, ChachachaActivity.class);
                startActivity(intent);
            }
        });

        mIvSearch = findViewById(R.id.myPage_iv_search);
        mIvMain = findViewById(R.id.myPage_iv_main);
        mIvMychachacha = findViewById(R.id.myPage_iv_mychachacha);


        fragmentManager = getSupportFragmentManager();

        mMypageMainFragment = new MypageMainFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("userid", userid);
//        mMypageMainFragment.setArguments(bundle);
        mSearchFragment = new SearchFragment();
        mMyChaChaChaFragment = new MyChaChaChaFragment();

        transaction = fragmentManager.beginTransaction();
        if(!checkMyCha){
            transaction.replace(R.id.myPage_frameLayout, mMypageMainFragment).commitAllowingStateLoss();
        }
        else{
            transaction.replace(R.id.myPage_frameLayout, mMyChaChaChaFragment).commitAllowingStateLoss();
            mIvSearch.setImageResource(R.drawable.ic_msg);
            mIvMain.setImageResource(R.drawable.ic_empty_mypage);
            mIvMychachacha.setImageResource(R.drawable.ic_red_like);
        }


    }

    public interface OnBackPressedListener {
        void onBack();
    }

    private OnBackPressedListener mBackListener;

    public void setOnBackPressedListener(OnBackPressedListener listener){
        mBackListener=listener;
    }

    @Override
    public void onBackPressed() {
        if(!checkMyCha){
            if(mBackListener !=null){
                mBackListener.onBack();
            }
            else{
                if(pressedTime == 0){
                    Toast.makeText(getApplicationContext(),"한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
                    pressedTime = System.currentTimeMillis();
                }
                else{
                    int seconds = (int) (System.currentTimeMillis()-pressedTime);
                    if(seconds>2000){
                        Toast.makeText(getApplicationContext(),"한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
                        pressedTime =0;
                    }
                    else{
                        super.onBackPressed();
                        finish();
                    }
                }
            }
        }
        else{
            finish();
        }
    }

    //    @Override
//    public void onBackPressed() { // 리뷰, 저장술집에 대해서도 추가
//        if(profile_edit!=null){
//            getSupportFragmentManager().beginTransaction().remove(profile_edit).commit();
//            profile_edit=null;
//            replaceFragment(MypageMainFragment.newInstance());
//        }
//        else{
//            super.onBackPressed();
//        }
//    }

    public void replaceFragment(Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.myPage_frameLayout, fragment).commitAllowingStateLoss();
    }

    public void tabClick(View v) {

        transaction = fragmentManager.beginTransaction();

        switch (v.getId()) {
            case R.id.myPage_iv_search:
                mIvSearch.setImageResource(R.drawable.ic_red_msg);
                mIvMain.setImageResource(R.drawable.ic_empty_mypage);
                mIvMychachacha.setImageResource(R.drawable.ic_like);
                transaction.replace(R.id.myPage_frameLayout, mSearchFragment).commitAllowingStateLoss();
                break;
            case R.id.myPage_iv_main:
                mIvSearch.setImageResource(R.drawable.ic_msg);
                mIvMain.setImageResource(R.drawable.ic_mypage);
                mIvMychachacha.setImageResource(R.drawable.ic_like);
                transaction.replace(R.id.myPage_frameLayout, mMypageMainFragment).commitAllowingStateLoss();
                break;
            case R.id.myPage_iv_mychachacha:
                mIvSearch.setImageResource(R.drawable.ic_msg);
                mIvMain.setImageResource(R.drawable.ic_empty_mypage);
                mIvMychachacha.setImageResource(R.drawable.ic_red_like);
                transaction.replace(R.id.myPage_frameLayout, mMyChaChaChaFragment).commitAllowingStateLoss();
                break;
        }
    }
}
