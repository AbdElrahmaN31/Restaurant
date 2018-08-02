package com.example.abdelrahman.temp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.abdelrahman.temp.Adapters.ItemsAdapter;
import com.example.abdelrahman.temp.Models.Item;
import com.example.abdelrahman.temp.Presenter.ItemsPresenter;
import com.example.abdelrahman.temp.R;
import com.example.abdelrahman.temp.View.ItemsView;
import java.util.List;

public class ItemsActivity extends AppCompatActivity implements ItemsView {

    ItemsPresenter itemsPresenter;
    RecyclerView itemsRecyclerView;
    ItemsAdapter itemsAdapter;
    RecyclerView.LayoutManager layoutManager;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_items);

        itemsRecyclerView = findViewById(R.id.rv_category_items);
        layoutManager = new LinearLayoutManager(this);
        itemsRecyclerView.setHasFixedSize(true);
        itemsRecyclerView.setLayoutManager(layoutManager);

        itemsPresenter = new ItemsPresenter(this,this,getIntent().getStringExtra("categoryId"));
        itemsPresenter.getCategoryItems();
        i =1;
    }

    @Override
    public void categoryItemsList(List<Item> items) {
        Log.i("items","ItemsActivity.CategoryItemsList,called");
        itemsAdapter = new ItemsAdapter(this, items);
        Log.i("items","ItemsAdapter.Activity is intialized");
        itemsRecyclerView.setAdapter(itemsAdapter);
        Log.i("items","Adapter had set");
        itemsAdapter.notifyDataSetChanged();
        Log.i("items","data adapter notified");
    }
}
