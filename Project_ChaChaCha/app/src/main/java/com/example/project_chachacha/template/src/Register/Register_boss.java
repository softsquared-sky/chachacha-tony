package com.example.project_chachacha.template.src.Register;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.Timer;
import java.util.TimerTask;

public class Register_boss extends BaseActivity implements RegisterView {

    private ImageView mivback;
    private Button mbtn_next;
    private EditText userid, userpw, userpw2, name, phone;
    private Button btnCheck;
    private boolean pwcheck = false;

    private CustomDialog_btn1 mCustomDialog_btn1;

    private View userpwline, userpwline2;
    private TextView pwcomment;

    private Timer timer = new Timer();

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

        userpwline=findViewById(R.id.userpwline);
        userpwline2 = findViewById(R.id.userpw2line);

        pwcomment = findViewById(R.id.pwcomment);

//        btnCheck = findViewById(R.id.pwcheck);
//        btnCheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(userpw.getText().toString().equals(userpw2.getText().toString())){
//                    pwcheck=true; // 비밀번호 형식이 일치하지 않으면 다시 false로
//                    mCustomDialog_btn1 = new CustomDialog_btn1(Register_boss.this, "비밀번호가 일치합니다.");
//                    mCustomDialog_btn1.setCancelable(false);
//                    mCustomDialog_btn1.show();
//                }
//                else{
//                    userpw.setText("");
//                    userpw2.setText("");
//                    userpw.requestFocus();
//                    mCustomDialog_btn1 = new CustomDialog_btn1(Register_boss.this, "비밀번호가 일치하지 않습니다.");
//                    mCustomDialog_btn1.setCancelable(false);
//                    mCustomDialog_btn1.show();
//                }
//            }
//        });

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
                if(pwcheck){
                    registerService.boss(userid.getText().toString(), userpw.getText().toString(),
                            name.getText().toString(), phone.getText().toString());
                }
                else{
                    mCustomDialog_btn1 = new CustomDialog_btn1(Register_boss.this, "비밀번호 확인을 눌러주세요.");
                    mCustomDialog_btn1.setCancelable(false);
                    mCustomDialog_btn1.show();
                }
            }
        });

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Register_boss.this.runOnUiThread(new Runnable() {
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
        else{ // 에러코드 정리되면 수정
            switch (code){
                case 101:
                    msg = "중복된 아이디입니다.\n다시 입력해주세요.";
                    userid.setText("");
                    userid.requestFocus();
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
                    break;
                case 106:
                    msg = "잘못된 전화번호 형식입니다,\n올바른 형식으로 입력해주세요.";
                    phone.setText("");
                    phone.requestFocus();
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
    protected void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }
}
