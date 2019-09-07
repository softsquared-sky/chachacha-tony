package com.example.project_chachacha.template.src.myChaShopDetail.myChaShop;

import com.example.project_chachacha.template.src.myChaShopDetail.myChaShop.Interfaces.MyChaShopInterface;
import com.example.project_chachacha.template.src.myChaShopDetail.myChaShop.Interfaces.MyChaShopView;
import com.example.project_chachacha.template.src.myChaShopDetail.myChaShop.models.MyChaShopResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofitToken;

public class MyChaShopService {

    private final MyChaShopView mMyChaShopView;

    MyChaShopService(MyChaShopView myChaShopView){
        this.mMyChaShopView = myChaShopView;
    }

    void getMyShop(String userid, int chaNum){
        final MyChaShopInterface myChaShopInterface = getRetrofitToken().create(MyChaShopInterface.class);
        myChaShopInterface.getMyShop(userid, chaNum).enqueue(new Callback<MyChaShopResponse>() {
            @Override
            public void onResponse(Call<MyChaShopResponse> call, Response<MyChaShopResponse> response) {
                final MyChaShopResponse myChaShopResponse = response.body();
                if(myChaShopResponse==null){
                    mMyChaShopView.validateFailure("서버가 응답하지 않습니다.");
                    return;
                }

                mMyChaShopView.validateSuccess(myChaShopResponse.getCode(), myChaShopResponse.getResult());
            }

            @Override
            public void onFailure(Call<MyChaShopResponse> call, Throwable t) {
                mMyChaShopView.validateFailure("서버가 응답하지 않습니다.");
            }
        });
    }


}
