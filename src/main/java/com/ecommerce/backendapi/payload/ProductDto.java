package com.ecommerce.backendapi.payload;

import lombok.Data;

@Data
public class ProductDto {
    private long id;
    private String productName;
    private String description;
    private double price;
}
