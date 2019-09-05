package com.example.project_chachacha.template.src.myChaShopDetail.MyChaShop.Interfaces;

import com.example.project_chachacha.template.src.myChaShopDetail.MyChaShop.models.MyChaShopResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyChaShopInterface {

    @GET("/user/{userid}/store/{chaNum}")
    Call<MyChaShopResponse> getMyShop(@Path("userid") String userid, @Path("chaNum") int chaNum);
}
