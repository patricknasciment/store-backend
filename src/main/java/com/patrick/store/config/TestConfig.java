package com.patrick.store.config;

import com.patrick.store.domain.Category;
import com.patrick.store.repositories.CategoryRepository;
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

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(1, "informática");
        Category cat2 = new Category(2, "eletronicos");
        categoryRepository.saveAll(List.of(cat1, cat2));
    }
}
