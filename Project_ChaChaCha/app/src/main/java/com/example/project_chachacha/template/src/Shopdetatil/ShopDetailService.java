package com.example.project_chachacha.template.src.Shopdetatil;

import com.example.project_chachacha.template.src.Shopdetatil.Interfaces.ShopDetailInterface;
import com.example.project_chachacha.template.src.Shopdetatil.Interfaces.ShopDetailView;
import com.example.project_chachacha.template.src.Shopdetatil.models.ShopDetailResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofitToken;

public class ShopDetailService {

    private final ShopDetailView mShopDetailView;

    ShopDetailService(final ShopDetailView shopDetailView){
        this.mShopDetailView = shopDetailView;
    }

    void getDetail(int storeNum){
        final ShopDetailInterface shopDetailInterface = getRetrofitToken().create(ShopDetailInterface.class);
        shopDetailInterface.getDetail(storeNum).enqueue(new Callback<ShopDetailResponse>() {
            @Override
            public void onResponse(Call<ShopDetailResponse> call, Response<ShopDetailResponse> response) {
                final ShopDetailResponse shopDetailResponse = response.body();
                if(shopDetailResponse==null){
                    mShopDetailView.validateFailure(0,"응답 null");
                    return;
                }

                mShopDetailView.validateSuccess(shopDetailResponse.getCode(),shopDetailResponse.getMessage(),shopDetailResponse.getResult());
            }

            @Override
            public void onFailure(Call<ShopDetailResponse> call, Throwable t) {
                mShopDetailView.validateFailure(0, "응답 fail");
            }
        });
    }
}