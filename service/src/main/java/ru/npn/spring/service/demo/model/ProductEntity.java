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
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductEntity implements Serializable {

  @Id
  @Column(name = "productid")
  @JsonProperty("productId")
  @EqualsAndHashCode.Exclude
  private UUID productId;

  @Column(name = "producttypeid")
  @JsonProperty("productTypeId")
  private UUID productTypeId;


  @Column(name = "name")
  @JsonProperty("name")
  private String name;



}
