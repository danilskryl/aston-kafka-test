package org.danilskryl.aston.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.danilskryl.aston.model.Market;
import org.danilskryl.aston.repository.MarketRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketService {

  private final MarketRepository marketRepository;

  public Market findById(Long id) {
    return marketRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Market not found with id " + id));
  }

  public List<Market> findAll() {
    return marketRepository.findAll();
  }

  public Market save(Market market) {
    return marketRepository.save(market);
  }

  public Market update(Market market) {
    return marketRepository.save(market);
  }

  public void delete(Long id) {
    marketRepository.deleteById(id);
  }

}
