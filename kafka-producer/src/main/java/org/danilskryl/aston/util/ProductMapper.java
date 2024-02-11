package org.danilskryl.aston.util;

import org.danilskryl.aston.dto.ProductDto;
import org.danilskryl.aston.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  public ProductDto toDto(Product product) {
    return ProductDto.builder()
        .name(product.getName())
        .description(product.getDescription())
        .marketId(product.getMarket().getId())
        .build();
  }

  public Product toEntity(ProductDto dto) {
    return Product.builder()
        .name(dto.getName())
        .description(dto.getDescription())
        .build();
  }
}
