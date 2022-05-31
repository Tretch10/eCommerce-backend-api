package com.ecommerce.backendapi.service;


import com.ecommerce.backendapi.entity.Product;
import com.ecommerce.backendapi.payload.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();

}