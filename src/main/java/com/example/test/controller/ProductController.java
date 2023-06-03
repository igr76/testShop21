package com.example.test.controller;

import com.example.test.dto.Category;
import com.example.test.dto.ProductDTO;
import com.example.test.entity.Product;
import com.example.test.entity.ProductProperties;
import com.example.test.loger.FormLogInfo;
import com.example.test.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
/**
 * Контроллер товаров
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Получить все товары по категории")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class)))
                    }
            )
    })
    @GetMapping("/{category}")
    public ResponseEntity<?> getProductByCategory(@PathVariable(name = "category")
                                                      @NotBlank(message = "категория  не должна быть пустой")
                                                     Category category) {
        log.info(FormLogInfo.getInfo());
        return ResponseEntity.ok(productService.getProductByCategory(category));
    }
    @Operation(summary = "Получить товарт по номеру")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class)))
                    }
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(name = "id")
                                                @NotBlank(message = "id не должен быть пустым")
                                                @Min(value = 1, message = "id должен быть больше 0")
                                                @Parameter(description = "id товара",
                                                        example = "1") int id) {
        log.info(FormLogInfo.getInfo());
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @Operation(summary = "Добавить товар")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "OK",
                    content = {
                            @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))
                    }
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = {@Content(array = @ArraySchema(schema = @Schema()))}
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden",
                    content = {@Content(array = @ArraySchema(schema = @Schema()))}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = {@Content(array = @ArraySchema(schema = @Schema()))}
            )
    })
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(
            @RequestBody @Valid ProductDTO productDTO) throws IOException {
        log.info(FormLogInfo.getInfo());
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }
    @Operation(summary = "Изменение товара")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Product added",
                    content = {
                            @Content(array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))
                    }),
    })
    @PatchMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable(name = "id")
                                                     @NotBlank(message = "id не должен быть пустым")
                                                     @Min(value = 1, message = "id должен быть больше 0")
                                                     @Parameter(description = "id товара",
                                                             example = "1") int id,
                                                     @RequestBody ProductDTO productDTO) {
        log.info(FormLogInfo.getInfo());
        return ResponseEntity.ok(productService.updateProduct(id,productDTO));
    }
}
