package com.example.project_chachacha.template.src.shop.shopInfo;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.CustomDialogOneButton;
import com.example.project_chachacha.template.src.CustomDialogTwoButton;
import com.example.project_chachacha.template.src.login.LoginActivity;
import com.example.project_chachacha.template.src.shop.Interfaces.ShopChaChaChaView;
import com.example.project_chachacha.template.src.shop.ShopChaChaChaService;
import com.example.project_chachacha.template.src.shop.shopInfo.ShopMenu.MenuFragment;
import com.example.project_chachacha.template.src.shop.shopInfo.ShopReview.ReviewFragment;

import static com.example.project_chachacha.template.src.ApplicationClass.USERID;

public class ShopInfoActivity extends BaseActivity implements ShopChaChaChaView {

    private ImageView mIvStar;
    boolean like = false;
    private TextView mTvMenu, mTvReview, mTvShopTitle;
    private View mViewMenu, mViewReview;

    private FragmentManager fragmentManager;
    private MenuFragment menuFragment;
    private ReviewFragment reviewFragment;
    private FragmentTransaction transaction;

    private CustomDialogTwoButton mCustomDialogTwoButton;
    private CustomDialogOneButton mCustomDialogOneButton;

    private String mStrMessage;

    private int storeNum;

    private final ShopChaChaChaService shopChaChaChaService = new ShopChaChaChaService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_info);

        storeNum = 1; // 임시값

        mTvMenu = findViewById(R.id.shopInfo_tv_menu);
        mTvReview = findViewById(R.id.shopInfo_tv_review);
        mViewMenu = findViewById(R.id.shopInfo_view_menu);
        mViewReview = findViewById(R.id.shopInfo_view_review);
        mTvShopTitle = findViewById(R.id.shopInfo_tv_title);

        Button btnChaChaCha = findViewById(R.id.shopInfo_btn_chachacha);
        btnChaChaCha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String msg = "마이차차차에 추가하시겠습니까?";
                mCustomDialogTwoButton = new CustomDialogTwoButton(ShopInfoActivity.this, msg, leftListener);
                mCustomDialogTwoButton.setCancelable(false);
                mCustomDialogTwoButton.show();
            }
        });

        mIvStar = findViewById(R.id.shopInfo_iv_star);
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

        menuFragment = new MenuFragment();
        reviewFragment = new ReviewFragment();

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.shopInfo_fragment, menuFragment).commitAllowingStateLoss();

        mTvMenu.setPressed(true);
        mTvMenu.setSelected(true);
        mViewMenu.setPressed(true);
        mViewMenu.setSelected(true);
    }

    private View.OnClickListener leftListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            shopChaChaChaService.postSaveMyCha(USERID, storeNum);
            mCustomDialogTwoButton.dismiss();
        }
    };

    public void menuClick(View v){

        transaction = fragmentManager.beginTransaction();

        switch (v.getId()){
            case R.id.shopInfo_tv_menu:
                mTvMenu.setPressed(true);
                mTvMenu.setSelected(true);
                mTvReview.setPressed(false);
                mTvReview.setSelected(false);
                mViewMenu.setPressed(true);
                mViewMenu.setSelected(true);
                mViewReview.setPressed(false);
                mViewReview.setSelected(false);
                transaction.replace(R.id.shopInfo_fragment, menuFragment).commitAllowingStateLoss();
                break;
            case R.id.shopInfo_tv_review:
                mTvReview.setPressed(true);
                mTvReview.setSelected(true);
                mTvMenu.setPressed(false);
                mTvMenu.setSelected(false);
                mViewReview.setPressed(true);
                mViewReview.setSelected(true);
                mViewMenu.setPressed(false);
                mViewMenu.setSelected(false);
                transaction.replace(R.id.shopInfo_fragment, reviewFragment).commitAllowingStateLoss();
                break;

        }
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

        if(code!=Success){
            switch (code){
                case InvalidToken:
                    ActivityCompat.finishAffinity(this); // 처리할 방법 생각
                    Intent intent = new Intent(ShopInfoActivity.this, LoginActivity.class);
                    startActivity(intent);
                    mStrMessage = "유효하지 않은 토큰입니다.\n다시 로그인 해주세요.";
                    mCustomDialogOneButton = new CustomDialogOneButton(this, mStrMessage);
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                    finish();
                    break;
                case InvalidFormStoreNum:
                    mStrMessage = "잘못된 형식의 storeNum입니다.";
                    break;
                case Duplicate:
                    mStrMessage = "이미 마이차차차에 등록된 가게입니다.";
                    break;
                case EmptyStoreNum:
                    mStrMessage = "storeNum이 입력되지 않았습니다.";
                    break;
                case InvalidUserId:
                    mStrMessage = "유효하지 않은 userId입니다.";
                    break;
                case InvalidStoreNum:
                    mStrMessage = "유효하지 않은 storeNum입니다.";
                    break;
            }
            mCustomDialogOneButton = new CustomDialogOneButton(this, mStrMessage);
            mCustomDialogOneButton.setCancelable(false);
            mCustomDialogOneButton.show();
        }

    }

    @Override
    public void validateFailureChaChaCha(String message) {
        mCustomDialogOneButton = new CustomDialogOneButton(this, message);
        mCustomDialogOneButton.setCancelable(false);
        mCustomDialogOneButton.show();
    }
}
