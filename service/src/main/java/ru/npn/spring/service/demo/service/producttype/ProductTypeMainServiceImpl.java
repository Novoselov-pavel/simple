package ru.npn.spring.service.demo.service.producttype;

import com.fasterxml.uuid.Generators;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.npn.spring.service.demo.controller.dto.AttributeLinkDto;
import ru.npn.spring.service.demo.controller.dto.ProductTypeCreateDto;
import ru.npn.spring.service.demo.controller.dto.ProductTypeDto;
import ru.npn.spring.service.demo.controller.dto.ProductTypeWithAttributeDto;
import ru.npn.spring.service.demo.domain.ProductTypeAttributeEntity;
import ru.npn.spring.service.demo.domain.ProductTypeEntity;
import ru.npn.spring.service.demo.mapper.DtoMapper;
import ru.npn.spring.service.demo.service.base.producttype.ProductTypeBaseService;
import ru.npn.spring.service.demo.service.base.producttypeattribute.ProductTypeAttributeBaseService;

import java.util.Objects;
import java.util.UUID;


/**
 * @author Новоселов Павел
 */
@Service
@RequiredArgsConstructor
public class ProductTypeMainServiceImpl implements ProductTypeMainService {
  private final ProductTypeBaseService productTypeBaseService;
  private final ProductTypeAttributeBaseService productTypeAttributeBaseService;
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

  @Override
  public ProductTypeDto create(ProductTypeCreateDto productTypeCreateDto) {
    ProductTypeEntity entity = new ProductTypeEntity();
    entity.setProductTypeId(Generators.timeBasedGenerator().generate());
    entity.setName(productTypeCreateDto.getName());
    entity = productTypeBaseService.save(entity);
    return dtoMapper.map(entity, ProductTypeDto.class);
  }

  @Override
  public ProductTypeWithAttributeDto addLink(AttributeLinkDto attributeLinkDto) {
    Assert.notNull(attributeLinkDto.getProductTypeId(),"Attribute productTypeId can't be null");
    Assert.notNull(attributeLinkDto.getProductTypeAttributeId(),"Attribute productTypeAttributeId can't be null");
    ProductTypeAttributeEntity attribute = productTypeAttributeBaseService.findById(attributeLinkDto.getProductTypeAttributeId());
    if(Objects.isNull(attribute)){
      throw new IllegalArgumentException("Attribute with id = " + attributeLinkDto.getProductTypeAttributeId() + " doesn't exist");
    }
    ProductTypeEntity productType = productTypeBaseService.findByIdWithAttributes(attributeLinkDto.getProductTypeId());

    if(Objects.isNull(productType)) {
      throw new IllegalArgumentException("ProductType with id = " + attributeLinkDto.getProductTypeId() + " doesn't exist");
    }
    productType.getProductTypeAttributeEntities().add(attribute);

    ProductTypeEntity retVal = productTypeBaseService.save(productType);

    return dtoMapper.map(retVal, ProductTypeWithAttributeDto.class);
  }


}
