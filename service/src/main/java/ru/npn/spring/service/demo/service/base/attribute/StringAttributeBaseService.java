package ru.npn.spring.service.demo.service.base.attribute;

import ru.npn.spring.service.demo.domain.StringAttributeValue;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
public interface StringAttributeBaseService {

  StringAttributeValue findById(UUID id);

  StringAttributeValue save(StringAttributeValue value);

  void delete(StringAttributeValue value);


}
