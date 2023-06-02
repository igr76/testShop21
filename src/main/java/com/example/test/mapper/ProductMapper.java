package com.example.test.mapper;

import com.example.test.dto.ProductDTO;
import com.example.test.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

/**
 * маппер для {@link com.example.test.entity.Product}
 * готовый DTO {@link com.example.test.dto.ProductDTO}
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)
    Product toEntity(ProductDTO productDTO);

    ProductDTO toDTO(Product product);

    Collection<ProductDTO> toDTOList(Collection<Product> productEntitys);
}
