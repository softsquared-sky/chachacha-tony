package com.example.project_chachacha.template.src.Mypage.ProfileEdit;

import com.example.project_chachacha.template.src.Mypage.ProfileEdit.Interfaces.ProfileEditInterface;
import com.example.project_chachacha.template.src.Mypage.ProfileEdit.Interfaces.ProfileEditView;
import com.example.project_chachacha.template.src.Mypage.ProfileEdit.models.ProfileEditResponse;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.MEDIA_TYPE_JSON;
import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofitToken;

public class ProfileEditService {

    private final ProfileEditView mProfileEditView;

    ProfileEditService(final ProfileEditView profileEditView){
        this.mProfileEditView = profileEditView;
    }

    void patchEdit(String userid, String name, String writing, String email, String phone){
        JSONObject params = new JSONObject();
        try {
            params.put("name",name);
            params.put("writing", writing);
            params.put("email",email);
            params.put("phone", phone);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final ProfileEditInterface profileEditInterface = getRetrofitToken().create(ProfileEditInterface.class);
        profileEditInterface.patchprofile(userid, RequestBody.create(params.toString(),MEDIA_TYPE_JSON)).enqueue(new Callback<ProfileEditResponse>() {
            @Override
            public void onResponse(Call<ProfileEditResponse> call, Response<ProfileEditResponse> response) {
                final ProfileEditResponse profileEditResponse = response.body();
                if(profileEditResponse==null){
                    mProfileEditView.validateFailure(0,"응답 null");
                    return;
                }

                mProfileEditView.validateSuccess(profileEditResponse.getCode(), profileEditResponse.getMessage());
            }

            @Override
            public void onFailure(Call<ProfileEditResponse> call, Throwable t) {
                mProfileEditView.validateFailure(0,"응답 fail");
            }
        });
    }
}
