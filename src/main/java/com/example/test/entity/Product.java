package com.example.test.entity;

import com.example.test.dto.Category;
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
@Entity
public class Product {
    /** Id Объявления
     * @param id  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
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
@OneToOne
ProductProperties properties;
}
