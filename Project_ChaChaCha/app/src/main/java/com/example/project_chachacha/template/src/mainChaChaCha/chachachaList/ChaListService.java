package com.example.project_chachacha.template.src.mainChaChaCha.chachachaList;

import com.example.project_chachacha.template.src.mainChaChaCha.chachachaList.Interfaces.ChaListInterface;
import com.example.project_chachacha.template.src.mainChaChaCha.chachachaList.Interfaces.ChaListView;
import com.example.project_chachacha.template.src.mainChaChaCha.chachachaList.models.ChaChaChaListResponse;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.MEDIA_TYPE_JSON;
import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofitToken;

public class ChaListService {

    private final ChaListView mChaListView;

    ChaListService(ChaListView chaListView){
        this.mChaListView = chaListView;
    }

    void postChaList(int people, String kind, String mode, int page, int size){
        JSONObject params = new JSONObject();
        try {
            params.put("people",people);
            params.put("kind",kind);
            params.put("mode", mode);
            params.put("page",page);
            params.put("size",size);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final ChaListInterface chaListInterface = getRetrofitToken().create(ChaListInterface.class);
        chaListInterface.postChaList(RequestBody.create(params.toString(),MEDIA_TYPE_JSON)).enqueue(new Callback<ChaChaChaListResponse>() {
            @Override
            public void onResponse(Call<ChaChaChaListResponse> call, Response<ChaChaChaListResponse> response) {
                ChaChaChaListResponse chaChaChaListResponse = response.body();
                if(chaChaChaListResponse==null){
                    mChaListView.validateFailure("서버가 응답하지 않습니다.");
                    return;
                }

                mChaListView.validateSuccess(chaChaChaListResponse.getCode(), chaChaChaListResponse.getResult());
            }

            @Override
            public void onFailure(Call<ChaChaChaListResponse> call, Throwable t) {
                mChaListView.validateFailure("서버가 응답하지 않습니다.");
            }
        });
    }
}
