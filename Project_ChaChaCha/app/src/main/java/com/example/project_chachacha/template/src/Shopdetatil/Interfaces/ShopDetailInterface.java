package com.example.project_chachacha.template.src.Shopdetatil.Interfaces;

import com.example.project_chachacha.template.src.Shopdetatil.models.ShopDetailResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ShopDetailInterface {

    @GET("/store/{storeNum}")
    Call<ShopDetailResponse> getDetail(@Path("storeNum") int storeNum);
}
