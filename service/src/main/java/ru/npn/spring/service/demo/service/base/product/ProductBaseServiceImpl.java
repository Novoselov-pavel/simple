package ru.npn.spring.service.demo.service.base.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.npn.spring.service.demo.domain.ProductEntity;
import ru.npn.spring.service.demo.repository.ProductRepository;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@Service
@RequiredArgsConstructor
public class ProductBaseServiceImpl implements ProductBaseService {
  private final ProductRepository productRepository;

  @Override
  public ProductEntity findById(UUID id) {
    return productRepository.findById(id).orElse(null);
  }

  @Override
  public ProductEntity save(ProductEntity value) {
    return productRepository.save(value);
  }

  @Override
  public void delete(ProductEntity value) {
    productRepository.delete(value);
  }
}
