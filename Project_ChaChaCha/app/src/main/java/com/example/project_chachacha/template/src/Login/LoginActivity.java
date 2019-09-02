package com.example.project_chachacha.template.src.Login;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.project_chachacha.template.src.CustomDialogOneButton;
import com.example.project_chachacha.template.src.Login.Interfaces.LoginView;
import com.example.project_chachacha.template.src.Mypage.MypageActivity;
import com.example.project_chachacha.template.src.Register.RegisterSelectActivity;

import static com.example.project_chachacha.template.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.project_chachacha.template.src.ApplicationClass.USERID;
import static com.example.project_chachacha.template.src.ApplicationClass.sSharedPreferences;

public class LoginActivity extends BaseActivity implements LoginView {

    private EditText mEdtUserId, mEdtUserPw;
    private Switch mSwtAuto;
    private SharedPreferences.Editor editor = sSharedPreferences.edit();

    private LoginService mLoginService = new LoginService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEdtUserId = findViewById(R.id.login_edt_userId);
        mEdtUserPw = findViewById(R.id.login_edt_userPw);
        mEdtUserPw.setImeOptions(EditorInfo.IME_ACTION_DONE);
        mEdtUserPw.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE || keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    login();
                    return true;
                }
                return false;
            }
        });

        mSwtAuto = findViewById(R.id.login_swt_autoCheck);


        Button btnLogin = findViewById(R.id.login_btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        TextView tvSignUp = findViewById(R.id.login_tv_register);
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterSelectActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void login() {
        String mStrUserId = mEdtUserId.getText().toString();
        String mStrUserPw = mEdtUserPw.getText().toString();
        mLoginService.postLogin(mStrUserId, mStrUserPw);
    }


    @Override
    public void validateSuccess(int code, String message, String jwt) {
        System.out.println("code: " + code);
        X_ACCESS_TOKEN = jwt;
        System.out.println(X_ACCESS_TOKEN);
        editor.putString("token", X_ACCESS_TOKEN);
        editor.putString("userId", mEdtUserId.getText().toString());
        editor.putBoolean("check",mSwtAuto.isChecked());
        editor.apply();

//        sharedPreferences = getSharedPreferences("Auto", MODE_PRIVATE); // 하나로 위에랑 합치기
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        boolean check = mSwtAuto.isChecked();
//        editor.putBoolean("check", check);
//        editor.putString("userid", mEdtUserId.getText().toString());
//        editor.apply();
        USERID = mEdtUserId.getText().toString();
        Intent intent = new Intent(LoginActivity.this, MypageActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void validateFailure(int code, String message) {
        System.out.println(code + " " + message);
        String mStrMsg = message;
        switch (code) {
            case 114:
                mStrMsg = "아이디 또는 패스워드가 올바르지 않습니다.\n다시 입력해주세요.";
                mEdtUserId.setText("");
                mEdtUserPw.setText("");
                mEdtUserId.requestFocus();
                break;
            case 111:
                mStrMsg = "아이디를 입력해주세요.";
                mEdtUserId.setText("");
                mEdtUserId.requestFocus();
                break;
            case 112:
                mStrMsg = "비밀번호를 입력해주세요.";
                mEdtUserPw.setText("");
                mEdtUserPw.requestFocus();
                break;
        }

        CustomDialogOneButton customDialogOneButton = new CustomDialogOneButton(this, mStrMsg);
        customDialogOneButton.setCancelable(false);
        customDialogOneButton.show();
    }
}
