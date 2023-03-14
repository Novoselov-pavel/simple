package ru.npn.spring.service.demo.service.producttype;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.npn.spring.service.demo.controller.dto.ProductTypeDto;
import ru.npn.spring.service.demo.domain.ProductTypeEntity;
import ru.npn.spring.service.demo.mapper.DtoMapper;
import ru.npn.spring.service.demo.service.base.producttype.ProductTypeBaseService;

import java.util.UUID;


/**
 * @author Новоселов Павел
 */
@Service
@RequiredArgsConstructor
public class ProductTypeMainServiceImpl implements ProductTypeMainService {
  private final ProductTypeBaseService productTypeBaseService;
  private final DtoMapper dtoMapper;

  @Override
  public ProductTypeDto getProductTypeById(@NonNull UUID id) {
    ProductTypeEntity entity = productTypeBaseService.findById(id);
    return dtoMapper.map(entity, ProductTypeDto.class);
  }

  @Override
  public Page<ProductTypeDto> findProductByParam(Predicate predicate, Pageable pageable) {

    Page<ProductTypeEntity> page = productTypeBaseService.findByParam(predicate, pageable);
    return new PageImpl<>(page.getContent().stream().map(x->dtoMapper.map(x, ProductTypeDto.class)).toList(),
        page.getPageable(),
        page.getTotalElements());
  }
}
