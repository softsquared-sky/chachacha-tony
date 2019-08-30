package com.example.project_chachacha.template.src.Register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.CustomDialog_btn1;
import com.example.project_chachacha.template.src.Register.Interfaces.RegisterView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register_customer extends BaseActivity implements RegisterView {

    private boolean age1checked = false, age2checked= false, age3checked=false, age4checked=false;
    private boolean gender_womanChecked = false, gender_manChecked = false;
    private Button age1,age2,age3,age4,genderw,genderm;
    private ImageView mivback;
    private Button mbtn_next, mbtnPwcheck;
    private EditText userid, userpw, userpw2, name, email, phone;
    private int age = 10, gender=10;
    private View userpwline, userpwline2;
    private TextView pwcomment;

    private Timer timer = new Timer();

    boolean pwcheck=false;
    String msg;

    private CustomDialog_btn1 mCustomDialog_btn1;

    Matcher matcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_customer);

        userid = findViewById(R.id.userid);
        userpw = findViewById(R.id.userpw);
        userpw2 = findViewById(R.id.userpw2);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);

        age1 = findViewById(R.id.age_btn1);
        age2 = findViewById(R.id.age_btn2);
        age3 = findViewById(R.id.age_btn3);
        age4 = findViewById(R.id.age_btn4);
        genderw = findViewById(R.id.gender_woman);
        genderm = findViewById(R.id.gender_man);

        userpwline=findViewById(R.id.userpwline);
        userpwline2 = findViewById(R.id.userpw2line);

        pwcomment = findViewById(R.id.pwcomment);

        //나중에 비밀번호호 패턴검사 가하면 추가


//        mbtnPwcheck = findViewById(R.id.pwcheck);
//        mbtnPwcheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{8,15}$";
////                matcher = Pattern.compile(pwPattern).matcher(userpw.getText().toString());
////                if(!matcher.matches()){
////                    msg = "잘못된 비밀번호 형식입니다.\n영어,숫자 및 특수문자조합으로\n8자리이상 15자리이하로 입력해주세요.";
////                    mCustomDialog_btn1 = new CustomDialog_btn1(Register_customer.this, msg);
////                    mCustomDialog_btn1.setCancelable(false);
////                    mCustomDialog_btn1.show();
////                    userpw.setText("");
////                    userpw2.setText("");
////                    userpw.requestFocus();
////                }
////                else {
//                if(userpw.getText().toString().equals("")){
//                    mCustomDialog_btn1 = new CustomDialog_btn1(Register_customer.this, "비밀번호를 입력해주세요.");
//                    mCustomDialog_btn1.setCancelable(false);
//                    mCustomDialog_btn1.show();
//                    userpw.setText("");
//                    userpw2.setText("");
//                    userpw.requestFocus();
//                }
//                else{
//                    if(userpw.getText().toString().equals(userpw2.getText().toString())){
//                        pwcheck=true; // 비밀번호 형식이 일치하지 않으면 다시 false로
//                        mCustomDialog_btn1 = new CustomDialog_btn1(Register_customer.this, "비밀번호가 일치합니다.");
//                        mCustomDialog_btn1.setCancelable(false);
//                        mCustomDialog_btn1.show();
//                    }
//                    else{
//                        mCustomDialog_btn1 = new CustomDialog_btn1(Register_customer.this, "비밀번호가 일치하지 않습니다.");
//                        mCustomDialog_btn1.setCancelable(false);
//                        mCustomDialog_btn1.show();
//                        userpw.setText("");
//                        userpw2.setText("");
//                        userpw.requestFocus();
//                    }
//                }
//
////                }
//
//            }
//        });

        mivback = findViewById(R.id.back);
        mivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_customer.this, Register_select.class);
                startActivity(intent);
                finish();
            }
        });

        final RegisterService registerService = new RegisterService(this);

        mbtn_next = findViewById(R.id.next);
        mbtn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(age + " " + gender + " " + pwcheck);
                if(pwcheck){
                    registerService.customer(userid.getText().toString(), userpw.getText().toString(),
                            name.getText().toString(),age,gender,email.getText().toString(), phone.getText().toString());
                }
                else{
                    mCustomDialog_btn1 = new CustomDialog_btn1(Register_customer.this, "비밀번호가 일치하지 않습니다.");
                    mCustomDialog_btn1.setCancelable(false);
                    mCustomDialog_btn1.show();
                    userpw.requestFocus();
                }
            }
        });

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Register_customer.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(userpw.getText().toString().equals("")){
                            userpwline2.setBackground(getDrawable(R.drawable.style3));
                            pwcomment.setText("비밀번호를 입력해주세요.");
                            pwcomment.setTextColor(Color.parseColor("#99FF0000"));
                            pwcheck=false;
                        }
                        else{
                            if(userpw.getText().toString().equals(userpw2.getText().toString())){
                                userpwline2.setBackground(getDrawable(R.drawable.style3));
                                pwcomment.setText("비밀번호가 일치합니다.");
                                pwcomment.setTextColor(Color.parseColor("#00bfff"));
                                pwcheck=true;
                            }
                            else{
                                userpwline2.setBackground(getDrawable(R.drawable.style8));
                                pwcomment.setText("비밀번호가 일치하지 않습니다.");
                                pwcomment.setTextColor(Color.parseColor("#99FF0000"));
                                pwcheck=false;
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
            Intent intent = new Intent(Register_customer.this, Register_Success.class);
            startActivity(intent);
            finish();
        }
        else{ // 에러코드 정리되면
            switch (code){
                case 101:
                    msg = "중복된 아이디입니다.\n다시 입력해주세요.";
                    userid.setText("");
                    userid.requestFocus();
                    break;
                case 102:
                    msg = "중복된 이메일입니다.\n다시 입력해주세요.";
                    email.setText("");
                    email.requestFocus();
                    break;
                case 103:
                    msg = "잘못된 이름 형식입니다.\n한글로 입력해주세요.";
                    name.setText("");
                    name.requestFocus();
                    break;
                case 104:
                    msg = "잘못된 비밀번호 형식입니다.\n영어,숫자 및 특수문자조합으로\n8자리이상 15자리이하로 입력해주세요.";
                    userpw.setText("");
                    userpw2.setText("");
                    userpw.requestFocus();
                    pwcheck=false;
                    break;
                case 105:
                    msg = "잘못된 이메일 형식입니다.\n다시 입력해주세요.";
                    email.setText("");
                    email.requestFocus();
                    break;
                case 106:
                    msg = "잘못된 전화번호 형식입니다.\n다시 입력해주세요.";
                    phone.setText("");
                    phone.requestFocus();
                    break;
                case 107:
                    msg = "나이를 선택해주세요.";
                    break;
                case 108:
                    msg = "성별을 선택해주세요.";
                    break;
                case 109:
                    msg = "모든 항목을 입력해주세요.";
                    break;
                case 110:
                    msg = "잘못된 아이디 형식입니다.\n영소문자,숫자 조합으로\n4자리 이상 10자리로 입력해주세요.";
                    userid.setText("");
                    userid.requestFocus();
                    break;
            }

            mCustomDialog_btn1 = new CustomDialog_btn1(this, msg);
            mCustomDialog_btn1.setCancelable(false);
            mCustomDialog_btn1.show();
        }

    }

    @Override
    public void validateFailure(int code, String message) {
        System.out.println(message);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Register_customer.this, Register_select.class);
        startActivity(intent);
        finish();
    }

    public void ageClick(View view){
        switch (view.getId()) {
            case R.id.age_btn1:
                age1.setPressed(true);
                age1.setSelected(true);
                age2.setPressed(false);
                age2.setSelected(false);
                age3.setPressed(false);
                age3.setSelected(false);
                age4.setPressed(false);
                age4.setSelected(false);
                age1checked=true;
                age2checked=false;
                age3checked=false;
                age4checked=false;
                age=0;
                break;
            case R.id.age_btn2:
                age2.setPressed(true);
                age2.setSelected(true);
                age1.setPressed(false);
                age1.setSelected(false);
                age3.setPressed(false);
                age3.setSelected(false);
                age4.setPressed(false);
                age4.setSelected(false);
                age2checked=true;
                age1checked=false;
                age3checked=false;
                age4checked=false;
                age=1;
                break;
            case R.id.age_btn3:
                age3.setPressed(true);
                age3.setSelected(true);
                age2.setPressed(false);
                age2.setSelected(false);
                age1.setPressed(false);
                age1.setSelected(false);
                age4.setPressed(false);
                age4.setSelected(false);
                age3checked=true;
                age2checked=false;
                age1checked=false;
                age4checked=false;
                age=2;
                break;
            case R.id.age_btn4:
                age4.setPressed(true);
                age4.setSelected(true);
                age2.setPressed(false);
                age2.setSelected(false);
                age3.setPressed(false);
                age3.setSelected(false);
                age1.setPressed(false);
                age1.setSelected(false);
                age4checked=true;
                age2checked=false;
                age3checked=false;
                age1checked=false;
                age=3;
                break;
        }
    }

    public void genderClick(View view){
        switch (view.getId()){
            case R.id.gender_woman:
                genderw.setPressed(true);
                genderw.setSelected(true);
                genderm.setPressed(false);
                genderm.setSelected(false);
                gender_womanChecked=true;
                gender_manChecked=false;
                gender=0;
                break;
            case R.id.gender_man:
                genderm.setPressed(true);
                genderm.setSelected(true);
                genderw.setPressed(false);
                genderw.setSelected(false);
                gender_manChecked=true;
                gender_womanChecked=false;
                gender=1;
                break;
        }
    }

    @Override
    protected void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }
}
