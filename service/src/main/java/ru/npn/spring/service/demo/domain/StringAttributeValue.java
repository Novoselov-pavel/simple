package ru.npn.spring.service.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@Entity
@Table(name = "string_attribute_value")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StringAttributeValue implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "attributeid")
  @JsonProperty("attributeId")
  @EqualsAndHashCode.Exclude
  private UUID attributeId;

  @Column(name = "productid")
  @JsonProperty("productId")
  private UUID productId;


  @Column(name = "att_value")
  @JsonProperty("attributeValue")
  private String attributeValue;

}
