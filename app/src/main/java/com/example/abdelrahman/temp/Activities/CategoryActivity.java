package com.example.abdelrahman.temp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.abdelrahman.temp.Adapters.CategoryAdapter;
import com.example.abdelrahman.temp.Model.Category;
import com.example.abdelrahman.temp.Presenter.CategoryPresenter;
import com.example.abdelrahman.temp.R;
import com.example.abdelrahman.temp.View.CategoryView;

import java.util.List;

public class CategoryActivity extends AppCompatActivity implements CategoryView {

    CategoryPresenter categoryPresenter;
    RecyclerView categoryRecyclerView;
    CategoryAdapter categoryAdapter;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        categoryRecyclerView = findViewById(R.id.rv_category);
        gridLayoutManager = new GridLayoutManager(this,2);
        categoryRecyclerView.setLayoutManager(gridLayoutManager);
        categoryPresenter = new CategoryPresenter(this,  this);
        categoryPresenter.getCategory("1");
    }

    @Override
    public void categoryList(List<Category> categoryList) {
        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
    }
}
