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
import java.util.regex.Matcher;

public class RegisterCustomerActivity extends BaseActivity implements RegisterView {

    private Button mBtnAge1, mBtnAge2, mBtnAge3, mBtnAge4, mBtnGenderWoman, mBtnGenderMan;
    private EditText mEdtUserId, mEdtUserPw, mEdtUserPwCheck, mEdtName, mEdtEmail, mEdtPhone;
    private int age = 10, gender=10;
    private View viewUserPwCheckLine;
    private TextView mTvPwComment;

    private Timer timer = new Timer();

    private boolean CheckPw =false;
    private boolean CheckAge = false; // 서버통신 최소화를 위해서 넘기기 전에 관리
    private boolean CheckGender = false;
    private String mStrMsg;

    private CustomDialogOneButton mCustomDialogOneButton;

    Matcher matcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_customer);

        mEdtUserId = findViewById(R.id.register_edt_userId);
        mEdtUserPw = findViewById(R.id.register_edt_userPw);
        mEdtUserPwCheck = findViewById(R.id.register_edt_userPwCheck);
        mEdtName = findViewById(R.id.register_edt_name);
        mEdtEmail = findViewById(R.id.register_edt_email);
        mEdtPhone = findViewById(R.id.register_edt_phone);

        mBtnAge1 = findViewById(R.id.register_btn_age1);
        mBtnAge2 = findViewById(R.id.register_btn_age2);
        mBtnAge3 = findViewById(R.id.register_btn_age3);
        mBtnAge4 = findViewById(R.id.register_age_btn4);
        mBtnGenderWoman = findViewById(R.id.register_btn_genderWoman);
        mBtnGenderMan = findViewById(R.id.register_btn_genderMan);

        viewUserPwCheckLine = findViewById(R.id.register_view_userPwCheck);

        mTvPwComment = findViewById(R.id.register_tv_pwComment);

        //나중에 비밀번호호 패턴검사 가하면 추가


//        mbtnPwcheck = findViewById(R.id.CheckPw);
//        mbtnPwcheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{8,15}$";
////                matcher = Pattern.compile(pwPattern).matcher(mEdtUserPw.getText().toString());
////                if(!matcher.matches()){
////                    mStrMsg = "잘못된 비밀번호 형식입니다.\n영어,숫자 및 특수문자조합으로\n8자리이상 15자리이하로 입력해주세요.";
////                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterCustomerActivity.this, mStrMsg);
////                    mCustomDialogOneButton.setCancelable(false);
////                    mCustomDialogOneButton.show();
////                    mEdtUserPw.setText("");
////                    mEdtUserPwCheck.setText("");
////                    mEdtUserPw.requestFocus();
////                }
////                else {
//                if(mEdtUserPw.getText().toString().equals("")){
//                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterCustomerActivity.this, "비밀번호를 입력해주세요.");
//                    mCustomDialogOneButton.setCancelable(false);
//                    mCustomDialogOneButton.show();
//                    mEdtUserPw.setText("");
//                    mEdtUserPwCheck.setText("");
//                    mEdtUserPw.requestFocus();
//                }
//                else{
//                    if(mEdtUserPw.getText().toString().equals(mEdtUserPwCheck.getText().toString())){
//                        CheckPw=true; // 비밀번호 형식이 일치하지 않으면 다시 false로
//                        mCustomDialogOneButton = new CustomDialogOneButton(RegisterCustomerActivity.this, "비밀번호가 일치합니다.");
//                        mCustomDialogOneButton.setCancelable(false);
//                        mCustomDialogOneButton.show();
//                    }
//                    else{
//                        mCustomDialogOneButton = new CustomDialogOneButton(RegisterCustomerActivity.this, "비밀번호가 일치하지 않습니다.");
//                        mCustomDialogOneButton.setCancelable(false);
//                        mCustomDialogOneButton.show();
//                        mEdtUserPw.setText("");
//                        mEdtUserPwCheck.setText("");
//                        mEdtUserPw.requestFocus();
//                    }
//                }
//
////                }
//
//            }
//        });

        ImageView mIvBack = findViewById(R.id.register_iv_back);
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterCustomerActivity.this, RegisterSelectActivity.class);
                startActivity(intent);
                finish();
            }
        });

        final RegisterService registerService = new RegisterService(this);

        Button mBtnNext = findViewById(R.id.register_btn_next);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(age + " " + gender + " " + CheckPw);
                if(CheckPw){
                    registerService.postCustomer(mEdtUserId.getText().toString(), mEdtUserPw.getText().toString(),
                            mEdtName.getText().toString(),age,gender, mEdtEmail.getText().toString(), mEdtPhone.getText().toString());
                }
                else{
                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterCustomerActivity.this, "비밀번호가 일치하지 않습니다.");
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                    mEdtUserPw.requestFocus();
                }
            }
        });

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                RegisterCustomerActivity.this.runOnUiThread(new Runnable() {
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
    public void validateSuccess(int code, String message) {
        System.out.println(code + "  " + message);
        if(code==100){
            Intent intent = new Intent(RegisterCustomerActivity.this, RegisterSuccessActivity.class);
            startActivity(intent);
            finish();
        }
        else{ // 에러코드 정리되면
            switch (code){
                case 101:
                    mStrMsg = "중복된 아이디입니다.\n다시 입력해주세요.";
                    mEdtUserId.setText("");
                    mEdtUserId.requestFocus();
                    break;
                case 102:
                    mStrMsg = "중복된 이메일입니다.\n다시 입력해주세요.";
                    mEdtEmail.setText("");
                    mEdtEmail.requestFocus();
                    break;
                case 103:
                    mStrMsg = "잘못된 이름 형식입니다.\n한글로 입력해주세요.";
                    mEdtName.setText("");
                    mEdtName.requestFocus();
                    break;
                case 104:
                    mStrMsg = "잘못된 비밀번호 형식입니다.\n영어,숫자 및 특수문자조합으로\n8자리이상 15자리이하로 입력해주세요.";
                    mEdtUserPw.setText("");
                    mEdtUserPwCheck.setText("");
                    mEdtUserPw.requestFocus();
                    CheckPw =false;
                    break;
                case 105:
                    mStrMsg = "잘못된 이메일 형식입니다.\n다시 입력해주세요.";
                    mEdtEmail.setText("");
                    mEdtEmail.requestFocus();
                    break;
                case 106:
                    mStrMsg = "잘못된 전화번호 형식입니다.\n다시 입력해주세요.";
                    mEdtPhone.setText("");
                    mEdtPhone.requestFocus();
                    break;
                case 107:
                    mStrMsg = "나이를 선택해주세요.";
                    break;
                case 108:
                    mStrMsg = "성별을 선택해주세요.";
                    break;
                case 109:
                    mStrMsg = "모든 항목을 입력해주세요.";
                    break;
                case 110:
                    mStrMsg = "잘못된 아이디 형식입니다.\n영소문자,숫자 조합으로\n4자리 이상 10자리로 입력해주세요.";
                    mEdtUserId.setText("");
                    mEdtUserId.requestFocus();
                    break;
            }

            mCustomDialogOneButton = new CustomDialogOneButton(this, mStrMsg);
            mCustomDialogOneButton.setCancelable(false);
            mCustomDialogOneButton.show();
        }

    }

    @Override
    public void validateFailure(int code, String message) {
        System.out.println(message);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RegisterCustomerActivity.this, RegisterSelectActivity.class);
        startActivity(intent);
        finish();
    }

    public void ageClick(View view){
        switch (view.getId()) {
            case R.id.register_btn_age1:
                mBtnAge1.setPressed(true);
                mBtnAge1.setSelected(true);
                mBtnAge2.setPressed(false);
                mBtnAge2.setSelected(false);
                mBtnAge3.setPressed(false);
                mBtnAge3.setSelected(false);
                mBtnAge4.setPressed(false);
                mBtnAge4.setSelected(false);
                age=0;
                CheckAge=true;
                break;
            case R.id.register_btn_age2:
                mBtnAge2.setPressed(true);
                mBtnAge2.setSelected(true);
                mBtnAge1.setPressed(false);
                mBtnAge1.setSelected(false);
                mBtnAge3.setPressed(false);
                mBtnAge3.setSelected(false);
                mBtnAge4.setPressed(false);
                mBtnAge4.setSelected(false);
                age=1;
                CheckAge=true;
                break;
            case R.id.register_btn_age3:
                mBtnAge3.setPressed(true);
                mBtnAge3.setSelected(true);
                mBtnAge2.setPressed(false);
                mBtnAge2.setSelected(false);
                mBtnAge1.setPressed(false);
                mBtnAge1.setSelected(false);
                mBtnAge4.setPressed(false);
                mBtnAge4.setSelected(false);
                age=2;
                CheckAge=true;
                break;
            case R.id.register_age_btn4:
                mBtnAge4.setPressed(true);
                mBtnAge4.setSelected(true);
                mBtnAge2.setPressed(false);
                mBtnAge2.setSelected(false);
                mBtnAge3.setPressed(false);
                mBtnAge3.setSelected(false);
                mBtnAge1.setPressed(false);
                mBtnAge1.setSelected(false);
                age=3;
                CheckAge=true;
                break;
        }
    }

    public void genderClick(View view){
        switch (view.getId()){
            case R.id.register_btn_genderWoman:
                mBtnGenderWoman.setPressed(true);
                mBtnGenderWoman.setSelected(true);
                mBtnGenderMan.setPressed(false);
                mBtnGenderMan.setSelected(false);
                gender=0;
                CheckGender=true;
                break;
            case R.id.register_btn_genderMan:
                mBtnGenderMan.setPressed(true);
                mBtnGenderMan.setSelected(true);
                mBtnGenderWoman.setPressed(false);
                mBtnGenderWoman.setSelected(false);
                gender=1;
                CheckGender = true;
                break;
        }
    }

    @Override
    protected void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }
}
