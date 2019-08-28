package com.example.project_chachacha.template.src.Register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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
import com.example.project_chachacha.template.src.CustomDialog_btn1;
import com.example.project_chachacha.template.src.Register.Interfaces.RegisterView;
import com.example.project_chachacha.template.src.Register.models.Register_customer_data;

public class Register_customer extends BaseActivity implements RegisterView {

    private boolean age1checked = false, age2checked= false, age3checked=false, age4checked=false;
    private boolean gender_womanChecked = false, gender_manChecked = false;
    private Button age1,age2,age3,age4,genderw,genderm;
    private ImageView mivback;
    private Button mbtn_next;
    private EditText userid, userpw, userpw2, name, email, phone;
    private int age, gender;
    private Register_customer_data data;

    String msg;

    private CustomDialog_btn1 mCustomDialog_btn1;

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
                registerService.customer(userid.getText().toString(), userpw.getText().toString(), userpw2.getText().toString(),
                        name.getText().toString(),age,gender,email.getText().toString(), phone.getText().toString());
            }
        });
    }

//    public void register(Register_customer_data data){
//        final RegisterService registerService = new RegisterService(this);
//        registerService.customer(data);
//    }

    @Override
    public void validateSuccess(int code, String message) {
        System.out.println(message);
        if(code==100){
            Intent intent = new Intent(Register_customer.this, Register_Success.class);
            startActivity(intent);
            finish();
        }
        else{
            switch (code){
                case 101:
                    msg = "중복된 아이디입니다.\n다시 입력해주세요.";
                    userid.setText("");
                    userid.requestFocus();
                    break;
                case 102:
                    msg = "잘못된 이메일 형식입니다.\n올바른 형식으로 입력해주세요.";
                    email.setText("");
                    email.requestFocus();
                    break;
                case 103:
                    msg = "잘못된 비밀번호 형식입니다.\n영어,숫자 및 특수문자조합으로\n8자리이상 15자리이하로 입력해주세요.";
                    userpw.setText("");
                    userpw2.setText("");
                    userpw.requestFocus();
                    break;
                case 104:
                    msg = "비밀번호가 일치하지 않습니다.\n다시 입력해주세요.";
                    userpw2.setText("");
                    userpw2.requestFocus();
                    break;
                case 105:
                    msg = "올바른 이름이 아닙니다.\n다시 입력해주세요.";
                    name.setText("");
                    name.requestFocus();
                    break;
                case 106:
                    msg = "아이디를 입력해주세요.";
                    userid.setText("");
                    userid.requestFocus();
                    break;
                case 107:
                    msg = "비밀번호를 입력해주세요.";
                    userpw.setText("");
                    userpw.requestFocus();
                    break;
                case 108:
                    msg = "비밀번호 확인을 입력해주세요.";
                    userpw2.setText("");
                    userpw2.requestFocus();
                    break;
                case 109:
                    msg = "성별을 선택해주세요.";
                    break;
                case 110:
                    msg = "이름을 입력해주세요.";
                    name.setText("");
                    name.requestFocus();
                    break;
                case 111:
                    msg = "나이를 선택해주세요.";
                    break;
                case 112:
                    msg = "이메일을 입력해주세요.";
                    email.setText("");
                    email.requestFocus();
                    break;
                case 113:
                    msg = "잘못된 전화번호 형식입니다,\n올바른 형식으로 입력해주세요.";
                    phone.setText("");
                    phone.requestFocus();
                    break;
                case 114:
                    msg = "전화번호를 입력해주세요.";
                    phone.setText("");
                    phone.requestFocus();
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

}
