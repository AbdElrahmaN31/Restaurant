package com.example.abdelrahman.temp.Presenter;

import android.content.Context;
import android.util.Log;

import com.example.abdelrahman.temp.Models.City;
import com.example.abdelrahman.temp.Models.User;
import com.example.abdelrahman.temp.Models.UserRegisterResponse;
import com.example.abdelrahman.temp.Retrofit.ApiClient;
import com.example.abdelrahman.temp.Retrofit.ApiMethod;
import com.example.abdelrahman.temp.View.RegisterView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationPresenter {
    Context context;
    RegisterView registerView;

    public RegistrationPresenter(Context context, RegisterView registerView) {
        this.context = context;
        this.registerView = registerView;
    }

    public void register(User user, City city){
        Map <String, String> userMap = new HashMap<>();
        userMap.put("name",user.getName());
        userMap.put("password",user.getPassword());
        userMap.put("mail",user.getMail());
        userMap.put("gender",user.getGender());
        userMap.put("cityId",city.getId().toString());
        userMap.put("districtId","1");
        userMap.put("address",user.getAddress());
        userMap.put("phone",user.getPhone());

        ApiMethod apiMethod = ApiClient.getClient().create(ApiMethod.class);
        Call<UserRegisterResponse> call = apiMethod.Register(userMap);
        call.enqueue(new Callback<UserRegisterResponse>() {
            @Override
            public void onResponse(Call<UserRegisterResponse> call, Response<UserRegisterResponse> response) {
//                if (response.isSuccessful()){
                    if (response.body().getSuccess().equals("ok"))
                        registerView.openMain();
                    else {
                        Log.e("Register","error on response");
                        registerView.showErrorMessage();
                    }
//                }else registerView.showErrorMessage();
            }

            @Override
            public void onFailure(Call<UserRegisterResponse> call, Throwable t) {
                Log.e("Register",t.getMessage());
                registerView.showErrorMessage();
            }
        });
    }
}
