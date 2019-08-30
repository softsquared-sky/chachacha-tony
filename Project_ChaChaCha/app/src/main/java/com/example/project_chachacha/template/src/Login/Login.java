package com.example.project_chachacha.template.src.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.CustomDialog_btn1;
import com.example.project_chachacha.template.src.Login.Interfaces.LoginView;
import com.example.project_chachacha.template.src.Mypage.Mypage;
import com.example.project_chachacha.template.src.Register.Register_customer;
import com.example.project_chachacha.template.src.Register.Register_select;

import static com.example.project_chachacha.template.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.project_chachacha.template.src.ApplicationClass._USERID;
import static com.example.project_chachacha.template.src.ApplicationClass.sSharedPreferences;
import static com.example.project_chachacha.template.src.ApplicationClass.sharedPreferences;

public class Login extends BaseActivity implements LoginView {

    private Button mbtn_login;
    private TextView mTv_signup;
    private EditText userid, userpw;
    private Switch auto;

    private CustomDialog_btn1 mCustomDialog_btn1;

    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final LoginService loginService = new LoginService(this);

        userid = findViewById(R.id.userid);
        userpw = findViewById(R.id.userpw);
        userpw.setImeOptions(EditorInfo.IME_ACTION_DONE);
        userpw.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i==EditorInfo.IME_ACTION_DONE || keyEvent.getKeyCode()==KeyEvent.KEYCODE_ENTER){
                    loginService.getLogin(userid.getText().toString(), userpw.getText().toString());
                    return true;
                }
                return false;
            }
        });

        auto = findViewById(R.id.autoswitch);


        mbtn_login = findViewById(R.id.login);
        mbtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginService.getLogin(userid.getText().toString(), userpw.getText().toString());
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


    @Override
    public void validateSuccess(int code, String message, String jwt) {
        System.out.println("code: " + code);
        X_ACCESS_TOKEN = jwt;
        System.out.println(X_ACCESS_TOKEN);
        SharedPreferences.Editor editor2 = sSharedPreferences.edit();
        editor2.putString("token", X_ACCESS_TOKEN);
        editor2.commit();

        sharedPreferences = getSharedPreferences("Auto", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean check = auto.isChecked();
        editor.putBoolean("check",check);
        editor.putString("userid", userid.getText().toString());
        editor.commit();
        _USERID = userid.getText().toString();
        Intent intent = new Intent(Login.this, Mypage.class);
//        intent.putExtra("userid", userid.getText().toString());
        startActivity(intent);
        finish();
    }

    @Override
    public void validateFailure(int code, String message) {
        System.out.println(code + " " +message);
        msg= message;
        switch (code){
            case 114:
                msg="아이디 또는 패스워드가 올바르지 않습니다.\n다시 입력해주세요.";
                userid.setText("");
                userpw.setText("");
                userid.requestFocus();
                break;
            case 111:
                msg="아이디를 입력해주세요.";
                userid.setText("");
                userid.requestFocus();
                break;
            case 112:
                msg="비밀번호를 입력해주세요.";
                userpw.setText("");
                userpw.requestFocus();
                break;
        }

        mCustomDialog_btn1 = new CustomDialog_btn1(this, msg);
        mCustomDialog_btn1.setCancelable(false);
        mCustomDialog_btn1.show();
    }
}
