package ru.npn.spring.service.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Новоселов Павел
 */
@Service
public class DtoMapperImpl implements DtoMapper {
  private final ModelMapper mapper = new ModelMapper();

  @Override
  public <D> D map(Object source, Class<D> destinationType) {
    if(Objects.isNull(source)){
      return null;
    }
    return mapper.map(source, destinationType);
  }
}
