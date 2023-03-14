package ru.npn.spring.service.demo.service.base.producttype;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.npn.spring.service.demo.domain.ProductTypeEntity;
import ru.npn.spring.service.demo.repository.ProductTypeRepository;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@RequiredArgsConstructor
@Service
public class ProductTypeBaseServiceImpl implements ProductTypeBaseService {
  private final ProductTypeRepository productTypeRepository;

  @Override
  public ProductTypeEntity findById(UUID id) {
    return productTypeRepository.findById(id).orElse(null);
  }

  @Override
  public ProductTypeEntity save(ProductTypeEntity value) {
    return productTypeRepository.save(value);
  }

  @Override
  public Page<ProductTypeEntity> findByParam(Predicate predicate, Pageable pageable) {
    return productTypeRepository.findAll(predicate, pageable);
  }

  @Override
  public void delete(ProductTypeEntity value) {
    productTypeRepository.delete(value);
  }
}
