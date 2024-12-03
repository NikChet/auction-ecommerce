package com.auction.commerce.services;
import com.auction.commerce.entity.Product;
import java.util.*;

public interface productService {
    public List<Product> findAllProducts();
    public Product findProductById(String Id);
}