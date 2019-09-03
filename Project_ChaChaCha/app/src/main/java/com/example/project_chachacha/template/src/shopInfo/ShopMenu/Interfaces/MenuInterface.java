package com.example.project_chachacha.template.src.shopInfo.ShopMenu.Interfaces;

import com.example.project_chachacha.template.src.shopInfo.ShopMenu.models.MenuResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MenuInterface {

    @GET("/store/{storeNum}/menu")
    Call<MenuResponse> getShopMenu(@Path("storeNum") int storeNum);
}
