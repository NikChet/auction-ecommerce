package com.auction.commerce.entity;

public class product {
    private long id;
    private String product_name;
    private String description;
    public product(long id, String product_name, String description) {
        this.id = id;
        this.product_name = product_name;
        this.description = description;
    }
    public product() {
        super();
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "product [id=" + id + ", product_name=" + product_name + ", description=" + description + "]";
    }
    
    
}
