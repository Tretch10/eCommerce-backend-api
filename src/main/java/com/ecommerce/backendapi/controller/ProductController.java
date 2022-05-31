package com.ecommerce.backendapi.controller;

import com.ecommerce.backendapi.payload.ProductDto;
import com.ecommerce.backendapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1/api/products")

public class ProductController {
    @Autowired
    ProductService productService;

    // Rest endpoint to get list of all products.
    @GetMapping
    public List<ProductDto> getAllPosts(){
       return productService.getAllProducts();
    }
}
