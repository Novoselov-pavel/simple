package ru.npn.spring.service.demo.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ru.npn.spring.service.demo.domain.ProductTypeEntity;
import ru.npn.spring.service.demo.domain.QProductTypeEntity;
import ru.npn.spring.service.demo.repository.jquery.DefaultQuerydslBinderCustomizer;

import java.util.List;
import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, UUID>,
    QuerydslPredicateExecutor<ProductTypeEntity>, DefaultQuerydslBinderCustomizer<QProductTypeEntity> {

  @EntityGraph(value = "productTypeWithAttr")
  ProductTypeEntity findFirstByProductTypeId(UUID productTypeId);

  @EntityGraph(value = "productTypeWithAttr")
  List<ProductTypeEntity> findAllByNameStartingWith(String nameStart);


}
