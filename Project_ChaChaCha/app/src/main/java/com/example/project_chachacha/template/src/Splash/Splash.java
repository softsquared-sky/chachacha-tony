package com.example.project_chachacha.template.src.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.Login.Login;
import com.example.project_chachacha.template.src.Mypage.Mypage;

public class Splash extends BaseActivity {

    private boolean auto = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();

        SharedPreferences sf = getSharedPreferences("Auto",MODE_PRIVATE);
        auto = sf.getBoolean("check", false);
        if(auto==true){
            SharedPreferences AutoLoginCheck = getSharedPreferences("autologincheck",MODE_PRIVATE);
            SharedPreferences.Editor editor = AutoLoginCheck.edit();
            editor.putBoolean("autologin",true);
            editor.commit(); // 화면이 자동로그인으로 넘어왔는지 로그인에서 넘어왔는지 체크
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Splash.this, Mypage.class);
                    startActivity(intent);
                    finish();
                }
            },500);
        }
        else{
            SharedPreferences AutoLoginCheck = getSharedPreferences("autologincheck",MODE_PRIVATE);
            SharedPreferences.Editor editor = AutoLoginCheck.edit();
            editor.putBoolean("autologin",false);
            editor.commit();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Splash.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            },500);
        }

    }


}
