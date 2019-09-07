package com.example.project_chachacha.template.src.mainChaChaCha.chachachaSelect;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.CustomDialogOneButton;
import com.example.project_chachacha.template.src.mainChaChaCha.chachachaList.ChaChaChaListActivity;
import com.example.project_chachacha.template.src.myPage.MypageActivity;
import com.example.project_chachacha.template.src.shop.shopdetatil.ShopDetailActivity;

import org.jetbrains.annotations.NotNull;

public class ChachachaActivity extends BaseActivity {

    public static Activity sChaChaChaActivity;

    private Button mBtnNum1, mBtnNum2, mBtnNum3, mBtnNum4, mBtnNum5, mBtnNum6;
    private Button mBtnMood1, mBtnMood2, mBtnMood3, mBtnMood4, mBtnMood5, mBtnMood6, mBtnMood7, mBtnMood8, mBtnNext;
    private ImageButton mBtnFood1, mBtnFood2, mBtnFood3, mBtnFood4, mBtnFood5, mBtnFood6, mBtnFood7, mBtnFood8, mBtnFood9, mBtnFood10, mBtnFood11, mBtnFood12, mBtnFood13, mBtnFood14, mBtnFood15, mBtnFood16;
    private ImageView mIvBack;

    private int mPeopleNumber;
    @NotNull private String mStoreKind = "";
    private String mStoreMood;

    private boolean mPeopleCheck = false;
    private boolean[] storeCheck = new boolean[16];
    private boolean mStoreKindCheck = false;
    private boolean mStoreMoodCheck = false;

    private CustomDialogOneButton mCustomDialogOneButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chachacha);

        sChaChaChaActivity = ChachachaActivity.this;

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
                for(int i=0; i<16; i++){
                    if(storeCheck[i]){
                        mStoreKindCheck = true;
                    }
                }
                if(!mPeopleCheck){
                    mCustomDialogOneButton = new CustomDialogOneButton(ChachachaActivity.this, "인원수를 선택해주세요.");
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                }
                else if(!mStoreKindCheck){
                    mCustomDialogOneButton = new CustomDialogOneButton(ChachachaActivity.this, "가게를 선택해주세요.");
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                }
                else if(!mStoreMoodCheck){
                    mCustomDialogOneButton = new CustomDialogOneButton(ChachachaActivity.this, "가게 분위기를 선택해주세요.");
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                }
                else{
                    System.out.println(mStoreKind);
                    Intent intent = new Intent(ChachachaActivity.this, ChaChaChaListActivity.class);
                    intent.putExtra("people", mPeopleNumber);
                    intent.putExtra("kind", mStoreKind);
                    intent.putExtra("mode", mStoreMood);
                    startActivity(intent);
                }
            }
        });
        mIvBack = findViewById(R.id.chachacha_iv_back);
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(ChachachaActivity.this, MypageActivity.class);
//                startActivity(intent);
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
        mBtnFood1.setClipToOutline(true);
        mBtnFood2.setClipToOutline(true);
        mBtnFood3.setClipToOutline(true);
        mBtnFood4.setClipToOutline(true);
        mBtnFood5.setClipToOutline(true);
        mBtnFood6.setClipToOutline(true);
        mBtnFood7.setClipToOutline(true);
        mBtnFood8.setClipToOutline(true);
        mBtnFood9.setClipToOutline(true);
        mBtnFood10.setClipToOutline(true);
        mBtnFood11.setClipToOutline(true);
        mBtnFood12.setClipToOutline(true);
        mBtnFood13.setClipToOutline(true);
        mBtnFood14.setClipToOutline(true);
        mBtnFood15.setClipToOutline(true);
        mBtnFood16.setClipToOutline(true);

        Drawable alpha1 = mBtnFood1.getDrawable();
        alpha1.setAlpha(255);
        Drawable alpha2 = mBtnFood2.getDrawable();
        alpha2.setAlpha(255);
        Drawable alpha3 = mBtnFood3.getDrawable();
        alpha3.setAlpha(255);
        Drawable alpha4 = mBtnFood4.getDrawable();
        alpha4.setAlpha(255);
        Drawable alpha5 = mBtnFood5.getDrawable();
        alpha5.setAlpha(255);
        Drawable alpha6 = mBtnFood6.getDrawable();
        alpha6.setAlpha(255);
        Drawable alpha7 = mBtnFood7.getDrawable();
        alpha7.setAlpha(255);
        Drawable alpha8 = mBtnFood8.getDrawable();
        alpha8.setAlpha(255);
        Drawable alpha9 = mBtnFood9.getDrawable();
        alpha9.setAlpha(255);
        Drawable alpha10 = mBtnFood10.getDrawable();
        alpha10.setAlpha(255);
        Drawable alpha11 = mBtnFood11.getDrawable();
        alpha11.setAlpha(255);
        Drawable alpha12 = mBtnFood12.getDrawable();
        alpha12.setAlpha(255);
        Drawable alpha13 = mBtnFood13.getDrawable();
        alpha13.setAlpha(255);
        Drawable alpha14 = mBtnFood14.getDrawable();
        alpha14.setAlpha(255);
        Drawable alpha15 = mBtnFood15.getDrawable();
        alpha15.setAlpha(255);
        Drawable alpha16 = mBtnFood16.getDrawable();
        alpha16.setAlpha(255);
    }

//    @Override
//    public void onStop() {
//        mPeopleNumber = 0;
//        mPeopleCheck = false;
//        mBtnNum1.setPressed(false);
//        mBtnNum1.setSelected(false);
//        mBtnNum2.setPressed(false);
//        mBtnNum2.setSelected(false);
//        mBtnNum3.setPressed(false);
//        mBtnNum3.setSelected(false);
//        mBtnNum4.setPressed(false);
//        mBtnNum4.setSelected(false);
//        mBtnNum5.setPressed(false);
//        mBtnNum5.setSelected(false);
//        mBtnNum6.setPressed(false);
//        mBtnNum6.setSelected(false);
//
//        mBtnFood1.setPressed(false);
//        mBtnFood1.setSelected(false);
//        mBtnFood2.setPressed(false);
//        mBtnFood2.setSelected(false);
//        mBtnFood3.setPressed(false);
//        mBtnFood3.setSelected(false);
//        mBtnFood4.setPressed(false);
//        mBtnFood4.setSelected(false);
//        mBtnFood5.setPressed(false);
//        mBtnFood5.setSelected(false);
//        mBtnFood6.setPressed(false);
//        mBtnFood6.setSelected(false);
//        mBtnFood7.setPressed(false);
//        mBtnFood7.setSelected(false);
//        mBtnFood8.setPressed(false);
//        mBtnFood8.setSelected(false);
//        mBtnFood9.setPressed(false);
//        mBtnFood9.setSelected(false);
//        mBtnFood10.setPressed(false);
//        mBtnFood10.setSelected(false);
//        mBtnFood11.setPressed(false);
//        mBtnFood11.setSelected(false);
//        mBtnFood12.setPressed(false);
//        mBtnFood12.setSelected(false);
//        mBtnFood13.setPressed(false);
//        mBtnFood13.setSelected(false);
//        mBtnFood14.setPressed(false);
//        mBtnFood14.setSelected(false);
//        mBtnFood15.setPressed(false);
//        mBtnFood15.setSelected(false);
//        mBtnFood16.setPressed(false);
//        mBtnFood16.setSelected(false);
//        for(int i=0; i<16; i++){
//            storeCheck[i] = false;
//        }
//        mStoreKind = "";
//
//        mBtnMood1.setPressed(false);
//        mBtnMood1.setSelected(false);
//        mBtnMood2.setPressed(false);
//        mBtnMood2.setSelected(false);
//        mBtnMood3.setPressed(false);
//        mBtnMood3.setSelected(false);
//        mBtnMood4.setPressed(false);
//        mBtnMood4.setSelected(false);
//        mBtnMood5.setPressed(false);
//        mBtnMood5.setSelected(false);
//        mBtnMood6.setPressed(false);
//        mBtnMood6.setSelected(false);
//        mBtnMood7.setPressed(false);
//        mBtnMood7.setSelected(false);
//        mBtnMood8.setPressed(false);
//        mBtnMood8.setSelected(false);
//        mStoreMoodCheck = false;
//        mStoreMood = "";
//
//        Drawable alpha1 = mBtnFood1.getDrawable();
//        alpha1.setAlpha(255);
//        Drawable alpha2 = mBtnFood2.getDrawable();
//        alpha2.setAlpha(255);
//        Drawable alpha3 = mBtnFood3.getDrawable();
//        alpha3.setAlpha(255);
//        Drawable alpha4 = mBtnFood4.getDrawable();
//        alpha4.setAlpha(255);
//        Drawable alpha5 = mBtnFood5.getDrawable();
//        alpha5.setAlpha(255);
//        Drawable alpha6 = mBtnFood6.getDrawable();
//        alpha6.setAlpha(255);
//        Drawable alpha7 = mBtnFood7.getDrawable();
//        alpha7.setAlpha(255);
//        Drawable alpha8 = mBtnFood8.getDrawable();
//        alpha8.setAlpha(255);
//        Drawable alpha9 = mBtnFood9.getDrawable();
//        alpha9.setAlpha(255);
//        Drawable alpha10 = mBtnFood10.getDrawable();
//        alpha10.setAlpha(255);
//        Drawable alpha11 = mBtnFood11.getDrawable();
//        alpha11.setAlpha(255);
//        Drawable alpha12 = mBtnFood12.getDrawable();
//        alpha12.setAlpha(255);
//        Drawable alpha13 = mBtnFood13.getDrawable();
//        alpha13.setAlpha(255);
//        Drawable alpha14 = mBtnFood14.getDrawable();
//        alpha14.setAlpha(255);
//        Drawable alpha15 = mBtnFood15.getDrawable();
//        alpha15.setAlpha(255);
//        Drawable alpha16 = mBtnFood16.getDrawable();
//        alpha16.setAlpha(255);
//
//        super.onStop();
//    }

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
                mPeopleNumber = 1;
                mPeopleCheck = true;
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
                mPeopleNumber = 2;
                mPeopleCheck = true;
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
                mPeopleNumber = 3;
                mPeopleCheck = true;
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
                mPeopleNumber = 4;
                mPeopleCheck = true;
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
                mPeopleNumber = 5;
                mPeopleCheck = true;
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
                mPeopleNumber = 6;
                mPeopleCheck = true;
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
                    mStoreKind +="BAR ";
                    storeCheck[0] = true;
                }
                else{
                    mBtnFood1.setPressed(false);
                    mBtnFood1.setSelected(false);
                    Drawable alpha = mBtnFood1.getDrawable();
                    alpha.setAlpha(255);
                    mStoreKind = mStoreKind.replace("BAR ", "");
                    storeCheck[0]=false;
                }
                break;
            case R.id.food2:
                if(!mBtnFood2.isSelected()){
                    mBtnFood2.setPressed(true);
                    mBtnFood2.setSelected(true);
                    Drawable alpha = mBtnFood2.getDrawable();
                    alpha.setAlpha(100);
                    mStoreKind +="치킨 ";
                    storeCheck[1] = true;
                }
                else{
                    mBtnFood2.setPressed(false);
                    mBtnFood2.setSelected(false);
                    Drawable alpha = mBtnFood2.getDrawable();
                    alpha.setAlpha(255);
                    mStoreKind = mStoreKind.replace("치킨 ", "");
                    storeCheck[1] = false;
                }
                break;
            case R.id.food3:
                if(!mBtnFood3.isSelected()){
                    mBtnFood3.setPressed(true);
                    mBtnFood3.setSelected(true);
                    Drawable alpha = mBtnFood3.getDrawable();
                    alpha.setAlpha(100);
                    mStoreKind +="피자 ";
                    storeCheck[2]=true;
                }
                else{
                    mBtnFood3.setPressed(false);
                    mBtnFood3.setSelected(false);
                    Drawable alpha = mBtnFood3.getDrawable();
                    alpha.setAlpha(255);
                    mStoreKind = mStoreKind.replace("피자 ", "");
                    storeCheck[2]=false;
                }
                break;
            case R.id.food4:
                if(!mBtnFood4.isSelected()){
                    mBtnFood4.setPressed(true);
                    mBtnFood4.setSelected(true);
                    Drawable alpha = mBtnFood4.getDrawable();
                    alpha.setAlpha(100);
                    mStoreKind +="이자카야 ";
                    storeCheck[3]=true;
                }
                else{
                    mBtnFood4.setPressed(false);
                    mBtnFood4.setSelected(false);
                    Drawable alpha = mBtnFood4.getDrawable();
                    alpha.setAlpha(255);
                    mStoreKind = mStoreKind.replace("이자카야 ", "");
                    storeCheck[3]=false;
                }
                break;
            case R.id.food5:
                if(!mBtnFood5.isSelected()){
                    mBtnFood5.setPressed(true);
                    mBtnFood5.setSelected(true);
                    Drawable alpha = mBtnFood5.getDrawable();
                    alpha.setAlpha(100);
                    mStoreKind +="고깃집 ";
                    storeCheck[4] = true;
                }
                else{
                    mBtnFood5.setPressed(false);
                    mBtnFood5.setSelected(false);
                    Drawable alpha = mBtnFood5.getDrawable();
                    alpha.setAlpha(255);
                    mStoreKind = mStoreKind.replace("고깃집 ", "");
                    storeCheck[4]=false;
                }
                break;
            case R.id.food6:
                if(!mBtnFood6.isSelected()){
                    mBtnFood6.setPressed(true);
                    mBtnFood6.setSelected(true);
                    Drawable alpha = mBtnFood6.getDrawable();
                    alpha.setAlpha(100);
                    mStoreKind +="중국집 ";
                    storeCheck[5]=true;
                }
                else{
                    mBtnFood6.setPressed(false);
                    mBtnFood6.setSelected(false);
                    Drawable alpha = mBtnFood6.getDrawable();
                    alpha.setAlpha(255);
                    mStoreKind = mStoreKind.replace("중국집 ", "");
                    storeCheck[5]=false;
                }
                break;
            case R.id.food7:
                if(!mBtnFood7.isSelected()){
                    mBtnFood7.setPressed(true);
                    mBtnFood7.setSelected(true);
                    Drawable alpha = mBtnFood7.getDrawable();
                    alpha.setAlpha(100);
                    mStoreKind +="횟집 ";
                    storeCheck[6]=true;
                }
                else{
                    mBtnFood7.setPressed(false);
                    mBtnFood7.setSelected(false);
                    Drawable alpha = mBtnFood7.getDrawable();
                    alpha.setAlpha(255);
                    mStoreKind = mStoreKind.replace("횟집 ", "");
                    storeCheck[6]=false;
                }
                break;
            case R.id.food8:
                if(!mBtnFood8.isSelected()){
                    mBtnFood8.setPressed(true);
                    mBtnFood8.setSelected(true);
                    Drawable alpha = mBtnFood8.getDrawable();
                    alpha.setAlpha(100);
                    mStoreKind +="포장마차 ";
                    storeCheck[7]=true;
                }
                else{
                    mBtnFood8.setPressed(false);
                    mBtnFood8.setSelected(false);
                    Drawable alpha = mBtnFood8.getDrawable();
                    alpha.setAlpha(255);
                    mStoreKind = mStoreKind.replace("포장마차 ", "");
                    storeCheck[7]=false;
                }
                break;
            case R.id.food9:
                if(!mBtnFood9.isSelected()){
                    mBtnFood9.setPressed(true);
                    mBtnFood9.setSelected(true);
                    Drawable alpha = mBtnFood9.getDrawable();
                    alpha.setAlpha(100);
                    mStoreKind +="전집 ";
                    storeCheck[8]=true;
                }
                else{
                    mBtnFood9.setPressed(false);
                    mBtnFood9.setSelected(false);
                    Drawable alpha = mBtnFood9.getDrawable();
                    alpha.setAlpha(255);
                    mStoreKind = mStoreKind.replace("전집 ", "");
                    storeCheck[8]=false;
                }
                break;
            case R.id.food10:
                if(!mBtnFood10.isSelected()){
                    mBtnFood10.setPressed(true);
                    mBtnFood10.setSelected(true);
                    Drawable alpha = mBtnFood10.getDrawable();
                    alpha.setAlpha(100);
                    mStoreKind +="족발보쌈 ";
                    storeCheck[9]=true;
                }
                else{
                    mBtnFood10.setPressed(false);
                    mBtnFood10.setSelected(false);
                    Drawable alpha = mBtnFood10.getDrawable();
                    alpha.setAlpha(255);
                    mStoreKind = mStoreKind.replace("족발보쌈 ", "");
                    storeCheck[9]=false;
                }
                break;
            case R.id.food11:
                if(!mBtnFood11.isSelected()){
                    mBtnFood11.setPressed(true);
                    mBtnFood11.setSelected(true);
                    Drawable alpha = mBtnFood11.getDrawable();
                    alpha.setAlpha(100);
                    mStoreKind +="호프집 ";
                    storeCheck[10]=true;
                }
                else{
                    mBtnFood11.setPressed(false);
                    mBtnFood11.setSelected(false);
                    Drawable alpha = mBtnFood11.getDrawable();
                    alpha.setAlpha(255);
                    mStoreKind = mStoreKind.replace("호프집 ", "");
                    storeCheck[10]=false;
                }
                break;
            case R.id.food12:
                if(!mBtnFood12.isSelected()){
                    mBtnFood12.setPressed(true);
                    mBtnFood12.setSelected(true);
                    Drawable alpha = mBtnFood12.getDrawable();
                    alpha.setAlpha(100);
                    mStoreKind +="퓨전요리 ";
                    storeCheck[11]=true;
                }
                else{
                    mBtnFood12.setPressed(false);
                    mBtnFood12.setSelected(false);
                    Drawable alpha = mBtnFood12.getDrawable();
                    alpha.setAlpha(255);
                    mStoreKind = mStoreKind.replace("퓨전요리 ", "");
                    storeCheck[11] = false;
                }
                break;
            case R.id.food13:
                if(!mBtnFood13.isSelected()){
                    mBtnFood13.setPressed(true);
                    mBtnFood13.setSelected(true);
                    Drawable alpha = mBtnFood13.getDrawable();
                    alpha.setAlpha(100);
                    mStoreKind +="국밥집 ";
                    storeCheck[12]=true;
                }
                else{
                    mBtnFood13.setPressed(false);
                    mBtnFood13.setSelected(false);
                    Drawable alpha = mBtnFood13.getDrawable();
                    alpha.setAlpha(255);
                    mStoreKind = mStoreKind.replace("국밥집 ", "");
                    storeCheck[12]=false;
                }
                break;
            case R.id.food14:
                if(!mBtnFood14.isSelected()){
                    mBtnFood14.setPressed(true);
                    mBtnFood14.setSelected(true);
                    Drawable alpha = mBtnFood14.getDrawable();
                    alpha.setAlpha(100);
                    mStoreKind +="양꼬치 ";
                    storeCheck[13]=true;
                }
                else{
                    mBtnFood14.setPressed(false);
                    mBtnFood14.setSelected(false);
                    Drawable alpha = mBtnFood14.getDrawable();
                    alpha.setAlpha(255);
                    mStoreKind = mStoreKind.replace("양꼬치 ", "");
                    storeCheck[13]=false;
                }
                break;
            case R.id.food15:
                if(!mBtnFood15.isSelected()){
                    mBtnFood15.setPressed(true);
                    mBtnFood15.setSelected(true);
                    Drawable alpha = mBtnFood15.getDrawable();
                    alpha.setAlpha(100);
                    mStoreKind +="한식 ";
                    storeCheck[14]=true;
                }
                else{
                    mBtnFood15.setPressed(false);
                    mBtnFood15.setSelected(false);
                    Drawable alpha = mBtnFood15.getDrawable();
                    alpha.setAlpha(255);
                    mStoreKind = mStoreKind.replace("한식 ", "");
                    storeCheck[14]=false;
                }
                break;
            case R.id.food16:
                if(!mBtnFood16.isSelected()){
                    mBtnFood16.setPressed(true);
                    mBtnFood16.setSelected(true);
                    Drawable alpha = mBtnFood16.getDrawable();
                    alpha.setAlpha(100);
                    mStoreKind +="와인바 ";
                    storeCheck[15]=true;
                }
                else{
                    mBtnFood16.setPressed(false);
                    mBtnFood16.setSelected(false);
                    Drawable alpha = mBtnFood16.getDrawable();
                    alpha.setAlpha(255);
                    mStoreKind = mStoreKind.replace("와인바 ", "");
                    storeCheck[15]=false;
                }
                break;
        }
    }

    public void moodClick(View view){
        switch (view.getId()){
            case R.id.mood1:
                mBtnMood1.setPressed(true);
                mBtnMood1.setSelected(true);
                mBtnMood2.setPressed(false);
                mBtnMood2.setSelected(false);
                mBtnMood3.setPressed(false);
                mBtnMood3.setSelected(false);
                mBtnMood4.setPressed(false);
                mBtnMood4.setSelected(false);
                mBtnMood5.setPressed(false);
                mBtnMood5.setSelected(false);
                mBtnMood6.setPressed(false);
                mBtnMood6.setSelected(false);
                mBtnMood7.setPressed(false);
                mBtnMood7.setSelected(false);
                mBtnMood8.setPressed(false);
                mBtnMood8.setSelected(false);
                mStoreMood = "#자유로운";
                mStoreMoodCheck = true;
                break;
            case R.id.mood2:
                mBtnMood2.setPressed(true);
                mBtnMood2.setSelected(true);
                mBtnMood1.setPressed(false);
                mBtnMood1.setSelected(false);
                mBtnMood3.setPressed(false);
                mBtnMood3.setSelected(false);
                mBtnMood4.setPressed(false);
                mBtnMood4.setSelected(false);
                mBtnMood5.setPressed(false);
                mBtnMood5.setSelected(false);
                mBtnMood6.setPressed(false);
                mBtnMood6.setSelected(false);
                mBtnMood7.setPressed(false);
                mBtnMood7.setSelected(false);
                mBtnMood8.setPressed(false);
                mBtnMood8.setSelected(false);
                mStoreMood = "#편안한";
                mStoreMoodCheck = true;
                break;
            case R.id.mood3:
                mBtnMood3.setPressed(true);
                mBtnMood3.setSelected(true);
                mBtnMood2.setPressed(false);
                mBtnMood2.setSelected(false);
                mBtnMood1.setPressed(false);
                mBtnMood1.setSelected(false);
                mBtnMood4.setPressed(false);
                mBtnMood4.setSelected(false);
                mBtnMood5.setPressed(false);
                mBtnMood5.setSelected(false);
                mBtnMood6.setPressed(false);
                mBtnMood6.setSelected(false);
                mBtnMood7.setPressed(false);
                mBtnMood7.setSelected(false);
                mBtnMood8.setPressed(false);
                mBtnMood8.setSelected(false);
                mStoreMood = "#어두운";
                mStoreMoodCheck = true;
                break;
            case R.id.mood4:
                mBtnMood4.setPressed(true);
                mBtnMood4.setSelected(true);
                mBtnMood2.setPressed(false);
                mBtnMood2.setSelected(false);
                mBtnMood3.setPressed(false);
                mBtnMood3.setSelected(false);
                mBtnMood1.setPressed(false);
                mBtnMood1.setSelected(false);
                mBtnMood5.setPressed(false);
                mBtnMood5.setSelected(false);
                mBtnMood6.setPressed(false);
                mBtnMood6.setSelected(false);
                mBtnMood7.setPressed(false);
                mBtnMood7.setSelected(false);
                mBtnMood8.setPressed(false);
                mBtnMood8.setSelected(false);
                mStoreMood = "#아늑한";
                mStoreMoodCheck = true;
                break;
            case R.id.mood5:
                mBtnMood5.setPressed(true);
                mBtnMood5.setSelected(true);
                mBtnMood2.setPressed(false);
                mBtnMood2.setSelected(false);
                mBtnMood3.setPressed(false);
                mBtnMood3.setSelected(false);
                mBtnMood4.setPressed(false);
                mBtnMood4.setSelected(false);
                mBtnMood1.setPressed(false);
                mBtnMood1.setSelected(false);
                mBtnMood6.setPressed(false);
                mBtnMood6.setSelected(false);
                mBtnMood7.setPressed(false);
                mBtnMood7.setSelected(false);
                mBtnMood8.setPressed(false);
                mBtnMood8.setSelected(false);
                mStoreMood = "#활기찬";
                mStoreMoodCheck = true;
                break;
            case R.id.mood6:
                mBtnMood6.setPressed(true);
                mBtnMood6.setSelected(true);
                mBtnMood2.setPressed(false);
                mBtnMood2.setSelected(false);
                mBtnMood3.setPressed(false);
                mBtnMood3.setSelected(false);
                mBtnMood4.setPressed(false);
                mBtnMood4.setSelected(false);
                mBtnMood5.setPressed(false);
                mBtnMood5.setSelected(false);
                mBtnMood1.setPressed(false);
                mBtnMood1.setSelected(false);
                mBtnMood7.setPressed(false);
                mBtnMood7.setSelected(false);
                mBtnMood8.setPressed(false);
                mBtnMood8.setSelected(false);
                mStoreMood = "#조용한";
                mStoreMoodCheck = true;
                break;
            case R.id.mood7:
                mBtnMood7.setPressed(true);
                mBtnMood7.setSelected(true);
                mBtnMood2.setPressed(false);
                mBtnMood2.setSelected(false);
                mBtnMood3.setPressed(false);
                mBtnMood3.setSelected(false);
                mBtnMood4.setPressed(false);
                mBtnMood4.setSelected(false);
                mBtnMood5.setPressed(false);
                mBtnMood5.setSelected(false);
                mBtnMood6.setPressed(false);
                mBtnMood6.setSelected(false);
                mBtnMood1.setPressed(false);
                mBtnMood1.setSelected(false);
                mBtnMood8.setPressed(false);
                mBtnMood8.setSelected(false);
                mStoreMood = "#데이트하기좋은";
                mStoreMoodCheck = true;
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
                mStoreMood = "상관없음";
                mStoreMoodCheck = true;
                break;

        }
    }
}
