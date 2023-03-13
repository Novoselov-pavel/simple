package ru.npn.spring.service.demo.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import ru.npn.spring.service.demo.domain.ProductTypeAttributeEntity;
import ru.npn.spring.service.demo.domain.ProductTypeEntity;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class ProductTypeRepositoryTest {

  @Autowired
  private ProductTypeRepository repository;

  @Autowired
  private ProductTypeAttributeRepository productTypeAttributeRepository;

  @BeforeEach
  void setUp() {
  }

  @Test
  void createProductType(){
    UUID productId = UUID.randomUUID();

    List<ProductTypeAttributeEntity> attributeEntities = productTypeAttributeEntities(productId);

    List<ProductTypeEntity> selectEntity = repository.findAllByNameStartingWith("test");

    for (ProductTypeEntity productType : selectEntity) {
      assertThat(attributeEntities).isEqualTo(productType.getProductTypeAttributeEntities());
    }
  }

  private List<ProductTypeAttributeEntity> productTypeAttributeEntities(UUID productId){
    ProductTypeEntity testProductType = createTestProductType(productId);
    return testProductType.getProductTypeAttributeEntities();
  }

  private ProductTypeEntity createTestProductType(UUID productId){
    ProductTypeEntity productType = new ProductTypeEntity();
    productType.setProductTypeId(productId);
    productType.setName("testName");


    ProductTypeAttributeEntity attributeEntity = new ProductTypeAttributeEntity();
    attributeEntity.setProductTypeAttributeId(UUID.randomUUID());
    attributeEntity.setName("attributeName");
    attributeEntity.setType(0);

    productTypeAttributeRepository.save(attributeEntity);

    productType.setProductTypeAttributeEntities(Collections.singletonList(attributeEntity));


    return repository.save(productType);
  }
}
