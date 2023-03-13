package ru.npn.spring.service.demo.controller;

import com.querydsl.core.types.Predicate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.npn.spring.service.demo.controller.dto.ProductTypeDto;
import ru.npn.spring.service.demo.service.producttype.ProductTypeMainService;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "ProductType", description = "Тип продукта")
@RequestMapping("/ProductType")
public class ProductTypeController {
  private final ProductTypeMainService productTypeMainService;

  @GetMapping("/{id}")
  @Operation(summary = "Получение типа продукта по id")
  ProductTypeDto getProductTypeById(@Parameter(name = "id",description = "Идентификатор типа продукта", required = true)
                                    @PathVariable UUID id) {
    return productTypeMainService.getProductTypeById(id);
  }

  @GetMapping("")
  @Operation(summary = "Описк типов продукта")
  Page<ProductTypeDto> findProductByParam(@QuerydslPredicate(root = ProductTypeDto.class) Predicate predicate, Pageable pageable){

    return productTypeMainService.findProductByParam(predicate, pageable);

  }



}
