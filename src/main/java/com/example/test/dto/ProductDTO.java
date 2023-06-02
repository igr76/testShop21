package com.example.test.dto;

import com.example.test.entity.ProductProperties;
import lombok.*;

import javax.persistence.*;
/**
 * Сущность объявления
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

        /** Категория товара
         * @param category  */
        Category category;
        /** Серия товара
         * @param series  */
        int series;
        /** Производитель товара
         * @param manufacturer  */
        String manufacturer;
        /** Стоимость Товара
         * @param price  */
        int price;
        /** Количество товара
         * @param quantity  */
        int quantity;
        /** Свойства товара
         * @param properties  */
        ProductProperties properties;
}
