package com.example.abdelrahman.temp.Models;

public class CartItem {

    String arabicName,imageUrl;
    double price, itemCartId;
    int numbers;

    public String getName() {
        return arabicName;
    }

    public void setName(String name) {
        this.arabicName = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public void increase (){
        this.numbers++;
    }

    public void decrease(){
         if(this.numbers > 0)
             this.numbers--;
    }
    public double getItemCartId() {
        return itemCartId;
    }

    public void setItemCartId(double itemCartId) {
        this.itemCartId = itemCartId;
    }
}
