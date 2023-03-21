package ru.npn.spring.service.demo.controller;

import com.querydsl.core.types.Predicate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;
import ru.npn.spring.service.demo.controller.dto.AttributeLinkDto;
import ru.npn.spring.service.demo.controller.dto.ProductTypeCreateDto;
import ru.npn.spring.service.demo.controller.dto.ProductTypeDto;
import ru.npn.spring.service.demo.controller.dto.ProductTypeWithAttributeDto;
import ru.npn.spring.service.demo.domain.ProductTypeEntity;
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
  private final ProductTypeMainService service;

  @GetMapping("/{id}")
  @Operation(summary = "Получение типа продукта по id")
  ProductTypeDto getProductTypeById(@Parameter(name = "id",description = "Идентификатор типа продукта", required = true)
                                    @PathVariable UUID id) {
    return service.getProductTypeById(id);
  }

  @GetMapping("")
  @Operation(summary = "Поиск типов продукта")
  @Parameters(value = {
      @Parameter(name = "productTypeId", description = "Идентификатор", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6",schema = @Schema(type = "string", format = "uuid")),
      @Parameter(name = "name", description = "Наименование", example = "name",schema = @Schema(type = "string")),
      @Parameter(name = "page", description = "Страница", example = "0",schema = @Schema(type = "integer")),
      @Parameter(name = "size", description = "Количество строк", example = "100",schema = @Schema(type = "integer")),
      @Parameter(name = "sort", description = "Сортировка", schema = @Schema(type = "string")),
  })
  Page<ProductTypeDto> findProductByParam(@Parameter(hidden = true) @QuerydslPredicate(root = ProductTypeEntity.class) Predicate predicate, @Parameter(hidden = true) Pageable pageable){
    return service.findProductByParam(predicate, pageable);
  }


  @PostMapping("")
  @Operation(summary = "Создание типа продукта")
  ProductTypeDto createProductType(@RequestBody(required = true) ProductTypeCreateDto createDto){
    return service.create(createDto);
  }

  @PostMapping("/addAttribute")
  @Operation(summary = "Добавление атрибута для типа продукта")
  ProductTypeWithAttributeDto addLink(@RequestBody(required = true) AttributeLinkDto attributeLinkDto){
    return service.addLink(attributeLinkDto);
  }


}
