package com.example.project_chachacha.template.src.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.Mypage.Mypage;
import com.example.project_chachacha.template.src.Register.Register_customer;

public class Login extends BaseActivity {

    private Button mbtn_login;
    private TextView mTv_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mbtn_login = findViewById(R.id.login);
        mbtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Mypage.class);
                startActivity(intent);
                finish();
            }
        });

        mTv_signup = findViewById(R.id.register);
        mTv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register_customer.class);
                startActivity(intent);
            }
        });
    }
}
