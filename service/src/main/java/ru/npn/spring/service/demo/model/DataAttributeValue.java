package ru.npn.spring.service.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * @author Новоселов Павел
 */
@Entity
@Table(name = "data_attribute_value")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataAttributeValue implements Serializable {
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
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", iso = DateTimeFormat.ISO.DATE_TIME)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", shape = JsonFormat.Shape.STRING)
  @JsonProperty("attributeValue")
  private ZonedDateTime attributeValue;

}
