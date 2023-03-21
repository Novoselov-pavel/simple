package ru.npn.spring.service.demo.service.producttypeattribute;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.npn.spring.service.demo.controller.dto.ProductTypeAttributeCreateDto;
import ru.npn.spring.service.demo.controller.dto.ProductTypeAttributeDto;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
public interface ProductTypeAttributeMainService {

  ProductTypeAttributeDto getProductTypeAttributeById(UUID id);

  ProductTypeAttributeDto create(ProductTypeAttributeCreateDto createDto);

  Page<ProductTypeAttributeDto> findProductTypeAttributeByParam(Predicate predicate, Pageable pageable);
}

