package com.example.project_chachacha.template.src.Register;

import com.example.project_chachacha.template.src.Register.Interfaces.RegisterView;
import com.example.project_chachacha.template.src.Register.Interfaces.Register_interface;
import com.example.project_chachacha.template.src.Register.models.RegisterResponse;
import com.example.project_chachacha.template.src.Register.models.Register_boss_data;
import com.example.project_chachacha.template.src.Register.models.Register_customer_data;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.project_chachacha.template.src.ApplicationClass.MEDIA_TYPE_JSON;
import static com.example.project_chachacha.template.src.ApplicationClass.getRetrofit;

public class RegisterService {
    private final RegisterView mRegisterView;

    RegisterService(final RegisterView registerView){
        this.mRegisterView = registerView;
    }

    void customer(String userid, String userpw, String userpw2, String name, int age, int gender, String email, String phone){
        JSONObject params = new JSONObject();
        try {
            params.put("userid", userid);
            params.put("userpw", userpw);
            params.put("userpw2", userpw2);
            params.put("name",name);
            params.put("age", age);
            params.put("gender", gender);
            params.put("email", email);
            params.put("phone", phone);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final Register_interface register_interface = getRetrofit().create(Register_interface.class);
        register_interface.post_register_customer(RequestBody.create(params.toString(),MEDIA_TYPE_JSON)).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                final RegisterResponse registerResponse = response.body();
                if(registerResponse == null){
                    mRegisterView.validateFailure(0,"response fail");
                    return;
                }

                mRegisterView.validateSuccess(registerResponse.getCode(), registerResponse.getMessage());
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                t.getCause();
                mRegisterView.validateFailure(0,"응답 실패");
            }
        });
    }

    void boss(String userid, String userpw, String userpw2, String name, String phone){
        JSONObject params = new JSONObject();
        try {
            params.put("userid", userid);
            params.put("userpw", userpw);
            params.put("userpw2", userpw2);
            params.put("name",name);
            params.put("phone", phone);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final Register_interface register_interface2 = getRetrofit().create(Register_interface.class);
        register_interface2.post_register_boss(RequestBody.create(params.toString(),MEDIA_TYPE_JSON)).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                final RegisterResponse registerResponse2 = response.body();
                if(registerResponse2 == null){
                    mRegisterView.validateFailure(0,"response fail");
                    return;
                }

                mRegisterView.validateSuccess(registerResponse2.getCode(), registerResponse2.getMessage());
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                mRegisterView.validateFailure(0,"응답 실패");
            }
        });

    }
}
