package ru.npn.spring.service.demo.service.base.producttypeattribute;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.npn.spring.service.demo.domain.ProductTypeAttributeEntity;
import ru.npn.spring.service.demo.repository.ProductTypeAttributeRepository;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@Service
@RequiredArgsConstructor
public class ProductTypeAttributeBaseServiceImpl implements ProductTypeAttributeBaseService {
  private final ProductTypeAttributeRepository productTypeAttributeRepository;

  @Override
  public ProductTypeAttributeEntity findById(UUID id) {
    return productTypeAttributeRepository.findById(id).orElse(null);
  }

  @Override
  public ProductTypeAttributeEntity save(ProductTypeAttributeEntity value) {
    return productTypeAttributeRepository.save(value);
  }

  @Override
  public void delete(ProductTypeAttributeEntity value) {
    productTypeAttributeRepository.delete(value);
  }

  @Override
  public Page<ProductTypeAttributeEntity> findByParam(Predicate predicate, Pageable pageable) {
    return productTypeAttributeRepository.findAll(predicate, pageable);
  }
}
