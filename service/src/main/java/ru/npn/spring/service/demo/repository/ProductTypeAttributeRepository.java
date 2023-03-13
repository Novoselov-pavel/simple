package ru.npn.spring.service.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.npn.spring.service.demo.domain.ProductTypeAttributeEntity;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@Repository
public interface ProductTypeAttributeRepository extends JpaRepository<ProductTypeAttributeEntity, UUID> {



}
