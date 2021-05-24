package com.xiongyiyun.model;

import java.io.StringReader;

public class Product {
    private Integer productId;
    private Integer categoryId;
    private String productName;
    private String productDescription;
    private String picture;
    private Double price;
    public Product() {
    }
    public Product(Integer categoryId, String productName,Double price) {
        this.categoryId=categoryId;
        this.productName=productName;
        this.price=price;
    }
    public Product(Integer categoryId, String productName,String productDescription,String picture,Double price) {
        this.categoryId=categoryId;
        this.productName=productName;
        this.productDescription=productDescription;
        this.picture=picture;
        this.price=price;
    }
    public Integer getProductId(){
        return  this.productId;
    }
    public void setProductId(Integer id){
        this.productId=id;
    }
    public Integer getCategoryId() {
        return this.categoryId;
    }
    public void setCategoryId(Integer id) {
        this.categoryId=id;
    }
    public String getProductName() {
        return this.productName;
    }
    public void setProductName(String name) {
        this.productName=name;
    }
    public String getProductDescription() {
        return this.productDescription;
    }
    public void setProductDescription(String a) {
        this.productDescription=a;
    }
    public String getPicture() {
        return this.picture;
    }
    public void setPicture(String picture) {
        this.picture=picture;
    }
    public Double getPrice() {
        return this.price;
    }
    public void setPrice(Double price) {
        this.price=price;
    }
    public String toString() {
        return "Product[productId="+productId+",categoryId="+categoryId+",productName="+productName+",prodcutDescription="+productDescription+",picture="+picture+",price="+price+"]";
    }
}