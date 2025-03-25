package com.uttkarsh.SpringBoot.JPA.controllers;


import com.uttkarsh.SpringBoot.JPA.entities.ProductEntity;
import com.uttkarsh.SpringBoot.JPA.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final int PAGE_SIZE = 5;

    private final ProductRepository productRepository;
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @GetMapping
//    public List<ProductEntity> getAllProducts(){
//        return productRepository.findByOrderByPrice();
//    }

//    @GetMapping
//    public List<ProductEntity> getAllProducts(
//            @RequestParam(defaultValue = "id") String sortBy
//    ){
//        return productRepository.findBy(Sort.by(sortBy));
//    }

    @GetMapping
    public Page<ProductEntity> getProductsWithPriceGreaterThan(
            @RequestParam(defaultValue = "50") Integer greater,
            @RequestParam(defaultValue = "1") Integer PageNumber
    ){
        Pageable pageable = PageRequest.of(PageNumber, PAGE_SIZE);
        return productRepository.findByPriceGreaterThan(greater, pageable);
    }

}
