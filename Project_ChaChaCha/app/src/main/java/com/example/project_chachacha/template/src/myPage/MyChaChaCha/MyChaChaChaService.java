package com.example.project_chachacha.template.src.myPage.MyChaChaCha;

import com.example.project_chachacha.template.src.myPage.MyChaChaCha.Interfaces.MyChaChaChaInterface;
import com.example.project_chachacha.template.src.myPage.MyChaChaCha.Interfaces.MyChaChaChaView;
import com.example.project_chachacha.template.src.myPage.MyChaChaCha.models.MyChaChaChaDeleteResponse;
import com.example.project_chachacha.template.src.myPage.MyChaChaCha.models.MyChaChaChaResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofitToken;

public class MyChaChaChaService {

    private final MyChaChaChaView mMyChaChaChaView;

    MyChaChaChaService(MyChaChaChaView mMyChaChaChaView){
        this.mMyChaChaChaView = mMyChaChaChaView;
    }

    void getMyChaChaCha(String userid){
        final MyChaChaChaInterface myChaChaChaInterface = getRetrofitToken().create(MyChaChaChaInterface.class);
        myChaChaChaInterface.getMyChaChaCha(userid).enqueue(new Callback<MyChaChaChaResponse>() {
            @Override
            public void onResponse(Call<MyChaChaChaResponse> call, Response<MyChaChaChaResponse> response) {
                MyChaChaChaResponse myChaChaChaResponse = response.body();
                if(myChaChaChaResponse==null){
                    mMyChaChaChaView.validateFailure("서버가 응답하지 않습니다.");
                    return;
                }
                mMyChaChaChaView.validateSuccess(myChaChaChaResponse.getCode(), myChaChaChaResponse.getResult());
            }

            @Override
            public void onFailure(Call<MyChaChaChaResponse> call, Throwable t) {
                mMyChaChaChaView.validateFailure("서버가 응답하지 않습니다.");
            }
        });
    }

    void deleteMyCha(String userid, int chaNum){
        final MyChaChaChaInterface myChaChaChaInterface = getRetrofitToken().create(MyChaChaChaInterface.class);
        myChaChaChaInterface.deleteMyChaChaCha(userid, chaNum).enqueue(new Callback<MyChaChaChaDeleteResponse>() {
            @Override
            public void onResponse(Call<MyChaChaChaDeleteResponse> call, Response<MyChaChaChaDeleteResponse> response) {
                MyChaChaChaDeleteResponse myChaChaChaDeleteResponse = response.body();
                if(myChaChaChaDeleteResponse==null){
                    mMyChaChaChaView.validateFailure("서버가 응답하지 않습니다.");
                    return;
                }

                mMyChaChaChaView.validateSuccessDelete(myChaChaChaDeleteResponse.getCode());
            }

            @Override
            public void onFailure(Call<MyChaChaChaDeleteResponse> call, Throwable t) {
                mMyChaChaChaView.validateFailure("서버가 응답하지 않습니다.");
            }
        });
    }
}
