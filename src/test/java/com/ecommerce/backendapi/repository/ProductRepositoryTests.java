package com.ecommerce.backendapi.repository;
import static org.assertj.core.api.Assertions.assertThat;

import com.ecommerce.backendapi.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

     private Product product;

    @BeforeEach
//    public void setup(){
//        product = Product.builder()
//                .productName("Team home kit")
//                .description("This is a team home kit")
//                .productImageUrl("teamkit.jpg")
//                .price(100)
//                .build();
//    }

    @Test
    public void givenProductObject_whenSaved_thenReturnSavedProduct(){
        //given - pre-condition or setup
        Product product = Product.builder()
                        .productName("Team home kit")
                        .description("This is a team home kit")
                        .productImageUrl("teamkit.jpg")
                        .price(100)
                        .build();

        // when - action or behavior we are going to test
        Product savedProduct = productRepository.save(product);

        //then - verify the output
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getId()).isGreaterThan(0);
    }

    @Test
    public void givenListOfProducts_whenFindAll_ThenReturnProductList(){
        //given a set of two employee objects
        Product product = Product.builder()
                .productName("Team Home kit")
                .description("This is a team home kit")
                .productImageUrl("team.kit.jpg")
                .price(100)
                .build();

        Product product1 = Product.builder()
                .productName("Second Home kit")
                .description("This is the second home kit")
                .productImageUrl("secondhomekit.jpg")
                .price(250)
                .build();

        productRepository.save(product);
        productRepository.save(product1);

        // when we call the find all method
        List<Product> productList = productRepository.findAll();

        // then we expect a list of employees
        assertThat(productList).isNotNull();
        assertThat(productList.size()).isEqualTo(7);

    }

}
