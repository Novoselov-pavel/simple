package ru.npn.spring.service.demo.service.base.producttype;

import ru.npn.spring.service.demo.domain.ProductTypeEntity;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
public interface ProductTypeBaseService {

  ProductTypeEntity findById(UUID id);

  ProductTypeEntity save(ProductTypeEntity value);

  void delete(ProductTypeEntity value);

}
