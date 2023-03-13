package ru.npn.spring.service.demo.service.producttype;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.npn.spring.service.demo.controller.dto.ProductTypeDto;

import java.util.UUID;

/**
 * @author Новоселов Павел
 */
public interface ProductTypeMainService {

  ProductTypeDto getProductTypeById(@NonNull UUID id);

  Page<ProductTypeDto> findProductByParam (Predicate predicate, Pageable pageable);
}
