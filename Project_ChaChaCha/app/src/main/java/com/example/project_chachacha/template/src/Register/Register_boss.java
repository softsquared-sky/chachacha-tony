package com.example.project_chachacha.template.src.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.CustomDialog_btn1;
import com.example.project_chachacha.template.src.Register.Interfaces.RegisterView;

public class Register_boss extends BaseActivity implements RegisterView {

    private ImageView mivback;
    private Button mbtn_next;
    private EditText userid, userpw, userpw2, name, phone;

    private CustomDialog_btn1 mCustomDialog_btn1;

    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_boss);

        userid = findViewById(R.id.userid);
        userpw = findViewById(R.id.userpw);
        userpw2 = findViewById(R.id.userpw2);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);

        mivback = findViewById(R.id.back);
        mivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_boss.this, Register_select.class);
                startActivity(intent);
                finish();
            }
        });

        final RegisterService registerService = new RegisterService(this);

        mbtn_next = findViewById(R.id.next);
        mbtn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerService.boss(userid.getText().toString(), userpw.getText().toString(), userpw2.getText().toString(),
                        name.getText().toString(), phone.getText().toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Register_boss.this, Register_select.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void validateSuccess(int code, String message) {
        System.out.println(message);
        if(code==100){
            Intent intent = new Intent(Register_boss.this, Register_Success.class);
            startActivity(intent);
            finish();
        }
        else{
            switch (code){
                case 105:
                    msg = "아이디를 입력해주세요.";
                    userid.setText("");
                    userid.requestFocus();
                    break;
                case 101:
                    msg = "중복된 아이디입니다.\n다시 입력해주세요.";
                    userid.setText("");
                    userid.requestFocus();
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
                case 106:
                    msg = "비밀번호를 입력해주세요.";
                    userpw.setText("");
                    userpw.requestFocus();
                    break;
                case 108:
                    msg = "이름을 입력해주세요.";
                    name.setText("");
                    name.requestFocus();
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
}
