package com.example.project_chachacha.template.src.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.project_chachacha.R;

public class Register_Success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__success);
        getWindow().setStatusBarColor(Color.parseColor("##FF7889"));
    }
}
