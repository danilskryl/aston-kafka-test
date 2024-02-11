package org.danilskryl.aston.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.danilskryl.aston.model.Product;
import org.danilskryl.aston.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public Product findById(Long id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Product save(Product product) {
    return productRepository.save(product);
  }

  public Product update(Product product) {
    return productRepository.save(product);
  }

  public void delete(Long id) {
    productRepository.deleteById(id);
  }
}
