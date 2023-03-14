package ru.npn.spring.service.demo.mapper;

/**
 * @author Новоселов Павел
 */
public interface DtoMapper {
  <D> D map(Object source, Class<D> destinationType);
}
