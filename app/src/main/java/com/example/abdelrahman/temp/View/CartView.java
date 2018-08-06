package com.example.abdelrahman.temp.View;

import com.example.abdelrahman.temp.Models.CartItem;

import java.util.List;

public interface CartView {
    void showTotal(List<CartItem> cartItems);
    void addToTotal(double value);
    void dicToTotal(double value);
}
