package org.danilskryl.aston.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.danilskryl.aston.dto.ProductDto;
import org.danilskryl.aston.model.Market;
import org.danilskryl.aston.model.Product;
import org.danilskryl.aston.service.MarketService;
import org.danilskryl.aston.service.ProductService;
import org.danilskryl.aston.util.ProductMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shop")
@RequiredArgsConstructor
public class ShopController {

  private final MarketService marketService;

  private final ProductService productService;

//  private final KafkaTemplate<String, String> kafka;

  private final KafkaTemplate<String, ProductDto> kafkaObject;

  private final ProductMapper productMapper;

  @PostMapping("/markets")
  public Market addMarket(@RequestBody Market market) {
//    kafka.send("new-market", "Someone add new market");
    return marketService.save(market);
  }

  @PostMapping("/products")
  public Product addProductToMarket(@RequestParam(name = "marketId") Long marketId,
      @RequestBody Product product) {
    Market market = marketService.findById(marketId);
    product.setMarket(market);
    market.getProducts().add(product);

    marketService.save(market);
    Product savedProduct = productService.save(product);

//    kafka.send("new-product", "Someone add new product");
    kafkaObject.send("transfer-product-info", productMapper.toDto(savedProduct));

    return savedProduct;
  }

  @GetMapping("/markets")
  public List<Market> getMarkets() {
    return marketService.findAll();
  }

  @GetMapping("/products")
  public List<Product> getProducts() {
    return productService.findAll();
  }

  @DeleteMapping("/products/{id}")
  public void removeProduct(@PathVariable Long id) {
    productService.delete(id);
  }

  @DeleteMapping("/markets/{id}")
  public void removeMarket(@PathVariable Long id) {
    marketService.delete(id);
  }
}
