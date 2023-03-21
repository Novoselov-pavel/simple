package ru.npn.spring.service.demo.service.producttypeattribute;

import com.fasterxml.uuid.Generators;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.npn.spring.service.demo.controller.dto.ProductTypeAttributeCreateDto;
import ru.npn.spring.service.demo.controller.dto.ProductTypeAttributeDto;
import ru.npn.spring.service.demo.domain.ProductTypeAttributeEntity;
import ru.npn.spring.service.demo.mapper.DtoMapper;
import ru.npn.spring.service.demo.service.base.producttypeattribute.ProductTypeAttributeBaseService;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@Service
@RequiredArgsConstructor
public class ProductTypeAttributeMainServiceImpl implements ProductTypeAttributeMainService {

  private final ProductTypeAttributeBaseService service;
  private final DtoMapper dtoMapper;

  @Override
  public ProductTypeAttributeDto getProductTypeAttributeById(UUID id) {
    ProductTypeAttributeEntity entity = service.findById(id);
    return dtoMapper.map(entity, ProductTypeAttributeDto.class);
  }

  @Override
  public ProductTypeAttributeDto create(ProductTypeAttributeCreateDto createDto) {
    ProductTypeAttributeEntity entity = new ProductTypeAttributeEntity();
    entity.setProductTypeAttributeId(Generators.timeBasedGenerator().generate());
    entity.setName(createDto.getName());
    entity.setType(createDto.getType());
    entity = service.save(entity);
    return dtoMapper.map(entity, ProductTypeAttributeDto.class);
  }

  @Override
  public Page<ProductTypeAttributeDto> findProductTypeAttributeByParam(Predicate predicate, Pageable pageable) {
    Page<ProductTypeAttributeEntity> page = service.findByParam(predicate, pageable);
    return new PageImpl<>(page.getContent().stream().map(x->dtoMapper.map(x, ProductTypeAttributeDto.class)).toList(),
        page.getPageable(),
        page.getTotalElements());
  }
}
