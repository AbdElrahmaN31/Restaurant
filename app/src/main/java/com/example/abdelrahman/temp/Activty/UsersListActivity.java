package com.example.abdelrahman.temp.Activty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.abdelrahman.temp.Activty.Adapters.UsersAdapter;
import com.example.abdelrahman.temp.Activty.Model.User;
import com.example.abdelrahman.temp.Activty.Model.UserResponse;
import com.example.abdelrahman.temp.Activty.Presenter.UserPresenter;
import com.example.abdelrahman.temp.Activty.View.UserView;
import com.example.abdelrahman.temp.R;

import java.util.List;

import retrofit2.Call;

public class UsersListActivity extends AppCompatActivity implements UserView {

    RecyclerView.LayoutManager layoutManager;
    UserPresenter userPresenter;
    RecyclerView userRecyclerView;
    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_lsit);
        userRecyclerView = findViewById(R.id.usersRV);
        layoutManager = new LinearLayoutManager(this);
        userRecyclerView.setLayoutManager(layoutManager);
        userPresenter = new UserPresenter(this, this);
        userPresenter.getUser("4");
    }

    @Override
    public void showUsers(List<User> users) {
        usersAdapter = new UsersAdapter(this,users);
        userRecyclerView.setAdapter(usersAdapter);
        usersAdapter.notifyDataSetChanged();
    }
}
