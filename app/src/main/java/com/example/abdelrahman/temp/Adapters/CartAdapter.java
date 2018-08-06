package com.example.abdelrahman.temp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdelrahman.temp.Models.CartItem;
import com.example.abdelrahman.temp.R;
import com.example.abdelrahman.temp.View.CartView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    Context context;
    static List<CartItem> cartItemList = new ArrayList<>();
    CartView cartView;

    public CartAdapter(Context context ,CartView cartView) {
        this.context = context;
        this.cartView = cartView;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cart_item,parent,false);
        cartView.showTotal(cartItemList);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CartViewHolder holder, int position) {
        final CartItem cartItem = cartItemList.get(position);
        int itemNumbers = cartItem.getNumbers();
        final double itemPrice = cartItem.getPrice();
        holder.itemArabicName.setText(cartItem.getName());
        holder.itemNumbers.setText(String.valueOf(cartItem.getNumbers()));
        holder.itemPrice.setText(String.valueOf(cartItem.getPrice()));
        holder.itemTotal.setText(String.valueOf(itemNumbers*itemPrice));
        Picasso.get().load(cartItem.getImageUrl()).into(holder.itemImage);
        holder.increaseItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartItem.increase();
                holder.itemTotal.setText(String.valueOf(cartItem.getNumbers()* cartItem.getPrice())); // Update total item price
                holder.itemNumbers.setText(String.valueOf(cartItem.getNumbers()));
                cartView.addToTotal(itemPrice);
            }
        });
        holder.decreaseItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartItem.decrease();
                holder.itemTotal.setText(String.valueOf(cartItem.getNumbers()* cartItem.getPrice())); // Update total item price
                holder.itemNumbers.setText(String.valueOf(cartItem.getNumbers()));
                if (cartItem.getNumbers() > 0 ) {
                    cartView.dicToTotal(itemPrice);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{

        TextView itemArabicName,itemTotal,itemNumbers,itemPrice;
        ImageView itemImage,increaseItem,decreaseItem;

        public CartViewHolder(View itemView) {
            super(itemView);
            itemArabicName = itemView.findViewById(R.id.cart_item_arabic_name);
            itemPrice      = itemView.findViewById(R.id.cart_item_price);
            itemNumbers    = itemView.findViewById(R.id.cart_item_numbers);
            itemImage      = itemView.findViewById(R.id.cart_item_image);
            increaseItem   = itemView.findViewById(R.id.cart_increase_item);
            decreaseItem   = itemView.findViewById(R.id.cart_decrease_item);
            itemTotal      = itemView.findViewById(R.id.cart_item_total);
        }
    }
}
