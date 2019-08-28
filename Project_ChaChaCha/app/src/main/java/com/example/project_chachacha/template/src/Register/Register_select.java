package com.example.project_chachacha.template.src.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.Login.Login;

public class Register_select extends AppCompatActivity {

    private ImageView mivback;
    private Button btn1, btn2; // 임시

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_select);

        mivback = findViewById(R.id.back);
        mivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_select.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

        btn1 = findViewById(R.id.boss);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_select.this, Register_boss.class);
                startActivity(intent);
                finish();
            }
        });

        btn2 = findViewById(R.id.guest);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_select.this, Register_customer.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Register_select.this, Login.class);
        startActivity(intent);
        finish();
    }
}
