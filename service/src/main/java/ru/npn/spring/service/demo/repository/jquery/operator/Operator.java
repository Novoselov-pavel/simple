package ru.npn.spring.service.demo.repository.jquery.operator;

import lombok.NonNull;
import org.apache.logging.log4j.util.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Новоселов Павел
 */
public enum Operator {
  EQUAL("eq"),
  NOT_EQUAL("ne"),
  CONTAINS("contains"),
  STARTS_WITH("startsWith", "starts-with"),
  ENDS_WITH("endsWith", "ends-with"),
  MATCHES("matches"),
  AND("and"),
  OR("or"),
  NOT("not"),
  GREATER_THAN("gt"),
  GREATER_THAN_OR_EQUAL("gte"),
  LESS_THAN("lt"),
  LESS_THAN_OR_EQUAL("lte"),
  CASE_IGNORE("ci"),
  IN("in");

  private final String[] stringValue;

  Operator(@NonNull String... stringValue) {
    this.stringValue = stringValue;
  }

  public String[] getStringValue() {
    return stringValue;
  }
  

  private static final Map<String, Operator> LOW_CASE_MAP = new HashMap<>();

  public static final String OPERATOR_VALUE_DELIMITER_PREFIX = "(";
  public static final String ALT_OPERATOR_VALUE_DELIMITER_PREFIX = "[";
  public static final String OPERATOR_VALUE_DELIMITER_SUFFIX = ")";
  public static final String ALT_OPERATOR_VALUE_DELIMITER_SUFFIX = "]";

  static {
    for (Operator value : Operator.values()) {
      for (String s : value.getStringValue()) {
        LOW_CASE_MAP.put(s.toLowerCase(), value);
      }
    }
  }


  public static Operator getOperator(String operator){
    if(Strings.isEmpty(operator)){
      return null;
    }
    return LOW_CASE_MAP.get(operator.toLowerCase());
  }


  public static boolean isOperator(@NonNull Operator operator, @NonNull String value){

//    for (String s : operator.getStringValue()) {
//
//
//
//    }
//
//
//    return value.startsWith(operator.toString())
//        && (value.indexOf("(") == operator.toString().length()
//        && value.endsWith(")") || value.indexOf("[") == operator.toString().length()
//        && value.endsWith("]"));

    return false;
  }



}
