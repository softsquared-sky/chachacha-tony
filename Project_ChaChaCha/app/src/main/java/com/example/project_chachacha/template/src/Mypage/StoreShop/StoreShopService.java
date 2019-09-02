package com.example.project_chachacha.template.src.Mypage.StoreShop;

import com.example.project_chachacha.template.src.Mypage.StoreShop.Intenfaces.StoreShopInterface;
import com.example.project_chachacha.template.src.Mypage.StoreShop.Intenfaces.StoreShopView;
import com.example.project_chachacha.template.src.Mypage.StoreShop.models.StoreShopResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofitToken;

class StoreShopService {

    private final StoreShopView mStoreShopView;

    StoreShopService(StoreShopView storeShopView){
        this.mStoreShopView = storeShopView;
    }

    void getBookMark(String userid){
        final StoreShopInterface storeShopInterface = getRetrofitToken().create(StoreShopInterface.class);
        storeShopInterface.getbookmark(userid).enqueue(new Callback<StoreShopResponse>() {
            @Override
            public void onResponse(@NotNull Call<StoreShopResponse> call, @NotNull Response<StoreShopResponse> response) {
                final StoreShopResponse storeShopResponse = response.body();
                if(storeShopResponse==null){
                    mStoreShopView.validateFailure(0,"응답 null");
                    return;
                }

                mStoreShopView.validateSuccess(storeShopResponse.getCode(),storeShopResponse.getMessage(),storeShopResponse.getResult());
            }

            @Override
            public void onFailure(@NotNull Call<StoreShopResponse> call, @NotNull Throwable t) {
                mStoreShopView.validateFailure(0,"응답 fail");
            }
        });
    }
}
