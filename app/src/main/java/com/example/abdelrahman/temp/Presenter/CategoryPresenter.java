package com.example.abdelrahman.temp.Presenter;

import android.content.Context;
import android.widget.Toast;


import com.example.abdelrahman.temp.Model.CategoryResponse;
import com.example.abdelrahman.temp.Retrofit.ApiClient;
import com.example.abdelrahman.temp.Retrofit.ApiMethod;
import com.example.abdelrahman.temp.View.CategoryView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryPresenter {

    Context context;
    CategoryView categoryView;

    public CategoryPresenter(Context context, CategoryView categoryView) {
        this.context = context;
        this.categoryView = categoryView;
    }

    public void getCategory(String restaurantId){

        Map<String,String> queryMap = new HashMap<>();
        queryMap.put("restaurantId",restaurantId);
        ApiMethod apiMethod = ApiClient.getClient().create(ApiMethod.class);
        Call<CategoryResponse> call = apiMethod.Category(queryMap);
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                categoryView.categoryList(response.body().getCategories());
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG);
            }
        });


    }
}
