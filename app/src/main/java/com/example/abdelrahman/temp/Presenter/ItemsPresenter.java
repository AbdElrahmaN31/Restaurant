package com.example.abdelrahman.temp.Presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.abdelrahman.temp.Models.ItemsResponse;
import com.example.abdelrahman.temp.Retrofit.ApiClient;
import com.example.abdelrahman.temp.Retrofit.ApiMethod;
import com.example.abdelrahman.temp.View.ItemsView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemsPresenter {

    Context context;
    ItemsView itemsView;
    String categoryId;


    public ItemsPresenter(Context context, ItemsView itemsView, String categoryId) {
        this.context = context;
        this.itemsView = itemsView;
        this.categoryId = categoryId;
        Log.i("items","categoryId : " + categoryId);
    }

    public void getCategoryItems() {
        ApiMethod apiMethod = ApiClient.getClient().create(ApiMethod.class);
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("restaurantid", "1");
        queryMap.put("categoryId", categoryId);

        Call<ItemsResponse> call = apiMethod.getItems(queryMap);
        call.enqueue(new Callback<ItemsResponse>() {
            @Override
            public void onResponse(Call<ItemsResponse> call, Response<ItemsResponse> response) {
                if (response.isSuccessful()) {
                    Log.i("items","response is successful");
                    itemsView.categoryItemsList(response.body().getItems());
                }
            }
            @Override
            public void onFailure(Call<ItemsResponse> call, Throwable t) {
                Log.i("items","Response is failure \n" + t.getMessage());
                Toast.makeText(context, "Error" , Toast.LENGTH_LONG);

            }
        });
    }
}
