package com.ecommerce.backendapi.controller;

import com.ecommerce.backendapi.payload.ProductDto;
import com.ecommerce.backendapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1/api/products")

public class ProductController {
    @Autowired
    ProductService productService;

    // Rest endpoint to read list of all products from database.
    @GetMapping
    public List<ProductDto> getAllPosts(){
       return productService.getAllProducts();
    }

    // Rest endpoint to create a new product
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    // Rest endpoint to get product by Id
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable (name = "id") long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    // Rest endpoint to delete product by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable(name = "id") long id){
        productService.deletePostById(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

    //Rest endpoint to update product
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(name = "id") long id, ProductDto productDto){
        ProductDto productCreated = productService.updateProduct(id, productDto);
        return new ResponseEntity<>(productCreated, HttpStatus.OK);
    }
}
