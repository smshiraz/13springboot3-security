package com.syed.springboot3security.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.syed.springboot3security.dto.Product;
import com.syed.springboot3security.entity.UserInfoEntity;
import com.syed.springboot3security.repository.UserInfoEntityRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {

    List<Product> productList = null;

    @Autowired
    private UserInfoEntityRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void loadProductsFromDB() {
        productList = Arrays.asList(new Product(1,"Bat",10,6000),
        		new Product(2,"Ball",20,5500),
        		new Product(3,"stump",2,890),
        		new Product(4,"Ball",50,5500),
        		new Product(5,"Ball",7,5500),
        		new Product(6,"Ball",90,5500),
        		new Product(7,"Ball",0,5500),
        		new Product(8,"Ball",70,5500),
        		new Product(9,"Ball",880,5500),
        		new Product(10,"Ball",60,5500),
        		new Product(11,"Ball",290,5500)
        		
        		     );
    }


    public List<Product> getProducts() {
        return productList;
    }

    public Product getProduct(int id) {
        return productList.stream()
                .filter(product -> product.getProductId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("product " + id + " not found"));
    }


    public String addUser(UserInfoEntity userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }
}