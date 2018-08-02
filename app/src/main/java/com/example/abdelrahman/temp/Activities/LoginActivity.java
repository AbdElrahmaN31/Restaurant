package com.example.abdelrahman.temp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.abdelrahman.temp.Models.User;
import com.example.abdelrahman.temp.Presenter.LoginPresenter;
import com.example.abdelrahman.temp.R;
import com.example.abdelrahman.temp.View.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView{
    EditText userName, password;
    Button login;
    TextView createAccount;
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = findViewById(R.id.login_ed_user_name);
        password = findViewById(R.id.login_ed_password);
        login = findViewById(R.id.login_bt);
        createAccount = findViewById(R.id.login_create_account);
        loginPresenter = new LoginPresenter(this,this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!userName.getText().toString().equals("") && !password.getText().toString().equals("")){
                    loginPresenter.login(userName.getText().toString().trim(),password.getText().toString().trim());
                }
            }
        });
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void openMain(User userLogin) {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
        finish();
    }
}
