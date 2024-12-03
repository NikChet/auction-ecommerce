package com.auction.commerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String product_id;

    @Column(name="seller")
    private String seller;

    @Column(name="Description")
    private String description;

    @Column(name="forwho")
    private String gender; 

    @Column(name="price")
    private double amount;
    
    @Column(name="category")
    private String category;

    @Column(name="sub_category")
    private String sub_cate;

    @Column(name="ratings")
    private double ratings;

    @Column(name="brand")
    private String brand;

    @Column(name="img")
    private String img;

    @Column(name="available_quantity")
    private int stock;

    public String getProduct_id() {
        return product_id;
    }
    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
    public String getSeller() {
        return seller;
    }
    public void setSeller(String seller) {
        this.seller = seller;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getSub_cate() {
        return sub_cate;
    }
    public void setSub_cate(String sub_cate) {
        this.sub_cate = sub_cate;
    }
    public double getRatings() {
        return ratings;
    }
    public void setRatings(double ratings) {
        this.ratings = ratings;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "product [product_id=" + product_id + ", seller=" + seller + ", description=" + description + ", gender="
                + gender + ", category=" + category + ", sub_cate=" + sub_cate + ", ratings=" + ratings + ", brand="
                + brand + ", img=" + img + ", stock=" + stock + "]";
    }

    public Product() {
        super();
    }
    public Product(String product_id, String seller, String description, String gender, String category,
            String sub_cate, double ratings, String brand, String img, int stock) {
        this.product_id = product_id;
        this.seller = seller;
        this.description = description;
        this.gender = gender;
        this.category = category;
        this.sub_cate = sub_cate;
        this.ratings = ratings;
        this.brand = brand;
        this.img = img;
        this.stock = stock;
    }
    
    

    
    // private long product_id;
    // private String product_name;
    // private String description;
    // public product(long id, String product_name, String description) {
    //     this.product_id = id;
    //     this.product_name = product_name;
    //     this.description = description;
    // }
    // public product() {
    //     super();
    // }
    // public long getId() {
    //     return product_id;
    // }
    // public void setId(long id) {
    //     this.product_id = id;
    // }
    // public String getProduct_name() {
    //     return product_name;
    // }
    // public void setProduct_name(String product_name) {
    //     this.product_name = product_name;
    // }
    // public String getDescription() {
    //     return description;
    // }
    // public void setDescription(String description) {
    //     this.description = description;
    // }
    // @Override
    // public String toString() {
    //     return "product [id=" + id + ", product_name=" + product_name + ", description=" + description + "]";
    // }
    
    
}
