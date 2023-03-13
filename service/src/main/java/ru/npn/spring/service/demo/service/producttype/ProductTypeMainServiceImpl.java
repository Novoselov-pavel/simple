package ru.npn.spring.service.demo.service.producttype;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.npn.spring.service.demo.controller.dto.ProductTypeDto;
import ru.npn.spring.service.demo.service.base.producttype.ProductTypeBaseService;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@Service
@RequiredArgsConstructor
public class ProductTypeMainServiceImpl implements ProductTypeMainService {
  private final ProductTypeBaseService productTypeBaseService;

  @Override
  public ProductTypeDto getProductTypeById(@NonNull UUID id) {
    return null;
  }

  @Override
  public Page<ProductTypeDto> findProductByParam(Predicate predicate, Pageable pageable) {
    return null;
  }
}
