package com.auction.commerce.entity;

// import org.glassfish.jaxb.core.annotation.OverrideAnnotationOf;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cart_id;
    
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private Product product_id;

    @Column(name="quantity")
    private int quantity;

    @Column(name="price_at_addition")
    private double price;

    public User getUsername(){
        return user;
    }
    public void setUsername(User user) {
        this.user = user;
    }
    public Product getProductId(){
        return product_id;
    }
    public void setProductId(Product product_id) {
        this.product_id = product_id;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString(){
        return "cart{" + "Username=" + user + ", product_id=" + product_id + ", quantity=" + quantity + ", price=" + price + "}";
    }

    public Cart(){
        super();
    }
    // public Cart(String username, String product_id, int quantity, double price){
    //     this.user = user;
    //     this.product_id = product_id;
    //     this.quantity = quantity;
    //     this.price = price;
    // }
}
