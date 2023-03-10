package ru.npn.spring.service.demo.model;


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
@Table(name = "product_type_attribute")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductTypeAttributeEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "producttypeattributeid")
  @JsonProperty("productTypeAttributeId")
  @EqualsAndHashCode.Exclude
  private UUID productTypeAttributeId;

  @Column(name = "name")
  @JsonProperty("name")
  private String name;

  @Column(name = "type")
  @JsonProperty("type")
  private Integer type;


}
