package com.example.project_chachacha.template.src.shop.shopdetatil;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;
import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.CustomDialogOneButton;
import com.example.project_chachacha.template.src.CustomDialogTwoButton;
import com.example.project_chachacha.template.src.login.LoginActivity;
import com.example.project_chachacha.template.src.myPage.MypageActivity;
import com.example.project_chachacha.template.src.shop.Interfaces.ShopChaChaChaView;
import com.example.project_chachacha.template.src.shop.ShopChaChaChaService;
import com.example.project_chachacha.template.src.shop.shopInfo.ShopInfoActivity;
import com.example.project_chachacha.template.src.shop.shopdetatil.Interfaces.ShopDetailView;
import com.example.project_chachacha.template.src.shop.shopdetatil.models.ShopDetailResult;

import java.util.List;

import static com.example.project_chachacha.template.src.ApplicationClass.USERID;

public class ShopDetailActivity extends BaseActivity implements ShopDetailView, ShopChaChaChaView {

    public static Activity sShopDetailActivity;

    private ImageView mIvMoreInfo, mIvShopImg, mIvCall, mIvStar, mIvback;
    private TextView mTvShopTitle, mTvShopTitle2, mTvMood, mTvWriting, mTvShopAddress, mTvShopTime;
    private String mStrPhone;
    private Button mBtnChaChaCha;
    private int storeNum; // 넘겨받아야하는값

    private CustomDialogTwoButton mCustomDialogTwoButton;
    private CustomDialogOneButton mCustomDialogOneButton;

    private String mStrMessage;
    private boolean like = false;

    private final ShopChaChaChaService shopChaChaChaService = new ShopChaChaChaService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

        sShopDetailActivity = ShopDetailActivity.this;

        Intent intent = getIntent();
        storeNum = intent.getIntExtra("storenum", 0);

        mTvShopTitle = findViewById(R.id.shopDetail_tv_title);
        mTvShopTitle2 = findViewById(R.id.shopDetail_tv_title2);
        mTvMood = findViewById(R.id.shopDetail_tv_mood);
        mTvWriting = findViewById(R.id.shopDetail_tv_storeWriting);
        mTvShopAddress = findViewById(R.id.shopDetail_tv_shopAddress);
        mTvShopTime = findViewById(R.id.shopDetail_tv_shoptime);
        mIvShopImg = findViewById(R.id.shopDetail_iv_shopImg);
        mIvCall = findViewById(R.id.shopDetail_iv_call);
        mIvStar = findViewById(R.id.shopDetail_iv_star);

        mIvCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(mStrPhone));
                startActivity(intent);
            }
        });

        mIvback = findViewById(R.id.shopDetail_iv_back);
        mIvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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

        final ShopDetailService shopDetailService = new ShopDetailService(this);

        shopDetailService.getDetail(storeNum); // 받은값으로 해당 가게 조회

        mIvMoreInfo = findViewById(R.id.shopDetail_iv_moreInfo);
        mIvMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopDetailActivity.this, ShopInfoActivity.class);
                intent.putExtra("storenum", storeNum);
                intent.putExtra("storename", mTvShopTitle.getText().toString());
                intent.putExtra("check",false);
                startActivity(intent);
            }
        });


        mBtnChaChaCha = findViewById(R.id.shopDetail_btn_chachacha);
        mBtnChaChaCha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "마이차차차에 추가하시겠습니까?";
                mCustomDialogTwoButton = new CustomDialogTwoButton(ShopDetailActivity.this, msg, leftListener);
                mCustomDialogTwoButton.setCancelable(false);
                mCustomDialogTwoButton.show();
            }
        });

    }

    private View.OnClickListener leftListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            showProgressDialog();
            shopChaChaChaService.postSaveMyCha(USERID, storeNum);
            mCustomDialogTwoButton.dismiss();
        }
    };

    private View.OnClickListener MyChaChaCha = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ShopDetailActivity.this, MypageActivity.class);
            intent.putExtra("checkMyCha",true);
            startActivity(intent);
            mCustomDialogTwoButton.dismiss();
            finish();
        }
    };

    @Override
    public void validateSuccess(int code, String message, List<ShopDetailResult> results) {
        if(code==207){
            List<ShopDetailResult> result = results;
            for(int i=0; i<result.size(); i++){
                mTvShopTitle.setText(result.get(i).getStorename());
                mTvShopTitle2.setText(result.get(i).getStorename());
                String mood = result.get(i).getMode().replace(",","");
                mTvMood.setText(mood);
                mTvWriting.setText(result.get(i).getStorewriting());
                mTvShopAddress.setText(result.get(i).getAddress());
                String content = result.get(i).getOpentime() + " - " + result.get(i).getClosstime();
                mTvShopTime.setText(getString(R.string.common_content, content));
                Glide.with(this).load(result.get(i).getImageurl()).into(mIvShopImg);
                mStrPhone = result.get(i).getPhone();
            }
            mStrPhone = mStrPhone.replace("-","");
            mStrPhone = "tel:"+ mStrPhone;
        }
    }

    @Override
    public void validateFailure(int code, String message) {
        System.out.println(code + " " + message);
    }

    @Override
    public void validateSuccessChaChaCha(int code) {
        final int Success = 215;
        final int InvalidToken = 201;
        final int InvalidFormStoreNum = 216;
        final int Duplicate = 217;
        final int EmptyStoreNum = 298;
        final int InvalidUserId = 399;
        final int InvalidStoreNum = 449;
        hideProgressDialog();
        if(code == Success){
            mCustomDialogTwoButton = new CustomDialogTwoButton(this, "마이차차차에 추가되었습니다.\n마이차차차로 이동하시겠습니까?",MyChaChaCha);
            mCustomDialogTwoButton.setCancelable(false);
            mCustomDialogTwoButton.show();
        }
        else{
            switch (code){
                case InvalidToken:
                    ActivityCompat.finishAffinity(this); // 처리할 방법 생각
                    Intent intent = new Intent(ShopDetailActivity.this, LoginActivity.class);
                    startActivity(intent);
                    mStrMessage = "유효하지 않은 토큰입니다.\n다시 로그인 해주세요.";
                    mCustomDialogOneButton = new CustomDialogOneButton(this, mStrMessage);
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                    finish();
                    break;
                case InvalidFormStoreNum:
                    mStrMessage = "잘못된 형식의 storeNum입니다.";
                    mCustomDialogOneButton = new CustomDialogOneButton(this, mStrMessage);
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                    break;
                case Duplicate:
                    mStrMessage = "이미 마이차차차에 등록된 가게입니다.\n마이차차차로 이동하시겠습니까?";
                    mCustomDialogTwoButton = new CustomDialogTwoButton(this, mStrMessage,MyChaChaCha);
                    mCustomDialogTwoButton.setCancelable(false);
                    mCustomDialogTwoButton.show();
                    break;
                case EmptyStoreNum:
                    mStrMessage = "storeNum이 입력되지 않았습니다.";
                    mCustomDialogOneButton = new CustomDialogOneButton(this, mStrMessage);
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                    break;
                case InvalidUserId:
                    mStrMessage = "유효하지 않은 userId입니다.";
                    mCustomDialogOneButton = new CustomDialogOneButton(this, mStrMessage);
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                    break;
                case InvalidStoreNum:
                    mStrMessage = "유효하지 않은 storeNum입니다.";
                    mCustomDialogOneButton = new CustomDialogOneButton(this, mStrMessage);
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                    break;
            }
        }

    }

    @Override
    public void validateFailureChaChaCha(String message) {
        mCustomDialogOneButton = new CustomDialogOneButton(this, message);
        mCustomDialogOneButton.setCancelable(false);
        mCustomDialogOneButton.show();
    }
}
