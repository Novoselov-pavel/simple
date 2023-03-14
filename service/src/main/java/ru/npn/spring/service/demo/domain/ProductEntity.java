package ru.npn.spring.service.demo.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
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
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "productid")
  @JsonProperty("productId")
  @EqualsAndHashCode.Exclude
  private UUID productId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "producttypeid")
  private ProductTypeEntity productType;

  @Column(name = "name")
  @JsonProperty("name")
  private String name;

  @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
  @JoinColumn(name = "productid")
  private List<DataAttributeValue> dataAttributeValues;

  @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
  @JoinColumn(name = "productid")
  private List<NumberAttributeValue> numberAttributeValues;

  @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
  @JoinColumn(name = "productid")
  private List<StringAttributeValue> stringAttributeValues;



}
