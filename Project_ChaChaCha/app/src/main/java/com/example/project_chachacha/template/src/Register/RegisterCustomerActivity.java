package com.example.project_chachacha.template.src.Register;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
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
import java.util.regex.Pattern;

public class RegisterCustomerActivity extends BaseActivity implements RegisterView {

    private Button mBtnAge1, mBtnAge2, mBtnAge3, mBtnAge4, mBtnGenderWoman, mBtnGenderMan;
    private EditText mEdtUserId, mEdtUserPw, mEdtUserPwCheck, mEdtName, mEdtEmail, mEdtPhone;
    private int age = 10, gender=10;
    private View viewUserPwCheckLine;
    private TextView mTvPwComment;

    private Timer timer = new Timer();

    private boolean CheckEmail = false;
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
                String userId = mEdtUserId.getText().toString();
                String userPw = mEdtUserPw.getText().toString();
                String userPwCheck = mEdtUserPwCheck.getText().toString();
                String userName = mEdtName.getText().toString();
                String userEmail = mEdtEmail.getText().toString();
                String userPhone = mEdtPhone.getText().toString();
                if(userId.equals("")||userPw.equals("")||userPwCheck.equals("")||userName.equals("")||
                userEmail.equals("")||userPhone.equals("")||!CheckAge||!CheckGender){
                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterCustomerActivity.this, "모든 항목을 입력해주세요.");
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                }
                else if(!Pattern.matches("^[a-z0-9]{4,10}$",userId)){
                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterCustomerActivity.this, "아이디가 올바르지 않습니다.");
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                    mEdtUserId.setText("");
                    mEdtUserId.requestFocus();
                }
                else if(!CheckPw){
                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterCustomerActivity.this, "비밀번호가 올바르지 않습니다.");
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                    mEdtUserPw.setText("");
                    mEdtUserPwCheck.setText("");
                    mEdtUserPw.requestFocus();
                }
                else if(!Pattern.matches("^[가-힣]{2,5}$",userName)){
                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterCustomerActivity.this, "이름을 올바르게 입력해주세요.");
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                    mEdtName.setText("");
                    mEdtName.requestFocus();
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterCustomerActivity.this, "이메일을 올바르게 입력해주세요.");
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                    mEdtEmail.setText("");
                    mEdtEmail.requestFocus();
                }
                else if(!Pattern.matches("^01([0|1|6|7|8|9][0-9]{3,4}[0-9]{4})$",userPhone)){
                    mCustomDialogOneButton = new CustomDialogOneButton(RegisterCustomerActivity.this, "전화번호를 올바르게 입력해주세요.");
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                    mEdtPhone.setText("");
                    mEdtPhone.requestFocus();
                }
                else{
                    registerService.postCustomer(mEdtUserId.getText().toString(), mEdtUserPw.getText().toString(),
                            mEdtName.getText().toString(),age,gender, mEdtEmail.getText().toString(), mEdtPhone.getText().toString());
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
    public void validateSuccess(int code, String message) {

        final int success = 100;
        final int DuplicateID = 101;
        final int DuplicateEmail = 102;
        final int InvalidName = 103;
        final int InvalidPw = 104;
        final int InvalidEmail = 105;
        final int InvalidPhone = 106;
        final int InvalidAge = 107;
        final int InvalidGender = 108;
        final int EmptyText = 109;
        final int InvalidID = 110;

        if(code==success){
            Intent intent = new Intent(RegisterCustomerActivity.this, RegisterSuccessActivity.class);
            startActivity(intent);
            finish();
        }
        else{ // 에러코드 정리되면
            switch (code){
                case DuplicateID:
                    mStrMsg = "중복된 아이디입니다.\n다시 입력해주세요.";
                    mEdtUserId.setText("");
                    mEdtUserId.requestFocus();
                    break;
                case DuplicateEmail:
                    mStrMsg = "중복된 이메일입니다.\n다시 입력해주세요.";
                    mEdtEmail.setText("");
                    mEdtEmail.requestFocus();
                    break;
                case InvalidName:
                    mStrMsg = "잘못된 이름 형식입니다.\n한글로 입력해주세요.";
                    mEdtName.setText("");
                    mEdtName.requestFocus();
                    break;
                case InvalidPw:
                    mStrMsg = "잘못된 비밀번호 형식입니다.\n영어,숫자 및 특수문자조합으로\n8자리이상 15자리이하로 입력해주세요.";
                    mEdtUserPw.setText("");
                    mEdtUserPwCheck.setText("");
                    mEdtUserPw.requestFocus();
                    CheckPw =false;
                    break;
                case InvalidEmail:
                    mStrMsg = "잘못된 이메일 형식입니다.\n다시 입력해주세요.";
                    mEdtEmail.setText("");
                    mEdtEmail.requestFocus();
                    break;
                case InvalidPhone:
                    mStrMsg = "잘못된 전화번호 형식입니다.\n다시 입력해주세요.";
                    mEdtPhone.setText("");
                    mEdtPhone.requestFocus();
                    break;
                case InvalidAge:
                    mStrMsg = "나이를 선택해주세요.";
                    break;
                case InvalidGender:
                    mStrMsg = "성별을 선택해주세요.";
                    break;
                case EmptyText:
                    mStrMsg = "모든 항목을 입력해주세요.";
                    break;
                case InvalidID:
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
