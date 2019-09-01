package com.example.project_chachacha.template.src.MainChaChaCha.ChaChaChaSelect;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.Mypage.MypageActivity;
import com.example.project_chachacha.template.src.Shopdetatil.ShopDetail;

public class ChachachaActivity extends BaseActivity {

    private Button mBtnNum1, mBtnNum2, mBtnNum3, mBtnNum4, mBtnNum5, mBtnNum6;
    private Button mBtnMood1, mBtnMood2, mBtnMood3, mBtnMood4, mBtnMood5, mBtnMood6, mBtnMood7, mBtnMood8, mBtnNext;
    private ImageButton mBtnFood1, mBtnFood2, mBtnFood3, mBtnFood4, mBtnFood5, mBtnFood6, mBtnFood7, mBtnFood8, mBtnFood9, mBtnFood10, mBtnFood11, mBtnFood12, mBtnFood13, mBtnFood14, mBtnFood15, mBtnFood16;
    private ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chachacha);

        mBtnNum1 = findViewById(R.id.num1);  // 인원 수
        mBtnNum2 = findViewById(R.id.num2);
        mBtnNum3 = findViewById(R.id.num3);
        mBtnNum4 = findViewById(R.id.num4);
        mBtnNum5 = findViewById(R.id.num5);
        mBtnNum6 = findViewById(R.id.num6);

        mBtnMood1 = findViewById(R.id.mood1);  // 분위기
        mBtnMood2 = findViewById(R.id.mood2);
        mBtnMood3 = findViewById(R.id.mood3);
        mBtnMood4 = findViewById(R.id.mood4);
        mBtnMood5 = findViewById(R.id.mood5);
        mBtnMood6 = findViewById(R.id.mood6);
        mBtnMood7 = findViewById(R.id.mood7);
        mBtnMood8 = findViewById(R.id.mood8);


        mBtnNext = findViewById(R.id.chachacha_btn_next);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChachachaActivity.this, ShopDetail.class);
                startActivity(intent);
            }
        });
        mIvBack = findViewById(R.id.chachacha_iv_back);
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChachachaActivity.this, MypageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mBtnFood1 = findViewById(R.id.food1);  // 음식
        mBtnFood2 = findViewById(R.id.food2);
        mBtnFood3 = findViewById(R.id.food3);
        mBtnFood4 = findViewById(R.id.food4);
        mBtnFood5 = findViewById(R.id.food5);
        mBtnFood6 = findViewById(R.id.food6);
        mBtnFood7 = findViewById(R.id.food7);
        mBtnFood8 = findViewById(R.id.food8);
        mBtnFood9 = findViewById(R.id.food9);
        mBtnFood10 = findViewById(R.id.food10);
        mBtnFood11 = findViewById(R.id.food11);
        mBtnFood12 = findViewById(R.id.food12);
        mBtnFood13 = findViewById(R.id.food13);
        mBtnFood14 = findViewById(R.id.food14);
        mBtnFood15 = findViewById(R.id.food15);
        mBtnFood16 = findViewById(R.id.food16);

    }

    public void numClick(View view){
        switch (view.getId()){
            case R.id.num1:
                mBtnNum1.setPressed(true);
                mBtnNum1.setSelected(true);
                mBtnNum2.setPressed(false);
                mBtnNum2.setSelected(false);
                mBtnNum3.setPressed(false);
                mBtnNum3.setSelected(false);
                mBtnNum4.setPressed(false);
                mBtnNum4.setSelected(false);
                mBtnNum5.setPressed(false);
                mBtnNum5.setSelected(false);
                mBtnNum6.setPressed(false);
                mBtnNum6.setSelected(false);
                break;
            case R.id.num2:
                mBtnNum2.setPressed(true);
                mBtnNum2.setSelected(true);
                mBtnNum1.setPressed(false);
                mBtnNum1.setSelected(false);
                mBtnNum3.setPressed(false);
                mBtnNum3.setSelected(false);
                mBtnNum4.setPressed(false);
                mBtnNum4.setSelected(false);
                mBtnNum5.setPressed(false);
                mBtnNum5.setSelected(false);
                mBtnNum6.setPressed(false);
                mBtnNum6.setSelected(false);
                break;
            case R.id.num3:
                mBtnNum3.setPressed(true);
                mBtnNum3.setSelected(true);
                mBtnNum2.setPressed(false);
                mBtnNum2.setSelected(false);
                mBtnNum1.setPressed(false);
                mBtnNum1.setSelected(false);
                mBtnNum4.setPressed(false);
                mBtnNum4.setSelected(false);
                mBtnNum5.setPressed(false);
                mBtnNum5.setSelected(false);
                mBtnNum6.setPressed(false);
                mBtnNum6.setSelected(false);
                break;
            case R.id.num4:
                mBtnNum4.setPressed(true);
                mBtnNum4.setSelected(true);
                mBtnNum2.setPressed(false);
                mBtnNum2.setSelected(false);
                mBtnNum3.setPressed(false);
                mBtnNum3.setSelected(false);
                mBtnNum1.setPressed(false);
                mBtnNum1.setSelected(false);
                mBtnNum5.setPressed(false);
                mBtnNum5.setSelected(false);
                mBtnNum6.setPressed(false);
                mBtnNum6.setSelected(false);
                break;
            case R.id.num5:
                mBtnNum5.setPressed(true);
                mBtnNum5.setSelected(true);
                mBtnNum2.setPressed(false);
                mBtnNum2.setSelected(false);
                mBtnNum3.setPressed(false);
                mBtnNum3.setSelected(false);
                mBtnNum4.setPressed(false);
                mBtnNum4.setSelected(false);
                mBtnNum1.setPressed(false);
                mBtnNum1.setSelected(false);
                mBtnNum6.setPressed(false);
                mBtnNum6.setSelected(false);
                break;
            case R.id.num6:
                mBtnNum6.setPressed(true);
                mBtnNum6.setSelected(true);
                mBtnNum2.setPressed(false);
                mBtnNum2.setSelected(false);
                mBtnNum3.setPressed(false);
                mBtnNum3.setSelected(false);
                mBtnNum4.setPressed(false);
                mBtnNum4.setSelected(false);
                mBtnNum5.setPressed(false);
                mBtnNum5.setSelected(false);
                mBtnNum1.setPressed(false);
                mBtnNum1.setSelected(false);
                break;
        }
    }

    public void foodClick(View view){
        switch (view.getId()){
            case R.id.food1:
                if(!mBtnFood1.isSelected()){
                    mBtnFood1.setPressed(true);
                    mBtnFood1.setSelected(true);
                    Drawable alpha = mBtnFood1.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    mBtnFood1.setPressed(false);
                    mBtnFood1.setSelected(false);
                    Drawable alpha = mBtnFood1.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food2:
                if(!mBtnFood2.isSelected()){
                    mBtnFood2.setPressed(true);
                    mBtnFood2.setSelected(true);
                    Drawable alpha = mBtnFood2.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    mBtnFood2.setPressed(false);
                    mBtnFood2.setSelected(false);
                    Drawable alpha = mBtnFood2.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food3:
                if(!mBtnFood3.isSelected()){
                    mBtnFood3.setPressed(true);
                    mBtnFood3.setSelected(true);
                    Drawable alpha = mBtnFood3.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    mBtnFood3.setPressed(false);
                    mBtnFood3.setSelected(false);
                    Drawable alpha = mBtnFood3.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food4:
                if(!mBtnFood4.isSelected()){
                    mBtnFood4.setPressed(true);
                    mBtnFood4.setSelected(true);
                    Drawable alpha = mBtnFood4.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    mBtnFood4.setPressed(false);
                    mBtnFood4.setSelected(false);
                    Drawable alpha = mBtnFood4.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food5:
                if(!mBtnFood5.isSelected()){
                    mBtnFood5.setPressed(true);
                    mBtnFood5.setSelected(true);
                    Drawable alpha = mBtnFood5.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    mBtnFood5.setPressed(false);
                    mBtnFood5.setSelected(false);
                    Drawable alpha = mBtnFood5.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food6:
                if(!mBtnFood6.isSelected()){
                    mBtnFood6.setPressed(true);
                    mBtnFood6.setSelected(true);
                    Drawable alpha = mBtnFood6.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    mBtnFood6.setPressed(false);
                    mBtnFood6.setSelected(false);
                    Drawable alpha = mBtnFood6.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food7:
                if(!mBtnFood7.isSelected()){
                    mBtnFood7.setPressed(true);
                    mBtnFood7.setSelected(true);
                    Drawable alpha = mBtnFood7.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    mBtnFood7.setPressed(false);
                    mBtnFood7.setSelected(false);
                    Drawable alpha = mBtnFood7.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food8:
                if(!mBtnFood8.isSelected()){
                    mBtnFood8.setPressed(true);
                    mBtnFood8.setSelected(true);
                    Drawable alpha = mBtnFood8.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    mBtnFood8.setPressed(false);
                    mBtnFood8.setSelected(false);
                    Drawable alpha = mBtnFood8.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food9:
                if(!mBtnFood9.isSelected()){
                    mBtnFood9.setPressed(true);
                    mBtnFood9.setSelected(true);
                    Drawable alpha = mBtnFood9.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    mBtnFood9.setPressed(false);
                    mBtnFood9.setSelected(false);
                    Drawable alpha = mBtnFood9.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food10:
                if(!mBtnFood10.isSelected()){
                    mBtnFood10.setPressed(true);
                    mBtnFood10.setSelected(true);
                    Drawable alpha = mBtnFood10.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    mBtnFood10.setPressed(false);
                    mBtnFood10.setSelected(false);
                    Drawable alpha = mBtnFood10.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food11:
                if(!mBtnFood11.isSelected()){
                    mBtnFood11.setPressed(true);
                    mBtnFood11.setSelected(true);
                    Drawable alpha = mBtnFood11.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    mBtnFood11.setPressed(false);
                    mBtnFood11.setSelected(false);
                    Drawable alpha = mBtnFood11.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food12:
                if(!mBtnFood12.isSelected()){
                    mBtnFood12.setPressed(true);
                    mBtnFood12.setSelected(true);
                    Drawable alpha = mBtnFood12.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    mBtnFood12.setPressed(false);
                    mBtnFood12.setSelected(false);
                    Drawable alpha = mBtnFood12.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food13:
                if(!mBtnFood13.isSelected()){
                    mBtnFood13.setPressed(true);
                    mBtnFood13.setSelected(true);
                    Drawable alpha = mBtnFood13.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    mBtnFood13.setPressed(false);
                    mBtnFood13.setSelected(false);
                    Drawable alpha = mBtnFood13.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food14:
                if(!mBtnFood14.isSelected()){
                    mBtnFood14.setPressed(true);
                    mBtnFood14.setSelected(true);
                    Drawable alpha = mBtnFood14.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    mBtnFood14.setPressed(false);
                    mBtnFood14.setSelected(false);
                    Drawable alpha = mBtnFood14.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food15:
                if(!mBtnFood15.isSelected()){
                    mBtnFood15.setPressed(true);
                    mBtnFood15.setSelected(true);
                    Drawable alpha = mBtnFood15.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    mBtnFood15.setPressed(false);
                    mBtnFood15.setSelected(false);
                    Drawable alpha = mBtnFood15.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
            case R.id.food16:
                if(!mBtnFood16.isSelected()){
                    mBtnFood16.setPressed(true);
                    mBtnFood16.setSelected(true);
                    Drawable alpha = mBtnFood16.getDrawable();
                    alpha.setAlpha(100);
                }
                else{
                    mBtnFood16.setPressed(false);
                    mBtnFood16.setSelected(false);
                    Drawable alpha = mBtnFood16.getDrawable();
                    alpha.setAlpha(255);
                }
                break;
        }
    }

    public void moodClick(View view){
        switch (view.getId()){
            case R.id.mood1:
                if(!mBtnMood1.isSelected()){
                    mBtnMood1.setPressed(true);
                    mBtnMood1.setSelected(true);
                    mBtnMood8.setPressed(false);
                    mBtnMood8.setSelected(false);
                }
                else{
                    mBtnMood1.setPressed(false);
                    mBtnMood1.setSelected(false);
                }
                break;
            case R.id.mood2:
                if(!mBtnMood2.isSelected()){
                    mBtnMood2.setPressed(true);
                    mBtnMood2.setSelected(true);
                    mBtnMood8.setPressed(false);
                    mBtnMood8.setSelected(false);
                }
                else{
                    mBtnMood2.setPressed(false);
                    mBtnMood2.setSelected(false);
                }
                break;
            case R.id.mood3:
                if(!mBtnMood3.isSelected()){
                    mBtnMood3.setPressed(true);
                    mBtnMood3.setSelected(true);
                    mBtnMood8.setPressed(false);
                    mBtnMood8.setSelected(false);
                }
                else{
                    mBtnMood3.setPressed(false);
                    mBtnMood3.setSelected(false);
                }
                break;
            case R.id.mood4:
                if(!mBtnMood4.isSelected()){
                    mBtnMood4.setPressed(true);
                    mBtnMood4.setSelected(true);
                    mBtnMood8.setPressed(false);
                    mBtnMood8.setSelected(false);
                }
                else{
                    mBtnMood4.setPressed(false);
                    mBtnMood4.setSelected(false);
                }
                break;
            case R.id.mood5:
                if(!mBtnMood5.isSelected()){
                    mBtnMood5.setPressed(true);
                    mBtnMood5.setSelected(true);
                    mBtnMood8.setPressed(false);
                    mBtnMood8.setSelected(false);
                }
                else{
                    mBtnMood5.setPressed(false);
                    mBtnMood5.setSelected(false);
                }
                break;
            case R.id.mood6:
                if(!mBtnMood6.isSelected()){
                    mBtnMood6.setPressed(true);
                    mBtnMood6.setSelected(true);
                    mBtnMood8.setPressed(false);
                    mBtnMood8.setSelected(false);
                }
                else{
                    mBtnMood6.setPressed(false);
                    mBtnMood6.setSelected(false);
                }
                break;
            case R.id.mood7:
                if(!mBtnMood7.isSelected()){
                    mBtnMood7.setPressed(true);
                    mBtnMood7.setSelected(true);
                    mBtnMood8.setPressed(false);
                    mBtnMood8.setSelected(false);
                }
                else{
                    mBtnMood7.setPressed(false);
                    mBtnMood7.setSelected(false);
                }
                break;
            case R.id.mood8:
                mBtnMood8.setSelected(true);
                mBtnMood8.setPressed(true);
                mBtnMood1.setSelected(false);
                mBtnMood1.setPressed(false);
                mBtnMood2.setSelected(false);
                mBtnMood2.setPressed(false);
                mBtnMood3.setSelected(false);
                mBtnMood3.setPressed(false);
                mBtnMood4.setSelected(false);
                mBtnMood4.setPressed(false);
                mBtnMood5.setSelected(false);
                mBtnMood5.setPressed(false);
                mBtnMood6.setSelected(false);
                mBtnMood6.setPressed(false);
                mBtnMood7.setSelected(false);
                mBtnMood7.setPressed(false);
                break;

        }
    }
}
