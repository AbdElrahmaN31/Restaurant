package com.example.abdelrahman.temp.Model;

import android.content.ClipData;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryItemsResponse {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("items")
    @Expose
    private List<CategoryItems> items = null;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<CategoryItems> getItems() {
        return items;
    }

    public void setItems(List<CategoryItems> items) {
        this.items = items;
    }
}
