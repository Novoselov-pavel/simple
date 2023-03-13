package ru.npn.spring.service.demo.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeDto implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("productTypeId")
  private UUID productTypeId;

  @JsonProperty("name")
  private String name;

}
