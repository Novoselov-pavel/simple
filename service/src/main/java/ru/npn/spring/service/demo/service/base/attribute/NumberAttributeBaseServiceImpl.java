package ru.npn.spring.service.demo.service.base.attribute;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.npn.spring.service.demo.domain.NumberAttributeValue;
import ru.npn.spring.service.demo.repository.NumberAttributeRepository;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@Service
@RequiredArgsConstructor
public class NumberAttributeBaseServiceImpl implements NumberAttributeBaseService {
  private final NumberAttributeRepository numberAttributeRepository;
  @Override
  public NumberAttributeValue findById(UUID id) {
    return numberAttributeRepository.findById(id).orElse(null);
  }

  @Override
  public NumberAttributeValue save(NumberAttributeValue value) {
    return numberAttributeRepository.save(value);
  }

  @Override
  public void delete(NumberAttributeValue value) {
    numberAttributeRepository.delete(value);
  }
}
