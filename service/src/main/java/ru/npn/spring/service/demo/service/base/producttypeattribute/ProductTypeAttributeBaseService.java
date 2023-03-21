package ru.npn.spring.service.demo.service.base.producttypeattribute;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.npn.spring.service.demo.domain.ProductTypeAttributeEntity;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
public interface ProductTypeAttributeBaseService {

  ProductTypeAttributeEntity findById(UUID id);

  ProductTypeAttributeEntity save(ProductTypeAttributeEntity value);

  void delete(ProductTypeAttributeEntity value);

  Page<ProductTypeAttributeEntity> findByParam(Predicate predicate, Pageable pageable);

}
