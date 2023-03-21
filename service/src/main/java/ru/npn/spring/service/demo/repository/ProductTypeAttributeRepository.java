package ru.npn.spring.service.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ru.npn.spring.service.demo.domain.ProductTypeAttributeEntity;
import ru.npn.spring.service.demo.domain.QProductTypeAttributeEntity;
import ru.npn.spring.service.demo.repository.jquery.DefaultQuerydslBinderCustomizer;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@Repository
public interface ProductTypeAttributeRepository extends JpaRepository<ProductTypeAttributeEntity, UUID>,
    QuerydslPredicateExecutor<ProductTypeAttributeEntity>, DefaultQuerydslBinderCustomizer<QProductTypeAttributeEntity> {



}
