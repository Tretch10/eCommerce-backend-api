package com.ecommerce.backendapi.entity;
/*
This class is for Object Relational Mapping. Here, we create Java objects that are mapped to database tables
in MySQL.
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
// This defines id field as the primary key of the database table and will be auto-generated.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Product Name", nullable = false)
    private String productName;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "Image Url", nullable = false)
    private String productImageUrl;

    @Column(name = "Price", nullable = false)
    private double price;
}
