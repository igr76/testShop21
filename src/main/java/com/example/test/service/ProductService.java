package com.example.test.service;

import com.example.test.dto.Category;
import com.example.test.dto.ProductDTO;
import com.example.test.entity.Product;

import java.util.Collection;
import java.util.List;
/**
 * Сервис для товаров
 */
public interface ProductService {
     /**
      * Возвращает список товаров по категории
      * @param category     категория
      * @return список товаров
      */
     Collection<ProductDTO> getProductByCategory(Category category);
     /**
      * Возвращает товар по номеру id
      * @param id     номер
      * @return  товар
      */
     ProductDTO getProductById(int id);
     /**
      * Создает новый  товар
      * @param productDTO     новый товар
      */
     ProductDTO createProduct(ProductDTO productDTO);
     /**
      * Обновляет   товар
      * @param id     номер товара
      * @param productDTO     новый товар
      */
     ProductDTO updateProduct(int id,ProductDTO productDTO);
}
