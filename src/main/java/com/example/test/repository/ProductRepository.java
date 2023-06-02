package com.example.test.repository;

import com.example.test.dto.Category;
import com.example.test.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * репозиторий для товаров
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByCategory(Category category);
    @Query(nativeQuery = true, value = "SELECT MAX(ID) FROM Products")
    int findMaxID();
}
