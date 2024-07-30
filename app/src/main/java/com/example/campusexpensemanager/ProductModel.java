package com.example.campusexpensemanager;

public class ProductModel {
    public int idProduct;
    public String nameProduct;
    public int priceProduct;

    public ProductModel(int id, String name, int price){
        this.idProduct = id;
        this.nameProduct = name;
        this.priceProduct = price;
    }
}
