package ru.npn.spring.service.demo.repository.jquery.provider;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import org.springframework.core.convert.ConversionService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Новоселов Павел
 */
public final class ExpressionProviderFactory {

  private static boolean supportsUnTypedValues = false;
  private static ConversionService conversionService;
  private static Map<Path<?>, String> path_alias_registry = new HashMap();

  public ExpressionProviderFactory() {
  }


  public static Optional<Predicate> getPredicate(Path<?> path, Object value) {
//    if (StringPath.class.isAssignableFrom(path.getClass())) {
//      return new StringPathExpressionProviderImpl(ExpressionProviderFactory.conversionService);
//    } else if (NumberPath.class.isAssignableFrom(path.getClass())) {
//      return new NumberPathExpressionProviderImpl(ExpressionProviderFactory.conversionService);
//    } else if (DatePath.class.isAssignableFrom(path.getClass())) {
//      return new DatePathExpressionProviderImpl(ExpressionProviderFactory.conversionService);
//    } else if (DateTimePath.class.isAssignableFrom(path.getClass())) {
//      return new DateTimePathExpressionProviderImpl(ExpressionProviderFactory.conversionService);
//    } else if (EnumPath.class.isAssignableFrom(path.getClass())) {
//      return new EnumPathExpressionProviderImpl(ExpressionProviderFactory.conversionService);
//    } else if (TimePath.class.isAssignableFrom(path.getClass())) {
//      return new TimePathExpressionProviderImpl(ExpressionProviderFactory.conversionService);
//    } else if (BooleanPath.class.isAssignableFrom(path.getClass())) {
//      return new BooleanPathExpressionProviderImpl(ExpressionProviderFactory.conversionService);
//    } else {
//      return ComparablePath.class.isAssignableFrom(path.getClass()) ? new ComparablePathExpressionProviderImpl(ExpressionProviderFactory.conversionService) : null;
//    }
//
//    return Optional.ofNullable(loadingCache.getUnchecked(path)).flatMap((p) -> {
//      return p.getPredicate(path, value);
//    });
    return Optional.empty();
  }





}
