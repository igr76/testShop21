package com.example.test.entity;

import com.example.test.dto.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

/**
 * Сущность товаров
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Products")
@Entity
public class Product {
    /** Id товара
     * @param id  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
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
