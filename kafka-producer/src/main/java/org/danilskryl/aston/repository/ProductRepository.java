package org.danilskryl.aston.repository;

import org.danilskryl.aston.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
