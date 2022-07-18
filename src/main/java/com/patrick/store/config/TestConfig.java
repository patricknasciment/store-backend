package com.patrick.store.config;

import com.patrick.store.domain.Category;
import com.patrick.store.domain.Product;
import com.patrick.store.repositories.CategoryRepository;
import com.patrick.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "informática");
        Category cat2 = new Category(null, "eletronicos");
        categoryRepository.saveAll(List.of(cat1, cat2));

        Product p1 = new Product(null, "Radio", 2000.00);
        Product p2 = new Product(null, "Computador", 6000.00);
        Product p3 = new Product(null, "Mouse", 400.00);

        p1.getCategories().add(cat1);
        p2.getCategories().add(cat2);
        p3.getCategories().add(cat1);

        cat1.getProducts().addAll(List.of(p1, p3));
        cat2.getProducts().add(p2);

        productRepository.saveAll(List.of(p1, p2, p3));
        categoryRepository.saveAll(List.of(cat1, cat2));
    }
}
