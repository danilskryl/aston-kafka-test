package org.danilskryl.aston.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.danilskryl.aston.model.Market;
import org.danilskryl.aston.repository.MarketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MarketServiceTest {

  @InjectMocks
  MarketService marketService;

  @Mock
  MarketRepository marketRepository;

  @Test
  void testFindById() {
    Long id = 4L;
    Market market = Market.builder()
        .id(id)
        .name("Test market")
        .build();

    when(marketRepository.findById(id)).thenReturn(Optional.ofNullable(market));

    Market actualMarket = marketService.findById(id);

    verify(marketRepository, times(1)).findById(id);
    assertEquals(market, actualMarket);
  }
}