package org.danilskryl.aston.repository;

import org.danilskryl.aston.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, Long> {

}
