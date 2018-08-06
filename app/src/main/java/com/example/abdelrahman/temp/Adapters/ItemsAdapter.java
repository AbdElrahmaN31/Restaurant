package com.example.abdelrahman.temp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdelrahman.temp.Models.CartItem;
import com.example.abdelrahman.temp.Models.Item;
import com.example.abdelrahman.temp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {

    Context context;
    List<Item> itemList ;
    int itemNumbers;

    public ItemsAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_category_items_item, parent, false);
        return new ItemsAdapter.ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemsViewHolder holder, int position) {
        final Item item = itemList.get(position);
        holder.itemArabicName.setText(item.getArabicName());
        holder.itemPrice.append(item.getPrice().toString());
        Picasso.get().load(item.getImageUrl()).into(holder.itemImage);
        holder.increaseItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemNumbers = Integer.parseInt(holder.itemNumbers.getText().toString());
                itemNumbers++;
                holder.itemNumbers.setText(String.valueOf(itemNumbers));
            }
        });
        holder.decreaseItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemNumbers = Integer.parseInt(holder.itemNumbers.getText().toString());
                if (itemNumbers != 0) {
                    itemNumbers--;
                    holder.itemNumbers.setText(String.valueOf(itemNumbers));
                }
            }
        });
        holder.cartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemNumbers != 0) {
                    CartItem cartItem = new CartItem();
                    cartItem.setName(item.getArabicName());
                    cartItem.setPrice(item.getPrice());
                    cartItem.setImageUrl(item.getImageUrl());
                    cartItem.setNumbers(itemNumbers);
                    cartItem.setItemCartId(item.getId());
                    boolean repeatedId = false;
                    int itemRepeatedPosition = 0;
                    for (int i = 0; i < CartAdapter.cartItemList.size(); i++) {
                        if (CartAdapter.cartItemList.get(i).getItemCartId() == item.getId()) {
                            repeatedId = true;
                            itemRepeatedPosition = i;
                        }
                    }
                    if (repeatedId) {
                        CartAdapter.cartItemList.remove(itemRepeatedPosition);
                    }
                    CartAdapter.cartItemList.add(cartItem);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ItemsViewHolder extends RecyclerView.ViewHolder {
        TextView itemArabicName, itemPrice, itemNumbers;
        ImageView itemImage, increaseItem, decreaseItem, cartImage;

        public ItemsViewHolder(View itemView) {
            super(itemView);
            Log.i("Items", "holder");
            itemArabicName = itemView.findViewById(R.id.item_arabic_name);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemNumbers = itemView.findViewById(R.id.item_numbers);
            itemImage = itemView.findViewById(R.id.card_item_image);
            increaseItem = itemView.findViewById(R.id.increase_item);
            decreaseItem = itemView.findViewById(R.id.decrease_item);
            cartImage = itemView.findViewById(R.id.item_cart);

        }
    }
}
