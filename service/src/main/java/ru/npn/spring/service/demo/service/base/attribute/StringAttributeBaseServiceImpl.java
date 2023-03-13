package ru.npn.spring.service.demo.service.base.attribute;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.npn.spring.service.demo.domain.StringAttributeValue;
import ru.npn.spring.service.demo.repository.StringAttributeRepository;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@RequiredArgsConstructor
@Service
public class StringAttributeBaseServiceImpl implements StringAttributeBaseService {
  private final StringAttributeRepository stringAttributeRepository;

  @Override
  public StringAttributeValue findById(UUID id) {
    return stringAttributeRepository.findById(id).orElse(null);
  }

  @Override
  public StringAttributeValue save(StringAttributeValue value) {
    return stringAttributeRepository.save(value);
  }

  @Override
  public void delete(StringAttributeValue value) {
    stringAttributeRepository.delete(value);
  }
}
