package com.example.project_chachacha.template.src.myChaShopDetail.writeReview.Interfaces;

import com.example.project_chachacha.template.src.myChaShopDetail.writeReview.models.WriteReviewResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WriteReviewInterface {

    @POST("/store/{chanum}/review")
    Call<WriteReviewResponse> postReview(@Path("chanum") int chaNum, @Body RequestBody params);
}
