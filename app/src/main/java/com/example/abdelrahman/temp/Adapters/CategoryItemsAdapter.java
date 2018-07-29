package com.example.abdelrahman.temp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdelrahman.temp.Model.CategoryItems;
import com.example.abdelrahman.temp.R;

import java.util.List;

public class CategoryItemsAdapter extends RecyclerView.Adapter<CategoryItemsAdapter.CategoryItemsHolder> {

    Context context;
    List categoryItemList;
    int itemNumbers = 1;

    public CategoryItemsAdapter(Context context, List categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public CategoryItemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_category_items_item,parent,false);
        return new CategoryItemsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryItemsHolder holder, int position) {
        CategoryItems categoryItems = (CategoryItems) categoryItemList.get(position);
        holder.itemArabicName.setText(categoryItems.getArabicName());
        holder.itemPrice.setText(categoryItems.getPrice());
        holder.increaseItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemNumbers++;
                holder.itemNumbers.setText("" + itemNumbers);
            }
        });
        holder.decreaseItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemNumbers != 1){
                    itemNumbers --;
                    holder.itemNumbers.setText("" + itemNumbers);
                }
            }
        });
        holder.cartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    @Override
    public int getItemCount() {
        return 0;
    }


    public class CategoryItemsHolder extends RecyclerView.ViewHolder{
        TextView itemArabicName,itemPrice,itemNumbers;
        ImageView itemImage,increaseItem,decreaseItem,cartImage;

        public CategoryItemsHolder(View itemView) {
            super(itemView);
            this.itemArabicName = itemView.findViewById(R.id.arabic_name);
            this.itemPrice = itemView.findViewById(R.id.item_price);
            this.itemNumbers =  itemView.findViewById(R.id.item_price);
            this.itemImage =  itemView.findViewById(R.id.card_item_image);
            this.increaseItem =  itemView.findViewById(R.id.increase_item);
            this.decreaseItem =  itemView.findViewById(R.id.decrease_item);
            this.cartImage =  itemView.findViewById(R.id.item_cart);

        }
    }
}
