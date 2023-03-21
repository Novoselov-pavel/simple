package ru.npn.spring.service.demo.repository.jquery;

import com.querydsl.core.types.EntityPath;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import ru.npn.spring.service.demo.repository.jquery.provider.ExpressionProviderFactory;

import java.math.BigDecimal;
import java.time.*;
import java.util.Date;
import java.util.UUID;


/**
 * @author Новоселов Павел
 */
public interface DefaultQuerydslBinderCustomizer<T extends EntityPath<?>> extends QuerydslBinderCustomizer<T> {

   default void customize(QuerydslBindings bindings, T root) {

    bindings.bind(String.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(Long.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(Integer.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(Short.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(Byte.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(BigDecimal.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(Boolean.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(Enum.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(Date.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(LocalDate.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(LocalDateTime.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(OffsetDateTime.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(ZonedDateTime.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(LocalTime.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(OffsetTime.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(UUID.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(Float.class).all(ExpressionProviderFactory::getPredicate);
    bindings.bind(Double.class).all(ExpressionProviderFactory::getPredicate);
  }
}
