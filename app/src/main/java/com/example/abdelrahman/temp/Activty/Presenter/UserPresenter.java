package com.example.abdelrahman.temp.Activty.Presenter;

import android.content.Context;
import android.widget.Toast;
import com.example.abdelrahman.temp.Activty.Model.UserResponse;
import com.example.abdelrahman.temp.Activty.Retrofit.ApiClient;
import com.example.abdelrahman.temp.Activty.Retrofit.ApiMethod;
import com.example.abdelrahman.temp.Activty.View.UserView;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserPresenter {
    Context context;
    UserView userView;

    public UserPresenter(Context context, UserView userView) {
        this.context = context;
        this.userView = userView;
    }

    public void getUser(String pageId){
        Map<String,String> queryMap = new HashMap<>();
        queryMap.put("page",pageId);
        ApiMethod apiMethod = ApiClient.getClient().create(ApiMethod.class);
        Call<UserResponse> call = apiMethod.User(queryMap);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                userView.showUsers(response.body().getData());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG);
            }
        });
    }

}
