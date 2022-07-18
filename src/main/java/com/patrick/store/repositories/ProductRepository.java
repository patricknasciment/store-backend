package com.patrick.store.repositories;

import com.patrick.store.domain.Category;
import com.patrick.store.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
