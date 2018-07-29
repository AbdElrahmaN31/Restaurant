package com.example.abdelrahman.temp.Presenter;

import android.content.Context;
import android.widget.Toast;
import com.example.abdelrahman.temp.Model.CategoryItemsResponse;
import com.example.abdelrahman.temp.Retrofit.ApiClient;
import com.example.abdelrahman.temp.Retrofit.ApiMethod;
import com.example.abdelrahman.temp.View.CategoryItemsView;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryItemsPresenter {

    Context context;
    CategoryItemsView categoryItemsView;
    String categoryId;


    public CategoryItemsPresenter(Context context, CategoryItemsView categoryItemsView, String categoryId) {
        this.context = context;
        this.categoryItemsView = categoryItemsView;
        this.categoryId = categoryId;
    }

    public void getCategoryItems(){
        Map<String,String> queryMap = new HashMap<>();
        queryMap.put("restaurantId","1");
        queryMap.put("GetcategoryItems",categoryId);
        ApiMethod apiMethod = ApiClient.getClient().create(ApiMethod.class);
        Call<CategoryItemsResponse> call = apiMethod.CategoryItems(queryMap);
        call.enqueue(new Callback<CategoryItemsResponse>() {
            @Override
            public void onResponse(Call<CategoryItemsResponse> call, Response<CategoryItemsResponse> response) {
                categoryItemsView.categoryItemsList(response.body().getItems());
            }

            @Override
            public void onFailure(Call<CategoryItemsResponse> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG);

            }
        });
    }
}
