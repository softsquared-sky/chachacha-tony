package com.example.project_chachacha.template.src.shopInfo.ShopReview;

import com.example.project_chachacha.template.src.shopInfo.ShopReview.Interfaces.ReviewInterface;
import com.example.project_chachacha.template.src.shopInfo.ShopReview.Interfaces.ReviewView;
import com.example.project_chachacha.template.src.shopInfo.ShopReview.models.ReviewResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofitToken;

class ReviewService {

    private final ReviewView mReviewView;

    ReviewService(ReviewView reviewView){
        this.mReviewView=reviewView;
    }

    void getShopReview(int storeNum){
        final ReviewInterface reviewInterface = getRetrofitToken().create(ReviewInterface.class);
        reviewInterface.getShopReview(storeNum).enqueue(new Callback<ReviewResponse>() {
            @Override
            public void onResponse(Call<ReviewResponse> call, Response<ReviewResponse> response) {
                final ReviewResponse reviewResponse = response.body();
                if(reviewResponse==null){
                    mReviewView.validateFailure("응답 null");
                    return;
                }
                mReviewView.validateSuccess(reviewResponse.getCode(),reviewResponse.getMessage(),reviewResponse.getResult());
            }

            @Override
            public void onFailure(Call<ReviewResponse> call, Throwable t) {
                mReviewView.validateFailure("응답 fail");
            }
        });
    }
}
