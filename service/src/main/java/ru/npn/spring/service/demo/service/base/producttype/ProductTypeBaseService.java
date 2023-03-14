package ru.npn.spring.service.demo.service.base.producttype;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.npn.spring.service.demo.domain.ProductTypeEntity;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
public interface ProductTypeBaseService {

  ProductTypeEntity findById(UUID id);

  ProductTypeEntity save(ProductTypeEntity value);

  Page<ProductTypeEntity> findByParam(Predicate predicate,  Pageable pageable);

  void delete(ProductTypeEntity value);

}
