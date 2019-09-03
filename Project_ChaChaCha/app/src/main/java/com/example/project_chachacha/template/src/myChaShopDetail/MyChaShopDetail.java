package com.example.project_chachacha.template.src.myChaShopDetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.shopInfo.ShopInfoActivity;

public class MyChaShopDetail extends BaseActivity {

    private Button mBtnReview;

    private ImageView mIvMoreInfo;
    private ImageView mIvStar;
    boolean like = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cha__shop__detail);

        mBtnReview =findViewById(R.id.myChaShopDetail_btn_review);
        mBtnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyChaShopDetail.this, WriteReview.class);
                startActivity(intent);
            }
        });

        mIvMoreInfo = findViewById(R.id.myChaShopDetail_iv_moreinfo);
        mIvMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyChaShopDetail.this, ShopInfoActivity.class);
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
    }
}
