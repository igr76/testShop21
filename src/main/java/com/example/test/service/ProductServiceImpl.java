package com.example.test.service;

import com.example.test.dto.Category;
import com.example.test.dto.ProductDTO;
import com.example.test.entity.Product;
import com.example.test.entity.ProductProperties;
import com.example.test.exception.ElemNotFound;
import com.example.test.loger.FormLogInfo;
import com.example.test.mapper.ProductMapper;
import com.example.test.repository.ProductRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.Collection;
/**
 * Реализация {@link ProductService}
 */
@NoArgsConstructor
@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
    public Product product;
    private ProductRepository productRepository;

    private ProductMapper productMapper;
    private ProductDTO productDTO;
    private int count;
    Category category;

    public ProductServiceImpl(Product product, ProductRepository productRepository, ProductMapper productMapper, ProductDTO productDTO) {
        this.product = product;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productDTO = productDTO;
    }
/** Реализация получение товаров по категории   */
    @Override
    public Collection<ProductDTO> getProductByCategory(Category category) {
        log.info(FormLogInfo.getInfo());
        return productMapper.toDTOList(productRepository.findAllByCategory(category));
    }
    /** Реализация получение товара по id   */
    @Override
    public ProductDTO getProductById(int id) {
        log.info(FormLogInfo.getInfo());
        return productMapper.toDTO(productRepository.findById(id).orElseThrow(ElemNotFound::new));
    }
    /** Реализация добавление товара   */
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        log.info(FormLogInfo.getInfo());
        Product product = productMapper.toEntity(productDTO);
        product.setId(++count);
        return productMapper.toDTO(productRepository.save(product));
    }
    /** Реализация изменения  товара   */
    @Override
    public ProductDTO updateProduct(int id, ProductDTO productDTO) {
        log.info(FormLogInfo.getInfo());
        Product product = productRepository.findById(id).orElseThrow(ElemNotFound::new);
        product.setCategory(productDTO.getCategory());
        product.setManufacturer(productDTO.getManufacturer());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setSeries(productDTO.getSeries());
        product.setProperties(productDTO.getProperties());

        return productMapper.toDTO(productRepository.save(product));
    }
}
