package com.example.project_chachacha.template.src.myChaShopDetail.writeReview;

import com.example.project_chachacha.template.src.myChaShopDetail.writeReview.Interfaces.WriteReviewInterface;
import com.example.project_chachacha.template.src.myChaShopDetail.writeReview.Interfaces.WriteReviewView;
import com.example.project_chachacha.template.src.myChaShopDetail.writeReview.models.WriteReviewResponse;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.MEDIA_TYPE_JSON;
import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofitToken;

public class WriteReviewService {

    private final WriteReviewView mWriteReviewView;

    WriteReviewService(WriteReviewView writeReviewView){
        this.mWriteReviewView = writeReviewView;
    }

    void postReview(int chaNum, String text, int star){
        JSONObject params = new JSONObject();
        try {
            params.put("text", text);
            params.put("star",star);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final WriteReviewInterface writeReviewInterface = getRetrofitToken().create(WriteReviewInterface.class);
        writeReviewInterface.postReview(chaNum, RequestBody.create(params.toString(),MEDIA_TYPE_JSON)).enqueue(new Callback<WriteReviewResponse>() {
            @Override
            public void onResponse(Call<WriteReviewResponse> call, Response<WriteReviewResponse> response) {
                final WriteReviewResponse writeReviewResponse = response.body();
                if(writeReviewResponse==null){
                    mWriteReviewView.validateFailure("서버가 응답하지 않습니다.");
                    return;
                }

                mWriteReviewView.validateSuccess(writeReviewResponse.getCode());
            }

            @Override
            public void onFailure(Call<WriteReviewResponse> call, Throwable t) {
                mWriteReviewView.validateFailure("서버가 응답하지 않습니다.");
            }
        });
    }
}
