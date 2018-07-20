package com.example.abdelrahman.temp.Activty.View;

import com.example.abdelrahman.temp.Activty.Model.User;
import java.util.List;
import retrofit2.http.GET;

public interface UserView {
    @GET("users")
   void showUsers(List<User> users);
}
