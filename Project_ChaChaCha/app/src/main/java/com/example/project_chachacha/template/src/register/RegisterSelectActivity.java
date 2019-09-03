package com.example.project_chachacha.template.src.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.login.LoginActivity;

public class RegisterSelectActivity extends BaseActivity {

    private ImageView mIvBack, mIvBoss, mIvGuest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_select);

        mIvBack = findViewById(R.id.back);
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterSelectActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mIvBoss = findViewById(R.id.registerSelect_iv_boss);
        mIvBoss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterSelectActivity.this, RegisterBossActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mIvGuest = findViewById(R.id.registerSelect_iv_guest);
        mIvGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterSelectActivity.this, RegisterCustomerActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RegisterSelectActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
