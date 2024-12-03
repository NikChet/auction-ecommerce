package com.auction.commerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.auction.commerce.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

    Iterable<Product> findAll();

    @Query("SELECT p FROM Product p WHERE p.product_id = ?1")
    Product findProductById(String Id);
} 
