package com.uttkarsh.SpringBoot.JPA.controllers;


import com.uttkarsh.SpringBoot.JPA.entities.ProductEntity;
import com.uttkarsh.SpringBoot.JPA.repositories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @GetMapping
//    public List<ProductEntity> getAllProducts(){
//        return productRepository.findByOrderByPrice();
//    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy){
        return productRepository.findBy(Sort.by(sortBy));
    }

}
