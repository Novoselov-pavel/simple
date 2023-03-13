package ru.npn.spring.service.demo.service.base.attribute;

import ru.npn.spring.service.demo.domain.NumberAttributeValue;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
public interface NumberAttributeBaseService {

  NumberAttributeValue findById(UUID id);

  NumberAttributeValue save(NumberAttributeValue value);

  void delete(NumberAttributeValue value);


}
