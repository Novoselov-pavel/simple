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
import ru.npn.spring.service.demo.controller.dto.ProductTypeAttributeCreateDto;
import ru.npn.spring.service.demo.controller.dto.ProductTypeAttributeDto;
import ru.npn.spring.service.demo.domain.ProductTypeAttributeEntity;
import ru.npn.spring.service.demo.service.producttypeattribute.ProductTypeAttributeMainService;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "ProductTypeAttribute", description = "Атрибуты типа продукта")
@RequestMapping("/ProductTypeAttribute")
public class ProductTypeAttributeController {

  private final ProductTypeAttributeMainService service;

  @GetMapping("/{id}")
  @Operation(summary = "Получение атрибута для типа продукта по id")
  ProductTypeAttributeDto getProductTypeAttributeById(@Parameter(name = "id",description = "Идентификатор атрибута для типа продукта", required = true)
                                    @PathVariable UUID id) {
    return service.getProductTypeAttributeById(id);
  }


  @PostMapping("")
  @Operation(summary = "Создание атрибута для типа продукта")
  ProductTypeAttributeDto createProductType(@RequestBody(required = true) ProductTypeAttributeCreateDto createDto){
    return service.create(createDto);
  }


  @GetMapping("")
  @Operation(summary = "Поиск атрибутов для типа продукта")
  @Parameters(value = {
      @Parameter(name = "producttypeattributeid", description = "Идентификатор", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6",schema = @Schema(type = "string", format = "uuid")),
      @Parameter(name = "name", description = "Наименование", example = "name",schema = @Schema(type = "string")),
      @Parameter(name = "type", description = "Тип 0 - строка, 1 - текст", example = "0",schema = @Schema(type = "integer")),
      @Parameter(name = "page", description = "Страница", example = "0",schema = @Schema(type = "integer")),
      @Parameter(name = "size", description = "Количество строк", example = "100",schema = @Schema(type = "integer")),
      @Parameter(name = "sort", description = "Сортировка", schema = @Schema(type = "string")),
  })
  Page<ProductTypeAttributeDto> findProductTypeAttributeByParam(@Parameter(hidden = true) @QuerydslPredicate(root = ProductTypeAttributeEntity.class) Predicate predicate,
                                                                @Parameter(hidden = true) Pageable pageable){
    return service.findProductTypeAttributeByParam(predicate, pageable);
  }



}
