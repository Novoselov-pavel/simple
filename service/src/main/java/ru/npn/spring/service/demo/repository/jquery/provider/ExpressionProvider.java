package ru.npn.spring.service.demo.repository.jquery.provider;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.apache.commons.lang3.StringUtils;
import ru.npn.spring.service.demo.repository.jquery.operator.Operator;

import java.util.Optional;

/**
 * @author Новоселов Павел
 */
public interface ExpressionProvider<P extends Path, V> {


  default Optional<Predicate> getPredicate(P path, V value) {
    Optional var10000 = this.getExpression(path, value);
    Predicate.class.getClass();
    return var10000.map(Predicate.class::cast);
  }


  default Optional<BooleanExpression> getExpression(P path, V value) {
    return Optional.empty();
  }


  static Optional<Operator> isOperator(String value) {
    return isOperator(Operator.values(), value);
  }


  static <S extends String> Optional<Operator> isOperator(Operator[] operators, S value) {
    if (operators != null && StringUtils.isNotBlank(value)) {
      Operator[] var2 = operators;
      int var3 = operators.length;

      for(int var4 = 0; var4 < var3; ++var4) {
        Operator operator = var2[var4];
        if (Operator.isOperator(operator, value)) {
          return Optional.of(operator);
        }
      }
    }

    return Optional.empty();
  }





  /**
   * Utility method which validates proper ordering and opening/closing delimiters of operators on supplied <code>value</code>
   *
   * @param value <code>value</code> to check for proper composition
   * @throws IllegalArgumentException if an invalid composition is found in provided <code>value</code>
   */
  static void validateComposition(final String value) {
    if (StringUtils.isNotBlank(value)) {
      if (isOperator(value).isPresent()) {
        int count = 0;
        int opening_bracket = Operator.OPERATOR_VALUE_DELIMITER_PREFIX.charAt(0);
        int closing_bracket = Operator.OPERATOR_VALUE_DELIMITER_SUFFIX.charAt(0);
        for (char c : value.toCharArray()) {
          if (c == opening_bracket)
            count++;
          else if (c == closing_bracket) {
            if (count <= 0) {
              throw new IllegalArgumentException("Malformed (bad-ordering) value: " + value);
            }
            count--;
          }
        }
        if (count != 0) {
          throw new IllegalArgumentException("Malformed (Incompletely closed) value: " + value);
        }
      }
    }
  }


}
