package com.example.project_chachacha.template.src.myPage.StoreShop.Intenfaces;

import com.example.project_chachacha.template.src.myPage.StoreShop.models.StoreShopResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StoreShopInterface {

    @GET("/user/{userid}/bookmark")
    Call<StoreShopResponse> getbookmark(@Path("userid") String userid);
}
