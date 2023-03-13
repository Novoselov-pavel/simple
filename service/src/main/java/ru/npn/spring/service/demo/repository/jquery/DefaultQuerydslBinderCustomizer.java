package ru.npn.spring.service.demo.repository.jquery;

import com.querydsl.core.types.EntityPath;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;


/**
 * @author Новоселов Павел
 */
public interface DefaultQuerydslBinderCustomizer<T extends EntityPath<?>> extends QuerydslBinderCustomizer<T> {

  default void customize(QuerydslBindings bindings, T root) {
  }
}
