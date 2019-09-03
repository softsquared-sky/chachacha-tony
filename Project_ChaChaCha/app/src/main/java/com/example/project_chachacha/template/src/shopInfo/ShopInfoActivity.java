package com.example.project_chachacha.template.src.shopInfo;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.shopInfo.ShopMenu.MenuFragment;
import com.example.project_chachacha.template.src.shopInfo.ShopReview.ReviewFragment;

public class ShopInfoActivity extends BaseActivity {

    private ImageView mIvStar;
    boolean like = false;
    private TextView mTvMenu, mTvReview, mTvShopTitle;
    private View mViewMenu, mViewReview;

    private FragmentManager fragmentManager;
    private MenuFragment menuFragment;
    private ReviewFragment reviewFragment;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_info);

        mTvMenu = findViewById(R.id.shopInfo_tv_menu);
        mTvReview = findViewById(R.id.shopInfo_tv_review);
        mViewMenu = findViewById(R.id.shopInfo_view_menu);
        mViewReview = findViewById(R.id.shopInfo_view_review);
        mTvShopTitle = findViewById(R.id.shopInfo_tv_title);

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
}
