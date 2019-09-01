package com.example.project_chachacha.template.src.Register;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.CustomDialogOneButton;
import com.example.project_chachacha.template.src.Register.Interfaces.RegisterView;

import java.util.Timer;
import java.util.TimerTask;

public class RegisterBossActivity extends BaseActivity implements RegisterView {

    private EditText mEdtUserId, mEdtUserPw, mEdtUserPwCheck, mEdtName, mEdtPhone;
    private boolean CheckPw = false;

    private CustomDialogOneButton mCustomDialogOneButton;

    private View viewUserPwCheckLine;
    private TextView mTvPwComment;

    private Timer timer = new Timer();

    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_boss);

        mEdtUserId = findViewById(R.id.registerBoss_edt_userId);
        mEdtUserPw = findViewById(R.id.registerBoss_edt_userPw);
        mEdtUserPwCheck = findViewById(R.id.registerBoss_edt_userPwCheck);
        mEdtName = findViewById(R.id.registerBoss_edt_name);
        mEdtPhone = findViewById(R.id.registerBoss_edt_phone);

        viewUserPwCheckLine = findViewById(R.id.registerBoss_view_userPwCheck);

        mTvPwComment = findViewById(R.id.registerBoss_tv_pwComment);

//        btnCheck = findViewById(R.id.CheckPw);
//        btnCheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(mEdtUserPw.getText().toString().equals(mEdtUserPwCheck.getText().toString())){
//                    CheckPw=true; // 비밀번호 형식이 일치하지 않으면 다시 false로
//                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterBossActivity.this, "비밀번호가 일치합니다.");
//                    mCustomDialogOneButton.setCancelable(false);
//                    mCustomDialogOneButton.show();
//                }
//                else{
//                    mEdtUserPw.setText("");
//                    mEdtUserPwCheck.setText("");
//                    mEdtUserPw.requestFocus();
//                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterBossActivity.this, "비밀번호가 일치하지 않습니다.");
//                    mCustomDialogOneButton.setCancelable(false);
//                    mCustomDialogOneButton.show();
//                }
//            }
//        });

        ImageView mIvBack = findViewById(R.id.registerBoss_iv_next);
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterBossActivity.this, RegisterSelectActivity.class);
                startActivity(intent);
                finish();
            }
        });

        final RegisterService registerService = new RegisterService(this);

        Button mBtnNext = findViewById(R.id.registerBoss_btn_next);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CheckPw){
                    registerService.postBoss(mEdtUserId.getText().toString(), mEdtUserPw.getText().toString(),
                            mEdtName.getText().toString(), mEdtPhone.getText().toString());
                }
                else{
                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterBossActivity.this, "비밀번호 확인을 눌러주세요.");
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                }
            }
        });

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                RegisterBossActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(mEdtUserPw.getText().toString().equals("")){
                            viewUserPwCheckLine.setBackground(getDrawable(R.drawable.style3));
                            mTvPwComment.setText("비밀번호를 입력해주세요.");
                            mTvPwComment.setTextColor(Color.parseColor("#99FF0000"));
                            CheckPw =false;
                        }
                        else{
                            if(mEdtUserPw.getText().toString().equals(mEdtUserPwCheck.getText().toString())){
                                viewUserPwCheckLine.setBackground(getDrawable(R.drawable.style3));
                                mTvPwComment.setText("비밀번호가 일치합니다.");
                                mTvPwComment.setTextColor(Color.parseColor("#00bfff"));
                                CheckPw =true;
                            }
                            else{
                                viewUserPwCheckLine.setBackground(getDrawable(R.drawable.style8));
                                mTvPwComment.setText("비밀번호가 일치하지 않습니다.");
                                mTvPwComment.setTextColor(Color.parseColor("#99FF0000"));
                                CheckPw =false;
                            }
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask,0,50);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RegisterBossActivity.this, RegisterSelectActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void validateSuccess(int code, String message) {
        System.out.println(message);
        if(code==100){
            Intent intent = new Intent(RegisterBossActivity.this, RegisterSuccessActivity.class);
            startActivity(intent);
            finish();
        }
        else{ // 에러코드 정리되면 수정
            switch (code){
                case 101:
                    msg = "중복된 아이디입니다.\n다시 입력해주세요.";
                    mEdtUserId.setText("");
                    mEdtUserId.requestFocus();
                    break;
                case 103:
                    msg = "잘못된 이름 형식입니다.\n한글로 입력해주세요.";
                    mEdtName.setText("");
                    mEdtName.requestFocus();
                    break;
                case 104:
                    msg = "잘못된 비밀번호 형식입니다.\n영어,숫자 및 특수문자조합으로\n8자리이상 15자리이하로 입력해주세요.";
                    mEdtUserPw.setText("");
                    mEdtUserPwCheck.setText("");
                    mEdtUserPw.requestFocus();
                    break;
                case 106:
                    msg = "잘못된 전화번호 형식입니다,\n올바른 형식으로 입력해주세요.";
                    mEdtPhone.setText("");
                    mEdtPhone.requestFocus();
                    break;
                case 109:
                    msg = "모든 항목을 입력해주세요.";
                    break;
                case 110:
                    msg = "잘못된 아이디 형식입니다.\n영소문자,숫자 조합으로\n4자리 이상 10자리로 입력해주세요.";
                    mEdtUserId.setText("");
                    mEdtUserId.requestFocus();
                    break;

            }
            mCustomDialogOneButton = new CustomDialogOneButton(this, msg);
            mCustomDialogOneButton.setCancelable(false);
            mCustomDialogOneButton.show();
        }

    }

    @Override
    public void validateFailure(int code, String message) {
        System.out.println(message);
    }

    @Override
    protected void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }
}
