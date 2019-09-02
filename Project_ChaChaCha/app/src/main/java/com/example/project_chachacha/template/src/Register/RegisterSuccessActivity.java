package com.example.project_chachacha.template.src.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.Login.LoginActivity;

public class RegisterSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__success);
        getWindow().setStatusBarColor(Color.parseColor("#ff7889"));
        View view = getWindow().getDecorView();
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.M){
            if (view != null) {
                view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
            }

        }

        Button btnLogin = findViewById(R.id.registerSuccess_btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterSuccessActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RegisterSuccessActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
