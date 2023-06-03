package com.example.test;

import com.example.test.dto.Category;
import com.example.test.dto.ProductDTO;
import com.example.test.entity.Product;
import com.example.test.entity.ProductProperties;
import com.example.test.exception.ElemNotFound;
import com.example.test.mapper.ProductMapper;
import com.example.test.repository.ProductRepository;
import com.example.test.service.ProductServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Тесты на сервис {@link com.example.test.service.ProductServiceImpl}
 */

@ExtendWith(MockitoExtension.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductServiceImplTest {
    @InjectMocks
    ProductServiceImpl service;
    @Mock
    ProductRepository repository;
    @Mock
    ProductMapper productMapper;
    Product product;
    Category category;
    ProductDTO productDTO;
    ProductProperties properties;
    Collection<Product>  products = new ArrayList<>();
    Collection<ProductDTO>  productDTOS = new ArrayList<>();
    Category category1 = category.PC;
    int count=0;
    int ONE=1;

    @BeforeEach
    void setUp() {
        product = new Product(1,category1,234,"IBM",12000,4,new ProductProperties(category1,"Windows"));
        productDTO = new ProductDTO(category1,234,"IBM",12000,4,new ProductProperties(category1,"Windows"));
        products.add(product);

}
    @Test
    void getProductByIdTest() {
    when(repository.findById(any())).thenReturn(Optional.ofNullable(product));
    when(productMapper.toDTO(any())).thenReturn(productDTO);
    assertThat(service.getProductById(ONE)).isEqualTo(productDTO);
        verify(repository,times(ONE)).findById(any());
    }
    @Test
    void getProductByIdNegativeTest() {
        assertThatExceptionOfType(ElemNotFound.class).isThrownBy(() -> service.getProductById(2));
    }
    @Test
    void getProductByCategoryTest() {
        when(repository.findAllByCategory(any())).thenReturn((List<Product>) products);
        when(productMapper.toDTOList(any())).thenReturn(productDTOS);
        assertThat(service.getProductByCategory(category1)).isEqualTo(productDTOS);
        verify(repository,times(ONE)).findAllByCategory(any());
    }

    void getProductByCategoryNegativeTest() {

    }
    @Test
    void createProductTest() {
        when(repository.save(product)).thenReturn(product);
        when(productMapper.toEntity(any())).thenReturn(product);
        when(productMapper.toDTO(any())).thenReturn(productDTO);
        assertThat(service.createProduct(productDTO)).isEqualTo(productDTO);
        verify(repository, times(ONE)).save(any());
    }
    @Test
    void updateProductTest() {
        when(repository.findById(any())).thenReturn(Optional.ofNullable(product));
        when(productMapper.toDTO(any())).thenReturn(productDTO);
        when(repository.save(product)).thenReturn(product);
        assertThat(service.updateProduct(ONE,productDTO)).isEqualTo(productDTO);
        verify(repository, times(ONE)).save(any());
    }
@Test
    void updateProductNegativeTest() {
        assertThatExceptionOfType(ElemNotFound.class).isThrownBy(() -> service.updateProduct(2,productDTO));
    }


}
