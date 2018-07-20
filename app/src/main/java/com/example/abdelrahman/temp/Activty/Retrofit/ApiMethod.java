package com.example.abdelrahman.temp.Activty.Retrofit;

import com.example.abdelrahman.temp.Activty.Model.UserResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


public interface ApiMethod {
    @GET("users")
    Call<UserResponse>User(@QueryMap Map<String,String>query);
}
