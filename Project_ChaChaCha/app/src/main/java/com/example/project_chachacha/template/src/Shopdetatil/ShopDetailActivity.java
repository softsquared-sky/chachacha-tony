package com.example.project_chachacha.template.src.Shopdetatil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.ShopInfo.ShopInfoActivity;
import com.example.project_chachacha.template.src.Shopdetatil.Interfaces.ShopDetailView;
import com.example.project_chachacha.template.src.Shopdetatil.models.ShopDetailResult;

import java.util.List;

public class ShopDetailActivity extends BaseActivity implements ShopDetailView {

    private ImageView mIvMoreInfo, mIvShopImg, mIvCall;
    private TextView mTvShopTitle, mTvShopTitle2, mTvMood, mTvWriting, mTvShopAddress, mTvShopTime;
    private String mStrPhone;
    private int storeNum; // 넘겨받아야하는값

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

        mTvShopTitle = findViewById(R.id.shopDetail_tv_title);
        mTvShopTitle2 = findViewById(R.id.shopDetail_tv_title2);
        mTvMood = findViewById(R.id.shopDetail_tv_mood);
        mTvWriting = findViewById(R.id.shopDetail_tv_storeWriting);
        mTvShopAddress = findViewById(R.id.shopDetail_tv_shopAddress);
        mTvShopTime = findViewById(R.id.shopDetail_tv_shoptime);
        mIvShopImg = findViewById(R.id.shopDetail_iv_shopImg);
        mIvCall = findViewById(R.id.shopDetail_iv_call);

        mIvCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(mStrPhone));
                startActivity(intent);
            }
        });

        final ShopDetailService shopDetailService = new ShopDetailService(this);
        shopDetailService.getDetail(1); // 받은값으로 해당 가게 조회

        mIvMoreInfo = findViewById(R.id.shopDetail_iv_moreInfo);
        mIvMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopDetailActivity.this, ShopInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void validateSuccess(int code, String message, List<ShopDetailResult> results) {
        if(code==207){
            List<ShopDetailResult> result = results;
            for(int i=0; i<result.size(); i++){
                mTvShopTitle.setText(result.get(i).getStorename());
                mTvShopTitle2.setText(result.get(i).getStorename());
                mTvMood.setText(result.get(i).getMode());
                mTvWriting.setText(result.get(i).getStorewriting());
                mTvShopAddress.setText(result.get(i).getAddress());
                String content = result.get(i).getOpentime() + "-" + result.get(i).getClosstime();
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
}
