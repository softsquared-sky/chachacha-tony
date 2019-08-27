package com.example.project_chachacha.template.src.MainChaChaCha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;

public class Chachacha extends BaseActivity {

    private Button num1,num2,num3,num4,num5,num6;
    private Button md1,md2,md3,md4,md5,md6,md7,md8,next;
    private ImageButton fd1,fd2,fd3,fd4,fd5,fd6,fd7,fd8,fd9,fd10,fd11,fd12,fd13,fd14,fd15,fd16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chachacha);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);

        md1 = findViewById(R.id.mood1);
        md2 = findViewById(R.id.mood2);
        md3 = findViewById(R.id.mood3);
        md4 = findViewById(R.id.mood4);
        md5 = findViewById(R.id.mood5);
        md6 = findViewById(R.id.mood6);
        md7 = findViewById(R.id.mood7);
        md8 = findViewById(R.id.mood8);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chachacha.this, ChaChaCha2.class);
                startActivity(intent);
            }
        });

        fd1 = findViewById(R.id.food1);
        fd2 = findViewById(R.id.food2);
        fd3 = findViewById(R.id.food3);
        fd4 = findViewById(R.id.food4);
        fd5 = findViewById(R.id.food5);
        fd6 = findViewById(R.id.food6);
        fd7 = findViewById(R.id.food7);
        fd8 = findViewById(R.id.food8);
        fd9 = findViewById(R.id.food9);
        fd10 = findViewById(R.id.food10);
        fd11 = findViewById(R.id.food11);
        fd12 = findViewById(R.id.food12);
        fd13 = findViewById(R.id.food13);
        fd14 = findViewById(R.id.food14);
        fd15 = findViewById(R.id.food15);
        fd16 = findViewById(R.id.food16);

    }

    public void numClick(View view){
        switch (view.getId()){
            case R.id.num1:
                num1.setPressed(true);
                num1.setSelected(true);
                num2.setPressed(false);
                num2.setSelected(false);
                num3.setPressed(false);
                num3.setSelected(false);
                num4.setPressed(false);
                num4.setSelected(false);
                num5.setPressed(false);
                num5.setSelected(false);
                num6.setPressed(false);
                num6.setSelected(false);
                break;
            case R.id.num2:
                num2.setPressed(true);
                num2.setSelected(true);
                num1.setPressed(false);
                num1.setSelected(false);
                num3.setPressed(false);
                num3.setSelected(false);
                num4.setPressed(false);
                num4.setSelected(false);
                num5.setPressed(false);
                num5.setSelected(false);
                num6.setPressed(false);
                num6.setSelected(false);
                break;
            case R.id.num3:
                num3.setPressed(true);
                num3.setSelected(true);
                num2.setPressed(false);
                num2.setSelected(false);
                num1.setPressed(false);
                num1.setSelected(false);
                num4.setPressed(false);
                num4.setSelected(false);
                num5.setPressed(false);
                num5.setSelected(false);
                num6.setPressed(false);
                num6.setSelected(false);
                break;
            case R.id.num4:
                num4.setPressed(true);
                num4.setSelected(true);
                num2.setPressed(false);
                num2.setSelected(false);
                num3.setPressed(false);
                num3.setSelected(false);
                num1.setPressed(false);
                num1.setSelected(false);
                num5.setPressed(false);
                num5.setSelected(false);
                num6.setPressed(false);
                num6.setSelected(false);
                break;
            case R.id.num5:
                num5.setPressed(true);
                num5.setSelected(true);
                num2.setPressed(false);
                num2.setSelected(false);
                num3.setPressed(false);
                num3.setSelected(false);
                num4.setPressed(false);
                num4.setSelected(false);
                num1.setPressed(false);
                num1.setSelected(false);
                num6.setPressed(false);
                num6.setSelected(false);
                break;
            case R.id.num6:
                num6.setPressed(true);
                num6.setSelected(true);
                num2.setPressed(false);
                num2.setSelected(false);
                num3.setPressed(false);
                num3.setSelected(false);
                num4.setPressed(false);
                num4.setSelected(false);
                num5.setPressed(false);
                num5.setSelected(false);
                num1.setPressed(false);
                num1.setSelected(false);
                break;
        }
    }

    public void foodClick(View view){
        switch (view.getId()){
            case R.id.food1:
                if(!fd1.isSelected()){
                    fd1.setPressed(true);
                    fd1.setSelected(true);
                    Drawable alpha = fd1.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    fd1.setPressed(false);
                    fd1.setSelected(false);
                    Drawable alpha = fd1.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food2:
                if(!fd2.isSelected()){
                    fd2.setPressed(true);
                    fd2.setSelected(true);
                    Drawable alpha = fd2.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    fd2.setPressed(false);
                    fd2.setSelected(false);
                    Drawable alpha = fd2.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food3:
                if(!fd3.isSelected()){
                    fd3.setPressed(true);
                    fd3.setSelected(true);
                    Drawable alpha = fd3.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    fd3.setPressed(false);
                    fd3.setSelected(false);
                    Drawable alpha = fd3.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food4:
                if(!fd4.isSelected()){
                    fd4.setPressed(true);
                    fd4.setSelected(true);
                    Drawable alpha = fd4.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    fd4.setPressed(false);
                    fd4.setSelected(false);
                    Drawable alpha = fd4.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food5:
                if(!fd5.isSelected()){
                    fd5.setPressed(true);
                    fd5.setSelected(true);
                    Drawable alpha = fd5.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    fd5.setPressed(false);
                    fd5.setSelected(false);
                    Drawable alpha = fd5.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food6:
                if(!fd6.isSelected()){
                    fd6.setPressed(true);
                    fd6.setSelected(true);
                    Drawable alpha = fd6.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    fd6.setPressed(false);
                    fd6.setSelected(false);
                    Drawable alpha = fd6.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food7:
                if(!fd7.isSelected()){
                    fd7.setPressed(true);
                    fd7.setSelected(true);
                    Drawable alpha = fd7.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    fd7.setPressed(false);
                    fd7.setSelected(false);
                    Drawable alpha = fd7.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food8:
                if(!fd8.isSelected()){
                    fd8.setPressed(true);
                    fd8.setSelected(true);
                    Drawable alpha = fd8.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    fd8.setPressed(false);
                    fd8.setSelected(false);
                    Drawable alpha = fd8.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food9:
                if(!fd9.isSelected()){
                    fd9.setPressed(true);
                    fd9.setSelected(true);
                    Drawable alpha = fd9.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    fd9.setPressed(false);
                    fd9.setSelected(false);
                    Drawable alpha = fd9.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food10:
                if(!fd10.isSelected()){
                    fd10.setPressed(true);
                    fd10.setSelected(true);
                    Drawable alpha = fd10.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    fd10.setPressed(false);
                    fd10.setSelected(false);
                    Drawable alpha = fd10.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food11:
                if(!fd11.isSelected()){
                    fd11.setPressed(true);
                    fd11.setSelected(true);
                    Drawable alpha = fd11.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    fd11.setPressed(false);
                    fd11.setSelected(false);
                    Drawable alpha = fd11.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food12:
                if(!fd12.isSelected()){
                    fd12.setPressed(true);
                    fd12.setSelected(true);
                    Drawable alpha = fd12.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    fd12.setPressed(false);
                    fd12.setSelected(false);
                    Drawable alpha = fd12.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food13:
                if(!fd13.isSelected()){
                    fd13.setPressed(true);
                    fd13.setSelected(true);
                    Drawable alpha = fd13.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    fd13.setPressed(false);
                    fd13.setSelected(false);
                    Drawable alpha = fd13.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food14:
                if(!fd14.isSelected()){
                    fd14.setPressed(true);
                    fd14.setSelected(true);
                    Drawable alpha = fd14.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    fd14.setPressed(false);
                    fd14.setSelected(false);
                    Drawable alpha = fd14.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food15:
                if(!fd15.isSelected()){
                    fd15.setPressed(true);
                    fd15.setSelected(true);
                    Drawable alpha = fd15.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    fd15.setPressed(false);
                    fd15.setSelected(false);
                    Drawable alpha = fd15.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food16:
                if(!fd16.isSelected()){
                    fd16.setPressed(true);
                    fd16.setSelected(true);
                    Drawable alpha = fd16.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    fd16.setPressed(false);
                    fd16.setSelected(false);
                    Drawable alpha = fd16.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
        }
    }

    public void moodClick(View view){
        switch (view.getId()){
            case R.id.mood1:
                if(!md1.isSelected()){
                    md1.setPressed(true);
                    md1.setSelected(true);
                    md8.setPressed(false);
                    md8.setSelected(false);
                }
                else{
                    md1.setPressed(false);
                    md1.setSelected(false);
                }
                break;
            case R.id.mood2:
                if(!md2.isSelected()){
                    md2.setPressed(true);
                    md2.setSelected(true);
                    md8.setPressed(false);
                    md8.setSelected(false);
                }
                else{
                    md2.setPressed(false);
                    md2.setSelected(false);
                }
                break;
            case R.id.mood3:
                if(!md3.isSelected()){
                    md3.setPressed(true);
                    md3.setSelected(true);
                    md8.setPressed(false);
                    md8.setSelected(false);
                }
                else{
                    md3.setPressed(false);
                    md3.setSelected(false);
                }
                break;
            case R.id.mood4:
                if(!md4.isSelected()){
                    md4.setPressed(true);
                    md4.setSelected(true);
                    md8.setPressed(false);
                    md8.setSelected(false);
                }
                else{
                    md4.setPressed(false);
                    md4.setSelected(false);
                }
                break;
            case R.id.mood5:
                if(!md5.isSelected()){
                    md5.setPressed(true);
                    md5.setSelected(true);
                    md8.setPressed(false);
                    md8.setSelected(false);
                }
                else{
                    md5.setPressed(false);
                    md5.setSelected(false);
                }
                break;
            case R.id.mood6:
                if(!md6.isSelected()){
                    md6.setPressed(true);
                    md6.setSelected(true);
                    md8.setPressed(false);
                    md8.setSelected(false);
                }
                else{
                    md6.setPressed(false);
                    md6.setSelected(false);
                }
                break;
            case R.id.mood7:
                if(!md7.isSelected()){
                    md7.setPressed(true);
                    md7.setSelected(true);
                    md8.setPressed(false);
                    md8.setSelected(false);
                }
                else{
                    md7.setPressed(false);
                    md7.setSelected(false);
                }
                break;
            case R.id.mood8:
                md8.setSelected(true);
                md8.setPressed(true);
                md1.setSelected(false);
                md1.setPressed(false);
                md2.setSelected(false);
                md2.setPressed(false);
                md3.setSelected(false);
                md3.setPressed(false);
                md4.setSelected(false);
                md4.setPressed(false);
                md5.setSelected(false);
                md5.setPressed(false);
                md6.setSelected(false);
                md6.setPressed(false);
                md7.setSelected(false);
                md7.setPressed(false);
                break;

        }
    }
}
