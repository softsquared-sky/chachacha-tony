package com.example.project_chachacha.template.src.shopInfo.ShopReview.Interfaces;

import com.example.project_chachacha.template.src.shopInfo.ShopReview.models.ReviewResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ReviewInterface {

    @GET("/store/{storeNum}/review")
    Call<ReviewResponse> getShopReview(@Path("storeNum") int storeNum);
}
