package com.ecommerce.backendapi.service;

import com.ecommerce.backendapi.entity.Product;
import com.ecommerce.backendapi.payload.ProductDto;
import com.ecommerce.backendapi.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    // Constructor based dependency injection
    private ProductRepository productRepository;
    private ModelMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper mapper){
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    // Business logic to get list of all products from database
    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> mapToDto(product)).collect(Collectors.toList());
    }


    // Method to convert/map entity to DTO
    private ProductDto mapToDto(Product product){
        ProductDto productDto = mapper.map(product, ProductDto.class);
        return productDto;
    }

    //Method to convert/map DTO to entity
    private Product mapToEntity(ProductDto productDto){
       Product product = mapper.map(productDto, Product.class);
       return product;
    }
}
