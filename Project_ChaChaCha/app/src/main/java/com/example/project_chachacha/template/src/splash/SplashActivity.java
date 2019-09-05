package com.example.project_chachacha.template.src.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.CustomDialogOneButton;
import com.example.project_chachacha.template.src.login.LoginActivity;
import com.example.project_chachacha.template.src.myPage.MypageActivity;
import com.example.project_chachacha.template.src.splash.Interfaces.SplashView;

import static com.example.project_chachacha.template.src.ApplicationClass.USERID;
import static com.example.project_chachacha.template.src.ApplicationClass.sSharedPreferences;

public class SplashActivity extends BaseActivity implements SplashView {

    private boolean auto = false;
    private String mStrUserId;

    private CustomDialogOneButton mCustomDialogOneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();

        final SplashService splashService = new SplashService(this);

        auto = sSharedPreferences.getBoolean("check", false);
        mStrUserId = sSharedPreferences.getString("userId", "");
        if(auto){
            splashService.getCheckToken(mStrUserId);
        }
        else{
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//            },500);
        }

    }


    @Override
    public void validateSuccess(int code) {
        USERID = mStrUserId;
        Intent intent = new Intent(SplashActivity.this, MypageActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void validateFailure(int code) {
        String msg = "자동로그인이 만료되었습니다.\n다시 로그인해주세요.";
        mCustomDialogOneButton = new CustomDialogOneButton(SplashActivity.this, msg);
        mCustomDialogOneButton.setCancelable(false);
        mCustomDialogOneButton.show();
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
