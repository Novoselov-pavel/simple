package ru.npn.spring.service.demo.service.base.product;

import ru.npn.spring.service.demo.domain.ProductEntity;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
public interface ProductBaseService {

  ProductEntity findById(UUID id);

  ProductEntity save(ProductEntity value);

  void delete(ProductEntity value);

}
