package com.example.project_chachacha.template.src.MyChaShopDetail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;

public class WriteReview extends BaseActivity {

    private ImageView mIvStar1, mIvStar2, mIvStar3, mIvStar4, mIvStar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);

        mIvStar1 = findViewById(R.id.writeReview_iv_star1);
        mIvStar2 = findViewById(R.id.writeReview_iv_star2);
        mIvStar3 = findViewById(R.id.writeReview_iv_star3);
        mIvStar4 = findViewById(R.id.writeReview_iv_star4);
        mIvStar5 = findViewById(R.id.writeReview_iv_star5);
    }

    public void starClick(View view){
        switch (view.getId()){
            case R.id.writeReview_iv_star1:
                mIvStar1.setImageResource(R.drawable.ic_yellow_star);
                mIvStar2.setImageResource(R.drawable.ic_grey50);
                mIvStar3.setImageResource(R.drawable.ic_grey50);
                mIvStar4.setImageResource(R.drawable.ic_grey50);
                mIvStar5.setImageResource(R.drawable.ic_grey50);
                break;
            case R.id.writeReview_iv_star2:
                mIvStar1.setImageResource(R.drawable.ic_yellow_star);
                mIvStar2.setImageResource(R.drawable.ic_yellow_star);
                mIvStar3.setImageResource(R.drawable.ic_grey50);
                mIvStar4.setImageResource(R.drawable.ic_grey50);
                mIvStar5.setImageResource(R.drawable.ic_grey50);
                break;
            case R.id.writeReview_iv_star3:
                mIvStar1.setImageResource(R.drawable.ic_yellow_star);
                mIvStar2.setImageResource(R.drawable.ic_yellow_star);
                mIvStar3.setImageResource(R.drawable.ic_yellow_star);
                mIvStar4.setImageResource(R.drawable.ic_grey50);
                mIvStar5.setImageResource(R.drawable.ic_grey50);
                break;
            case R.id.writeReview_iv_star4:
                mIvStar1.setImageResource(R.drawable.ic_yellow_star);
                mIvStar2.setImageResource(R.drawable.ic_yellow_star);
                mIvStar3.setImageResource(R.drawable.ic_yellow_star);
                mIvStar4.setImageResource(R.drawable.ic_yellow_star);
                mIvStar5.setImageResource(R.drawable.ic_grey50);
                break;
            case R.id.writeReview_iv_star5:
                mIvStar1.setImageResource(R.drawable.ic_yellow_star);
                mIvStar2.setImageResource(R.drawable.ic_yellow_star);
                mIvStar3.setImageResource(R.drawable.ic_yellow_star);
                mIvStar4.setImageResource(R.drawable.ic_yellow_star);
                mIvStar5.setImageResource(R.drawable.ic_yellow_star);
                break;
        }
    }
}
