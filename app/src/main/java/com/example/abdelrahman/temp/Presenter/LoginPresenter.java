package com.example.abdelrahman.temp.Presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.abdelrahman.temp.Models.User;
import com.example.abdelrahman.temp.Models.UserLoginResponse;
import com.example.abdelrahman.temp.Retrofit.ApiClient;
import com.example.abdelrahman.temp.Retrofit.ApiMethod;
import com.example.abdelrahman.temp.View.LoginView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {

    Context context;
    LoginView loginView;

    public LoginPresenter(Context context, LoginView loginView) {
        this.context = context;
        this.loginView = loginView;
    }

    public void login(String name, String password){
        Map<String,String> map = new HashMap<>();
        map.put("emailOrPhone" , name);
        map.put("password" , password);
        map.put("token","1");

        ApiMethod apiMethod = ApiClient.getClient().create(ApiMethod.class);
        Call<UserLoginResponse> call = apiMethod.login(map);
        call.enqueue(new Callback<UserLoginResponse>() {
            @Override
            public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {
                Log.i("LoginResponse",response.message());
                if(response.isSuccessful()){
                    if (response.body().getSuccess().equals("ok")){
                        User user = new User();
                        user.setName(response.body().getArabicName());
                        user.setId(response.body().getUserid());
                        user.setUrl(response.body().getArabicName());
                        loginView.openMain(user);
                    }
                }else {
                    Toast.makeText(context,"Login Error",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserLoginResponse> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }
}
