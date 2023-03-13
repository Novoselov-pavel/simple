package ru.npn.spring.service.demo.service.base.attribute;

import ru.npn.spring.service.demo.domain.DataAttributeValue;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
public interface DataAttributeBaseService {

  DataAttributeValue findById(UUID id);

  DataAttributeValue save(DataAttributeValue value);

  void delete(DataAttributeValue value);


}
