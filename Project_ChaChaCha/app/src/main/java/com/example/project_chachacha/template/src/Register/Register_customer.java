package com.example.project_chachacha.template.src.Register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;

public class Register_customer extends BaseActivity {

    private boolean age1checked = false, age2checked= false, age3checked=false, age4checked=false;
    private boolean gender_womanChecked = false, gender_manChecked = false;
    private Button age1,age2,age3,age4,genderw,genderm;
    private ImageView mivback;
    private Button mbtn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_customer);

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
                finish();
            }
        });

        mbtn_next = findViewById(R.id.next);
        mbtn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_customer.this, Register_Success.class);
                startActivity(intent);
                finish();
            }
        });
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
                break;
            case R.id.gender_man:
                genderm.setPressed(true);
                genderm.setSelected(true);
                genderw.setPressed(false);
                genderw.setSelected(false);
                gender_manChecked=true;
                gender_womanChecked=false;
                break;
        }
    }
}
