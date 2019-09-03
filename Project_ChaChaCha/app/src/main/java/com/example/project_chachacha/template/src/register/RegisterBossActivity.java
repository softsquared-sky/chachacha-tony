package com.example.project_chachacha.template.src.register;

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
import com.example.project_chachacha.template.src.register.Interfaces.RegisterView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

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
                String userId = mEdtUserId.getText().toString();
                String userPw = mEdtUserPw.getText().toString();
                String userPwCheck = mEdtUserPwCheck.getText().toString();
                String userName = mEdtName.getText().toString();
                String userPhone = mEdtPhone.getText().toString();
                if(userId.equals("")||userPw.equals("")||userPwCheck.equals("")||userName.equals("")||
                        userPhone.equals("")){
                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterBossActivity.this, "모든 항목을 입력해주세요.");
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                }
                else if(!Pattern.matches("^[a-z0-9]{4,10}$",userId)){
                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterBossActivity.this, "아이디가 올바르지 않습니다.");
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                    mEdtUserId.setText("");
                    mEdtUserId.requestFocus();
                }
                else if(!CheckPw){
                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterBossActivity.this, "비밀번호가 올바르지 않습니다.");
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                    mEdtUserPw.setText("");
                    mEdtUserPwCheck.setText("");
                    mEdtUserPw.requestFocus();
                }
                else if(!Pattern.matches("^[가-힣]{2,5}$",userName)){
                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterBossActivity.this, "이름을 올바르게 입력해주세요.");
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                    mEdtName.setText("");
                    mEdtName.requestFocus();
                }
                else if(!Pattern.matches("^01([0|1|6|7|8|9][0-9]{3,4}[0-9]{4})$",userPhone)){
                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterBossActivity.this, "전화번호를 올바르게 입력해주세요.");
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                    mEdtPhone.setText("");
                    mEdtPhone.requestFocus();
                }
                else{
                    registerService.postBoss(mEdtUserId.getText().toString(), mEdtUserPw.getText().toString(),
                            mEdtName.getText().toString(), mEdtPhone.getText().toString());
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
                            if(!Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{8,15}$", mEdtUserPw.getText().toString())){
                                mTvPwComment.setText("비밀번호가 올바른형식이 아닙니다.\n영어,특수문자,숫자 조합으로 8자리이상 15자리이하입니다.");
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

        final int success = 100;
        final int DuplicateID = 101;
        final int InvalidName = 103;
        final int InvalidPw = 104;
        final int InvalidPhone = 106;
        final int EmptyText = 109;
        final int InvalidID = 110;

        if(code==success){
            Intent intent = new Intent(RegisterBossActivity.this, RegisterSuccessActivity.class);
            startActivity(intent);
            finish();
        }
        else{ // 에러코드 정리되면 수정
            switch (code){
                case DuplicateID:
                    msg = "중복된 아이디입니다.\n다시 입력해주세요.";
                    mEdtUserId.setText("");
                    mEdtUserId.requestFocus();
                    break;
                case InvalidName:
                    msg = "잘못된 이름 형식입니다.\n한글로 입력해주세요.";
                    mEdtName.setText("");
                    mEdtName.requestFocus();
                    break;
                case InvalidPw:
                    msg = "잘못된 비밀번호 형식입니다.\n영어,숫자 및 특수문자조합으로\n8자리이상 15자리이하로 입력해주세요.";
                    mEdtUserPw.setText("");
                    mEdtUserPwCheck.setText("");
                    mEdtUserPw.requestFocus();
                    break;
                case InvalidPhone:
                    msg = "잘못된 전화번호 형식입니다,\n올바른 형식으로 입력해주세요.";
                    mEdtPhone.setText("");
                    mEdtPhone.requestFocus();
                    break;
                case EmptyText:
                    msg = "모든 항목을 입력해주세요.";
                    break;
                case InvalidID:
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
