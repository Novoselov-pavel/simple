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
@Table(name = "product_type")
@NoArgsConstructor
@AllArgsConstructor
@Data
@NamedEntityGraph(name = "productTypeWithAttr",
    attributeNodes = @NamedAttributeNode("productTypeAttributeEntities"))
public class ProductTypeEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "producttypeid")
  @JsonProperty("productTypeId")
  @EqualsAndHashCode.Exclude
  private UUID productTypeId;

  @Column(name = "name")
  @JsonProperty("name")
  private String name;

  @OneToMany(mappedBy = "productType", cascade = CascadeType.REMOVE, orphanRemoval = false)
  private List<ProductEntity> productEntities;

  @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
  @JoinTable(name = "type_attribute",
  joinColumns = @JoinColumn(name = "producttypeid"),
  inverseJoinColumns = @JoinColumn(name = "producttypeattributeid"))
  private List<ProductTypeAttributeEntity> productTypeAttributeEntities;



}
