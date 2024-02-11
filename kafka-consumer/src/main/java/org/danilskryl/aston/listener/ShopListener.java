package org.danilskryl.aston.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.danilskryl.aston.dto.ProductDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShopListener {

  private final ObjectMapper objectMapper;

  @KafkaListener(topics = "new-product", groupId = "kafka-aston")
  public void newProductListener(String productTransfer) {
    System.out.println("GET NEW MESSAGE FOR ADD NEW PRODUCT");
    System.out.println(productTransfer);
  }

  @KafkaListener(topics = "new-market", groupId = "kafka-aston")
  public void newMarketListener(String marketTransfer) {
    System.out.println("GET NEW MESSAGE FOR ADD NEW MARKET");
    System.out.println(marketTransfer);
  }

  @KafkaListener(topics = "transfer-product-info", groupId = "kafka-aston", containerFactory = "factory")
  public void transferProductInfoListener(ProductDto dto)  {
//    ProductDto productDto = objectMapper.readValue(dto, ProductDto.class);
    System.out.println(dto.getName());
    System.out.println(dto);
  }
}
