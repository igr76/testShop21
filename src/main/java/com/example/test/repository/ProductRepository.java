package com.example.test.repository;

import com.example.test.dto.Category;
import com.example.test.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * репозиторий для товаров
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByCategory(Category category);
//    @Query(nativeQuery = true, value = "SELECT MAX(id) FROM Products")
//    int findMaxID();
}
