package com.example.test.entity;

import com.example.test.dto.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class ProductProperties {
    @Id
    Category id;
    String properties;
}
