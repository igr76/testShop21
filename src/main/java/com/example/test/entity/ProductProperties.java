package com.example.test.entity;

import com.example.test.dto.Category;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
/**
 * дополнительные свойства для категорий товаров
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductProperties {
    @Id
    Category id;
    String properties;
}
