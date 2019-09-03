package com.example.project_chachacha.template.src.shopdetatil;

import com.example.project_chachacha.template.src.shopdetatil.Interfaces.ShopDetailInterface;
import com.example.project_chachacha.template.src.shopdetatil.Interfaces.ShopDetailView;
import com.example.project_chachacha.template.src.shopdetatil.models.ShopDetailResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofitToken;

class ShopDetailService {

    private final ShopDetailView mShopDetailView;

    ShopDetailService(final ShopDetailView shopDetailView){
        this.mShopDetailView = shopDetailView;
    }

    void getDetail(int storeNum){
        final ShopDetailInterface shopDetailInterface = getRetrofitToken().create(ShopDetailInterface.class);
        shopDetailInterface.getDetail(storeNum).enqueue(new Callback<ShopDetailResponse>() {
            @Override
            public void onResponse(@NotNull Call<ShopDetailResponse> call, @NotNull Response<ShopDetailResponse> response) {
                final ShopDetailResponse shopDetailResponse = response.body();
                if(shopDetailResponse==null){
                    mShopDetailView.validateFailure(0,"응답 null");
                    return;
                }

                mShopDetailView.validateSuccess(shopDetailResponse.getCode(),shopDetailResponse.getMessage(),shopDetailResponse.getResult());
            }

            @Override
            public void onFailure(@NotNull Call<ShopDetailResponse> call, @NotNull Throwable t) {
                mShopDetailView.validateFailure(0, "응답 fail");
            }
        });
    }
}
