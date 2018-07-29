package com.example.abdelrahman.temp.Retrofit;

import com.example.abdelrahman.temp.Model.CategoryItemsResponse;
import com.example.abdelrahman.temp.Model.CategoryResponse;
import com.example.abdelrahman.temp.Model.CategoryItems;
import com.example.abdelrahman.temp.Model.CityResponce;
import com.example.abdelrahman.temp.Model.UserLoginResponse;
import com.example.abdelrahman.temp.Model.UserRegisterResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;


public interface ApiMethod {

    @POST("Login")
    Call<UserLoginResponse>login(@QueryMap Map<String,String> query);

    @POST("Register")
    Call<UserRegisterResponse> Register(@QueryMap Map<String,String> query);

    @GET("getCities")
    Call<CityResponce> getCities();

    @POST("getCatagories")
    Call<CategoryResponse> Category(@QueryMap Map<String,String>query);

    @POST("GetcategoryItems")
    Call<CategoryItemsResponse>CategoryItems(@QueryMap Map<String ,String>query);

}
