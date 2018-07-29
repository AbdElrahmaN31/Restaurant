package com.example.abdelrahman.temp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_items);

        categoryItemsRecyclerView = findViewById(R.id.rv_category_items);
        categoryItemsPresenter = new CategoryItemsPresenter(this,this,getIntent().getStringExtra("categoryId"));
        categoryItemsPresenter.getCategoryItems();
        layoutManager = new LinearLayoutManager(this);
    }

    @Override
    public void categoryItemsList(List<CategoryItems> categoryItems) {
        categoryItemsAdapter = new CategoryItemsAdapter(this,categoryItems);
        categoryItemsRecyclerView.setAdapter(categoryItemsAdapter);
        categoryItemsAdapter.notifyDataSetChanged();
    }
}
