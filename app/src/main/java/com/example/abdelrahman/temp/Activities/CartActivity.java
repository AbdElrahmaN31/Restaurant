package com.example.abdelrahman.temp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.abdelrahman.temp.Adapters.CartAdapter;
import com.example.abdelrahman.temp.Models.CartItem;
import com.example.abdelrahman.temp.R;
import com.example.abdelrahman.temp.View.CartView;

import java.util.List;

public class CartActivity extends AppCompatActivity implements CartView {

    RecyclerView cartRecyclerView;
    CartAdapter cartAdapter;
    RecyclerView.LayoutManager layoutManager;
    TextView total_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        cartRecyclerView = findViewById(R.id.cart_rv);
        total_tv = findViewById(R.id.cart_total);
        layoutManager = new LinearLayoutManager(this);
        cartRecyclerView.setLayoutManager(layoutManager);
        cartAdapter = new CartAdapter(this,this);
        cartRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();
    }


    @Override
    public void showTotal(List<CartItem> cartItems) {
        double total = 0;
        for(int i = 0; i < cartItems.size() ; i++){
            CartItem cartItem = cartItems.get(i);
            int num = cartItem.getNumbers();
            double price = cartItem.getPrice();
            total += num*price;
        }
        total_tv.setText(String.valueOf(total));
    }

    @Override
    public void addToTotal(double value) {
        double total = Double.valueOf(total_tv.getText().toString());
        total += value;
        total_tv.setText(String.valueOf(total));
    }

    @Override
    public void dicToTotal(double value) {
        double total = Double.valueOf(total_tv.getText().toString());
        total -= value;
        total_tv.setText(String.valueOf(total));
    }
}
