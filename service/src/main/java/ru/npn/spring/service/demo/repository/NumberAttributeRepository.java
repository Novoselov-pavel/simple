package ru.npn.spring.service.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.npn.spring.service.demo.domain.NumberAttributeValue;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@Repository
public interface NumberAttributeRepository extends JpaRepository<NumberAttributeValue, UUID> {

}
