package ru.npn.spring.service.demo.service.base.attribute;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.npn.spring.service.demo.domain.DataAttributeValue;
import ru.npn.spring.service.demo.repository.DataAttributeRepository;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@Service
@RequiredArgsConstructor
public class DataAttributeBaseServiceImpl implements DataAttributeBaseService {
  private final DataAttributeRepository dataAttributeRepository;

  @Override
  public DataAttributeValue findById(UUID id) {
    return dataAttributeRepository.findById(id).orElse(null);
  }

  @Override
  public DataAttributeValue save(DataAttributeValue value) {
    return dataAttributeRepository.save(value);
  }

  @Override
  public void delete(DataAttributeValue value) {
    dataAttributeRepository.delete(value);
  }
}
