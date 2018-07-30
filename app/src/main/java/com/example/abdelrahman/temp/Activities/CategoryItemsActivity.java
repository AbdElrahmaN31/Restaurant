package com.example.abdelrahman.temp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.abdelrahman.temp.Adapters.CategoryItemsAdapter;
import com.example.abdelrahman.temp.Model.CategoryItems;
import com.example.abdelrahman.temp.Presenter.CategoryItemsPresenter;
import com.example.abdelrahman.temp.R;
import com.example.abdelrahman.temp.View.CategoryItemsView;

import java.util.List;

public class CategoryItemsActivity extends AppCompatActivity implements CategoryItemsView {

    CategoryItemsPresenter categoryItemsPresenter;
    RecyclerView categoryItemsRecyclerView;
    CategoryItemsAdapter categoryItemsAdapter;
    GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_items);

        categoryItemsRecyclerView = findViewById(R.id.rv_category_items);
        layoutManager = new GridLayoutManager(this,2);
        categoryItemsRecyclerView.setLayoutManager(layoutManager);
        categoryItemsPresenter = new CategoryItemsPresenter(this,this,getIntent().getStringExtra("categoryId"));
        categoryItemsPresenter.getCategoryItems();

    }

    @Override
    public void categoryItemsList(List<CategoryItems> categoryItems) {
        categoryItemsAdapter = new CategoryItemsAdapter(this,categoryItems);
        categoryItemsRecyclerView.setAdapter(categoryItemsAdapter);
        categoryItemsAdapter.notifyDataSetChanged();
    }
}
