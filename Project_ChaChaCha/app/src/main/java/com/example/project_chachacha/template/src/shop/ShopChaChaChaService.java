package com.example.project_chachacha.template.src.shop;

import com.example.project_chachacha.template.src.shop.Interfaces.ShopChaChaChaInterface;
import com.example.project_chachacha.template.src.shop.Interfaces.ShopChaChaChaView;
import com.example.project_chachacha.template.src.shop.models.ShopChaChaChaResponse;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.MEDIA_TYPE_JSON;
import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofitToken;

public class ShopChaChaChaService {

    private final ShopChaChaChaView mShopChaChaChaView;

    public ShopChaChaChaService(ShopChaChaChaView shopChaChaChaView){
        this.mShopChaChaChaView = shopChaChaChaView;
    }

    public void postSaveMyCha(String userid, int storeNum){
        JSONObject params = new JSONObject();
        try {
            params.put("storenum", storeNum);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final ShopChaChaChaInterface shopChaChaChaInterface = getRetrofitToken().create(ShopChaChaChaInterface.class);
        shopChaChaChaInterface.postSaveMyChaChaCha(userid, RequestBody.create(params.toString(),MEDIA_TYPE_JSON)).enqueue(new Callback<ShopChaChaChaResponse>() {
            @Override
            public void onResponse(Call<ShopChaChaChaResponse> call, Response<ShopChaChaChaResponse> response) {
                ShopChaChaChaResponse shopChaChaChaResponse = response.body();
                if(shopChaChaChaResponse==null){
                    mShopChaChaChaView.validateFailureChaChaCha("서버가 응답하지 않습니다.");
                    return;
                }

                mShopChaChaChaView.validateSuccessChaChaCha(shopChaChaChaResponse.getCode());
            }

            @Override
            public void onFailure(Call<ShopChaChaChaResponse> call, Throwable t) {
                mShopChaChaChaView.validateFailureChaChaCha("서버가 응답하지 않습니다.");
            }
        });
    }
}
