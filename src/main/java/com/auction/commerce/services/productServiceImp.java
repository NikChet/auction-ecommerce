package com.auction.commerce.services;
import java.util.List;
import java.util.Optional;

// import org.glassfish.jaxb.core.annotation.OverrideAnnotationOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// import com.auction.commerce.entity.User;
import com.auction.commerce.entity.Product;
import com.auction.commerce.repository.ProductRepository;
// import com.auction.commerce.repository.UserRepository;

@Service
public class productServiceImp implements productService {
     @Autowired
    private ProductRepository prod_repo;

    @Override
    public List<Product> findAllProducts(){
        Iterable<Product> findAllIterable = prod_repo.findAll();
        List<Product> listOfProducts = new ArrayList<>();
        for(Product Product : findAllIterable){
            listOfProducts.add(Product);
        }
        return listOfProducts;
    }

    @Override
    public Product findProductById(String Id){
        System.out.println(Id);
        try{
            return prod_repo.findProductById(Id); 
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
