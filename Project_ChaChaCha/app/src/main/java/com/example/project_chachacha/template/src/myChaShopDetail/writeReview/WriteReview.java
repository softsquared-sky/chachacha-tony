package com.example.project_chachacha.template.src.myChaShopDetail.writeReview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.CustomDialogOneButton;
import com.example.project_chachacha.template.src.myChaShopDetail.writeReview.Interfaces.WriteReviewView;

public class WriteReview extends BaseActivity implements WriteReviewView {

    private ImageView mIvStar1, mIvStar2, mIvStar3, mIvStar4, mIvStar5;
    private ImageView mIvback;

    private TextView mTvCommit;
    private TextView mTvTitle;

    private EditText mEdtText;
    private int star = 0;
    private int chaNum;
    private String title;

    private CustomDialogOneButton mCustomDialogOneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);

        Intent intent = getIntent();
        chaNum = intent.getIntExtra("chanum",0);
        title = intent.getStringExtra("title");

        final WriteReviewService writeReviewService = new WriteReviewService(this);

        mIvStar1 = findViewById(R.id.writeReview_iv_star1);
        mIvStar2 = findViewById(R.id.writeReview_iv_star2);
        mIvStar3 = findViewById(R.id.writeReview_iv_star3);
        mIvStar4 = findViewById(R.id.writeReview_iv_star4);
        mIvStar5 = findViewById(R.id.writeReview_iv_star5);

        mEdtText = findViewById(R.id.writeReview_edt_text);

        mTvTitle = findViewById(R.id.writeReview_tv_title);
        if(title!=null){
            mTvTitle.setText(title);
        }

        mIvback = findViewById(R.id.writeReview_iv_back);
        mIvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mTvCommit = findViewById(R.id.writeReview_tv_commit);
        mTvCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(star==0){
                    String msg = "별점을 선택해주세요.";
                    mCustomDialogOneButton = new CustomDialogOneButton(WriteReview.this, msg);
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                }
                else if(mEdtText.getText().toString().equals("")){
                    String msg = "내용을 입력해주세요.";
                    mCustomDialogOneButton = new CustomDialogOneButton(WriteReview.this, msg);
                    mCustomDialogOneButton.setCancelable(false);
                    mCustomDialogOneButton.show();
                }
                else{
                    writeReviewService.postReview(chaNum, mEdtText.getText().toString(), star);
                }
            }
        });
    }

    public void starClick(View view){
        switch (view.getId()){
            case R.id.writeReview_iv_star1:
                mIvStar1.setImageResource(R.drawable.ic_yellow_star);
                mIvStar2.setImageResource(R.drawable.ic_grey50);
                mIvStar3.setImageResource(R.drawable.ic_grey50);
                mIvStar4.setImageResource(R.drawable.ic_grey50);
                mIvStar5.setImageResource(R.drawable.ic_grey50);
                star = 1;
                break;
            case R.id.writeReview_iv_star2:
                mIvStar1.setImageResource(R.drawable.ic_yellow_star);
                mIvStar2.setImageResource(R.drawable.ic_yellow_star);
                mIvStar3.setImageResource(R.drawable.ic_grey50);
                mIvStar4.setImageResource(R.drawable.ic_grey50);
                mIvStar5.setImageResource(R.drawable.ic_grey50);
                star=2;
                break;
            case R.id.writeReview_iv_star3:
                mIvStar1.setImageResource(R.drawable.ic_yellow_star);
                mIvStar2.setImageResource(R.drawable.ic_yellow_star);
                mIvStar3.setImageResource(R.drawable.ic_yellow_star);
                mIvStar4.setImageResource(R.drawable.ic_grey50);
                mIvStar5.setImageResource(R.drawable.ic_grey50);
                star=3;
                break;
            case R.id.writeReview_iv_star4:
                mIvStar1.setImageResource(R.drawable.ic_yellow_star);
                mIvStar2.setImageResource(R.drawable.ic_yellow_star);
                mIvStar3.setImageResource(R.drawable.ic_yellow_star);
                mIvStar4.setImageResource(R.drawable.ic_yellow_star);
                mIvStar5.setImageResource(R.drawable.ic_grey50);
                star=4;
                break;
            case R.id.writeReview_iv_star5:
                mIvStar1.setImageResource(R.drawable.ic_yellow_star);
                mIvStar2.setImageResource(R.drawable.ic_yellow_star);
                mIvStar3.setImageResource(R.drawable.ic_yellow_star);
                mIvStar4.setImageResource(R.drawable.ic_yellow_star);
                mIvStar5.setImageResource(R.drawable.ic_yellow_star);
                star=5;
                break;
        }
    }

    @Override
    public void validateSuccess(int code) {
        System.out.println("리뷰작성 코드: " + code);
        if(code == 222){
            finish();
        }
        else{
            String msg = "";
            switch (code){
                case 201:
                    msg = "유효하지 않은 토큰입니다.";
                    break;
                case 599:
                    msg = "유효하지 않은 마이차차차 번호입니다.";
                    break;
                case 240:
                    msg = "이미 리뷰를 작성한 가게이거나\n이메일인증을 완료하지 않은 가게입니다.";
                    break;
                case 299:
                    msg = "입력되지 않은 항목을 입력해주세요.";
                    break;
            }
            mCustomDialogOneButton = new CustomDialogOneButton(this, msg);
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
