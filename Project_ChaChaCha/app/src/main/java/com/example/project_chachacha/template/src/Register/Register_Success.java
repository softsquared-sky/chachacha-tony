package com.example.project_chachacha.template.src.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.Login.Login;

public class Register_Success extends AppCompatActivity {

    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__success);
        getWindow().setStatusBarColor(Color.parseColor("#FF7889"));

        login = findViewById(R.id.goto_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_Success.this, Login.class);
                startActivity(intent);
                finish();
                finish();
            }
        });
    }
}
