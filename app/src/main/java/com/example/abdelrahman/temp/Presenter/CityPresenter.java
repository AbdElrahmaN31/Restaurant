package com.example.abdelrahman.temp.Presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.abdelrahman.temp.Models.CityResponce;
import com.example.abdelrahman.temp.Retrofit.ApiClient;
import com.example.abdelrahman.temp.Retrofit.ApiMethod;
import com.example.abdelrahman.temp.View.CityVeiw;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityPresenter {
    Context context;
    CityVeiw cityVeiw;

    public CityPresenter(Context context, CityVeiw cityVeiw) {
        this.context = context;
        this.cityVeiw = cityVeiw;
    }

    public void getCites(){
        ApiMethod apiMethod = ApiClient.getClient().create(ApiMethod.class);
        Call<CityResponce> call = apiMethod.getCities();
        call.enqueue(new Callback<CityResponce>() {
            @Override
            public void onResponse(Call<CityResponce> call, Response<CityResponce> response) {
                cityVeiw.showCites(response.body().getCities());
            }

            @Override
            public void onFailure(Call<CityResponce> call, Throwable t) {
                Toast.makeText(context,"Error has occured",Toast.LENGTH_LONG).show();
            }
        });


    }
}
