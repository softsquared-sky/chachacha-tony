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
import com.example.project_chachacha.template.src.myChaShopDetail.writeReview.WriteReview;
import com.example.project_chachacha.template.src.myPage.MypageActivity;
import com.example.project_chachacha.template.src.shop.Interfaces.ShopChaChaChaView;
import com.example.project_chachacha.template.src.shop.ShopChaChaChaService;
import com.example.project_chachacha.template.src.shop.shopInfo.ShopMenu.MenuFragment;
import com.example.project_chachacha.template.src.shop.shopInfo.ShopReview.ReviewFragment;
import com.example.project_chachacha.template.src.shop.shopdetatil.ShopDetailActivity;

import static com.example.project_chachacha.template.src.ApplicationClass.USERID;

public class ShopInfoActivity extends BaseActivity implements ShopChaChaChaView {

    private ImageView mIvStar;
    private ImageView mIvback;
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

    private Button mBtnChaChaCha;
    private Button mBtnReview;

    private int storeNum;
    private int chaNum;
    private String storeName;
    private boolean checkToMyChaChaCha;

    private final ShopChaChaChaService shopChaChaChaService = new ShopChaChaChaService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_info);

        mTvMenu = findViewById(R.id.shopInfo_tv_menu);
        mTvReview = findViewById(R.id.shopInfo_tv_review);
        mViewMenu = findViewById(R.id.shopInfo_view_menu);
        mViewReview = findViewById(R.id.shopInfo_view_review);
        mTvShopTitle = findViewById(R.id.shopInfo_tv_title);

        mBtnChaChaCha = findViewById(R.id.shopInfo_btn_chachacha);
        mBtnChaChaCha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String msg = "마이차차차에 추가하시겠습니까?";
                mCustomDialogTwoButton = new CustomDialogTwoButton(ShopInfoActivity.this, msg, leftListener);
                mCustomDialogTwoButton.setCancelable(false);
                mCustomDialogTwoButton.show();
            }
        });

        mIvback = findViewById(R.id.shopinfo_iv_back);
        mIvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        Intent intent = getIntent();
        storeNum = intent.getIntExtra("storenum",0);
        chaNum = intent.getIntExtra("chanum", -10);
        storeName = intent.getStringExtra("storename");
        checkToMyChaChaCha = intent.getBooleanExtra("check", false);
        if(storeName!=null){
            mTvShopTitle.setText(storeName);
        }

        if(checkToMyChaChaCha){
            mBtnChaChaCha.setVisibility(View.GONE);
        }


        mBtnReview = findViewById(R.id.shopInfo_btn_review);
        mBtnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopInfoActivity.this, WriteReview.class);
                intent.putExtra("title", mTvShopTitle.getText().toString());
                if(chaNum!=-10){
                    intent.putExtra("chanum",chaNum);
                }
                startActivity(intent);
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

        Bundle bundle1 = new Bundle();
        bundle1.putInt("storenum", storeNum);
        menuFragment.setArguments(bundle1);

        Bundle bundle2 = new Bundle();
        bundle2.putInt("storenum", storeNum);
        reviewFragment.setArguments(bundle2);

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
            showProgressDialog();
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

    private View.OnClickListener MyChaChaCha = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ShopDetailActivity sd = (ShopDetailActivity)ShopDetailActivity.sShopDetailActivity;
            Intent intent = new Intent(ShopInfoActivity.this, MypageActivity.class);
            intent.putExtra("checkMyCha",true);
            startActivity(intent);
            mCustomDialogTwoButton.dismiss();
            finish();
            sd.finish();
        }
    };

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

        if (code == Success){
            mCustomDialogTwoButton = new CustomDialogTwoButton(this, "마이차차차에 추가되었습니다.\n마이차차차로 이동하시겠습니까?",MyChaChaCha);
            mCustomDialogTwoButton.setCancelable(false);
            mCustomDialogTwoButton.show();
        }
        else{
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
