package com.ecommerce.backendapi.service;

import com.ecommerce.backendapi.entity.Product;
import com.ecommerce.backendapi.exception.ResourceNotFoundException;
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

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        // Map DTO to entity and save
        Product product = mapToEntity(productDto);
        Product newProduct = productRepository.save(product);

        // Map new product entity back to DTO
        ProductDto productResponse = mapToDto(newProduct);
        return productResponse;
    }

    // Business logic to get a product by id
    @Override
    public ProductDto getProductById(long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
        return mapToDto(product);
    }

    // Logic to delete product by Id
    @Override
    public void deletePostById(long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
        productRepository.delete(product);
    }

    @Override
    public ProductDto updateProduct(long id, ProductDto productDto) {
        // get product by Id from database
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));

        product.setProductName(productDto.getProductName());
        product.setDescription(productDto.getDescription());
        product.setProductImageUrl(productDto.getProductImageUrl());
        product.setPrice(productDto.getPrice());

        Product updatedProduct = productRepository.save(product);
        return mapToDto(updatedProduct);
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
