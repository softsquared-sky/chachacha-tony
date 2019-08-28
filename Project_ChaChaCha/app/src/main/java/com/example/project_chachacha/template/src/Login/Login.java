package com.example.project_chachacha.template.src.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.Mypage.Mypage;
import com.example.project_chachacha.template.src.Register.Register_customer;
import com.example.project_chachacha.template.src.Register.Register_select;

public class Login extends BaseActivity {

    private Button mbtn_login;
    private TextView mTv_signup;
    private EditText userid, userpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userid = findViewById(R.id.userid);
        userpw = findViewById(R.id.userpw);
        userpw.setImeOptions(EditorInfo.IME_ACTION_DONE);
        userpw.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i==EditorInfo.IME_ACTION_DONE || keyEvent.getKeyCode()==KeyEvent.KEYCODE_ENTER){
                    Intent intent = new Intent(Login.this, Mypage.class);
                    startActivity(intent);
                    finish();
                    return true;
                }
                return false;
            }
        });

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
                Intent intent = new Intent(Login.this, Register_select.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
