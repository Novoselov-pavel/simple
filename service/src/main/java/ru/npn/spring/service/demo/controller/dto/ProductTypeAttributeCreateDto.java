package ru.npn.spring.service.demo.controller.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Новоселов Павел
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeAttributeCreateDto implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("type")
  private Integer type;


}
