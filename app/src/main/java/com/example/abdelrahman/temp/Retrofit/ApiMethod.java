package com.example.abdelrahman.temp.Retrofit;

import com.example.abdelrahman.temp.Models.ItemsResponse;
import com.example.abdelrahman.temp.Models.CategoryResponse;
import com.example.abdelrahman.temp.Models.CityResponce;
import com.example.abdelrahman.temp.Models.UserLoginResponse;
import com.example.abdelrahman.temp.Models.UserRegisterResponse;

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
    Call<ItemsResponse> getItems(@QueryMap Map<String ,String>query);

}
