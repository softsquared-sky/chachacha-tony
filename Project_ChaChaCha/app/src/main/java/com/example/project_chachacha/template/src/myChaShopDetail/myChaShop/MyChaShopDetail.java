package com.example.project_chachacha.template.src.myChaShopDetail.myChaShop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.CustomDialogOneButton;
import com.example.project_chachacha.template.src.myChaShopDetail.myChaShop.Interfaces.MyChaShopView;
import com.example.project_chachacha.template.src.myChaShopDetail.myChaShop.models.MyChaShopResult;
import com.example.project_chachacha.template.src.myChaShopDetail.writeReview.WriteReview;
import com.example.project_chachacha.template.src.shop.shopInfo.ShopInfoActivity;

import static com.example.project_chachacha.template.src.ApplicationClass.USERID;

public class MyChaShopDetail extends BaseActivity implements MyChaShopView {

    private Button mBtnReview;

    private TextView mTvMainTitle, mTvSubTitle, mTvMood, mTvWriting, mTvAddress, mTvShopTime;
    private ImageView mIvBackImg;
    private ImageView mIvCall;
    private ImageView mIvMoreInfo;
    private ImageView mIvStar;
    private ImageView mIvback;
    private boolean like = false;

    private String mStrMessage;
    private String mStrPhone;

    private int storeNum;
    private int chaNum;

    private CustomDialogOneButton mCustomDialogOneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cha__shop__detail);

        Intent intent = getIntent();
        chaNum = intent.getIntExtra("chanum", 0);
        storeNum = intent.getIntExtra("storenum",0);

        final MyChaShopService myChaShopService = new MyChaShopService(this);
        myChaShopService.getMyShop(USERID, chaNum);

        mBtnReview =findViewById(R.id.myChaShopDetail_btn_review);
        mBtnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyChaShopDetail.this, WriteReview.class);
                intent.putExtra("chanum",chaNum);
                intent.putExtra("title", mTvMainTitle.getText().toString());
                startActivity(intent);
            }
        });

        mIvback = findViewById(R.id.myChashopDetail_iv_back);
        mIvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mIvCall = findViewById(R.id.myChaShopDetail_iv_call);
        mIvCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(mStrPhone));
                startActivity(intent);
            }
        });

        mIvMoreInfo = findViewById(R.id.myChaShopDetail_iv_moreinfo);
        mIvMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(mTvMainTitle.getText().toString());
                Intent intent = new Intent(MyChaShopDetail.this, ShopInfoActivity.class);
                intent.putExtra("storenum", storeNum);
                intent.putExtra("storename", mTvMainTitle.getText().toString());
                intent.putExtra("check",true);
                intent.putExtra("chanum", chaNum);
                startActivity(intent);
            }
        });

        mIvStar = findViewById(R.id.myChaShopDetail_iv_star);
        mIvStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!like){
                    mIvStar.setImageResource(R.drawable.ic_yellow_star);
                    like = true;
                }
                else{
                    mIvStar.setImageResource(R.drawable.ic_empty_star);
                    like = false;
                }
            }
        });

        mTvMainTitle = findViewById(R.id.myChaShopDetail_tv_shoptitle);
        mTvSubTitle = findViewById(R.id.myChaShopDetail_tv_shoptitle2);
        mTvMood = findViewById(R.id.myChaShopDetail_tv_mood);
        mTvWriting = findViewById(R.id.myChaShopDetail_tv_writing);
        mTvAddress = findViewById(R.id.myChaShopDetail_tv_shopAddress);
        mTvShopTime = findViewById(R.id.myChaShopDetail_tv_shoptime);
        mIvBackImg = findViewById(R.id.myChaShopDetail_iv_backImg);
    }

    @Override
    public void validateSuccess(int code, MyChaShopResult result) {
        final int Success = 227;
        final int InvalidToken = 201;
        final int InvalidUserId = 399;
        final int InvalidChaNum = 599;
        if(code == Success){
            mTvMainTitle.setText(result.getStorename());
            mTvSubTitle.setText(result.getStorename());
            String mood = result.getMode();
            mood = mood.replace(",","");
            mTvMood.setText(mood);
            mTvWriting.setText(result.getStorewriting());
            Glide.with(this).load(result.getImageurl()).into(mIvBackImg);
            mTvAddress.setText(result.getAddress());
            String shopTime = result.getOpentime() + " - " + result.getClosstime();
            mTvShopTime.setText(shopTime);
            mStrPhone = result.getPhone().replace("-","");
            mStrPhone = "tel:"+mStrPhone;
        }
        else{
            switch (code){
                case InvalidToken:
                    mStrMessage = "유효하지 않은 토큰입니다.";
                    break;
                case InvalidUserId:
                    mStrMessage = "유효하지 않은 아이디입니다.";
                    break;
                case InvalidChaNum:
                    mStrMessage = "유효하지 않은 마이차차차넘버입니다.";
                    break;
            }

            mCustomDialogOneButton = new CustomDialogOneButton(this, mStrMessage);
            mCustomDialogOneButton.setCancelable(false);
            mCustomDialogOneButton.show();
        }
    }

    @Override
    public void validateFailure(String message) {
        mCustomDialogOneButton = new CustomDialogOneButton(this, message);
        mCustomDialogOneButton.setCancelable(false);
        mCustomDialogOneButton.show();
    }
}
